import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int a_prev = Math.max(x, y);
		int b_prev = Math.min(x, y);
		
		int a = a_prev;
		int b = b_prev;
		int reminder = -1;
		
		while(reminder != 0) {
			reminder = a%b;
			a = b;
			b = reminder;	
		}
		
		System.out.println(a+"\n"+b_prev*(a_prev/a));
	}

}
