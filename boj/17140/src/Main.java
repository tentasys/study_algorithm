//2시간 22분 ..

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int A[][] = new int[3][3];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		
		while(time <= 100) {
			if(A.length >= r && A[0].length >= c)
				if((A[r-1][c-1]) == k)	break;
			
			int col_len = A[0].length;		//열 길이 
			int row_len = A.length;			//행 길이 
			
			int[][] res = null;
			if(row_len >= col_len)
				res = calRows(A);
			else
				res = calCols(A);
			
			A = res;
			
			time++;
			
//			System.out.println("time : "+time+", row : "+A.length+", col : "+A[0].length);
//			for(int i=0; i<A.length; i++) {
//				for(int j=0; j<A[0].length; j++)
//					System.out.print(A[i][j]+" ");
//				System.out.println();
//			}
//			System.out.println();
		}
		
		if(time > 100)
			System.out.println(-1);
		else
			System.out.println(time);
		
		br.close();
	}

	//R연산 
	static int[][] calRows(int[][] A) {
		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		int max_len = 0;
		
		//숫자 세기 
		for(int r=0; r<A.length; r++) {
			ArrayList<Node> cur_list = new ArrayList<Node>();
			int nums[] = new int[101];
			
			for(int c=0; c<A[r].length; c++)
				nums[A[r][c]]++;
			
			for(int i=1; i<101; i++) {
				if(nums[i] != 0) {
					cur_list.add(new Node(i, nums[i]));
				}
			}
			
			Collections.sort(cur_list);
			list.add(cur_list);
			
			max_len = Math.max(max_len, cur_list.size());
		}
		
		//리스트를 배열화 
		int rows = A.length;
		int cols = max_len*2;
		
		if(rows > 100)
			rows = 100;
		if(cols > 100)
			cols = 100;
		
		int arr[][] = new int[rows][cols];
		int i=0;
		for(ArrayList<Node> cur_list : list) {
			if(i >= 100)		break;
			for(int j=0; j<cur_list.size(); j++) {
				if(j >= 100)	break;			
				arr[i][j*2] = cur_list.get(j).n;
				arr[i][j*2+1] = cur_list.get(j).time;
			}
			
			i++;
		}
		
		return arr;
	}
	
	//C연산 
	static int[][] calCols(int[][] A) {
		ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		int max_len = 0;
		
		//숫자 세기 
		for(int c=0; c<A[0].length; c++) {
			ArrayList<Node> cur_list = new ArrayList<Node>();
			int nums[] = new int[101];
			
			for(int r=0; r<A.length; r++)
				nums[A[r][c]]++;
			
			for(int i=1; i<101; i++) {
				if(nums[i] != 0) {
					cur_list.add(new Node(i, nums[i]));
				}
			}
			
			Collections.sort(cur_list);
			list.add(cur_list);
			
			max_len = Math.max(max_len, cur_list.size());
		}
		
		//리스트를 배열화 
		int rows = max_len*2;
		int cols = A[0].length;
		
		if(rows > 100)	rows = 100;
		if(cols > 100)	cols = 100;
		
		int arr[][] = new int[rows][cols];
		int i=0;
		for(ArrayList<Node> cur_list : list) {
			if(i >= 100)		break;
			for(int j=0; j<cur_list.size(); j++) {
				if(j >= 100)		break;
				arr[j*2][i] = cur_list.get(j).n;
				arr[j*2+1][i] = cur_list.get(j).time;
			}
			i++;
		}
		
		return arr;
	}
}

class Node implements Comparable<Node>{
	int n;
	int time;
	Node(int n, int time){
		this.n = n;
		this.time = time;
	}
	@Override
	public int compareTo(Node o) {
		//수 등장횟수 오름차순 
		if(this.time-o.time != 0)
			return this.time-o.time;
		
		return this.n - o.n;
	}
}
