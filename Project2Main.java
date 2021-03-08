/*
Shea Suggs 
comp 250 
Tyler Hylander 

talked about some errors with austin 
talked about classes with Casey

The point of this code is to simulate an entire baseball series like the play offs 
game and then print the results out the the viewer/ user 
*/

package Suggs_Project2;

import java.util.ArrayList;
import java.util.Arrays;

public class project2Main 
{
    // global array that will keep track of bases 
    static String[] bases = { "Empty", "Empty", "Empty" };

    // global array list of the players names and there batting averages 
   static ArrayList<hitters> homeHitters = new ArrayList<hitters>();
   static ArrayList<hitters> awayHitters = new ArrayList<hitters>();

    // global pitching arrays for the pitchers witch hold the pitchers name and there pitching average 
    static ArrayList<Pitcher> teamPitchers = new ArrayList<Pitcher>();

    // global ints to keep track of who should be going in the list 
    static int homeOrder = 0;
    static int awayOrder = 0;

    // average pro batting average is .250

    public static void main(String[] args) {
    // Hometeam batters 
        homeHitters.add(new hitters("Nemesis", .250));
        homeHitters.add(new hitters("Nike", .300));
        homeHitters.add(new hitters("Nox", .270));
        homeHitters.add(new hitters("Odin", .310));
        homeHitters.add(new hitters("Aries", .200));
        homeHitters.add(new hitters("Pele", .305));
        homeHitters.add(new hitters("Thanatos", .250));
        homeHitters.add(new hitters("Set", .266));
        homeHitters.add(new hitters("skadi", .290));
        homeHitters.add(new hitters("Sobek", .300));
    // Awayteam batters 
        awayHitters.add(new hitters("sol",.267));
        awayHitters.add(new hitters("Terra",.359));
        awayHitters.add(new hitters("Ra",.220));
        awayHitters.add(new hitters("Thoth",.280));
        awayHitters.add(new hitters("Tyr",.234));
        awayHitters.add(new hitters("Uler",.212));
        awayHitters.add(new hitters("Yemoja",.240));
        awayHitters.add(new hitters("Zeus",.290)); 
        awayHitters.add(new hitters("Ymir", .300));

    // pitchers
        teamPitchers.add(new Pitcher("Anubis",70));
        teamPitchers.add(new Pitcher("Neith",75));

        int homeSeriesScore = 0;
        int awaySeriesScore = 0;
        int seriesNum = 1;
        boolean winner = true; 
        boolean newChamoion = true; 

        
        System.out.println("Lets PLay ball!!");
        // while loop for the best of 7
        while (newChamoion) 
        {
            
            System.out.println();
            System.out.println("Series number: " + (seriesNum + 1) + " is being played now");
            System.out.println("The Series score is " + "homes series wins: " + homeSeriesScore + " away series wins: " + awaySeriesScore);

            winner = simulate();
            if (winner == true) {
                homeSeriesScore += 1;
                System.out.println("the home team wins!! game " + seriesNum + " of the series");
                System.out.println();
            }else if (winner == false) {
                awaySeriesScore += 1;
                System.out.println("the away team wins!! game " + seriesNum + " of the series");
                System.out.println();
            }

            if(homeSeriesScore == 4){
                System.out.println();
                System.out.println("The Series score is " + "homes series wins: " + homeSeriesScore + " away series wins: " + awaySeriesScore);
                System.out.println("IT'S ALL OVER!");
                System.out.println("The Home team has won the whole series!!");
                System.out.println("The home team is the world champions!!");
                newChamoion = false;
            }else if(awaySeriesScore == 4){
                System.out.println();
                System.out.println("The Series score is " + "homes series wins: " + homeSeriesScore + " away series wins: " + awaySeriesScore);
                System.out.println("IT'S ALL OVER!");
                System.out.println("The Away team has won the whole series!!");
                System.out.println("The Away team is the world champions!!");
                newChamoion = false; 
            }
            
            homeOrder = 0; // need to reset the order every series 
            awayOrder = 0;
            seriesNum += 1;
        }
        
    }

