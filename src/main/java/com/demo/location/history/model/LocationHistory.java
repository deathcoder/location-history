package com.demo.location.history.model;


import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

import java.util.List;
import java.util.stream.Collectors;

public class LocationHistory {
    private Document rawDocument;

    public List<Placemark> getPlacemarks() {
        return rawDocument.getFeature()
                .stream()
                .map( Placemark.class::cast )
                .collect( Collectors.toList() );
    }

    public LocationHistory rawDocument( Feature rawDocument ) {
        this.rawDocument = (Document) rawDocument;
        return this;
    }
}
