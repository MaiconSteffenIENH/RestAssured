package com.sicredi.apiTest.base;

import com.sicredi.apiTest.dto.BookingDTO;
import com.sicredi.apiTest.dto.ResponseBookingDTO;
import com.sicredi.apiTest.service.CreateService;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public ResponseBookingDTO responseBookingDTO;
    public CreateService createService;
    public BookingDTO bookingRequest;

    @BeforeEach
    public void setUp() {
        createService = new CreateService();
    }
}
