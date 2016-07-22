package UnrelatedThread;

public class Tea extends Thread{
	public void run()
	{
		while(true)
		{
			System.out.println("I like Tea");
			Thread.yield();
		}
	}
}
