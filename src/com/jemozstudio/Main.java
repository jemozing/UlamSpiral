package com.jemozstudio;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Main extends JFrame {

    public int width;
    public int height;
    public int number;
    int x=0,y=0;
    Color color = new Color(0,0,0);
    public Main(int width, int height){
        this.width = width;
        this.height = height;
        setTitle("UlamSpiral");
        setSize (new Dimension (width, height));
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize (), fSize = getSize ();
        if (fSize.height > sSize.height) {fSize.height = sSize.height;}
        if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
        setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/2);

        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setVisible (true);
    }

    public boolean checkNum(int number){
        if((number%10==1)||(number%10==3)||(number%10==7)||(number%10==9)){
         for(int i = 3; i <= Math.sqrt(number);i+=2){
             if(number%i==0)
                 return false;
         }
         return true;
        }
        return false;
    };

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.drawRect(width/2,height/2,0,0);

        g.drawRect(width/2+x,height/2+y,0,0);
    };
    public void run(){
        number = 1;
        int radius=2;
        while (true){
                color = Color.WHITE;
                if(radius%2==0){
                    for(int i = 1; i < radius; i++){
                        if(Math.abs(x)<=radius && Math.abs(x) <= width/2){
                            x++;
                            if(checkNum(number)){
                                color = Color.BLACK;
                                paint(getGraphics());
                                try {
                                    sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                color = Color.WHITE;
                            }
                            number++;
                        }
                    }
                    for(int i = 1; i < radius; i++){
                        if(Math.abs(y)<=radius && Math.abs(y) <= height/2){
                            y++;
                            if(checkNum(number)){
                                color = Color.BLACK;
                                paint(getGraphics());
                                try {
                                    sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                color = Color.WHITE;
                            }
                            number++;
                        }
                    }
                }
                else {
                    for(int i = 1; i < radius; i++){
                        if(Math.abs(x)<=radius && Math.abs(x) <= width/2){
                            x--;
                            if(checkNum(number)){
                                color = Color.BLACK;
                                paint(getGraphics());
                                try {
                                    sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                color = Color.WHITE;
                            }
                            number++;
                        }
                    }
                    for(int i = 1; i < radius; i++){
                        if(Math.abs(y)<=radius && Math.abs(y) <= height/2){
                            y--;
                            if(checkNum(number)){
                                color = Color.BLACK;
                                paint(getGraphics());
                                try {
                                    sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                color = Color.WHITE;
                            }
                            number++;
                        }
                    }
                }





            radius ++;

        }
    };
    public static Main main;
    public static void main(String[] args) {
        main = new Main(1001,1001);
        main.run();
    }
}
