import java.util.ArrayList;
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
    static double food = 100;
    static ArrayList<Fish> fishes = new ArrayList<>();

    //variables for plants
    static int sunlight = 100;
    static ArrayList<Plant> plants = new ArrayList<>();

    //variables for the tank
    static double pH = 7.5;
    static int volume = 1000;
    static int wtemp = 22;
    static int ptemp = 22;

    //Timer
    private static Timer myTimer = new Timer();
    private static long totalElapsedTime = 0;
    private static long elapsedTime = 0;

    public static void changeVolume(int n)
    {
        volume = n;
    }

    public void increaseWTemp()
    {
        wtemp++;
    }

    public void decreaseWTemp()
    {
        wtemp--;
    }

    public void increasePTemp()
    {
        ptemp++;
    }

    public void decreasePTemp()
    {
        ptemp--;
    }

    public static double getFood()
    {
        return food / fishes.size();
    }

    public static void addFish()
    {
        fishes.add(new Fish());
    }

    public static void removeFish(int i)
    {
        fishes.remove(i);
        Fish.removeFish();
    }

    public static void addPlant()
    {
      plants.add(new Plant());
    }

    public static void removePlant(int i)
    {
        plants.remove(i);
        Plant.removePlant();
    }

    public static void increasepH()
    {
        pH += 0.1;
    }

    public static void decreasepH()
    {
        pH -= 0.1;
    }

    public static void increaseSunlight() {
      sunlight += 25;
    }

    public static void decreaseSunlight() {
      sunlight -= 25;
    }

    //Start the timer
    public static void startTime() {
        long startTime = System.currentTimeMillis();

        myTimer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                elapsedTime =(System.currentTimeMillis() - startTime) * speed + totalElapsedTime;
                long elapsedDays = elapsedTime / 1000;

                ArrayList<Integer> deadFishes = new ArrayList<>();
                ArrayList<Integer> deadPlants = new ArrayList<>();

                if (Fish.getNumFish() > 0)
                {
                    for (Fish fish : fishes)
                    {
                        fish.updateWeight();

                        if (checkDeadFish(fish))
                        {
                            deadFishes.add(fishes.indexOf(fish));
                        }
                    }

                    for (int i = deadFishes.size()-1; i >= 0; i--)
                    {
                        removeFish(i);
                    }
                }

                if (Plant.getNumPlant() > 0)
                {
                    for (Plant plant : plants) {
                        plant.updateHealth();

                        if (plant.getHealth().equals("Dead"))
                        {
                            deadPlants.add(plants.indexOf(plant));
                        }

                        System.out.println(plant.getHealth());
                    }

                    for (int i = deadPlants.size()-1; i >= 0; i--)
                    {
                        removePlant(i);
                    }
                }

                pH += Plant.getQuality()/4;
            }
        };

        myTimer.schedule(task,0,1000/speed);
    }

    public static int getDays()
    {
        return (int) ((elapsedTime + totalElapsedTime)/1000);
    }

    public static double getpH()
    {
        return pH;
    }

    public static int getSunlight()
    {
      return sunlight;
    }

    public static boolean checkDeadFish(Fish f)
    {
        if (f.getDeathChance() >= 100)
            return true;

        double chance = (Math.random() * 100) + 50;
        return chance <= f.getDeathChance();
    }

    public static double getTotalFishOutput()
    {
        int output = 0;

        for (Fish f : fishes)
        {
            output += f.getOutput();
        }

        return output;
    }

    public static int getNumFishes()
    {
        return fishes.size();
    }

    public static double getWTemp()
    {
        return wtemp;
    }

    public static double getPTemp()
    {
        return ptemp;
    }

    public static double getWTempImperial()
    {
        return (wtemp * 9/5) + 32;
    }

    public static double getPTempImperial()
    {
        return (ptemp * 9/5) + 32;
    }

    public static double getTotalFishOutputImperial()
    {
        int output = 0;

        for (Fish f : fishes)
        {
            output += f.getOutput();
        }

        return output / 28.35;
    }

    //Pause the timer
    public static void changeSpeed(int s)
    {
        totalElapsedTime = elapsedTime;
        myTimer.cancel();
        speed = s;

        if (s != 0)
            resume();
    }

    //Resume the timer
    public static void resume()
    {
        startTime();
    }
}
