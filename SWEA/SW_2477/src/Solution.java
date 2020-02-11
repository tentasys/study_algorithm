import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV6c6bgaIuoDFAXy
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int ii=0; ii<T; ii++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			aa a[] = new aa[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++)
				a[i] = new aa(Integer.parseInt(st.nextToken()));
			
			bb b[] = new bb[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++)
				b[i] = new bb(Integer.parseInt(st.nextToken()));
			
			c t[] = new c[K+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++)
				t[i] = new c(Integer.parseInt(st.nextToken()));
			
			Queue<c> a_q = new LinkedList<c>();
			Queue<c> b_q = new LinkedList<c>();
			
			int time = 0;
			
			while(true)
			{
				for(int i=1; i<=K; i++)
					if(t[i].t == time)
						a_q.add(t[i]);
				
				int count = 0;
				for(int i=1; i<=N; i++)
				{
					if(a[i].isEmpty == true)
					{
						c temp = a_q.poll();
						temp.a = a[i].t;
						if(i == A)	temp.isA = true;
						a[i].isEmpty = false;
					}
				}
				
				
				time++;
				break;
			}
			
			System.out.println("#" + (ii+1) + " ");
		}//each TC
	}

}

class c{
	int a;
	int b;
	int t;
	boolean isA;
	boolean isB;
	
	c(){
	}
	
	c(int num)
	{
		this.t = num;
		isA = false;
		isB = false;
	}
}

class aa{
	int t;
	boolean isEmpty;
	
	aa(){
		
	}
	aa(int num)
	{
		this.t = num;
		this.isEmpty = true;
	}
}

class bb{
	int t;
	boolean isEmpty;
	
	bb(){
		
	}
	bb(int num)
	{
		this.t = num;
		this.isEmpty = true;
	}
}