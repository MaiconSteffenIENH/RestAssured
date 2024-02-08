package com.sicredi.apiTest.API;

import com.sicredi.apiTest.base.BaseTest;
import com.sicredi.apiTest.dto.ResponseBookingDTO;
import com.sicredi.apiTest.service.RestService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sicredi.apiTest.util.StaticValue.PATH_BOOKING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Post extends BaseTest {

    @Test
    @DisplayName("Criar booking - *200*")
    void criarBooking() {
        bookingRequest = createService.CreateBooking();

        responseBookingDTO = RestService.post(bookingRequest, PATH_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseBookingDTO.class);

        Assertions.assertAll("Validar reserva",
                () -> assertEquals(bookingRequest.firstname(), responseBookingDTO.booking().firstname()),
                () -> assertEquals(bookingRequest.lastname(), responseBookingDTO.booking().lastname()),
                () -> assertEquals(bookingRequest.totalprice(), responseBookingDTO.booking().totalprice()),
                () -> assertEquals(bookingRequest.depositpaid(), responseBookingDTO.booking().depositpaid()),
                () -> assertEquals(bookingRequest.additionalneeds(), responseBookingDTO.booking().additionalneeds())
        );

        Assertions.assertAll("Validar datas",
                () -> assertEquals(bookingRequest.bookingdates().checkin(), responseBookingDTO.booking().bookingdates().checkin()),
                () -> assertEquals(bookingRequest.bookingdates().checkout(), responseBookingDTO.booking().bookingdates().checkout())
        );
    }

    @Test
    @DisplayName("Criar booking - *400*")
    void criarBookingSemBody() {
        new RestService();
        RestService.post(null, PATH_BOOKING);
        assertEquals(
                HttpStatus.SC_BAD_REQUEST, RestService.post(null, PATH_BOOKING).statusCode());
    }

    @Test
    @DisplayName("Criar booking e listar por ID - *200*")
    void criarBookingEBuscarID() {
        bookingRequest = createService.CreateBooking();

        responseBookingDTO = RestService.post(bookingRequest, PATH_BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .as(ResponseBookingDTO.class);

        RestService.getID("/" + responseBookingDTO.bookingid(), bookingRequest);

        Assertions.assertAll("Validar reserva",
                () -> assertEquals(bookingRequest.firstname(), responseBookingDTO.booking().firstname()),
                () -> assertEquals(bookingRequest.lastname(), responseBookingDTO.booking().lastname()),
                () -> assertEquals(bookingRequest.totalprice(), responseBookingDTO.booking().totalprice()),
                () -> assertEquals(bookingRequest.depositpaid(), responseBookingDTO.booking().depositpaid()),
                () -> assertEquals(bookingRequest.additionalneeds(), responseBookingDTO.booking().additionalneeds())
        );
        Assertions.assertAll("Validar datas",
                () -> assertEquals(bookingRequest.bookingdates().checkin(), responseBookingDTO.booking().bookingdates().checkin()),
                () -> assertEquals(bookingRequest.bookingdates().checkout(), responseBookingDTO.booking().bookingdates().checkout())
        );
    }
}
