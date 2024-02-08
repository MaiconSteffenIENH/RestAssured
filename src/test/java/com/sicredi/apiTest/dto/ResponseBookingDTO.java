package com.sicredi.apiTest.dto;


public record ResponseBookingDTO(
        int bookingid,
        Booking booking
) {
    public record Booking(
            String firstname,
            String lastname,
            int totalprice,
            boolean depositpaid,
            BookingDates bookingdates,
            String additionalneeds) {

    }
    public record BookingDates(String checkin, String checkout) {
    }
}
