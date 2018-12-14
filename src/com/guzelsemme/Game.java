package com.guzelsemme;

import com.guzelsemme.display.Display;

public class Game implements Runnable {

    private Display display;
    private int width,height;

    private Thread thread;

    public Game(String title,int width,int height){
        this.width = width;
        this.height = height;
        display = new Display(title, width, height);
    }

    @Override
    public void run() {

    }

    public synchronized void start(){

    }

}
