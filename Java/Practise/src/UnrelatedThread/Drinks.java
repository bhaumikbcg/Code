package UnrelatedThread;

public class Drinks {
	public static void main(String[] args) {
		Coffee t1 = new Coffee();
		t1.start();
		new Tea().start();
	}
}
