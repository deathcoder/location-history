package com.demo.location.history.model;

public class SimpleDate {
    private String day;
    private String month;
    private String year;

    /**
     * format: dd-MM-yyyy
     **/
    public SimpleDate( String date ) {
        final String[] dateParts = date.split( "-" );
        day = dateParts[ 0 ];
        month = dateParts[ 1 ];
        year = dateParts[ 2 ];
    }

    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }
}
