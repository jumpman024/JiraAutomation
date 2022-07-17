package utils;

import constants.CommonConsts;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Authorization {

    public static RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter();
    public static ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter();


    public static RequestSpecification loginToJira() {
//        RestAssured.filters(requestLoggingFilter,responseLoggingFilter);
        return given().filters(requestLoggingFilter,responseLoggingFilter).auth().preemptive().basic(CommonConsts.USERNAME,CommonConsts.PASSWORD)
                .baseUri(CommonConsts.BASE_URI);
    }

}
