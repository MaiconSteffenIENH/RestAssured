package com.sicredi.apiTest.dto;


public record CreateDTO(
        String firstname,
        String lastname,
        int totalprice,
        boolean depositpaid,
        BookingDates bookingdates,
        String additionalneeds) {
    public record BookingDates(String checkin, String checkout) {
    }
}