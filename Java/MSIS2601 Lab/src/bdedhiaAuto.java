//This is a parent class and has two child classes namely Truck and Car. It has attributes which are common to the child class as well.
public class bdedhiaAuto 
{	//declare private variables
	private String make;
	private Integer cylinders;
	private String transmission;
	private String color;
	public bdedhiaAuto(String make, Integer cylinders, String transmission, String color)
	{
		super();
		this.make = make;
		this.cylinders = cylinders;
		this.transmission = transmission;
		this.color = color;
	}
	public String getMake()//getter method to get variable
	{
		return make;
	}
	public void setMake(String make)
	{
		this.make = make; //setter method ;sets a value
	}
	public Integer getCylinders()
	{
		return cylinders;
	}
	public void setCylinders(Integer cylinders)
	{
		this.cylinders = cylinders;
	}
	public String getTransmission() 
	{
		return transmission;
	}
	public void setTransmission(String transmission)
	{
		this.transmission = transmission;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}
	public void printInfo()
	{
		System.out.print("A " + color + ", " + transmission + " transmission," + " v" + cylinders + " " + make);
	}
}