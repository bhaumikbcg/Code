

public class Scope {
	public static void main(String[] args) 
	{
		int x;
		x=10;
		if(x==10)
		{
			int y=20;
			System.out.println("x and y are: "+x + y);
		}
		//y=100;
		//x is still known here
		System.out.println("x is "+x);
	}
}
