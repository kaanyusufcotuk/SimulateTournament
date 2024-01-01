import java.util.Scanner;
import java.util.Random;

public class App{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("How many teams are there in the tournament?");
        int numTeams = input.nextInt();
        String[] Teams = new String[numTeams];

        for (int i = 0; i < numTeams; i++){
            System.out.print("Enter the team name: ");
            String team = input.next();
            Teams[i] = team;
        }        

        int numTour = (int)(Math.log(numTeams) - Math.log(2));
        for (int h = 0; h < numTour; h++) {
	        String[][] Match = DrawTheMatches(Teams);
	        for (int i = 0; i < Match.length; i++) Teams[i] = null;
	        
	        Teams = new String[Match.length];
	        
	        for (int i = 0; i < Match.length; i++) {
	        	System.out.println(Match[i][0] + " vs " + Match[i][1]);
		       	System.out.print("Who won the match? ");
		       	String winner = input.next();
		       	Teams[i] = winner;
	        }
        }
        
    }

    public static String[][] DrawTheMatches(String[] Teams){
        Random random = new Random();
        int numMatch = (int) Math.floor(Teams.length/2) + 1;
        String[][] Match = new String[numMatch][2];

        for(int i = 0; i < numMatch; i++){
            int home = random.nextInt(Teams.length);
            int visitor = random.nextInt(Teams.length);
            
            if (i < numMatch - 1) {
            	while (home == visitor || Teams[home] == null) home = random.nextInt(Teams.length);
	            while (Teams[visitor] == null) visitor = random.nextInt(Teams.length);
            }
            
           	Match[i][0] = Teams[home];
           	Match[i][1] = Teams[visitor];
           	Teams[home] = null;
           	Teams[visitor] = null;
        }
        return Match;
    }
}
