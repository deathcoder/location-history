package com.demo.location.history.service;

import com.demo.location.history.model.LocationHistory;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.TimeSpan;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class WorkHoursService {

    private static Logger logger = LoggerFactory.getLogger( WorkHoursService.class );

    private LocationHistoryProvider locationHistoryProvider = new LocationHistoryProvider();
    /**
     * Within the KML, the times are West Coast USA
     * */
    public long result() {
        final LocationHistory locationHistory = locationHistoryProvider.retrieveLocationHistory("", "");
        final long workMillis = TimeUnit.HOURS.toMillis( 8 );
        return locationHistory.getPlacemarks().stream()
                .filter( placemark -> placemark.getName().equals( "Work" ) )
                .map( Feature::getTimePrimitive )
                .map( TimeSpan.class::cast )
                .map( timeSpan -> {
                    final String begin = timeSpan.getBegin();
                    final String end = timeSpan.getEnd();
                    final long elapsed = ZonedDateTime.parse( begin, DateTimeFormatter.ISO_INSTANT.withZone( ZoneId.systemDefault() ) )
                            .until( ZonedDateTime.parse( end, DateTimeFormatter.ISO_INSTANT.withZone( ZoneId.systemDefault() ) ),
                                    ChronoUnit.MILLIS );
                    final String humanReadable = DurationFormatUtils.formatDuration( elapsed, "HH:mm:ss,SSS" );
                    logger.info( "elapsed is [{}]", humanReadable );
                    return elapsed;
                } )
                .reduce( workMillis, ( accumulator, elapsed ) -> accumulator - elapsed );
    }
}
