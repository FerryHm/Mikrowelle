package org.openjfx.backend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Display {

    private String displayMode;
    private String displayContent;

    public Display() {
        setDisplayContent();
    }

    public String getDisplayContent() {
        return displayContent;
    }
    //clock
    public void setDisplayContent() {
        setMode("clock");
        Clock clock = new Clock();
        displayContent = clock.getCurrentTime();
    }
    //timer
    public void setDisplayContent(String s) {
        setMode("timer");
        displayContent = s;
    }
    //watt
    public void setDisplayContent(int watt) {
        setMode("watt");
        this.displayContent = String.valueOf(watt);
    }

    public String getMode() {
        return displayMode;
    }

    private void setMode(String mode) {
        displayMode = mode;
    }

}
