package org.openjfx.backend;

public class Timer {

    private int seconds;
    private long startTime;

    public void startTimer(int seconds) {
        this.seconds = seconds;
        startTime = System.currentTimeMillis();
    }

    public int getTimeLeft() {
        int timeBygone = (int) ((System.currentTimeMillis() - startTime) / 1000);
        int timeLeft = seconds - (timeBygone);
        return timeLeft;
    }

    public String convertTimeFormat(int seconds) {
        String minutesFormatted = String.format("%02d", seconds / 60);
        String secondsFormatted = String.format("%02d", seconds % 60);
        return minutesFormatted + ":" + secondsFormatted;
    }

    public int convertTimeFormat(String mm_ss) {
        String[] s = mm_ss.split(":");
        int minutes = Integer.parseInt(s[0]);
        int seconds = Integer.parseInt(s[1]);
        return minutes * 60 + seconds;
    }


}
