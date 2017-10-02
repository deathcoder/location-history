package com.demo.location.history.model;

import java.time.LocalDateTime;

public class Workday {
    private LocalDateTime begin;
    private LocalDateTime end;

    public Workday begin( LocalDateTime begin ) {
        this.begin = begin;
        return this;
    }
    public Workday end( LocalDateTime end ) {
        this.end = end;
        return this;
    }

}
