import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[1000001];
		int generator = 1;
		int count = 0;
		
		while(true) {
			count = generator;	//분해합에 포함되는 생성자
			
			//각 자릿수 더하기 
			int div = generator;
			while(div > 0) {
				count += div%10;
				div /= 10;
			}
			
			if(count > 1000000)		break;
			if(arr[count] == 0)		arr[count] = generator;
			generator++;
		}
		
		System.out.println(arr[N]);
	}
}