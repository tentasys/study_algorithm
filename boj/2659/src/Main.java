import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int arr[] = new int[4];
		for(int i=0; i<4; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {				
				if(i > j)	continue;			
				for(int k=1; k<10; k++) {					
					if(j > k)	continue;
					for(int h=1; h<10; h++) {						
						if(k > h)	continue;					
						cnt++;
						if(i==arr[0] && j==arr[1] && k==arr[2] && h==arr[3]) {
							System.out.println(cnt);
							return;
						}
					}
				}
			}
		}
	}
}