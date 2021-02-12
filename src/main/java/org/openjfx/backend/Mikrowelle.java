package org.openjfx.backend;

import org.openjfx.FXMLController;

public class Mikrowelle {

    Display display = new Display();
    Timer timer = new Timer();
    Clock clock = new Clock();

    private int watt = 400;
    private int seconds = 0;
    private int timeLeftWhenPaused;

    private int[] mode1 = { 400, 90};
    private int[] mode2 = { 800, 30};
    private int[] mode3 = { 300, 180};
    private int[] mode4 = { 600, 60};

    private String mode = "clock";

    public String getMode() {
        return mode;
    }

    public String getDisplayContent() {
        switch (mode) {
            case "clock":
                display.setDisplayContent();
                break;
            case "countdown":
                display.setDisplayContent(timer.getTimeLeft() + "/" + watt);
                break;
        }
        return display.getDisplayContent();
    }

    public void startTimer() {
        switch (mode) {
            case "countdown" -> {
                seconds += 30;
                timer.startTimer(timer.getTimeLeft() + 30);
                display.setDisplayContent(Integer.toString(timer.getTimeLeft()));
            }
            case "paused" -> {
                mode = "countdown";
                timer.startTimer(timeLeftWhenPaused);
                display.setDisplayContent(timer.getTimeLeft());
            }
            case "clock" -> {
                mode = "countdown";
                timer.startTimer(30);
                display.setDisplayContent(Integer.toString(timer.getTimeLeft()));
            }
            case "watt", "timer" -> {
                mode = "countdown";
                timer.startTimer(seconds);
                display.setDisplayContent(timer.getTimeLeft());
            }
        }
    }

    public void stopTimer() {
        if(mode == "countdown") {
            mode = "paused";
            timeLeftWhenPaused = timer.getTimeLeft();
            display.setDisplayContent(timeLeftWhenPaused);
        } else if(mode == "paused" || mode == "watt" || mode == "timer"){
            mode = "clock";
            display.setDisplayContent();
        }
    }

    public void startPreset(int preset) {

    }

    public void increase() {
        if (mode == "clock") {
            mode = "watt";
            display.setDisplayContent(watt);
        } else if (mode == "watt") {
            watt += 5;
            display.setDisplayContent(watt);
        } else if (mode == "timer") {
            seconds += 5;
            display.setDisplayContent(seconds);
        }
    }

    public void decrease() {
        if (mode == "clock") {
            mode = "watt";
            display.setDisplayContent(watt);
        } else if (mode == "watt") {
            watt -= 5;
            display.setDisplayContent(watt);
        } else if (mode == "timer") {
            seconds -= 5;
            display.setDisplayContent(seconds);
        }
    }

    public void switchMode() {
        if(mode == "watt") {
            mode = "timer";
            display.setDisplayContent(seconds);
        } else if(mode == "timer") {
            mode = "watt";
            display.setDisplayContent(watt);
        }
    }

    public void mode1() {
        if(mode == "clock")
            clickMode1();
        else if(mode == "watt" || mode == "timer")
            setMode1();
    }

    public void mode2() {
        if(mode == "clock")
            clickMode2();
        else if(mode == "watt" || mode == "timer")
            setMode2();
    }

    public void mode3() {
        if(mode == "clock")
            clickMode3();
        else if(mode == "watt" || mode == "timer")
            setMode3();
    }

    public void mode4() {
        if(mode == "clock")
            clickMode4();
        else if(mode == "watt" || mode == "timer")
            setMode4();
    }

    public void clickMode1() {
        watt = mode1[0];
        seconds = mode1[1];
        mode = "timer";
        startTimer();
    }

    public void clickMode2() {
        watt = mode2[0];
        seconds = mode2[1];
        mode = "timer";
        startTimer();
    }

    public void clickMode3() {
        watt = mode3[0];
        seconds = mode3[1];
        mode = "timer";
        startTimer();
    }

    public void clickMode4() {
        watt = mode4[0];
        seconds = mode4[1];
        mode = "timer";
        startTimer();
    }

    public void setMode1() {
        mode1[0] = watt;
        mode1[1] = seconds;
    }

    public void setMode2() {
        mode2[0] = watt;
        mode2[1] = seconds;
    }

    public void setMode3() {
        mode3[0] = watt;
        mode3[1] = seconds;
    }

    public void setMode4() {
        mode4[0] = watt;
        mode4[1] = seconds;
    }
}
