package com.guzelsemme;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.guzelsemme.display.Display;
import com.guzelsemme.gfx.ImageLoader;

public class Game implements Runnable {

    private Display display;
    private int width,height;
    private String title;
    
    private BufferStrategy bs;
    private Graphics g;

    private boolean running = false;
    
    private Thread thread;
    
    private BufferedImage testImage;

    public Game(String title,int width,int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    /*
     * this method will execute only at begining
     */    
    private void init() {
    	display = new Display(title, width, height);
    	testImage = ImageLoader.loadImage("/textures/photo.jpg");
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
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear the screen
		g.clearRect(0, 0, width, height);
		//Draw here
		
		
		g.drawImage(testImage,20,20,null);
		
		
		//End Drawing
		
		bs.show();
		g.dispose();
	}
    /*
     * update all variables
     * scenes and everything
     */
	private void tick() {
		// TODO Auto-generated method stub
		
	}

	public synchronized void start(){
    	if(running)
    		return;
    	running = true;
    	thread = new Thread(this);
    	thread.start();
    	
    }
    
    public synchronized void stop(){
    	if(!running)
    		return;
    	running = false;
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
