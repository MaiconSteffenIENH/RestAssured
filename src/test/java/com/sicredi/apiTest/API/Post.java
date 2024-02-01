package com.sicredi.apiTest.API;

import com.sicredi.apiTest.dto.CreateDTO;
import com.sicredi.apiTest.service.ServRestService;
import com.sicredi.apiTest.util.BookingUtil;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Post {

    @Test
    @DisplayName("Criar reserva - *200*")
    void criarReserva() {
        ServRestService servRestService = new ServRestService();
        CreateDTO reserva = BookingUtil.criarReserva();
        Response response = servRestService.post(reserva);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals(reserva.firstname(), response.jsonPath().getString("booking.firstname"));
    }

    @Test
    @DisplayName("Criar reserva - *400*")
    void criarReservaSemBody() {
        ServRestService servRestService = new ServRestService();
        Response response = servRestService.post(null);
        assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    }

    @Test
    @DisplayName("Criar reserva e listar por ID - *200*")
    void criarReservaEBuscarID() {
        ServRestService servRestService = new ServRestService();
        CreateDTO reserva = BookingUtil.criarReserva();
        Response response = servRestService.post(reserva);
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals(reserva.firstname(), response.jsonPath().getString("booking.firstname"));
        assertEquals(reserva.lastname(), response.jsonPath().getString("booking.lastname"));
        assertEquals(reserva.totalprice(), response.jsonPath().getInt("booking.totalprice"));
        assertEquals(reserva.depositpaid(), response.jsonPath().getBoolean("booking.depositpaid"));
        assertEquals(reserva.additionalneeds(), response.jsonPath().getString("booking.additionalneeds"));

        int id = response.jsonPath().getInt("bookingid");
        Response responseGet = servRestService.get("/" + id);
        assertEquals(HttpStatus.SC_OK, responseGet.statusCode());
        assertEquals(reserva.firstname(), responseGet.jsonPath().getString("firstname"));
        assertEquals(reserva.lastname(), responseGet.jsonPath().getString("lastname"));
        assertEquals(reserva.totalprice(), responseGet.jsonPath().getInt("totalprice"));
        assertEquals(reserva.depositpaid(), responseGet.jsonPath().getBoolean("depositpaid"));
        assertEquals(reserva.additionalneeds(), responseGet.jsonPath().getString("additionalneeds"));


    }
}
