package com.colak.springtutorial.marker;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class CustomMarker {

    public static final Marker TELEGRAM_MARKER = MarkerFactory.getMarker("TELEGRAM_MARKER");
}
