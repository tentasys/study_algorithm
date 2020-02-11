import java.util.*;
import java.io.*;

//49분 39초
public class Main {

	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];		//지도
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int op[] = new int[K];	//명령
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++)
			op[i] = Integer.parseInt(st.nextToken());
		//------------입력 완료
		
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);		//주사위 만들고 초기화
		
		//명령대로!
		for(int i=0; i<K; i++)
		{
			if(isAble(x, y, op[i]) == false)	continue;	//불가능한 명령 무시
			
			dice.roll(op[i]);	//주사위 구른다
			
			//좌표 이동(우좌상하 순)
			if(op[i] == 1)	y++;	else if(op[i] == 2)	y--;	else if(op[i] == 3)	x--;	else x++;
			
			//밑면과 지도 비교
			if(map[x][y] == 0)		//주사위의 바닥면이 칸에 복사
			{
				map[x][y] = dice.down;
			}
			else			//칸에 있는게 주사위로 복사, 칸 0으로
			{
				dice.down = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice.up); 	//윗면 출력
		}
		br.close();
	}
	
	//그쪽으로 가는게 가능한 명령인지(좌표가 주어지면 다음걸 판단)
	static boolean isAble(int r, int c, int op)
	{
		boolean result = false;
		
		if(op == 1)		//우로 이동
		{
			if(c+1 < M)	result = true;
		}
		else if(op == 2)		//좌로 이동
		{
			if(c-1 >= 0)	result = true;
		}
		else if(op == 3)		//위로 이동
		{
			if(r-1 >= 0)	result = true;
		}
		else if(op == 4) //아래로 이동
		{
			if(r+1 < N)	result = true;
		}
		return result;
	}
}

class Dice{
	int up, down, front, back, left, right;
	Dice(){};
	Dice(int up, int down, int front, int back, int left, int right){
		this.up = up;	this.down = down;	this.front = front;		this.back = back;	this.left = left;	this.right = right;
	};
	public void roll(int op)
	{
		int temp = this.up;
		
		if(op == 1)		//동쪽(우회전): 앞뒤 똑같고 상하좌우가 시계방향으로 회전
		{
			this.up = this.left;
			this.left = this.down;
			this.down = this.right;
			this.right = temp;
		}
		else if(op == 2)	//서쪽(좌회전): 앞뒤 똑같고 상하좌우가 시계반대방향으로 회전
		{
			this.up = this.right;
			this.right = this.down;
			this.down = this.left;
			this.left = temp;
		}
		else if(op == 3)	//북쪽(뒤로): 좌우 똑같고 상하전후가 위로 회전
		{
			this.up = this.front;
			this.front = this.down;
			this.down = this.back;
			this.back = temp;
		}
		else if(op == 4)	//남쪽(앞으로): 좌우 똑같고 상하전후가 아래로 회전
		{
			this.up = this.back;
			this.back = this.down;
			this.down = this.front;
			this.front = temp;
		}
	}
}
