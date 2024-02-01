package com.sicredi.apiTest.util;

import com.github.javafaker.Faker;
import com.sicredi.apiTest.dto.CreateDTO;

public class BookingUtil {

    private static final Faker faker = new Faker();
    public static CreateDTO criarReserva() {
        return new CreateDTO(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(1, 1000),
                true,
                new CreateDTO.BookingDates(
                        "2024-02-16",
                        "2024-02-18"
                ),
                "Breakfast"
        );
    }
}

