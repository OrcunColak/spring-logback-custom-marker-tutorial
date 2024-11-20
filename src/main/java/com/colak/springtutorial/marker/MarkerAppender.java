package com.colak.springtutorial.marker;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.Marker;

import java.util.List;

public class MarkerAppender extends AppenderBase<ILoggingEvent> {

    private boolean containsMarker(ILoggingEvent event) {
        boolean result = false;
        List<Marker> markers = event.getMarkerList();
        if (markers == null || markers.isEmpty()) {
            return result;
        }

        for (Marker marker : markers) {
            if (marker.contains(CustomerMarker.TELEGRAM_MARKER)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    protected void append(ILoggingEvent event) {
        if (containsMarker(event)) {
            System.out.println(event.getFormattedMessage());
        }
    }

}
