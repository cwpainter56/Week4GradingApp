import java.util.*;
import java.lang.Math;
public class GradingApp {
	static int examarr[] = new int[4];
	static int assgnarr[] = new int[4];
	static int examgradeSum[] = new int [1];
	static int assgngradeSum[] =new int [1];
	static int gradeSum[] = new int [10];
	static char lettrGrade[] = new char [10];
	static char AdjLtrGrade[] = new char [10];
	static Scanner input = new Scanner(System.in);
	final static int MAXEXAM = 50;
	final static int MAXASSGN = 75;
	static String str;
	static String[] string;

			
	public static void main(String[] args) {
		/* Accepts 4 test and 4 assignment scores 
		 *  for ten students from the user and 
		 *  puts them into two arrays.
		 */ 
		int max;
		int[] studentnumber = new int[10];	
		studentnumber[0] = 1;
		studentnumber[1] = 2;
		studentnumber[2] = 3;
		studentnumber[3] = 4;
		studentnumber[4] = 5;
		studentnumber[5] = 6;
		studentnumber[6] = 7;
		studentnumber[7] = 8;
		studentnumber[8] = 9;
		studentnumber[9] = 10;
		for (int i = 0; i < 10; i++) {
			do {
		System.out.println("Please enter student " + studentnumber[i] + "'s" + " 4 exam scores (separated by spaces):");
        str = input.nextLine();
        string = str.split("[ ,]+", 4);
        	for(int j=0; j<4; j++) {
        		examarr[j] = Integer.parseInt(string[j]);
        			}
        		Arrays.sort(examarr);
        		max=examarr[examarr.length-1];
        			if(max>MAXEXAM) {
        				System.out.println("Entry error. Maximum exam score is: " + MAXEXAM);
        			};
        		}
			   while (max>MAXEXAM); 
			do {
				System.out.println("Please enter student " + studentnumber[i] + "'s" + " 4 assignment scores (separated by spaces):");
		        str = input.nextLine();
		        string = str.split("[ ]+", 4);
		        	for(int j=0; j<4; j++) {
		        		assgnarr[j] = Integer.parseInt(string[j]);
		        			}
		        		Arrays.sort(assgnarr);
		        		max=assgnarr[assgnarr.length-1];
		        			if(max>75) {
		        				System.out.println("Entry error. Maximum assignment score is: " + MAXASSGN);
		        			};
		        		}
					   while (max>MAXASSGN); 
        		
        	
        	
        	examgradeSum[0] = examarr[0] + examarr[1] + examarr[2] + examarr[3];
        	assgngradeSum[0] = assgnarr[0] + assgnarr[1] + assgnarr[2] + assgnarr[3];
        	gradeSum[i] = assgngradeSum[0] + examgradeSum[0]; 
        	
		}
		 finalGrade(gradeSum);
		 adjustGrade(gradeSum);
		
		 
		
		 for (int i = 0; i < 10; i++) {
		    System.out.println("The final grade for student " + studentnumber[i] + " is: " + lettrGrade[i]);
		    
		    };
		 for (int i = 0; i < 10; i++) {
			 System.out.println("The adjusted final grade for student " + studentnumber[i] + " is: " + AdjLtrGrade[i]);
		 	}
 }
		 
	
	public static void finalGrade(int[] args) {
		// Assigns final letter grade based on score sums.
		for (int i = 0; i < 10; i++)
	    {
		if (gradeSum[i] >=450) {lettrGrade[i] = 'A';}
		else
			if (gradeSum[i] >=400 && gradeSum[i] < 450) {lettrGrade[i] = 'B';}
			else
				if (gradeSum[i] >=350 && gradeSum[i] < 400) {lettrGrade[i] = 'C';}
				else
					if (gradeSum[i] >=300 && gradeSum[i] < 350) {lettrGrade[i] = 'D';}
					else {lettrGrade[i] = 'F';
		}
		
	    }
		
	}
	


	public static void adjustGrade(int[] args) {
		/* Assigns adjusted letter grade 
		 * based on score sum statistics 
		* and prints the ranges for the 
		* adjusted grades
		*/
		double avg = 0;
		float sd = 0;
		int sum = 0;
		for(int i=0; i<gradeSum.length; i++)
        {
            sum += gradeSum[i];
        }
		
		avg = sum / gradeSum.length;
		for (int i = 0; i < gradeSum.length; i++)
		{
		sd += Math.pow(gradeSum[i] - avg, 2) / gradeSum.length;
		}
		sd = (float) Math.sqrt(sd);
		
		
	for (int i = 0; i < 10; i++)
    {
	if (gradeSum[i]>= avg + (2*sd)) {AdjLtrGrade[i] = 'A';}
	else
		if (gradeSum[i]>= avg + (1*sd) && gradeSum[i]< avg + (2*sd)) {AdjLtrGrade[i] = 'B';}
		else
			if (gradeSum[i]>= avg && gradeSum[i] < avg + (1*sd))  {AdjLtrGrade[i] = 'C';}
			else
				if (gradeSum[i]>= avg - (2*sd) && gradeSum[i] < avg) {AdjLtrGrade[i] = 'D';}
				else
					if (gradeSum[i]< avg - (2*sd)) {AdjLtrGrade[i] = 'F';}
	}
	System.out.println("Ranges for adjusted scores:");
	System.out.println("A: >= " + (avg + (2*sd)));
	System.out.println("B: >= " + (avg + (1*sd)));
	System.out.println("C: >= " + (avg));
	System.out.println("D: >= " + (avg - (2*sd)));
	System.out.println("F: < " +  (avg - (2*sd)));
}
}

