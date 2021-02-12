package org.openjfx.backend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {

    public String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

}
