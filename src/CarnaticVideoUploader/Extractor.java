package csvParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Extractor {
	
	public static void main(String args[]){
		
		String csvFile = "C:/Users/KRITHIVASAN CHANDRAN/Desktop/CarnaticLessons - Lessons and Chapters (02-14-2015).csv";
		BufferedReader br = null;
		String line = "";
		
		try {
			
			int delimeter = 0;
			br = new BufferedReader(new FileReader(csvFile));
			int index = 0;
			while ((line = br.readLine()) != null) {
				
				if(line != null){
					String[] country = line.split(",");
					for(String s: country){
						System.out.println( index++ + " -------> " + s);
					}}
				
				index=0;
				delimeter++;
				if(delimeter == 98) break;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}}
