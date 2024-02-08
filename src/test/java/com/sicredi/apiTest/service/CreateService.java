package com.sicredi.apiTest.service;

import com.github.javafaker.Faker;
import com.sicredi.apiTest.dto.BookingDTO;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

public class CreateService {
    private static Faker faker = new Faker();

    @DisplayName("Criar uma reserva")
    public BookingDTO CreateBooking() {
        LocalDate dateActual = LocalDate.now();

        return new BookingDTO (
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(1, 1000),
                true,
                new BookingDTO.BookingDates(
                        dateActual.toString(),
                        dateActual.plusDays(3).toString()
                ),
                "Breakfast"
        );
    }
}
