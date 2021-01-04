//https://www.acmicpc.net/problem/1065
//진행중
//퇴근후 피곤해..

import java.io.*;

public class Main {

	static boolean check = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N < 100) {
			//100 미만은 무조건 한수이므로 그 수 그대로 출력 
			System.out.println(N);
		}
		else {
			
		}
	}

	public static void f(int num, int sub) {
		int x = num%10;
		int y = (num/10)%10;
		
		if(y+sub != x) {
			check = false;
			return;
		}
		
		
	}
}