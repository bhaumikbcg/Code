package UnrelatedThread;

public class Coffee extends Thread{
	public void run()
	{
		while(true)
		{
			System.out.println("I like Coffee");
			Thread.yield();
		}
	}
}
