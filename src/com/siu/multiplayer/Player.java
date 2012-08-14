package com.siu.multiplayer;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 05/08/12
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
public class Player implements Serializable {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
