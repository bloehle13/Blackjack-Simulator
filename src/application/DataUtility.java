package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVWriter;


public class DataUtility {
	
	public static List<String[]> data = new ArrayList<String[]>(); 
	private static String path = "C:\\Users\\brand\\eclipse-workspace\\Blackjack Simulator\\AI.ser";
	
	public static void writeDataAtOnce(String filePath) 
	{ 
	  
	    // first create file object for file placed at location 
	    // specified by filepath 
	    File file = new File(filePath); 
	  
	    try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        // create a List which contains String array 
	        data.add(0, new String[] { "Money", "Streak" }); 
	        writer.writeAll(data); 
	  
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	} 
	
	public static void saveHashMap(HashMap<Integer, BetPercentage> bets) {
    	ObjectOutputStream out = null;
        FileOutputStream out_file = null;
    
        try {
            File file = new File(path);
            file.createNewFile();//creates it if it does not exist. Ensures no overwriting
            out_file = new FileOutputStream(file, false);
            out = new ObjectOutputStream(out_file);

           out.writeObject(bets);
            out.close();
          } catch(java.io.IOException e) {
            e.printStackTrace();
          }
    }
    
    @SuppressWarnings("unchecked")
	public static HashMap<Integer, BetPercentage> loadHashMap() {
    	ObjectInputStream in = null;
        FileInputStream in_file = null;
        HashMap<Integer, BetPercentage> bets = null;

        try {
            File file = new File(path);
            file.createNewFile();//creates it if it does not exist. Ensures no overwriting
            in_file = new FileInputStream(file);
            in = new ObjectInputStream(in_file);

            bets = (HashMap<Integer, BetPercentage>) in.readObject();
            in.close();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
        if(bets == null) {
        	return new HashMap<Integer, BetPercentage>();
        }
        return bets;

    }

}
