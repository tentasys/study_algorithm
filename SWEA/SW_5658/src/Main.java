import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=0; ii<T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String num = br.readLine();
			
			System.out.println("#"+(ii+1)+" "+f(N, K, num));
		}
		
	}

	static int f(int N, int K, String str)
	{
		ArrayList<String> arr = new ArrayList<String>();
		int side = N/4;
		
		for(int i=0; i<side; i++)
		{
			String temp;
			for(int j=0; j<4; j++)
			{
				temp = str.substring(side*j, side*(j+1));
				if(!arr.contains(temp))	arr.add(temp);
			}
			String tempchar = ((Character)str.charAt(N-1)).toString();
			temp = str.substring(0, N-1);
			str = tempchar.concat(temp);
		}
		
		Descending desc = new Descending();
		Collections.sort(arr, desc);
		
		int result = Integer.parseInt(arr.get(K-1), 16);
		
		return result;
	}
}

class Descending implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		
		return arg1.compareTo(arg0);
	}
	
}