package com.exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Database_1{

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
			System.out.println(records[i].getFirstName()+" "+records[i].getEndDate());
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
				// validate metodunu cagir. insert etmeden kontrol et.
				
				if (validate(tokens)){
					Record r = new Record();
					r.setUserName(tokens[0]);
					r.setFirstName(tokens[1]);
					r.setLastName(tokens[2]);
					r.setDepartment(tokens[3]);
					r.setTelNum(tokens[5]);
					
					//convert string to date format
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String dateInString = tokens[4];
					Date date = null;
					try {
						date = df.parse(dateInString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					r.setEndDate(date);

					records.add(r);
				}
				else{
					System.out.println("Kayit hatalidir.");
				}
				

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
	
	//user name kontrolu
		private static boolean validate(String[] tokens) {
		
			boolean flag = false;
			int nameLen=tokens[0].length();

			flag = tokens[0].matches("\\A\\p{ASCII}*\\z");
			if(!flag){
				System.out.println(tokens[0]+ " User name ASCII karakter icermektedir.");
				return false;
			}
			if (nameLen<6 || nameLen>10){
				System.out.println(tokens[0] + " User name karater uzunlugu uymuyor.");
				return false;
			}
			
			if(!tokens[1].matches("[a-zA-Z]+") || !tokens[2].matches("[a-zA-Z]+")){
				System.out.println(tokens[1] +" "+ tokens[2] + " first name ve last name karakter icermiyor.");
				return false;
			}
			//final byte[] utf8Bytes = string.getBytes("UTF-8");
			byte[] utf8FirstName = null;
			byte[] utf8LastName = null;
			try {
				utf8FirstName = tokens[1].getBytes("UTF-8");
				utf8LastName = tokens[2].getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(utf8FirstName.length>30 || utf8LastName.length>30){
				System.out.println(tokens[1] +" "+ tokens[2] + " first name ve last name 30 byte'dan fazla");
				return false;
			}
			if (!isAsciiPrintable(tokens[3])){
				System.out.println("printable degil");
				return false;
			}
			
			byte[] utf8Depart = null;
			
			try {
				utf8Depart = tokens[3].getBytes("UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(utf8Depart.length>20){
				System.out.println("byte 20'den buyuk depart");
				return false;
			}
			return true;
		
	}
		public static boolean isAsciiPrintable(String str) {
		      if (str == null) {
		          return false;
		      }
		      int sz = str.length();
		      for (int i = 0; i < sz; i++) {
		          if (isAsciiPrintable(str.charAt(i)) == false) {
		              return false;
		          }
		      }
		      return true;
		  }
		  
		  /**
		   * <p>Checks whether the character is ASCII 7 bit printable.</p>
		   *
		   * <pre>
		   *   CharUtils.isAsciiPrintable('a')  = true
		   *   CharUtils.isAsciiPrintable('A')  = true
		   *   CharUtils.isAsciiPrintable('3')  = true
		   *   CharUtils.isAsciiPrintable('-')  = true
		   *   CharUtils.isAsciiPrintable('\n') = false
		   *   CharUtils.isAsciiPrintable('&copy;') = false
		   * </pre>
		   * 
		   * @param ch  the character to check
		   * @return true if between 32 and 126 inclusive
		   */
		  public static boolean isAsciiPrintable(char ch) {
		      return ch >= 32 && ch < 127;
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
			Arrays.sort(recordArr);
			return recordArr;
		}
}
