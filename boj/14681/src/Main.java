import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int q = -1;
		
		if(x > 0 && y > 0)			q = 1;
		else if(x < 0 && y > 0)		q = 2;
		else if(x < 0 && y < 0)		q = 3;
		else if(x > 0 && y < 0)		q = 4;
		
		System.out.println(q);
	}
}