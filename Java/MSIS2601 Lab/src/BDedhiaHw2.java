import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*This program helps us understand how to sort strings and integers.*/
public class BDedhiaHw2 
	{	//Declaration of variables
		static String returnString = ""; 
		static String returnNumber = "";
		static String repeatName = "";
	public static void main(String[] args) 
	{

		InputStreamReader j = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(j);

		
		System.out.println("Let's Play with strings !");
		System.out.println(" ");
		String name[];
		name = new String[6];
		//use for loop to take input from user
		for (int i = 0; i < 6; i++) 
		{
			System.out.println("Enter Name " + (i+1) + ":"); //Asks for input from the user
			/* System.in -> Standard input * 
			 * InpurStreamReader -> Allows you to associate a stream that reads from the specified input
			 * BufferedReader -> Abstraction to help us work with the streams*/
			try 
			{
				String a = b.readLine();
				repeatName = checkString(a);
				//reduces space between 2 words to one word
				name[i] = repeatName.replaceAll("\\s+", " ").trim();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("The names sorted in ascending order:");
		Arrays.sort(name);
		for (int k = 0; k < 6; k++)
		{
			System.out.println(name[k]);
		}
		//call method to sort number
		sortNum();
		try {
			j.close();
			b.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String checkString(String a)
	{
		if (a.trim().length() > 0 && a.matches("^[a-zA-Z\\s]*$")) 
		{
			return a;
		} 
		else
		{
			System.out.println("please enter some name");
			System.out.println("Enter Name Again:");
			InputStreamReader j = new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(j);
			try 
			{
				returnString = b.readLine();
				//Calls method checkString
				checkString(returnString);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnString;
	}
	//method to sort numbers
	public static void sortNum() 
	{
		int num[];
		num = new int[5];
		System.out.println("");
		System.out.println("Let's play with some integers now !");
		System.out.println("");
		System.out.println("Enter 5 integers:");
		System.out.println("");
		for (int i = 1; i < 6; i++)
		{
			System.out.println("Integer " + i + ":");
			InputStreamReader j = new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(j);
			try 
			{
				String a = b.readLine();
				int number = checkNumber(a);
				num[i - 1] = number;
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("The numbers you entered:");
		System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3] + " " + num[4]);
		System.out.println(" ");
		int k = 0;
		//sorting using bubble sort
		for (int j = 0; j < 4; j++)
		{
			for (int i = 0; i < 4; i++)
			{
				if (num[i] > num[i + 1])
				{
					num[i] = num[i];
				} 
				else 
				{
					k = num[i];
					num[i] = num[i + 1];
					num[i + 1] = k;
				}
			}
		}
		System.out.println("The number sorted in descending order:");
		System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3] + " " + num[4]);
	}

	private static int checkNumber(String a)
	{
		// TODO Auto-generated method stub
		try 
		{
			return Integer.parseInt(a);

		} 
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("please enter valid integer");
			System.out.println("Enter Number Again:");
			InputStreamReader j = new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(j);
			try 
			{
				returnNumber = b.readLine();
				checkNumber(returnNumber);
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return Integer.parseInt(returnNumber);
	}
}