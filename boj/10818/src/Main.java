import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		br.readLine();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sign = 1;
		int num = 0;
		
		for(int ch : br.readLine().getBytes()) {
			if(ch == '-') {
				sign = -1;
			}
			else if(ch >= '0' && ch <= '9') {
				num = num*10 + (ch-'0');
			}
			else if(ch == ' ') {
				num *= sign;
				min = Math.min(min, num);
				max = Math.max(max, num);
				
				num = 0;
				sign = 1;
			}
			
		}
		
		num *= sign;
		min = Math.min(min, num);
		max = Math.max(max, num);
		
		System.out.println(min+" "+max);
	}
}