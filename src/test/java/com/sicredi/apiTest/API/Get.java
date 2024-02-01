package com.sicredi.apiTest.API;

import com.github.javafaker.Faker;
import com.sicredi.apiTest.service.ServRestService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;


public class Get {

    @Test
    @DisplayName("Buscar reserva por ID - *200*")
    void listaReservaID() {
        ServRestService servRestService = new ServRestService();
        Response response = servRestService.get("/");
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        String numeroAleatorio = String.valueOf((int) (Math.random() * 20) + 1);
        //tentar pegar o tamanho do array e pegar um numero aleatorio

        Response responseGet = servRestService.get("/" + numeroAleatorio);
        Assertions.assertEquals(HttpStatus.SC_OK, responseGet.statusCode());
    }

    @Test
    @DisplayName("Buscar reserva por ID - *404*")
    void listaReservaIDInexistente() {
        ServRestService servRestService = new ServRestService();
        Response response = servRestService.get("/^&*()");
        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.statusCode());
    }

    @Test
    @DisplayName("Buscar todas as reservas - *200*")
    void listaTodasReservas() {
        ServRestService servRestService = new ServRestService();
        Response response = servRestService.get("/");
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

}
