package com.siu.multiplayer;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 06/08/12
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
public class MultiGameContext {

    private static MultiGameContext instance;

    private int counterPlayer1;
    private int counterPlayer2;
    private int counterMax;
    private int number;
    private int numberMax;

    public static MultiGameContext getInstance() {
        if (null == instance) {
            instance = new MultiGameContext();
        }
        return instance;
    }

    private MultiGameContext() {
    }

    public void incrementCounterPlayer1() {
        counterPlayer1++;
    }

    public void incrementCounterPlayer2() {
        counterPlayer2++;
    }

    public void decrementCounterMax() {
        counterMax--;
    }

    public void reset() {
        counterPlayer1 = 0;
        number = 0;
    }

    public int getCounterPlayer1() {
        return counterPlayer1;
    }

    public void setCounterPlayer1(int counterPlayer1) {
        this.counterPlayer1 = counterPlayer1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberMax() {
        return numberMax;
    }

    public void setNumberMax(int numberMax) {
        this.numberMax = numberMax;
    }

    public int getCounterMax() {
        return counterMax;
    }

    public void setCounterMax(int counterMax) {
        this.counterMax = counterMax;
    }
}


