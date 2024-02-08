package com.sicredi.apiTest.API;

import com.sicredi.apiTest.service.RestService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ping_HealthCheck {
    @Test
    @DisplayName("Ping - *201*")
    void ping() {
        new RestService();
        RestService.ping();

        Assertions.assertAll("Ping",
                () -> assertEquals(
                        HttpStatus.SC_CREATED, RestService.ping().statusCode())
        );
    }
}
