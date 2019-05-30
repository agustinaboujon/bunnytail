package bunnytail.bunnytail.entity;

import javax.swing.*;
import java.awt.*;

public class Home extends Canvas implements  Runnable{
    private static final long serialVersionId = 1L;
    private static final int HEIGHT = 800;
    private static final int WIDTH = 800;
    private static JFrame window;
    private static Thread thread;
    private static volatile boolean itsOn = false;
    private static final String NAME = "Bunny Tail";


    public Home(){
        setPreferredSize(new Dimension(HEIGHT, WIDTH));

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

    @Override
    public void run() {
        while(itsOn){

        }
    }
}
