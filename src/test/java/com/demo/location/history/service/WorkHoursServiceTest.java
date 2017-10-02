package com.demo.location.history.service;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkHoursServiceTest {
    private static Logger logger = LoggerFactory.getLogger( WorkHoursServiceTest.class );

    @Test
    public void name() throws Exception {
        final long resultMillis = new WorkHoursService().result();

        logger.info( "missing time to end of day: [{}]", DurationFormatUtils.formatDuration(resultMillis, "HH:mm:ss,SSS") );


    }
}