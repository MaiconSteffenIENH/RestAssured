package com.sicredi.apiTest.service;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.sicredi.apiTest.util.StaticValue.BASE_URI;
import static com.sicredi.apiTest.util.StaticValue.PATH_BOOKING;

public class RestService {

    public static Response get(String path) {
        return
                RestAssured.given()
                        .baseUri(BASE_URI)
                        .basePath(PATH_BOOKING + path)
                        .when()
                        .get()
                        .then()
                        .log()
                        .all()
                        .extract()
                        .response();
    }

    public static <T> Response post(T payload, String PATH) {
        return
                RestAssured.given()
                        .baseUri(BASE_URI)
                        .basePath(PATH)
                        .body(new Gson().toJson(payload))
                        .contentType("application/json")
                        .when()
                        .post()
                        .then()
                        .log()
                        .all()
                        .extract()
                        .response();
    }

    public static <T> Response getID(String path, T payload) {
        return
                RestAssured.given()
                        .baseUri(BASE_URI)
                        .basePath(PATH_BOOKING + path)
                        .body(new Gson().toJson(payload))
                        .contentType("application/json")
                        .when()
                        .get()
                        .then()
                        .log()
                        .all()
                        .extract()
                        .response();
    }

    public static Response ping() {
        return
                RestAssured.given()
                        .baseUri(BASE_URI)
                        .basePath("/ping")
                        .when()
                        .get()
                        .then()
                        .log()
                        .all()
                        .extract()
                        .response();
    }

}
