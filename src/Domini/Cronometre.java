package Domini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Cronometre {
    private int segons;
    private final Timer timer;
    private final ActionListener timerListener;
    
    public Cronometre(){
        timerListener = (ActionEvent e) -> {
            incrementarSegons();
        };
        segons = 00;
        timer = new Timer(1000, timerListener);
    }
    
    private void incrementarSegons(){
        ++segons;
    }
    
    public void showCurrentValue(){
        System.out.print("Segons: ");
        if(segons < 10) System.out.print("0");
        System.out.println(segons);
    }
    
    public int getCurrentTime(){
        return this.segons;
    }
    
    public void start(){
        timer.start();
    }
    
    public void stop(){
        timer.stop();
    }
    
    public void restart(){
        segons = 0;
        timer.stop();
        timer.restart();
    }
    
    public void end(){
        timer.stop();
        timer.removeActionListener(timerListener);
    }
}
