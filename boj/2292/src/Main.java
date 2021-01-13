import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 1;
		int result = 0;
		
		//while문이 최대로 돌아가는 횟수 : 약 18000여 건이므로 그냥 1부터 돌려도 시간초과 안 날 듯 
		//계차수열 참조 : https://www.mathfactory.net/10916
		//계차수열의 일반항 구함 
		
		while (true) {
			result = 3 * (int) Math.pow(count, 2) - 3 * count + 1;	//굳이 이렇게 복잡한 식을 세우진 않아도 되었었네.. 
			if(N <= result) 	break;
			count++;
		}
		
		System.out.println(count);
	}
}