package utils;

public class Generic {

    public static void delay(int seconds) throws InterruptedException {
        int miliseconds = seconds*1000;
        Thread.sleep(miliseconds);
    }



}