    public static boolean simulate()
    {
        /*
         * the point of this fucntion is to simulate a whole game of baseball and play out all 9 endings 
         * when this function is done it returns a boolean 
         * if true is returned that mean that the home team won, if false is returned that means that the away team has won
         * 
         * this plays through all 9 ending of a game and then on the 9th ending if the home team is winning then the game ends 
         */



    boolean winner = true; // this returns true if home team winns and flase if away team wins
    int inning = 0; 
    int homeScore = 0;
    int awayScore = 0;


    // will have a while loop that stops once 9 endings have been played 
        while(inning != 9)
        {
            System.out.println("Top of the Inning " + (inning + 1));
            System.out.println("Home: " + homeScore + " Away: " + awayScore); 
            System.out.println(" ");
            System.out.println(" ");

            if(inning == 9)
            {
                for(int i = 0; i < 2; i++)
                {
                    if(i == 1)
                    {
                        awayScore += awayAtbat();
                    }
                    else
                    {
                        if(awayScore > homeScore)
                        {
                            System.out.println("The Home team has won no need to play this last round");
                            break;
                        }
                        homeScore += HomeAtbat();
                    }
                }   
            }

            else
            {
                for(int i = 0; i < 2; i++)
                {
                  switch(i){
                      case 1:
                      awayScore += awayAtbat();
                      case 2:
                      homeScore += HomeAtbat();
                }
            }
        }
            inning += 1;

        }

        // for the bonos of when there is a tie 
        if(awayScore == homeScore){
            System.out.println("Top of the Inning " + (inning + 1));
            System.out.println("Home: " + homeScore + " Away: " + awayScore); 
            System.out.println("The score is tied exstra games will be played until there is a winner");

            while(homeScore == awayScore){
                for(int i = 0; i < 2; i++)
                {
                    System.out.println("Top of the Inning " + (inning + 1));
                    System.out.println("Home: " + homeScore + " Away: " + awayScore);
                    switch(i){
                        case 1:
                        awayScore += HomeAtbat();
                        case 2:
                        homeScore += awayAtbat();
                    }
                }
                inning += 1;
        } 
        }

            System.out.print("The final score of this game is: ");
            System.out.println("Home: " + homeScore + " Away: " + awayScore); 
            if(homeScore > awayScore){ 
                winner = true;
                System.out.println("The Home team has won the Game!!");
            }else{
                winner = false;
                System.out.println("The Away team has won the Game!!");
            }
        
            return winner; // return true means that the home team has won ---- return false mean that the away team has won. 
    }

    public static int playerRun(hitters hitters) {
        // this function just moves players in the bases array so that they match up with what is happening 
        // this returns a int for when a point has been scored in the current game this has been called in 

        int points = 0;
        
        if(bases[2] != "Empty"){
            points += 1;
            bases[2] = bases[1];
            bases[1] = bases[0];
            bases[0] = hitters.getName();
        }
        else if(bases[2] == "Empty"){
            bases[2] = bases[1];
            bases[1] = bases[0];
            bases[0] = hitters.getName();

        }
        else if(bases[1] == "Empty"){
            bases[1] = bases[0];
            bases[0] = hitters.getName();
        }
        else if(bases[0] == "Empty"){
            bases[0] = hitters.getName();
        }


        return points; 


    }

    public static void clearbases(){
        // the point of this function is to set all the bases back to empty
        bases[0] = "Empty";
        bases[1] = "Empty";
        bases[2] = "Empty";
    }


    public static int HomeAtbat() 
    {
        /*
         * the point of this function is to play out when the away pitcher is pitching and the home team has its batters going up 
         * this plays though the 3 outs 
         */

        int homeScore = 0;
        int ball = 0;
        int strikes = 0; 
        int outs = 0;
        int points = 0; // this int is just used to catch a return that may or may not sometimes have 0 
        boolean atBat = true;

        while(outs != 3)
        {
            System.out.println(homeHitters.get(homeOrder).getName() + " is batting now.");
            System.out.print("Bases: ");
            System.out.println(Arrays.toString(bases));
            System.out.println("Current outs: " + outs);
        
            // loop for when a player goes at bat
            while(atBat)
            {
                boolean inZone = teamPitchers.get(1).pitching();
                if(inZone == false) // pitcher missed the zone 
                {
                    ball += 1; 
                    if(ball == 4){
                        System.out.println("Walk !");
                        System.out.println("Ball: " + ball + " player: " + homeHitters.get(homeOrder).getName() + " gets a free base");
                        System.out.println();
                        strikes = 0;
                        ball = 0;
                        points = playerRun(homeHitters.get(homeOrder));
                        homeScore += points; 
                        points = 0;
                        homeOrder +=1; 
                        atBat = false;
                    } else{
                    System.out.println("Ball: " + ball + " Strikes: " + strikes);
                    }
                }

                else if(inZone == true) // pitcher was in the zone
                {
                    boolean hit = homeHitters.get(homeOrder).hitting();
                    if(hit == false){ // player missed the ball
                        strikes += 1;
                        if(strikes == 3){
                            System.out.println("Balls: " + ball + " Strikes: " + strikes);
                            System.out.println(teamPitchers.get(1).getName() + " struck batter " + homeHitters.get(homeOrder).getName() + " Out");
                            System.out.println("Batter: " + homeHitters.get(homeOrder).getName() + " has been struck out");
                            System.out.println(" ");
                            System.out.println(" ");
                            strikes = 0;
                            ball = 0;
                            outs += 1;
                            atBat = false;
                            homeOrder += 1;
                        }
                        else{
                        System.out.println("Balls: " + ball + " Strikes: " + strikes);
                        }
                        
                    }
                    if(hit == true){ // player hit the ball
                        System.out.println("Hit !");
                        System.out.println("Player: " + homeHitters.get(homeOrder).getName() + " hit the ball");
                        points = playerRun(homeHitters.get(homeOrder));
                        homeScore += points;
                        strikes = 0;
                        ball = 0;
                        if(points == 1)
                        {
                            System.out.println("The home team has scored a Run!! "); 
                        }
                        points = 0; 
                        System.out.println(" "); 
                        homeOrder += 1;
                        atBat = false; 
                    }
                }
            if(homeOrder > 9){
                homeOrder = 0;
            }
            }
        atBat = true;
        strikes = 0;
        ball = 0;

        }
            System.out.println("Home team has gotten 3 outs." + " The Home team scored: " + homeScore + " points");
            System.out.println(" ");
            if(homeOrder >= 9){
                homeOrder = 0;
            }
            clearbases();
            return homeScore;
        }
        // this resets all the sutff for the next team playing 

