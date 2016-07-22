import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BDedhiaLab1 {
	public static void main(String[] args) {
		printMenu();
	}
	public static void printMenu()
	{
		System.out.println("Main Menu:");
		System.out.println("1. Play with String");
		System.out.println("2. Play with Integers");
		System.out.println("3. Exit");
		System.out.println("");
		System.out.println("Please enter your choice:");
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(i);
		int num;
		try
		{
			String choice = b.readLine();
			num = Integer.parseInt(choice);
			switch(num)
			{
			case 1:
				printString();
				printMenu();
				break;
			case 2:
				printInteger();
				printMenu();
				break;
			case 3:
				exit();
				break;
			default:
				System.out.println("Please enter valid choice:");
				printMenu();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please enter a number");
			printMenu();
		}
	}
	public static void printString()
	{
		System.out.println("Let's play with a String!");
		System.out.println("");
		System.out.println("Please enter a string:");
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(i);
		int count = 0;
		int space = 0;
		try
		{
			String myString = b.readLine();
			if(myString.trim().length()==0)
			{
				System.out.println("Please enter a String:");
				myString = b.readLine();
			}
			else if(myString.trim().length()>0)
			{
				myString.trim();
				for(int j=0; j<myString.length(); j++)
				{
					if(myString.charAt(j)==('a'))
					{
						count++;
					}
					if(myString.charAt(j)==('e'))
					{
						count++;
					}
					if(myString.charAt(j)==('i'))
					{
						count++;
					}
					if(myString.charAt(j)==('o'))
					{
						count++;
					}
					if(myString.charAt(j)==('u'))
					{
						count++;
					}
					if(myString.charAt(j)==('A'))
					{
						count++;
					}
					if(myString.charAt(j)==('E'))
					{
						count++;
					}
					if(myString.charAt(j)==('I'))
					{
						count++;
					}
					if(myString.charAt(j)==('O'))
					{
						count++;
					}
					if(myString.charAt(j)==('U'))
					{
						count++;
					}
				}
				System.out.println("The number of vowels in the string are:");
				System.out.println(count);
				String finalString = myString.trim();
				for(int k=0; k<finalString.length(); k++)
				{
					if(finalString.charAt(k)==' ')
					{
						space++;
					}
				}
				System.out.println("The number of blank spaces are:");
				System.out.println(space);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
		
		}
	}
	public static void printInteger()
	{
		System.out.println("Let's play with some integers!");
		System.out.println("Please enter integer array size:");
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(i);
		int size;
		String input = "";
		int finalNumber;
		int large = 0;
		int small=0;
		try
		{
			String arraySize = b.readLine();
			size = Integer.parseInt(arraySize);
			int num[];
			num = new int[size];
			System.out.println("");
			System.out.println("Now enter " + size + "integers:");
			System.out.println("");
			for(int l=0; l<size; l++)
			{
				System.out.println("Integer " + (l+1) +":");
				input = b.readLine();
				finalNumber = Integer.parseInt(input);
				num[l] = finalNumber;
			}
			if(size>0)
			{
				for(int n=0; n<size; n++)
				{
					for(int m=0; m<size; m++)
					{
						if(num[m]>num[m+1])
						{
							large = num[m];
							small = num[m+1];
						}
					}
				}
			}
			i.close();
			b.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("The largest integer is: " + large);
			System.out.println("The smallest integer is: " + small);
		}
	}
	public static void exit()
	{
		System.out.println("Good Bye!");
	}
}