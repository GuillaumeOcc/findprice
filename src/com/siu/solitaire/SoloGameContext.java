package com.siu.solitaire;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 23/07/12
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class SoloGameContext {

    private static SoloGameContext instance;

    private int counter;
    private int counterMax;
    private int number;
    private int numberMax;

    public static SoloGameContext getInstance() {
        if (null == instance) {
            instance = new SoloGameContext();
        }
        return instance;
    }

    private SoloGameContext() {
    }

    public void reset() {
        counter = 0;
        number = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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

    public void incrementCounter() {
        counter++;
    }

    public void decrementCounterMax() {
        counterMax--;
    }
}
