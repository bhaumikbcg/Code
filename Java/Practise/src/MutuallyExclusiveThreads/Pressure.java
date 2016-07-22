package MutuallyExclusiveThreads;

public class Pressure extends Thread{
	void raisePressure() 
	{
		if(P.pressureGuage < P.safetyLimit - 15)
		{
			try
			{
				sleep(100);
			}
			catch(Exception e){}
			P.pressureGuage += 15;
		}
		else;
	}
	public void run()
	{
		raisePressure();
	}
}
