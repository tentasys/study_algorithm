//1시간만의 삽질... 문제 이해 잘못함 
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int arr[] = new int[4];
	   	for(int i=0; i<4; i++)
	   		arr[i] = Integer.parseInt(str[i]);
	 
	    int result = findclock(arr[0]*1000+arr[1]*100+arr[2]*10+arr[3]);
	    int cnt = 0;
	    for (int i = 1111; i <= result; i++)
	    {
	        if (findclock(i) == i) {
	        	//System.out.println(i);
	        	cnt++;
	        }
	    }
	    System.out.println(cnt);
	}

	
	static int findclock(int num){
	    int result = num;
	    int cal = num;
	    //밀면서 탐색하기
	    for (int i = 0; i < 3; i++)
	    {
	    	cal = cal % 1000 * 10 + cal / 1000;
	    	result = Math.min(cal,  result);
	    }
	    return result;
	}
	 
}