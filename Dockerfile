#FROM jenkins/jenkins:lts
#LABEL maintainer="mstewart@riotgames.com"
#
## Prep Jenkins Directories
#USER root
#RUN mkdir /var/log/jenkins
#RUN mkdir /var/cache/jenkins
#RUN chown -R jenkins:jenkins /var/log/jenkins
#RUN chown -R jenkins:jenkins /var/cache/jenkins
#RUN apt-get update
#RUN apt install xvfb
##USER jenkins
#
#
## Set Defaults
#ENV JAVA_OPTS="-Xmx8192m"
#ENV JENKINS_OPTS="--handlerCountMax=300 --logfile=/var/log/jenkins/jenkins.log  --webroot=/var/cache/jenkins/war"


#FROM maven:3.6.3-jdk-11 — базовый образ с предустановленным mvn 3.6.3 и jdk11
FROM maven:3.6.3-jdk-11

#RUN sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-Linux-* \
#    && sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-Linux-* \
#    && yum -y install java-1.8.0-openjdk-devel wget unzip xorg-x11-server-Xvfb xdpyinfo \
#    && mkdir /driver

#RUN mkdir -p /usr/src/app — создание каталога /usr/src/app в контейнере
RUN mkdir -p app/
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update
RUN apt --fix-broken install
RUN apt-get install google-chrome-stable -y


ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF8" \
    DISPLAY=":99"
#ADD . /usr/src/app — копирование файлов в директорию. см. ADD or COPY: https://docs.docker.com/develop/develop-images/dockerfile_best-practices/
COPY pom.xml /app
COPY src /app/src
#WORKDIR /usr/src/app — задаёт рабочую директорию для следующей инструкции.
WORKDIR /app/
# выполняет команду и создаёт слой образа. Используется для установки в контейнер пакетов.
RUN mvn clean test


#FROM jenkins/jenkins:lts
#
## Prep Jenkins Directories
#USER root
#RUN mkdir /var/log/jenkins
#RUN mkdir /var/cache/jenkins
#RUN chown -R jenkins:jenkins /var/log/jenkins
#RUN chown -R jenkins:jenkins /var/cache/jenkins
#RUN apt-get update
#RUN apt install xvfb
#
#ENV JAVA_OPTS="-Xmx8192m"
#ENV JENKINS_OPTS="--handlerCountMax=300 --logfile=/var/log/jenkins/jenkins.log  --webroot=/var/cache/jenkins/war"

