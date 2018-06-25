/**

BMI = Body Mass Index.Calculates one's mass per unit of surface area
BMR = BMR (Basal Metabolic Rate) is an estimate of how many calories
	  you'd burn if you were to do nothing but rest for 24 hours.
	  
This program calculates the BMI & BMR

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class Calculator {

	static void printSpace(int n){             /// to handle the whitespaces
		for(int i = 0; i < n; i++){
			System.out.print(" ");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("|                                                                        |");
		System.out.println("|                                                                        |");
		System.out.println("|                                                                        |");
		System.out.println("|                           BMI & BMR Calculator                         |");
		System.out.println("|                                                                        |");
		System.out.println("|                                                                        |");
		System.out.println("|                                                                        |");
		System.out.println("+------------------------------------------------------------------------+");
		
		//Scanner in = new Scanner(new File("in.txt"));
		Scanner in = new Scanner(System.in);
		DecimalFormat dec = new DecimalFormat("#0.00");
		String name, sex, comment;
		double bmi, bmr, weight, heightInMeter, neededCalorieLow, neededCalorieHigh;
		int heightInInch, heightInFeet, age, len, cnt = 1;
		
		while(true){
			if(cnt > 1) in.nextLine();
			System.out.print("Enter your Name = ");
			name = in.nextLine();
		
			System.out.print("Enter your Age = ");
			age = in.nextInt();
		
			System.out.print("(Male or Female? = ");
			sex = in.next();
			sex = sex.toLowerCase();
		
			System.out.print("Enter your Weight (in KG) = ");
			weight = in.nextDouble();
		
			System.out.println("Enter your Height = ");
			System.out.print("               Feet : ");
			int heightFeet = in.nextInt();
			System.out.print("               Inch : ");
			int heightInch = in.nextInt();
		
			int totalInch = heightFeet*12 + heightInch;
		
			heightInMeter = totalInch*0.0254;
		
			bmi = weight/(heightInMeter*heightInMeter);
		
		
			if(sex.equals("male")){
				bmr = 66.0 + (13.75*weight) + (5.0*100.0*heightInMeter) - (6.8*age);
				sex = "Male";
			}
		
			else{
				bmr = 655.0 + (9.6*weight) + (1.8*100.0*heightInMeter) - (4.7*age);
				sex = "Female";
			}
			
			
			if(bmi < 18.5) comment = "Underweight";
			else if(bmi < 25.0) comment = "Healthy weight/Normal";
			else if(bmi < 30) comment = "Above ideal range";
			else comment = "Obese";
			
		
			neededCalorieLow = bmr*1.1;
			neededCalorieHigh = bmr*1.525;
		
		
			len = Integer.toString((int) neededCalorieLow).length() + Integer.toString((int) neededCalorieHigh).length();
		
			System.out.println("+------------------------------------------------------------------------+");
			System.out.println("|                                                                        |");
			System.out.print("|                               Profile " + cnt); printSpace(33 - Integer.toString(cnt).length()); System.out.println("|"); cnt++;
			System.out.println("|                                                                        |");
			System.out.println("+------------------------------------------------------------------------+");
			System.out.println("|                                                                        |");
			System.out.print("|      Name     : " + name); printSpace(55 - name.length()); System.out.println("|");                                     
			System.out.print("|      Age      : " + age);  if(age < 10) printSpace(55 - 1); else if(age < 100) printSpace(53); else printSpace(52); System.out.println("|");
			System.out.print("|      Sex      : " + sex); printSpace(55 - sex.length()); System.out.println("|");
			System.out.print("|      Weight   : " + dec.format(weight) + " KG"); if(weight < 10.0) printSpace(48); else if(weight < 100.00) printSpace(47); else printSpace(55 - 9); System.out.println("|");
			System.out.print("|      Height   : " + heightFeet + " Feet " + heightInch + " Inch"); if(heightInch < 10) printSpace(42); else printSpace(41); System.out.println("|"); 
			System.out.print("|      BMI      : " + dec.format(bmi) + " (" +  comment + ") "); printSpace(46 - comment.length());     System.out.println("|");
			System.out.print("|      BMR      : " + dec.format(bmr)); if(bmr < 1000.0) printSpace(49); else printSpace(48); System.out.println("|");                                        
			System.out.print("|      Comment  : You need " + dec.format(neededCalorieLow) + " - " + dec.format(neededCalorieHigh) + " Calories/Day"); printSpace(24 - len); System.out.println("|");
			System.out.println("|                                                                        |");
			System.out.println("|                                                                        |");
			System.out.println("+------------------------------------------------------------------------+");
		
		
		
			System.out.print("\n\n\n\n                Do you want to calculate again? (y/n) = ");
		
			String reply = in.next();
			reply = reply.toLowerCase();
			if(reply.equals("n")){
				System.out.println("\n\n\n\n+-------------------------- TERMINATED ----------------------------------+");
				break;
			}
			System.out.print("\n\n\n\n");
		}
		
	}

}
 