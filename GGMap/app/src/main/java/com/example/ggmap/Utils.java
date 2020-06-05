package com.example.ggmap;

import com.google.android.gms.maps.model.Circle;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    public static int getZoomLevel(Circle circle) {
        int zoomlevel = 11;
        if (circle != null) {
            double radius = circle.getRadius() + circle.getRadius() / 2;
            double scale = radius / 500;
            zoomlevel = (int) (16 - Math.log(scale) / Math.log(2));
        }
        return zoomlevel;
    }
    public static String convertMeterToKilometer(int totalDistance) {
        double ff = totalDistance / 1000.0;
        BigDecimal bd = BigDecimal.valueOf(ff);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(bd.doubleValue());
    }
}
