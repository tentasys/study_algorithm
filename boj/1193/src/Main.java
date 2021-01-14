import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int x = 2;
		int count = 1;
		int cur = 0;
		int add = -1;
		
		for(int i=1; i<=10000000; i++) {
			x += add;
			cur++;
			
			if(i == N)	break;
			
			if(cur == count) {
				count++;
				cur = 0;
				
				if(add == -1)
					x = 0;
				else
					x = count+1;
				
				add *= -1;
			}
		}
		
		System.out.println(x+"/"+(count+1-x));
	}
}