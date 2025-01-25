package com.example.deepDive.ood.lms;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

    public void sendBookAvailableNotification() {
    }
}
