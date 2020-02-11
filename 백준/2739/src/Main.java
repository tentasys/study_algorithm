import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=9; i++)
		{
			sb.append(num + " * " + i + " = " + (num*i) + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
}