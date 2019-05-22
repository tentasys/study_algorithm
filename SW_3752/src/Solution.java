import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=1; ii<=T; ii++)
		{
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i=0; i<N; i++)
				list.add(Integer.parseInt(st.nextToken()));
			
			map.put(0, 0);
			for(int a : list)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				
				for(int b : map.keySet())
				{
					temp.add(b+a);
				}
				
				for(int b : temp)
				{
					if(!map.containsKey(b))
						map.put(b, b);
				}
			}
			
			System.out.println("#"+ii+" "+map.size());
		}
		
		br.close();
	}
}
