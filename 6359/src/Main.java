import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			int a = Integer.parseInt(br.readLine().trim());
			arr[i] = (int)Math.sqrt(a);
		}
		
		for(int i=0; i<n; i++)
			System.out.println(arr[i]);
	}

}
