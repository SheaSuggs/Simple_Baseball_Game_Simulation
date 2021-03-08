/*
the point of this class is to determine if the pitcher has thrown
in the zone or out of the zone

Assume the pitcher has thrown a strike, uses this batter's average 
to determine wheter he hits the pitch (methods returns true) 
or swings and misses (method returns false). 
*/

package Suggs_Project2;

import java.util.Random;

public class Pitcher 
{
    public String name;
    public double pitchingAvg;

    public Pitcher(String name, double pitchingAvg){
        this.name = name; 
        this.pitchingAvg = pitchingAvg;
    }


    public boolean pitching() // methods will be names and there pitching average 
    {
        // this function makes a radnom number between 1 - 100 
        // once the random number is made it compares that to the average of the pithcer and then returns true if its
        // in the zone and false if it not in the zone
        Random rnd = new Random();
        boolean inZone = true;

        int val1 = rnd.nextInt(100);
        if(pitchingAvg >= val1){
            inZone = true;
        }else if(pitchingAvg < val1){
            inZone = false;
        }
        
        return inZone;
    }

    public String getName(){
        return name;
    }public void setName(String name){
        this.name = name;
    }public double pitchingAvg(){
        return pitchingAvg;
    }public void pitchingAvg(double pitchingAvg){
        this.pitchingAvg  = pitchingAvg;
    }

    public String toString() {
        String str = ("pitcher name: " + name + "pitching Average: " + pitchingAvg);
        return str;
    }
}
