package com.siu.model;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 04/07/12
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
public class Score {

    private String name;
    private int counter;

    public Score(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
