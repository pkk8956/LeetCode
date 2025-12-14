package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC_649 {

    //Dota2 Senate

    /* In a world where Dota2 has just become a popular sport, the Dota2 senate consists of two parties: 
    the Radiant and the Dire. The Dota2 senate wants to make a decision about a change in the Dota2 game. 
    The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
    1. Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
    2. Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, 
    he can announce the victory and decide on the change in the game.
    Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant 
    party and the Dire party respectively. Then if there are n senators, the size of the given string will be n.
    The round-based procedure starts from the first senator to the last senator in the given order. 
    This procedure will last until the end of voting. You need to predict which party will finally 
    announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire". */

    public static void main(String[] args) {
        LC_649 obj = new LC_649();
        String senate = "RDD";
        System.out.println(obj.predictPartyVictory(senate));
    }

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Initialize the queues with the indices of the senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }

        // Simulate the rounds of banning
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
    
}
