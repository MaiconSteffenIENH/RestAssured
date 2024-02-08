package com.sicredi.apiTest.API;

import com.sicredi.apiTest.service.RestService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sicredi.apiTest.util.StaticValue.createRandomID;


public class Get {

    @Test
    @DisplayName("Buscar booking por ID - *200*")
    void listaBookingID() {
        new RestService();
        Response responseGet = RestService.get("/" + createRandomID());
        Assertions.assertEquals(HttpStatus.SC_OK, responseGet.statusCode());
    }

    @Test
    @DisplayName("Buscar booking por ID - *404*")
    void listaBookingIDInexistente() {
        new RestService();
        Response response = RestService.get("/^&*()");
        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.statusCode());
    }

    @Test
    @DisplayName("Buscar todas os bookings - *200*")
    void listaTodosBookings() {
        new RestService();
        Response response = RestService.get("/");
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

}
