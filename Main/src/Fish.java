/*
Author: Alex Liu, Michael Cheng
Date: July 18th, 2020
Description: Fish Object
 */

public class Fish
{
    private double weight;
    private int age;
    private double lifespan;
    private double minFood;
    private double output;
    private double deathChance;
    
    public Fish()
    {
        weight = 2.4;
        age = 0;
        lifespan = 10 * 365;
        minFood = weight * 4.5;
        output = weight * 2.25;
    }

    //Update weight based on food intake
    public void updateWeight()
    {
        double diff = BackEnd.getFood() - minFood;
        double diffPercent = (diff / minFood);

        if (diffPercent < 0)
        {
            weight = weight * (1 - (0.6 * Math.abs(diffPercent)));
        }
        else {
            weight = weight * (1.05 + (0.05 * Math.abs(diffPercent)));
        }
        
        updateMinFood();
        updateOutput();
        updateAge();
    }
    
    public void updateMinFood()
    {
        minFood = weight * 4.5;
    }
    
    public void updateOutput()
    {
        output = BackEnd.getFood() / 2;
    }
    
    public void updateAge()
    {
        age++;
    }
    
    public void updateDeathChance()
    {
        double ageDeath = Math.pow(1.005, age - 3463);
        double weightDeath = Math.pow(2, Math.abs(5.125 - weight) - 0.1);
    }
    
    public double getMinFood()
    {
        return minFood;
    }
    
    public double getWeight()
    {
        return weight;
    }
    
    public double getAge()
    {
        return age;
    }
    
    public double getLifespan()
    {
        return lifespan;
    }
    
    public double getOutput()
    {
        return output / 2;
    }
}
