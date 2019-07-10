import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = br.readLine().charAt(0)-'0';
		
		for(int ii=1; ii<=T; ii++)
		{
			int N = br.readLine().charAt(0)-'0';

			int map[] = new int[401];
			boolean visit[] = new boolean[401];
			
			for(int i=0; i<N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				map[Math.min(a, b)] = Math.max(b, a)
			}

			//�Է� �Ϸ�
			
			int total = 0;
			for(int i=1; i<401; i++)
			{
				if(map[i] == 0)		continue;
				if(visit[i] == true)	continue;
				
				total++;
				go(map, visit, i);
			}
			
			System.out.println("#"+ii+" "+total);
		}
		
		br.close();
	}

	static void go(int map[], boolean visit[], int start)
	{
		if(start > 401)	return;
		visit[start] = true;		//�������� üũ
		visit[map[start]] = true;	//������ ���� üũ
		
		for(int i=map[start]+1; i<401; i++)
		{
			if(map[i] != 0)
			{
				go(map, visit, i);
				break;
			}
		}
		
		return;
	}
}