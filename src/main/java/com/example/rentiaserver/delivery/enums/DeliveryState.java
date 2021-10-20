package com.example.rentiaserver.delivery.enums;

public enum DeliveryState {

    REGISTERED,
    STARTED,
    FINISHED,
    CLOSED,
    TO_ACCEPT;

    public static DeliveryState getNextStateAfterAction(String action) {
        if ("start".equals(action))
            return STARTED;
        if ("finish".equals(action))
            return FINISHED;
        if ("close".equals(action))
            return CLOSED;
        if ("toAccept".equals(action))
            return TO_ACCEPT;
        throw new IllegalArgumentException("Wrong action name");
    }
}
