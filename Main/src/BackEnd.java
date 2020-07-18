import java.util.Timer;
import java.util.TimerTask;

/*
Author: Alex Liu, Michael Cheng
Date: July 18th, 2020
Description: The backend (variable change, synthesizing data, etc) portion of the project
 */

public class BackEnd {

    //variables for speed
    static int speed = 2;

    //variables for fish
    static int numFish = 0;
    static double food = 10;

    //variables for plants
    static int numPlants = 0;
    static int health = 0;
    static int plantInput = 0;
    static int plantOutput = 0;
    static int plantLifespan = 5;

    //variables for the tank
    static int pH = 7;
    static int volume = 1000;
    static double roF = 2.31;
    static float wtemp = 20;
    static float ptemp = 20;
    
    //Timer
    private static Timer myTimer;
    private static long totalElapsedTime = 0;
    private static long elapsedTime = 0;
    
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
    
    public void changeVolume(int n)
    {
        volume = n;
    }
    
    public static double getFood()
    {
        return food;
    }
    
    //Start the timer
    public static void startTime() {
        long startTime = System.currentTimeMillis();
        
        myTimer=new Timer();
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                elapsedTime =(System.currentTimeMillis() - startTime) * speed + totalElapsedTime;
                long elapsedDays = elapsedTime / 1000;
                long daysDisplay = elapsedDays % 60;
                long elapsedMinutes = elapsedDays / 60;
                
                
               }
        };

        myTimer.schedule(task,0,1000/speed);
    }
    
    //Pause the timer
    public static void changeSpeed(int s)
    {
        totalElapsedTime = elapsedTime;
        speed = s;
        myTimer.cancel();
        
        if (s != 0)
            resume();
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