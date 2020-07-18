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
    
    public Fish()
    {
        weight = 1;
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
    }
}