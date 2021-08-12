import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int idx = 0;
		int arr[] = new int[K];
		
		for(int ii=0; ii<K; ii++)
		{
			int cur = Integer.parseInt(br.readLine());
			
			if(cur == 0)
			{
				idx--;
				arr[idx] = 0;
			}
			else
			{
				arr[idx] = cur;
				idx++;
			}
		}
		
		for(int a : arr)
			sum += a;
		
		System.out.println(sum);
	}

}
