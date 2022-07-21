pipeline {
    agent {
         label 'docker'
    }

//        tools {
//            maven "3.8.1"
//        }

    parameters {
        choice(choices: ['server1', 'server2'], description: 'select server fo test run', name: 'server')
        booleanParam(defaultValue: true, description: 'run rest tests', name: 'rest')
        booleanParam(defaultValue: false, description: 'run web tests', name: 'web')
    }

        stages {

//            stage('rest tests') {
//                when {
//                    expression { return params.rest }
//                }
//                steps {
//                    sh "mvn -Dtest=api.** verify"
//                }
//            }
            stage('web tests') {
                 when {
                     expression { return params.web }
                 }
                 steps {
                      script{
    sh "docker build -t test -f src/test/resources/docker/Dockerfile --target chromelast ./"
    sh "docker run -v `pwd`:/tests --privileged --shm-size='4g' --rm test mvn -Dtest=ui.** verify"

    sh "docker build -t test -f src/test/resources/docker/Dockerfile --no-cache --target chrome83 ./"
    sh "docker run -v `pwd`:/tests --privileged --shm-size='4g' --rm test mvn -Dtest=ui.** verify"
                         }
//                        sh "mvn -Dtest=ui.** verify"
                      }
                 }
            }
        }
        post {
            always {
                allure([
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
