package com.chameapp.data.entities.pojos;

/**
 * Created by Natallia Zhabitskaya on 6/2/17.
 */

public class Event {
    private final EventType eventType;
    private final int param;

    public Event(EventType eventType, int param) {
        this.eventType = eventType;
        this.param = param;
    }

    public Event(EventType eventType) {
        this(eventType, 0);
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getParam() {
        return param;
    }

    public enum EventType {
        NONE,
        LOAD_NEXT,
        STOP_LOADING
    }
}
