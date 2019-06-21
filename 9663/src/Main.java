import java.io.*;

public class Main {

	static int result = 0;
	static int row[];
	static int num;		//판 넓이
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		row = new int[num];		//행별로 관리
		
		backtracking(0);
		System.out.print(result);
		
		br.close();
	}

	static void backtracking(int cur) {		//줄별로 차례차례 배치해 나가자. cur행 n열부터
		if(cur == num)
		{
			result++;
			return;
		}
		
		for(int i=0; i<num; i++)
		{
			if(check(cur, i) == false)
				continue;
			
			row[cur] = i;
			backtracking(cur+1);
			row[cur] = 0;
		}
	}
	
	static boolean check(int r, int c) {
		for(int i=0; i<r; i++)
		{
			if(row[i] == c)		//사용하고 있는 열이 있는지?
				return false;
			if(Math.abs(r-i) == Math.abs(row[i]-c) )	//현재 점과 해당 포인트간의 기울기가 1 혹은 -1인지(대각선인지)
				return false;
		}
		return true;
	}
}