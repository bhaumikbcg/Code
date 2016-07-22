import java.io.*;
public class bdedhiaTest 
{ // This class prints the details of all the three classes namely Auto, truck and Car and lists the details.
	public static void main(String[] args)
	{	
		//declare string and integer variables
		String amake, atransmission, acolor, tmake, ttransmission, tcolor, cmake, ctransmission, ccolor;
		int towCapacity = 0, groundClearance = 0, doors = 0, mpg = 0;
		int ccylinders=0,tcylinders=0,acylinders=0;
		System.out.println("Welcome to Bucky Bronco's Auto Inventory");			
		System.out.println(" ");
		System.out.println("Let's start by entering an automobile:");
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(i);
		boolean flag=false;
		try
		{				
			System.out.println("What's the make?");
			amake = b.readLine();			
			
			do //do-while loop to check the validity of integer
			{
				System.out.println("How many cylinders?");
				try
				{
					acylinders = Integer.parseInt(b.readLine());	
					flag=true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
				
			}
			while(flag==false);
			
			System.out.println("What transmission?");
			atransmission = b.readLine();			
			System.out.println("What color?");
			acolor = b.readLine();
			//creates object auto with parameters
			bdedhiaAuto Auto = new bdedhiaAuto(amake, acylinders, atransmission, acolor);
			
			System.out.println(" ");
			System.out.println("Now let's add truck to the inventory:");
			System.out.println("What's the make?");
			tmake = b.readLine();
			
			do
			{
				System.out.println("How many cylinders?");	
				try
				{
					tcylinders = Integer.parseInt(b.readLine());
					flag=true;
				}catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
				
			}
			while(flag==false);
			
			System.out.println("What transmission?");
			ttransmission = b.readLine();			
			System.out.println("What color?");
			tcolor = b.readLine();
			
			do
			{
				System.out.println("How many pounds of towing capacity?");
				try
				{
					towCapacity = Integer.parseInt(b.readLine());	//converts string to integer
					flag=true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
				
			}
			while(flag==false);
			
			do
			{
				System.out.println("How many inches of ground clearence?");
				try
				{
					groundClearance = Integer.parseInt(b.readLine());	
					flag=true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
			}
			while(flag==false);
			bdedhiaTruck Truck= new bdedhiaTruck(tmake, tcylinders, ttransmission, tcolor, towCapacity, groundClearance);
			
			System.out.println(" ");
			System.out.println("Finally, let's add a car to the inventory");
			System.out.println("What's the make?");
			cmake = b.readLine();
			
			do
			{
				System.out.println("How many cylinders?");	
				try
				{
					ccylinders = Integer.parseInt(b.readLine());		
					flag=true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
				
			}
			while(flag==false);
				
			System.out.println("What transmission?");
			ctransmission= b.readLine();			
			System.out.println("What color?");
			ccolor = b.readLine();
			do
			{
				System.out.println("How many doors?");
				try
				{
					doors = Integer.parseInt(b.readLine());	
					flag=true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
				
			}
			while(flag==false);		
			do
			{
				System.out.println("How many MPG?");
				try
				{
					mpg = Integer.parseInt(b.readLine());	
					flag=true;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter valid input");
					flag=false;
				}
				
			}
			while(flag==false);
			bdedhiaCar Car = new bdedhiaCar(cmake, ccylinders, ctransmission, ccolor, doors, mpg);
			
			System.out.println("\n");
			System.out.println("BBronco has following vehicles in inventory");
			System.out.println("");
			Auto.printInfo(); //call the print method
			System.out.println(" automobile");
			System.out.println("");
			Truck.printInfo();
			System.out.println("\n");
			Car.printInfo();
		}
		catch(IOException | NumberFormatException ex)
		{
			System.out.println(" ");
			System.out.println("Please Enter a valid Integer.");	
		}
	}	
}