import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n+1];
		arr[1] = 1;
		
		for(int i=2; i<=n; i++)
		{
			if(i%2 == 0)	//짝수번째 : 이전값*2+1
				arr[i] = ((arr[i-1]*2)+1)%10007;
			else			//홀수번째 : (이전값-1)*2+1
				arr[i] = (((arr[i-1]-1)*2)+1)%10007;
		}	
		System.out.print(arr[n]%10007);
	}
}
