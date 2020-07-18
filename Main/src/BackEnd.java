<<<<<<< HEAD
import java.util.Timer;
import java.util.TimerTask;

public class BackEnd
{
    //Variables
    private static int speed = 2;
    private int numPlants = 1;
    private int numFish = 1;
    
    //Timer
    private static Timer myTimer;
    private static long totalElapsedTime = 0;
    private static long elapsedTime = 0;
    
    //Change the speed of the simulation
    public void changeSpd(int s)
    {
        speed = s;
    }
    
    //Change the number of plants
    public void changePlants(int n)
    {
        numPlants = n;
    }
    
    //Change the number of fish
    public void changeFish(int n)
    {
        numFish = n;
    }
    
    //Start the timer
    public static void startTime() {
        long startTime = System.currentTimeMillis();
        
        myTimer=new Timer();
        
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                elapsedTime = (System.currentTimeMillis() - startTime) * speed + totalElapsedTime;
                long elapsedSeconds = elapsedTime / 1000;
                long secondsDisplay = elapsedSeconds % 60;
                long elapsedMinutes = elapsedSeconds / 60;
                System.out.println(String.format("%02d:%02d", elapsedMinutes, secondsDisplay));
               }
        };

        myTimer.schedule(task,0,1000/speed);
    }
    
    //Pause the timer
    public static void pause()
    {
        totalElapsedTime = elapsedTime;
        myTimer.cancel();
    }
    
    //Resume the timer
    public static void resume()
    {
        startTime();
    }
    
    public static void main(String[] args)
    {
        startTime();
    }
}
=======
/*
Author: Alex Liu, Michael Cheng
Date: July 18th, 2020
Description: The backend (variable change, synthesizing data, etc) portion of the project
 */

/**
 *
 * @author Admin
 */
public class BackEnd {

  //variables for speed
  static int speed = 1;

  //variables for fish
  static int numFish = 0;
  static int weight = 0;
  static int lifespan = 10;
  static int food = 10;
  static int fishOutput = 5;

  //variables for plants
  static int numPlants = 0;
  static int lifeSpan = 0;
  static int plantInput = 0;
  static int plantOutput = 0;
  static int lifespan = 5;

  //variables for the tank
  static int pH = 7;
  static int


}
>>>>>>> 5d3d4e0e28d923a679161aca8b0d4530146f0d2c
