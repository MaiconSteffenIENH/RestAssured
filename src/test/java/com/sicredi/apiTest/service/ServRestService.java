package com.sicredi.apiTest.service;

import com.google.gson.Gson;
import com.sicredi.apiTest.dto.CreateDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.sicredi.apiTest.util.StaticValue.*;

public class ServRestService {

    public Response get(String path) {
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

    public Response post(CreateDTO body) {
        return
                RestAssured.given()
                        .baseUri(BASE_URI)
                        .basePath(PATH_BOOKING)
                        .body(new Gson().toJson(body))
                        .contentType("application/json")
                        .when()
                        .post()
                        .then()
                        .log()
                        .all()
                        .extract()
                        .response();
    }

}
