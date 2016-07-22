//This class is a child of Auto. It uses the super method to overrides the method in the parent class and has its specific attributes.
public class bdedhiaCar extends bdedhiaAuto 
{
	private int doors;
	private int mpg;	
	public bdedhiaCar(String cMake, int cCylinders, String cTransmission, String cColor, int cDoors, int cMpg)
	{
		super(cMake, cCylinders, cTransmission, cColor);
		doors = cDoors;
		mpg = cMpg;
	}
	int getcardoors()
	{
		return doors;
	}
	public void setdoors(int setdoors)
	{
		doors = setdoors;
	}
	int getcarMPG()
	{
		return mpg;
	}
	public void setmpg(int setmpg)
	{
		mpg = setmpg;
	}
	public void printInfo()//overrides auto.printinfo method
	{
		super.printInfo();
		System.out.print(" car with " + doors + " doors getting " + mpg + " mpg.");
	}	
}