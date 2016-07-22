package BasicThreads;

public class PingPong extends Thread{
	String word;
	int delay;
	PingPong(String WhatToSay, int dealyTime)
	{
		word = WhatToSay;
		delay = dealyTime;
	}
	public void run()
	{
		try
		{
			for(;;)
			{
				System.out.println(word + " ");
				sleep(delay);
			}
		}
		catch(Exception e)
		{
			return;
		}
	}
	public static void main(String[] args) {
		new PingPong("Ping", 5000).start();
		new PingPong("Pong", 5000).start();
		new PingPong("It's just a program", 10000).start();	}
}