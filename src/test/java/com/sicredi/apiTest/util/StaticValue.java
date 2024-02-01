package com.sicredi.apiTest.util;

public class StaticValue {

    public static String BASE_URI = "https://restful-booker.herokuapp.com";
    public static String PATH_BOOKING = "/booking";

    public static String createRandomID() {
        return String.valueOf((int) (Math.random() * 20) + 1);
    }

}
