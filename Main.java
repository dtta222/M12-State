//*************************************************************************
//M12-State.java
//Date: 04/12/2023
//Author: David Taylor
//Class: CIT 149–19Z1–78178
//Instructor: Krishna Nandanoor
//Purpose: Develop a Java application where you display all the state names, nicknames and ratified dates in a nicely
// formatted manner
//*************************************************************************

import java.util.Scanner;
import java.io.*;

public class Main {

    public static String formatDate(State[] stateArray, int count) {
        String date = stateArray[count].getDateEnteredUnion();

        //store first four char to "add" variable
        String add = date.substring(0,4);
        String temp = date.substring(5,date.length());
        temp += "-" + add;

        return temp;
    }

    public static String stateBird(State[] stateArray) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            //compare array String to "Cardinal"
            if (stateArray[i].getStateBird().equals("Cardinal")) {
                count += 1;
            }
        }
        //turn int to String
        return String.valueOf(count);
    }
    public static String settledBefore(State[] stateArray) {
        int count = 0;

        for (int i = 0; i < 50; i++) {
            //compare states settled before 1675
            if (stateArray[i].getYearSettled() < 1675) {
                count += 1;
            }
        }
        //turn int to String
        return String.valueOf(count);
    }

    public static int firstSettled(State[] stateArray) {
        int count = 0;

        int year = stateArray[0].getYearSettled();

        for (int i = 1; i < 50; i++) {
            //first earliest settled state
            if (year > stateArray[i].getYearSettled()) {
                count = i;
            }
        }
        //turn int to String
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String fileRecord = "";
        Scanner fileScan, lineScan;
        int count = 0;

        State stateArray [] = new State[50];

        String stateName, stateCapital, stateBird, stateFlower, nickname, dateEnteredUnion;
        int yearSettled;

        fileScan = new Scanner (new File("StateData.txt"));

        while (fileScan.hasNext()) {
            fileRecord = fileScan.nextLine();

            lineScan = new Scanner(fileRecord);
            lineScan.useDelimiter(",");

            stateName = lineScan.next();
            stateCapital = lineScan.next();
            stateBird = lineScan.next();
            stateFlower = lineScan.next();
            nickname = lineScan.next();
            dateEnteredUnion = lineScan.next();
            yearSettled = lineScan.nextInt();

            stateArray[count] = new State(stateName, stateCapital, stateBird, stateFlower, nickname, dateEnteredUnion, yearSettled);
            count++;

        }

        System.out.println("\nAccessing State Data and Displaying Them\n");

        // Display select data from the array
        System.out.printf("%-15s\t\t%-20s\t\t%-18s", "STATE NAME", "NICKNAME", "DATE RATIFIED");
        System.out.println("\n==========================================================================================");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s\t\t%-20s\t\t%-18s\n", stateArray[i].getStateName(), stateArray[i].getNickName(), formatDate(stateArray, i));
        }

        System.out.printf("\nNumber of states settled before 1675: %s\n", settledBefore(stateArray));
        System.out.printf("\nNumber of states with some type of Cardinal as a state bird: %s\n", stateBird(stateArray));
        int x = firstSettled(stateArray);
        System.out.printf("\nFirst state settled: %s in %d\n", stateArray[x].getStateName(), stateArray[x].getYearSettled());

        stateArray[0].setDateEnteredUnion("1800?00?00");
    }
}