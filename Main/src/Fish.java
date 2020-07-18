<<<<<<< HEAD
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
        
        if (diff < minFood)
        {
            
        }
    }
=======
/*
Author: Alex Liu, Michael Cheng
Date: July 18th, 2020
Description: Fish Object
 */

/**
 *
 * @author Admin
 */
public class Fish {

>>>>>>> 01e08a429e4c28dd2fbf4a11b57a8f30ee36ff82
}
