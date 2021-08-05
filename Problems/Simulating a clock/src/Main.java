class Clock {

    int hours = 12;
    int minutes = 0;

    public void next() {
        // implement me
        if (minutes == 59 && hours == 12) {
            minutes = 0;
            hours = 1;
        } else if (minutes == 59) {
            minutes = 0;
            hours++;
        } else {
            minutes++;
        }
    }
}