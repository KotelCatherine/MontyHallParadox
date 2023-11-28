package ru.geekbrains.threading;

import java.util.HashMap;
import java.util.Random;

public class ParadoxStatistic {
    static Random randomGenerator  = new Random();
    static int iterations = 1000;
    static HashMap<Integer, String> statistic = new HashMap<>();
    static String playerOptionString = "Win with a door replacement";

    public ParadoxStatistic() {
        int winningStrat = 0;
        int strategy2 = 0;
        for(int i = 0; i < iterations; i++)
        {
            int prze = randomGenerator.nextInt(3);
            int playerOption = randomGenerator.nextInt(3);
            int hostOption = chooseAlterDoor(prze, playerOption);
            int playerOption2 = chooseAlterDoor(playerOption, hostOption);

            if(playerOption2 == prze) {
                winningStrat++;
                statistic.put(i, playerOptionString);
            }

            strategy2 = 1000 - winningStrat;
        }

        System.out.println("Number of wins if the door changes: " + winningStrat
                + "\nWins if the door does not change: " + strategy2 );
    }

    static int chooseAlterDoor(int door1,int door2)
    {
        int door3;

        do
            door3 = randomGenerator.nextInt(3);
        while (door3 == door1 || door3 == door2);

        return door3;
    }
}
