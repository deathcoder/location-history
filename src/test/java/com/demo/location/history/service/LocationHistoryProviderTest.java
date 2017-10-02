package com.demo.location.history.service;

import com.demo.location.history.model.LocationHistory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LocationHistoryProviderTest {

    private static Logger logger = LoggerFactory.getLogger( LocationHistoryProviderTest.class );

    @Test
    public void name() throws Exception {
        final LocationHistory history = new LocationHistoryProvider().retrieveLocationHistory("01-09-2017", "01-10-2017");

        logger.info( "{}", history.getPlacemarks() );
    }

    @Test
    public void testDownloadUrlGeneration() throws Exception {
        final LocationHistoryProvider locationHistoryProvider = new LocationHistoryProvider();

        final String actualUrl = locationHistoryProvider.generateDownloadUrl( "01-09-2017", "01-10-2017" );
        String expectedUrl = "https://www.google.com/maps/timeline/kml?authuser=0&pb=!1m8!1m3!1i01!2i09!3i2017!2m3!1i01!2i10!3i2017";
        assertThat( actualUrl, is( expectedUrl ) );
    }
}