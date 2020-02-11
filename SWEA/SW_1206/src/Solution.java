import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int ii=1; ii<=10; ii++)
		{
			int num = Integer.parseInt(br.readLine());
			int arr[] = new int[num];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<num; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int result = 0;
			
			for(int i=2; i<num-2; i++)
			{
				int max = Math.max(arr[i-2], Math.max(arr[i-1], Math.max(arr[i+1], arr[i+2])));
				int cal = arr[i]-max;
				
				if(cal > 0)
					result += cal;
			}
			
			System.out.println("#"+ii+" "+result);
		}
		
		br.close();
	}
}