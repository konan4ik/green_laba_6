package util;

public class ReloadTimer {

    public int counter;

    public int reloadTime;

    public ReloadTimer(int delay) {
        reloadTime = delay;
        counter = 0;
    }

    public void update() {
        if (counter > 0) {
            counter--;
        }
    }

    public int getCounter() {
        return counter;
    }

    public boolean tryUse() {
        if (counter <= 0) {
            counter = reloadTime;
            return true;
        } else {
            return false;
        }
    }
}
