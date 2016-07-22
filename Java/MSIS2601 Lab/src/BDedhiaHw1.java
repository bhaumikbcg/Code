import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*This program helps to understand string manipulation and how to use loops and 
 * conditional statements.*/

public class BDedhiaHw1 {
	public static void main(String[] args) 
		{
			printMenu(); //Initialization of variable
			
			/*do{//main logic of how menu is selected
				inputRet =	printMenu();
				if( inputRet == 1 )
				{
					printName();
					printMenu();
				}
				else if( inputRet == 2 )
				{
					exitGame();
				}
				else //this block executes if user enters a number other than 1 or 2
				{
					System.out.println("Please enter valid choice");
					printMenu();
				}
			}
			while( inputRet != 2 );*/
		}
		public static void printMenu()
		{
			System.out.println("Main Menu:");
			System.out.println("1. String Manipulation");
			System.out.println("2. Exit the game");
			System.out.println("Please enter your choice:");//prompt user to enter a choice from given menu
			/* * System.in -> Standard input 
			 * InpurStreamReader -> Allows you to associate a stream that 
			 * reads from the specified input.
			 * BufferedReader -> Abstraction to help us work with the streams */
			
			
			InputStreamReader i = new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(i);
			//This is how we create objects for classes.
			int input=0;
			try 
			{
				String menu = b.readLine();
				//readLine method reads input from stream and returns string
				input = Integer.parseInt(menu);
				switch(input)
				{
				case 1:printName();
				printMenu();
				break;
				case 2:exitGame();break;
				default:System.out.println("Please enter a valid choice");
				printMenu();
					break;
				}
				//parseInt() method accepts string value and converts it to Integer
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please enter a valid number");
				printMenu();
			}
			
		}
		public static void printName()
		{
			System.out.print("\n");
			System.out.println("Please enter your Full Name");
			InputStreamReader i = new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(i);
			String finalName = "";
			try 
			{
				String name = b.readLine();
				if(name.trim().length()<=0)
				{
					System.out.println("Oops! You forgot to enter the name!");
					printMenu();
				}
				finalName = name.trim();/*trim blank spaces from starting and 
				end of string*/
				int strlength = finalName.length();
				//length method gives length of string finalName
				int space = 0;
				for(int j=0; j<strlength; j++)
				{
					if(Character.isWhitespace(finalName.charAt(j)))
					{
						space++;
					}
				}
				if( space > 1 )
					{
						System.out.println("Please enter first name and last name only!!");
					}
				else if(finalName.length()==0)
					{
						System.out.println("Oops! you forgot to enter the name");
					}
				else
					{
						String[] arrayForFirstLastName = finalName.split(" ");
						if (arrayForFirstLastName.length==2)
						System.out.println("Your first name is " +arrayForFirstLastName[0] + " and last name is " + arrayForFirstLastName[1]);
						System.out.print("\n");
					}
				i.close();
				b.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch(NumberFormatException e)
			{
				System.out.println("Oops! you forgot to enter the name!");
			}
		}
		//exitGame() method prints the abort statement
		public static void exitGame()
		{
			System.out.println("Game Aborted!!");
		}
}
