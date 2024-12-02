package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day02 {
    private final String filename = "./src/day02/input.txt";
    private int counter = 0; 
     
    
    

    public static void main(String[]arg) throws IOException{

        Day02 d = new Day02(); 
        d.reader(); 
        System.out.println(d.counter);

    }
   
  
     
    
    
    void reader () throws IOException{
    BufferedReader buffer = new BufferedReader(new FileReader(filename));
        try {
            
            String line = buffer.readLine();
            
            while (line != null) {

                String[] parts = line.split(" ");

        
                ArrayList<Integer> temp = new ArrayList<Integer>(); 

                for(String g : parts){
                    temp.add(Integer.parseInt(g)); 
                }

                if(this.accendingOrDecinding(temp)){
                    counter = counter + 1; 
                } 


                // rewrite the object 
                temp = null; 
                // read next line so we are still inside the loop
                line = buffer.readLine();
            }
        } finally {
            buffer.close();
        }
        
    }
    private boolean accendingOrDecinding(ArrayList<Integer> input){
        
        //boolean flag1 = true;
        boolean accending = true; 
        boolean decinding = true; 
        
        for (int i = 1; i < input.size(); i++) {
            
            int diff = input.get(i) - input.get(i - 1);

            if (diff < 1 || diff > 3) {
                return false; // Adjacent levels must differ by at least 1 and at most 3
            }

            if (diff < 0) {
                accending = false; // Not increasing
            } else if (diff > 0) {
                decinding = false; // Not decreasing
            }

            // If neither increasing nor decreasing, it's not safe
            if (!accending && !decinding) {
                return false;
            }
        }
        
        
        return true;

    }

    
}
