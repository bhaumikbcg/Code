// This class is also a child class of Auto. It overrides the attributes of the parent class Auto and has its specific attributes.
public class bdedhiaTruck extends bdedhiaAuto 
{
	private int towCapacity;
	private int groundClearance;
	public bdedhiaTruck(String tMake, int tCylinders, String tTransmission, String tColor, int tTowCapacity, int tGroundClearance)
	{
		super(tMake, tCylinders, tTransmission, tColor);
		towCapacity = tTowCapacity;
		groundClearance = tGroundClearance;
	}
	int gettrucktowcapacity()
	{
		return towCapacity;
	}
	public void settrucktowcapacity(int settowcapacity)
	{
		towCapacity = settowcapacity;
	}
	public void setgroundclearance(int setgroundclearance)
	{
		groundClearance = setgroundclearance;
	}
	int getgroundclearance()
	{
		return groundClearance;
	}
	public void printInfo()//overrides the Auto.printinfo method
	{
		super.printInfo();
		System.out.print(" truck with " + towCapacity + " lbs of towing capacity and " + groundClearance + " inched of ground clearance.");
	}
}