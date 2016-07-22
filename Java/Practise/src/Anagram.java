import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Anagram {
	public static void main(String args[]) throws IOException{
		
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter no of line");
		int n = reader.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter string");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			solution(input);
		}
	}
	public static void solution(String s) {
		System.out.println(s);
		int str = s.length();
		String left = s.substring(0, str/2);
		String right = s.substring(str/2);
		int count=0;
		if(str%2!=0){
			System.out.println("-1");
		}
		else
		{
			
			int ll=left.length();
			int rl=right.length();
			boolean flag=false;
			for (int j = 0; j <ll ; j++) {
				for (int k = 0; k < rl; k++) {
					flag=false;
					if (left.charAt(j)==right.charAt(k)) {
						if(k==0)
						{
							right = right.substring(k+1);
							//System.out.println("right : "+right);
						}
						else
							if(k<rl){
								right = right.substring(0, k)+right.substring(k+1);
								//System.out.println("right : "+right);
							}
						rl--;
						break;
					} else {
						flag=true;
					}
				}
				//System.out.println("count: "+count+"right"+right);
				if(flag==true)
				{
					count++;
				}
				
			}
			System.out.println(count);
		}
		
	}
}
