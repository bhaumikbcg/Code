

public class Average {
	public static void main(String[] args) {
		double num[]={1.0,25.3,45.0,12.0,32.0};
		double result=0;
		for(int i=0;i<5;i++)
		{
			result = result+num[i];
		}
		System.out.println("average is: "+result/5);
	}
}
