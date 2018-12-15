package com.guzelsemme;

import com.guzelsemme.display.Display;

public class Game implements Runnable {

    private Display display;
    private int width,height;

    private boolean running = false;
    
    private Thread thread;

    public Game(String title,int width,int height){
        this.width = width;
        this.height = height;
        display = new Display(title, width, height);
    }

    /*
     * this method will execute only at begining
     */    
    private void init() {
    	
    }
    
    @Override
    public void run() {
    	init();
    	while(running) {
    		tick();
    		render();
    	}
    	stop();
    }

    /*
     * render everything
     */
    private void render() {
		// TODO Auto-generated method stub
		
	}
    /*
     * update all variables
     * scenes and everything
     */
	private void tick() {
		// TODO Auto-generated method stub
		
	}

	public synchronized void start(){
    	
    	thread = new Thread(this);
    	thread.start();
    	
    }
    
    public synchronized void stop(){
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
