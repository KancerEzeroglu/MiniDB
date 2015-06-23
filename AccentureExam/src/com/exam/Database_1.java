package com.exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database_1 {

	static ArrayList<Record> records = new ArrayList<Record>();

	public static void main(String[] args) {

		int dataSize= loadData("input_1.csv");
		System.out.println("Toplam kayit sayisi:"+dataSize);
		Record[] recordsName = findByName("Kancer", "Gok");
		printAllElement(recordsName);
	}

	public static void printAllElement(ArrayList<Record> records) {
		for (int i = 0; i < records.size(); i++) {
			System.out.println(records.get(i).getFirstName());
		}
	}
	public static void printAllElement(Record[] records) {
		for (int i = 0; i < records.length; i++) {
			System.out.println(records[i].getFirstName());
		}
	}

	public static int loadData(String fileName) {
		// Open the file
		FileInputStream fstream;
		BufferedReader br = null;

		try {
			fstream = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				// System.out.println (strLine);
				String[] tokens = strLine.split(";");
				Record r = new Record();
				r.setUserName(tokens[0]);
				r.setFirstName(tokens[1]);
				r.setLastName(tokens[2]);
				r.setDepartment(tokens[3]);
				r.setEndDate(tokens[4]);
				r.setTelNum(tokens[5]);

				records.add(r);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return records.size();
	}
	
		public static Record[] findByName(String firstname, String lastname){
			ArrayList<Record> matchRecords = new ArrayList<Record>();
			
			for (int i = 0; i < records.size(); i++) {
				if(records.get(i).getFirstName().equals(firstname)&&records.get(i).getLastName().equals(lastname)){
					matchRecords.add(records.get(i));
				}
					
			}
			Record[] recordArr = new Record[matchRecords.size()];
			recordArr = matchRecords.toArray(recordArr);
			
			return recordArr;
		}
}
