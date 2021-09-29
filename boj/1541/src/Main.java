import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[] = br.readLine().toCharArray();
		
		//입력받은 숫자를 Integer형으로 파싱 
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<arr.length; i++) {
			char ch = arr[i];
			
			if(ch == '+' || ch == '-') {
				list.add(Integer.parseInt(sb.toString()));
				sb = new StringBuilder();
				sb.append(ch);
			}
			else
				sb.append(ch);
		}
		list.add(Integer.parseInt(sb.toString()));
		
		br.close();
		//파싱 끝 
		
		//마이너스 -> 무조건 뺀다 
		//플러스 -> 처음만 더하고, 그 뒤에 나오는 플러스는 다른 마이너스 만날때까지 더하다가 뺌 
		int result = 0;
		int sum = 0;
		
		for(int a : list) {
			if(a >= 0) {
				if(sum < 0) {
					sum -= a;
				}
				else
					result += a;
			}
			else {
				if(sum < 0) {
					result += sum;
					sum = a;
				}
				else {
					sum += a;
				}
			}
		}
		
		result += sum;
		
		System.out.println(result);
	}

}
