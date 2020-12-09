import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int arr[] = new int[10];
		String str = String.valueOf(A*B*C);
		
		for(int a : str.getBytes()) {
			arr[a-'0']++;
		}
	
		for(int a : arr)	System.out.println(a);
	}
}