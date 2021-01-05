import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(f(i) == true)	count++;
		}
		
		System.out.println(count);
		
	}
	//주어진 수가 한수인지 아닌지 판별하는 함수 
	
	public static boolean f(int num) {	
		//100 미만은 무조건 한수이므로 
		if(num < 100)						return true;
		//1000은 한수가 아니므로 
		else if(num == 1000)				return false;
		
		//어차피 들어오는수는 100 이상 1000 미만인 수이므로 범위를 특정하지 않는다(문제 조건) 
		//그러면 세자리수만 확인해도 된다 
		int arr[] = new int[3];
		arr[0] = num/100;
		arr[1] = (num/10)%10;
		arr[2] = num%10;
		
		if(arr[1]-arr[0] == arr[2]-arr[1])
			return true;
		else
			return false;
	}
}