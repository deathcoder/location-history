package com.demo.location.history.service;


import com.demo.location.history.model.SimpleDate;
import com.demo.location.history.model.LocationHistory;
import de.micromata.opengis.kml.v_2_2_0.Kml;

import java.io.InputStream;
import java.text.MessageFormat;

public class LocationHistoryProvider {
    private final String url = "https://www.google.com/maps/timeline/kml?authuser=0&pb=!1m8!1m3!1i{0}!2i{1}!3i{2}!2m3!1i{3}!2i{4}!3i{5}";

    public LocationHistory retrieveLocationHistory( String from, String to ) {
        final InputStream file = LocationHistoryProvider.class.getResourceAsStream( "/history-2017-09-20.kml" );
        return new LocationHistory().rawDocument( Kml.unmarshal( file ).getFeature() );
    }

    protected String generateDownloadUrl( String from, String to ) {
        SimpleDate fromDate = new SimpleDate( from );
        SimpleDate toDate = new SimpleDate( to );
        return MessageFormat.format(url, fromDate.getDay(), fromDate.getMonth(), fromDate.getYear(),
                toDate.getDay(), toDate.getMonth(), toDate.getYear() );
    }
}
