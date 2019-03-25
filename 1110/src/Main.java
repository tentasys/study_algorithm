import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int a, b;
		if(N<10)
		{
			a = 0;
			b = N;
		}
		else
		{
			a = N/10;
			b = N%10;
		}
		
		int cycle = 0;
		
		while(true)
		{
			cycle++;
			int temp = b;
			b = (a+b)%10;
			a = temp;
			
			if(a*10+b == N)
				break;
		}
		
		System.out.print(cycle);
	}

}
