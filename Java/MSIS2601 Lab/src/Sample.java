import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Sample extends Applet {
	public void init()
	{
		getContentPane().setBackground(Color.cyan);
	}
	private Component getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
	public void start()
	{
		
	}
	public void stop()
	{
		
	}
	public void destroy()
	{
		
	}
	public void paint(Graphics g)
	{
		g.drawString("Hello world of Applet", 20, 20);
	}
}
