/*
Author: Alex Liu, Michael Cheng
Date: July 18th, 2020
Description: Plant Objects
*/

public class Plant {
  private int numPlants;
  private double plantHealth;
  private double plantInput;
  private int plantLifespan = 130;
  private int minFood;
  private int minLight;

  public Plant() {
    numPlants = 1;
    plantHealth = 4.0;
    plantInput = 1.5;
    plantOutput = 1.5;
    minFood = ((0.0075/2.205)*1000);
    minLight = 100;
  }

  public void updateHealth() { //update the health of the plant
    double qtFood = Fish.getOutput() / numPlants;
    double qtSunlight = BackEnd.getSunlight() / numPlants;

    //food requirements
    if (qtFood < minFood) {
      if ((qtFood-(minFood/1.2)) < 0) {
          plantHealth += (qtFood-(minFood/1.2));
      } else {
        plantHealth -= (qtFood-(minFood/1.2));
      }
    }

    //sunlight requirements
    if (qtSunlight < minLight) {
      if ((qtSunlight-(minLight/5)) < 0) {
          plantHealth += (qtSunlight-(minLight/5));
      } else {
          plantHealth -= (qtSunlight-(minLight/5));
      }
    }

    if (qtSunlight > 400) { //too much sunlight, plant just dies
      plantHealth == 0;
    }

    //temperature requirements
    if(BackEnd.getPTemp() > 23 || BackEnd.getPTemp() < 21) {
      plantHealth -= 0.625;
    }

  }

  public String getHealth() { //returning the Health of the Plant
    if (plantHealth <= 0) {
      return "Dead";

    } else if (plantHealth <= 1) {
      return "Weak";

    } else if (plantHealth <= 2) {
      return "Average";

    } else if (plantHealth <= 3) {
      return "Good";

    } else if (plantHealth <= 4) {
      return "Perfect";
    }
  }

  public void updateLife() { //udpating the life expectancy

  }

  public int getLifeUpdate() {

  }

  public void setInput() {
    plantInput = Fish.getOutput() / numPlants;
  }

  public double getQuality() {
    double waterQ = Fish.getOutput() - (((0.0075/2.205)*1000)*numPlants);

    if (waterQ < 0) {
      return 0;
    } else {
      return waterQ;
    }
  }




}
