/*
Author: Alex Liu, Michael Cheng
Date: July 18th, 2020
Description: Plant Objects
*/

public class Plant {
  private int numPlants;
  private int plantHealth;
  private double plantInput;
  private int plantLifespan = 130;

  public Plant() {
    numPlants = 1;
    plantHealth = 4;
    plantInput = 1.5;
    plantOutput = 1.5;
  }

  public void updateHealth(int nutrients, int life, int temperature) {

  }

  public void updateLife(int health) {

  }

  public void setInput() {
    plantInput = Fish.getOutput() / numPlants;
  }

  public double getQuality(int input) {

  }




}
