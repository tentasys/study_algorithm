import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			String str[] = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			int LCM = getLCM(Math.min(a, b), Math.max(a, b));
			sb.append(LCM+"\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

	static int getLCM(int a, int b) {
		int cal_a = a;
		int cal_b = b;
		int reminder = -1;
		
		while(reminder != 0) {
			reminder = cal_b%cal_a;
			cal_b = cal_a;
			cal_a = reminder;
		}
		
		return a*(b/cal_b);
	}
}
