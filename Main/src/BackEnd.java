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