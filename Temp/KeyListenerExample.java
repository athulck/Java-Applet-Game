import java.awt.*;  
import java.awt.event.*;  
public class KeyListenerExample extends Frame implements KeyListener{  

    TextArea area;  
    KeyListenerExample(){  
          
        area=new TextArea();  
        area.setBounds(0, 30, 50, 50);  
        area.addKeyListener(this);  

        add(area);  
        setSize(50,70);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void keyPressed(KeyEvent e) {
        area.setText(""); 
    }  
    public void keyReleased(KeyEvent e) { 

        String text=area.getText();  
        String words[]=text.split("\\s");  
        System.out.println("Key pressed : "+text);  
    }  
    public void keyTyped(KeyEvent e) {}  
  
    public static void main(String[] args) {  
        new KeyListenerExample();  
    }  
}  