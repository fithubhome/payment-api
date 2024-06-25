package com.paymentapi.common;

import java.time.LocalDateTime;

public class Logger {

    public static void logInfo(String info) {
        System.out.println(LocalDateTime.now() + " - " + info);
    }

    public static void logError(String error) {
        System.err.println(LocalDateTime.now() + " - " + error);
    }

}
