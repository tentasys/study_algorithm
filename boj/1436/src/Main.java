import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[100001];
		int count = 1;
		
		for(int i=666; i<=Integer.MAX_VALUE; i++) {
			Integer cur = i;
			String str = cur.toString();
			if(str.contains("666") == true)
			{
				arr[count] = i;
				count++;
			}
			
			if(count > 10000)		break;
		}
		
		System.out.println(arr[N]);
	}

}