    public static int awayAtbat()
    {
        /*
        * the point of this function is to play out when the home pitcher is pitching and the away team has its batters going up 
         * this plays though the 3 outs 
         */

        int awayScore = 0;
        int ball = 0;
        int strikes = 0;
        int outs = 0;
        int points = 0; // this int is just used to catch a return that may or may not sometimes have 0 
        boolean atBat = true;
            
        while(outs != 3)            {
            System.out.println(awayHitters.get(awayOrder).getName() + " is batting now.");
            System.out.print("Bases: ");
            System.out.println(Arrays.toString(bases));
            System.out.println("Current outs: " + outs);
            
            // loop for when a player goes at bat
            while(atBat)
            {
                boolean inZone = teamPitchers.get(0).pitching(); // this calls the other team pitcher and puts it into the pitching function in the Pitcher class 
                if(inZone == false) // pitcher missed the zone 
                {
                    ball += 1; 
                    if(ball == 4){
                        System.out.println("Walk !");
                        System.out.println("Ball: " + ball + " player: " + awayHitters.get(awayOrder).getName() + " gets a free base");
                        System.out.println();
                        strikes = 0;
                        ball = 0;
                        points = playerRun(awayHitters.get(awayOrder));
                        awayScore += points; 
                        points = 0;
                        awayOrder +=1; 
                        atBat = false;
                    } else{
                    System.out.println("Ball: " + ball + " Strikes: " + strikes);
                    }
                }
    
                else if(inZone == true) // pitcher was in the zone
                {
                    boolean hit = awayHitters.get(awayOrder).hitting(); // this puts the current batter ups information into the bating function 
                    if(hit == false){ // player missed the ball
                        strikes += 1;
                        if(strikes == 3){
                            System.out.println("Balls: " + ball + " Strikes: " + strikes);
                            System.out.println(teamPitchers.get(1).getName() + " struck batter " + awayHitters.get(awayOrder).getName() + " Out");
                            System.out.println("Batter: " + awayHitters.get(awayOrder).getName() + " has been struck out");
                            System.out.println(" ");
                            System.out.println(" ");
                            strikes = 0;
                            ball = 0;
                            outs += 1;
                            atBat = false;
                            awayOrder += 1;
                        }
                        else{
                        System.out.println("Balls: " + ball + " Strikes: " + strikes);
                        }
                            
                    }
                    if(hit == true){ // player hit the ball
                        System.out.println("Hit !");
                        System.out.println("Player: " + awayHitters.get(awayOrder).getName() + " hit the ball");
                        points = playerRun(awayHitters.get(awayOrder));
                        awayScore += points;
                        strikes = 0;
                        ball = 0;
                        if(points == 1)
                        {
                            System.out.println("The away team has scored a Run!! "); 
                        }
                        points = 0; 
                        System.out.println(" "); 
                        awayOrder += 1;
                        atBat = false; 
                    }
                }
            if(awayOrder >= 8){
                awayOrder = 0;
            }
            }
        atBat = true;
        strikes = 0;
        ball = 0;
    
        }
            System.out.println("away team has gotten 3 outs." + " The away team scored: " + awayScore + " points");
            System.out.println(" ");
            if(awayOrder >= 9){
                awayOrder = 0;                
            }
                clearbases();
                return awayScore;
            }
            // this resets all the sutff for the next team playing 

}
