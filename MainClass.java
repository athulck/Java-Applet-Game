
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class MyKeyListener extends Frame implements KeyListener{  

    TextArea area;
    String text;

    MyKeyListener(){  
          
        area = new TextArea();  
        area.setBounds(0, 30, 50, 50);  
        area.addKeyListener(this);  

        add(area);
        setSize(50,70);  
        setLayout(null);  
        setVisible(true);  
    }  
    
    //Abstract Method overriding
    public void keyPressed(KeyEvent e) { 
    	area.setText(""); 
    } 

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {
    	text = area.getText();
    	System.out.println("Key pressed : "+text);
    }
    
    public String getInput() {
    	return text;
    }

}  

public class MainClass extends Applet implements Runnable {

	int x=165, y=510;
	Image road;
	Image car;
	MyKeyListener kle;

	public void init () {
		
		kle = new MyKeyListener();
		(new Thread(this)).start();

		road = getImage (getDocumentBase(), "road.jpg");
		car = getImage (getDocumentBase(), "PlayerCar.png");

	}

	public void paint (Graphics G) {

		//drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
		G.drawImage(road, 30, 30, 500, 600, null);
		G.drawImage(car, x, y, 65, 134, null);
		//System.out.println(x+":"+y);
	}

	public void run () {

		String inp;
		while (true) {
			
			//Getting user controls
			inp = kle.getInput();
			if (inp != null){

				if(inp.equals("a")) //Moving Left
				{
					if (x > 165) x -= 5;
					else x = 165;
				}
				else if(inp.equals("d")) //Moving Right
				{
					if (x < 330) x += 5;
					else x = 330;
				}
				else if(inp.equals("w")) //Moving Up
				{
					if (y > 30) y -= 2;
					else y = 30;
				}
				else if(inp.equals("s")) //Moving Down
				{
					if (y < 510) y += 3;
					else y = 510;
				}
			}

			y -= 1; //Speed
			repaint();

			//Delay
			try{
				Thread.sleep(100);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

/*
<applet code = "MainClass.class"
		height = 700
		width = 600>
</applet>
*/

