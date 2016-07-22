import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bdedhiaTestStudent {
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to Lab Assignment 2" + "\n");
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(i);
		try
		{
			System.out.println("Name: ");
			String gradName = b.readLine();
			System.out.println("Age: ");
			int gradAge = Integer.parseInt(b.readLine());
			bdedhiaGradStudent Grad=new bdedhiaGradStudent(gradName, gradAge);
			int gscore1 = 0;
			int gscore2 = 0;
			int ugscore1 = 0;
			int ugscore2 = 0;
			try
			{
				boolean flag = true;
				while(flag)
				{
					System.out.println("Score 1: ");
					gscore1 = Integer.parseInt(b.readLine());
					if (gscore1 < 0 || gscore1 > 100)
						flag = true;
					else 
						flag = false;
				}
			}
			catch(IOException | NumberFormatException e)
			{
				System.out.println("Please enter proper values");
				System.out.println("Score 1: ");
				gscore1 = Integer.parseInt(b.readLine());
			}
			
			try
			{
				boolean flag = true;
				while(flag)
				{
					System.out.println("Score 2: ");
					gscore2 = Integer.parseInt(b.readLine());
					if (gscore2 < 0 || gscore2 > 100)
						flag = true;
					else 
						flag = false;
				}
			}
			catch(IOException | NumberFormatException e)
			{
				System.out.println("Please enter proper values");
				System.out.println("Score 2: ");
				gscore2 = Integer.parseInt(b.readLine());
			}
			
			Grad.setTestScore(1, gscore1);
			Grad.setTestScore(2, gscore2);
			System.out.println(Grad.name + " is " + Grad.getAge() + " years old and he is a Graduate Student.");
			System.out.println("Average score for " + Grad.name + "'s exams is "+ Grad.getAverage());
			Grad.getCourseGrade();
			System.out.println("His Course Grade is " + Grad.CourseGrade + "\n");
			
			System.out.println("Name: ");
			String ugName = b.readLine();
			System.out.println("Age: ");
			int ugAge = Integer.parseInt(b.readLine());
			bdedhiaUGStudent UG= new bdedhiaUGStudent(ugName, ugAge);
			
			try
			{
				boolean flag = true;
				while(flag)
				{
					System.out.println("Score 1: ");
					ugscore1 = Integer.parseInt(b.readLine());
					if (ugscore1 < 0 || ugscore1 > 100)
						flag = true;
					else 
						flag = false;
				}
			}
			catch(IOException | NumberFormatException e)
			{
				System.out.println("Please enter proper values");
				System.out.println("Score 1: ");
				ugscore1 = Integer.parseInt(b.readLine());
			}
			
			try
			{
				boolean flag = true;
				while(flag)
				{
					System.out.println("Score 2: ");
					ugscore2 = Integer.parseInt(b.readLine());
					if (ugscore2 < 0 || ugscore2 > 100)
						flag = true;
					else 
						flag = false;
				}
			}
			catch(IOException | NumberFormatException e)
			{
				System.out.println("Please enter proper values:");
				System.out.println("Score 2: ");
				ugscore2 = Integer.parseInt(b.readLine());
			}
			
			UG.setTestScore(1, ugscore1);
			UG.setTestScore(2, ugscore2);
			System.out.println(UG.name + " is " + UG.getAge() + " years old and she is an Under Graduate Student.");
			System.out.println("Average score for " + UG.name + "'s exams is " + UG.getAverage());
			UG.getCourseGrade();
			System.out.println("Her course Grade is "+ UG.CourseGrade);
		}
		catch(ArrayIndexOutOfBoundsException | NumberFormatException | IOException a)
		{
			System.out.println("Please Enter or Set Proper Values.");
		}
	}
}