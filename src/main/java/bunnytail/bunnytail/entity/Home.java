package bunnytail.bunnytail.entity;

import bunnytail.bunnytail.controller.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Home extends Canvas implements  Runnable{
    private static final long serialVersionId = 1L;
    private static final int HEIGHT = 800;
    private static final int WIDTH = 800;
    private static int aps = 0;
    private static int fps = 0;
    private static JFrame window;
    private static Thread thread;
    private static Keyboard keyboard;
    private static volatile boolean itsOn = false;
    private static final String NAME = "Bunny Tail";


    public Home(){
        setPreferredSize(new Dimension(HEIGHT, WIDTH));

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        window  = new JFrame(NAME);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true );
    }

    public synchronized void init(){
        itsOn = true;
        thread = new Thread(this, "Graphics");
        thread.start();
    }
    public synchronized void stop(){
        itsOn = false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void update(){
        aps++;
    }
    public void showIt(){
        fps++;
    }

    @Override
    public void run() {
        final int NS_BY_SECOND = 1000000000;
        final byte APS_GOAL = 60;
        final double NS_BY_UPDATE = NS_BY_SECOND / APS_GOAL;
        long referenceUpdate = System.nanoTime();
        long refereceCounter = System.nanoTime();
        double timeRunning;
        double delta = 0;

        while(itsOn){
            final long initLoop = System.nanoTime();
            timeRunning = initLoop - referenceUpdate;
            referenceUpdate = initLoop;
            delta += timeRunning / NS_BY_UPDATE;
            while(delta >= 1){
                update();
                delta--;
            }
            showIt();

            if(System.nanoTime() - refereceCounter > NS_BY_SECOND){
                window.setTitle(NAME + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                refereceCounter = System.nanoTime();
            }
        }
    }
}
