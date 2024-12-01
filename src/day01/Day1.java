package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Day1 {

    static ArrayList listLeft = new ArrayList<>();
    static ArrayList listRight = new ArrayList<>();
    static ArrayList result; 
    
    FileReader reader;

    Scanner scanner;

    public static void main(String[] arg) throws IOException {
        Day1 d = new Day1();
        try {
            d.reader("./src/day01/input.txt");
        

            d.sortSmallestToLargest(listLeft); 
            d.sortSmallestToLargest(listRight); 

            System.out.println("Part1: " + d.counterSolverPart1(listLeft, listRight));

            System.out.println("---------part2--------");

            
            System.out.println("Part2: " + d.counterSolverPart2(listLeft, listRight));



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void reader(String filename) throws IOException {
        // reads from the file
        BufferedReader buffer = new BufferedReader(new FileReader(filename));
        try {
            StringBuilder sb = new StringBuilder();
            String line = buffer.readLine();
            while (line != null) {

                String[] parts = line.split(" ");

                // no so smart sollution

                listLeft.add(Integer.parseInt(parts[0]));
                listRight.add(Integer.parseInt(parts[3]));

                // read next line so we are still inside the loop
                line = buffer.readLine();
            }
        } finally {
            buffer.close();
        }
        // System.out.println(builder);
    }

    public int StringToInt(String s) {
        return Integer.parseInt(s);
    }

    private void Print(ArrayList s) {
        for (Object g : s) {
            System.out.println(g);
        }

    }
    private ArrayList<Integer>sortSmallestToLargest(ArrayList<Integer> s){
        if(s.isEmpty()){
            return null; 
        }
        ArrayList<Integer> temp = s; 
        Collections.sort(temp);
        return temp;
    }

    
    private int counterSolverPart1(ArrayList<Integer> l, ArrayList<Integer> r){

        result = new ArrayList<>();
        int counter = 0;  
        int temp = 0; 

        for(int i = 0; i < l.size() && i < r.size(); i++){
            temp = Math.abs(l.get(i) - r.get(i)); 
            counter = counter + temp; 
        }

        return counter; 
    }
    private long counterSolverPart2 (ArrayList<Integer> l, ArrayList<Integer> r){
        long counter = 0; 

        int leftSide = 0; 
        int timeOnRight = 0; 

        for(int i = 0; i < l.size(); i++){
            leftSide = l.get(i); 
            System.out.println(leftSide);
            for(int j = 0 ; j < r.size(); j++){
                int temp2 = r.get(j); 
                if(leftSide == temp2){
                    timeOnRight ++; 
                }
            }
            counter =  (leftSide * timeOnRight) + counter; 
            timeOnRight = 0; 
        }





        return counter; 
    }

}