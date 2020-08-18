import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int ii=0; ii<n; ii++)
		{
			int r = Integer.parseInt(br.readLine());	//돌리는 수
			String op[] = new String[r];				//명령 담는 배열
			
			//명령을 배열에 담기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<r; i++)
				op[i] = st.nextToken();
			
			roll(op);		//큐브 돌리기
		}
	}

	static public void roll(String[] op)
	{
		Cube cube = new Cube();
		
		for(String s : op)
		{
			if(s.compareTo("F+") == 0)			cube.Front_Clock();
			else if(s.compareTo("F-") == 0)		cube.Front_CounterClock();
			else if(s.compareTo("B+") == 0)		cube.Back_Clock();
			else if(s.compareTo("B-") == 0)		cube.Back_CounterClock();
			else if(s.compareTo("U+") == 0)		cube.Up_Clock();
			else if(s.compareTo("U-") == 0)		cube.Up_CounterClock();
			else if(s.compareTo("D+") == 0)		cube.Down_Clock();
			else if(s.compareTo("D-") == 0)		cube.Down_CounterClock();
			else if(s.compareTo("L+") == 0)		cube.Left_Clock();
			else if(s.compareTo("L-") == 0)		cube.Left_CounterClock();
			else if(s.compareTo("R+") == 0)		cube.Right_Clock();
			else if(s.compareTo("R-") == 0)		cube.Right_CounterClock();
			
//			cube.Print();
//			System.out.println();
		}
		
		cube.Up_Print();
	}
}

class Cube{
	//면별로 관리
	char UP[][] = {{'w', 'w', 'w'},{'w', 'w', 'w'},{'w', 'w', 'w'}};
	char DOWN[][] = {{'y', 'y', 'y'},{'y', 'y', 'y'},{'y', 'y', 'y'}};
	char LEFT[][] = {{'g', 'g', 'g'},{'g', 'g', 'g'},{'g', 'g', 'g'}};
	char RIGHT[][] = {{'b', 'b', 'b'},{'b', 'b', 'b'},{'b', 'b', 'b'}};
	char FRONT[][] = {{'r', 'r', 'r'},{'r', 'r', 'r'},{'r', 'r', 'r'}};
	char BACK[][] = {{'o', 'o', 'o'},{'o', 'o', 'o'},{'o', 'o', 'o'}};
	
	Cube(){};
	
	public void Up_Clock()		//전후좌우 맨윗줄이 회전
	{
		//앞면 맨윗줄 복사
		char temp[] = new char[3];
		temp[0] = FRONT[0][0];
		temp[1] = FRONT[0][1];
		temp[2] = FRONT[0][2];
		
		//우측 -> 앞면
		FRONT[0][0] = RIGHT[0][0];		FRONT[0][1] = RIGHT[0][1];		FRONT[0][2] = RIGHT[0][2];
		//뒷면 -> 우측
		RIGHT[0][0] = BACK[0][0];		RIGHT[0][1] = BACK[0][1];		RIGHT[0][2] = BACK[0][2];
		//좌측 -> 뒷면
		BACK[0][0] = LEFT[0][0];		BACK[0][1] = LEFT[0][1];		BACK[0][2] = LEFT[0][2];
		//앞면(임시배열) -> 좌측
		LEFT[0][0] = temp[0];			LEFT[0][1] = temp[1];			LEFT[0][2] = temp[2];
		
		//윗면 모든 요소가 시계방향으로 회전
		//가장자리 회전
		temp[0] = UP[0][0];
		UP[0][0] = UP[2][0];	UP[2][0] = UP[2][2];	UP[2][2] = UP[0][2];	UP[0][2] = temp[0];
		//나머지 회전
		temp[0] = UP[0][1];
		UP[0][1] = UP[1][0];	UP[1][0] = UP[2][1];	UP[2][1] = UP[1][2];	UP[1][2] = temp[0];
		
	}
	
	public void Up_CounterClock()		//전후좌우 맨윗줄이 회전, 윗면 시계반대방향으로 회전
	{
		//앞면 맨윗줄 복사
		char temp[] = new char[3];
		temp[0] = FRONT[0][0];
		temp[1] = FRONT[0][1];
		temp[2] = FRONT[0][2];
		
		//좌측 -> 앞면
		FRONT[0][0] = LEFT[0][0];		FRONT[0][1] = LEFT[0][1];		FRONT[0][2] = LEFT[0][2];
		//뒷면 -> 좌측
		LEFT[0][0] = BACK[0][0];		LEFT[0][1] = BACK[0][1];		LEFT[0][2] = BACK[0][2];		
		//우측 -> 뒷면
		BACK[0][0] = RIGHT[0][0];		BACK[0][1] = RIGHT[0][1];		BACK[0][2] = RIGHT[0][2];
		//앞면(임시배열) -> 우측
		RIGHT[0][0] = temp[0];			RIGHT[0][1] = temp[1];			RIGHT[0][2] = temp[2];
		
		//윗면 모든 요소가 시계반대방향으로 회전
		//가장자리 회전
		temp[0] = UP[0][0];
		UP[0][0] = UP[0][2];	UP[0][2] = UP[2][2];	UP[2][2] = UP[2][0];	UP[2][0] = temp[0];
		//나머지 회전
		temp[0] = UP[0][1];
		UP[0][1] = UP[1][2];	UP[1][2] = UP[2][1];	UP[2][1] = UP[1][0];	UP[1][0] = temp[0];
	}
	
	public void Down_Clock()		//전후좌우 아랫줄이 회전, 밑면 시계방향으로 회전
	{
		//앞면 맨아랫줄 복사
		char temp[] = new char[3];
		temp[0] = FRONT[2][0];
		temp[1] = FRONT[2][1];
		temp[2] = FRONT[2][2];
		
		//좌측 -> 앞면
		FRONT[2][0] = LEFT[2][0];		FRONT[2][1] = LEFT[2][1];		FRONT[2][2] = LEFT[2][2];
		//뒷면 -> 좌측
		LEFT[2][0] = BACK[2][0];		LEFT[2][1] = BACK[2][1];		LEFT[2][2] = BACK[2][2];		
		//우측 -> 뒷면
		BACK[2][0] = RIGHT[2][0];		BACK[2][1] = RIGHT[2][1];		BACK[2][2] = RIGHT[2][2];
		//앞면(임시배열) -> 우측
		RIGHT[2][0] = temp[0];			RIGHT[2][1] = temp[1];			RIGHT[2][2] = temp[2];
		
		//아랫면 모든 요소가 시계방향으로 회전
		//가장자리 회전
		temp[0] = DOWN[0][0];
		DOWN[0][0] = DOWN[2][0];	DOWN[2][0] = DOWN[2][2];	DOWN[2][2] = DOWN[0][2];	DOWN[0][2] = temp[0];
		//나머지 회전
		temp[0] = DOWN[0][1];
		DOWN[0][1] = DOWN[1][0];	DOWN[1][0] = DOWN[2][1];	DOWN[2][1] = DOWN[1][2];	DOWN[1][2] = temp[0];
	}
	
	public void Down_CounterClock()	//전후좌후 아랫줄이 회전, 아랫면 시계반대방향으로 회전
	{
		//앞면 맨윗줄 복사
		char temp[] = new char[3];
		temp[0] = FRONT[2][0];
		temp[1] = FRONT[2][1];
		temp[2] = FRONT[2][2];
		
		//우측 -> 앞면
		FRONT[2][0] = RIGHT[2][0];		FRONT[2][1] = RIGHT[2][1];		FRONT[2][2] = RIGHT[2][2];
		//뒷면 -> 우측
		RIGHT[2][0] = BACK[2][0];		RIGHT[2][1] = BACK[2][1];		RIGHT[2][2] = BACK[2][2];
		//좌측 -> 뒷면
		BACK[2][0] = LEFT[2][0];		BACK[2][1] = LEFT[2][1];		BACK[2][2] = LEFT[2][2];
		//앞면(임시배열) -> 좌측
		LEFT[2][0] = temp[0];			LEFT[2][1] = temp[1];			LEFT[2][2] = temp[2];
		
		//아랫면 모든 요소가 시계반대방향으로 회전
		//가장자리 회전
		temp[0] = DOWN[0][0];
		DOWN[0][0] = DOWN[0][2];	DOWN[0][2] = DOWN[2][2];	DOWN[2][2] = DOWN[2][0];	DOWN[2][0] = temp[0];
		//나머지 회전
		temp[0] = DOWN[0][1];
		DOWN[0][1] = DOWN[1][2];	DOWN[1][2] = DOWN[2][1];	DOWN[2][1] = DOWN[1][0];	DOWN[1][0] = temp[0];	
	}
	
	public void Front_Clock()		//상하좌우 회전, 앞면 시계방향으로 회전
	{
		//윗면 맨아랫줄 복사
		char temp[] = new char[3];
		temp[0] = UP[2][0];
		temp[1] = UP[2][1];
		temp[2] = UP[2][2];
		
		//좌측 -> 윗면
		UP[2][0] = LEFT[2][2];			UP[2][1] = LEFT[1][2];			UP[2][2] = LEFT[0][2];
		//아랫면 -> 좌측
		LEFT[0][2] = DOWN[0][0];		LEFT[1][2] = DOWN[0][1];		LEFT[2][2] = DOWN[0][2];
		//우측 -> 아랫면
		DOWN[0][0] = RIGHT[2][0];		DOWN[0][1] = RIGHT[1][0];		DOWN[0][2] = RIGHT[0][0];
		//윗면(임시배열) -> 우측
		RIGHT[0][0] = temp[0];			RIGHT[1][0] = temp[1];			RIGHT[2][0] = temp[2];
		
		//앞면 모든 요소가 시계방향으로 회전
		//가장자리 회전
		temp[0] = FRONT[0][0];
		FRONT[0][0] = FRONT[2][0];	FRONT[2][0] = FRONT[2][2];	FRONT[2][2] = FRONT[0][2];	FRONT[0][2] = temp[0];
		//나머지 회전
		temp[0] = FRONT[0][1];
		FRONT[0][1] = FRONT[1][0];	FRONT[1][0] = FRONT[2][1];	FRONT[2][1] = FRONT[1][2];	FRONT[1][2] = temp[0];
	}
	
	public void Front_CounterClock()	//상하좌우 회전, 앞면 시계반대방향으로 회전
	{
		//윗면 맨아랫줄 복사
		char temp[] = new char[3];
		temp[0] = UP[2][0];
		temp[1] = UP[2][1];
		temp[2] = UP[2][2];
		
		//우측 -> 윗면
		UP[2][0] = RIGHT[0][0];			UP[2][1] = RIGHT[1][0];			UP[2][2] = RIGHT[2][0];
		//아랫면 -> 우측
		RIGHT[0][0] = DOWN[0][2];		RIGHT[1][0] = DOWN[0][1];		RIGHT[2][0] = DOWN[0][0];		
		//좌측 -> 아랫면
		DOWN[0][0] = LEFT[0][2];		DOWN[0][1] = LEFT[1][2];		DOWN[0][2] = LEFT[2][2];
		//윗면(임시배열) -> 좌측
		LEFT[0][2] = temp[2];			LEFT[1][2] = temp[1];			LEFT[2][2] = temp[0];
		
		//앞면 모든 요소가 시계반대방향으로 회전
		//가장자리 회전
		temp[0] = FRONT[0][0];
		FRONT[0][0] = FRONT[0][2];	FRONT[0][2] = FRONT[2][2];	FRONT[2][2] = FRONT[2][0];	FRONT[2][0] = temp[0];
		//나머지 회전
		temp[0] = FRONT[0][1];
		FRONT[0][1] = FRONT[1][2];	FRONT[1][2] = FRONT[2][1];	FRONT[2][1] = FRONT[1][0];	FRONT[1][0] = temp[0];		
	}
	
	public void Back_Clock()		//상하좌우 회전, 뒷면 시계방향으로 회전
	{
		//윗면 맨윗줄 복사
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[0][1];
		temp[2] = UP[0][2];
		
		//우측 -> 윗면
		UP[0][0] = RIGHT[0][2];			UP[0][1] = RIGHT[1][2];			UP[0][2] = RIGHT[2][2];
		//아랫면 -> 우측
		RIGHT[0][2] = DOWN[2][2];		RIGHT[1][2] = DOWN[2][1];		RIGHT[2][2] = DOWN[2][0];
		//좌측 -> 아랫면
		DOWN[2][2] = LEFT[2][0];		DOWN[2][1] = LEFT[1][0];		DOWN[2][0] = LEFT[0][0];
		//윗면(임시배열) -> 좌측
		LEFT[2][0] = temp[0];			LEFT[1][0] = temp[1];			LEFT[0][0] = temp[2];
		
		//뒷면 모든 요소가 시계방향으로 회전
		//가장자리 회전
		temp[0] = BACK[0][0];
		BACK[0][0] = BACK[2][0];	BACK[2][0] = BACK[2][2];	BACK[2][2] = BACK[0][2];	BACK[0][2] = temp[0];
		//나머지 회전
		temp[0] = BACK[0][1];
		BACK[0][1] = BACK[1][0];	BACK[1][0] = BACK[2][1];	BACK[2][1] = BACK[1][2];	BACK[1][2] = temp[0];
	}
	
	public void Back_CounterClock()		//상하좌우 회전, 뒷면 시계반대방향으로 회전
	{
		//윗면 맨윗줄 복사
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[0][1];
		temp[2] = UP[0][2];
		
		//좌측 -> 윗면
		UP[0][0] = LEFT[2][0];			UP[0][1] = LEFT[1][0];			UP[0][2] = LEFT[0][0];
		//아랫면 -> 좌측
		LEFT[2][0] = DOWN[2][2];		LEFT[1][0] = DOWN[2][1];		LEFT[0][0] = DOWN[2][0];		
		//우측 -> 아랫면
		DOWN[2][0] = RIGHT[2][2];		DOWN[2][1] = RIGHT[1][2];		DOWN[2][2] = RIGHT[0][2];
		//윗면(임시배열) -> 우측
		RIGHT[0][2] = temp[0];			RIGHT[1][2] = temp[1];			RIGHT[2][2] = temp[2];
		
		//뒷면 모든 요소가 시계반대방향으로 회전
		//가장자리 회전
		temp[0] = BACK[0][0];
		BACK[0][0] = BACK[0][2];	BACK[0][2] = BACK[2][2];	BACK[2][2] = BACK[2][0];	BACK[2][0] = temp[0];
		//나머지 회전
		temp[0] = BACK[0][1];
		BACK[0][1] = BACK[1][2];	BACK[1][2] = BACK[2][1];	BACK[2][1] = BACK[1][0];	BACK[1][0] = temp[0];		
	}
	
	public void Left_Clock()	//상하전후 회전, 왼쪽면 시계방향으로 회전
	{
		//윗면 맨왼쪽줄 복사
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[1][0];
		temp[2] = UP[2][0];
		
		//뒷면 -> 윗면
		UP[0][0] = BACK[2][2];			UP[1][0] = BACK[1][2];			UP[2][0] = BACK[0][2];
		//아랫면 -> 뒷면
		BACK[0][2] = DOWN[2][0];		BACK[1][2] = DOWN[1][0];		BACK[2][2] = DOWN[0][0];
		//앞면 -> 아랫면
		DOWN[0][0] = FRONT[0][0];		DOWN[1][0] = FRONT[1][0];		DOWN[2][0] = FRONT[2][0];
		//윗면(임시배열) -> 앞면
		FRONT[0][0] = temp[0];			FRONT[1][0] = temp[1];			FRONT[2][0] = temp[2];
		
		//왼쪽면 모든 요소가 시계방향으로 회전
		//가장자리 회전
		temp[0] = LEFT[0][0];
		LEFT[0][0] = LEFT[2][0];	LEFT[2][0] = LEFT[2][2];	LEFT[2][2] = LEFT[0][2];	LEFT[0][2] = temp[0];
		//나머지 회전
		temp[0] = LEFT[0][1];
		LEFT[0][1] = LEFT[1][0];	LEFT[1][0] = LEFT[2][1];	LEFT[2][1] = LEFT[1][2];	LEFT[1][2] = temp[0];
	}
	
	public void Left_CounterClock()		//상하전후 회전, 왼쪽면 시계반대방향으로 회전
	{
		//윗면 맨왼쪽줄줄 복사
		char temp[] = new char[3];
		temp[0] = UP[0][0];
		temp[1] = UP[1][0];
		temp[2] = UP[2][0];
		
		//앞면 -> 윗면
		UP[0][0] = FRONT[0][0];			UP[1][0] = FRONT[1][0];			UP[2][0] = FRONT[2][0];
		//아랫면 -> 앞면
		FRONT[0][0] = DOWN[0][0];		FRONT[1][0] = DOWN[1][0];		FRONT[2][0] = DOWN[2][0];		
		//뒷면 -> 아랫면
		DOWN[0][0] = BACK[2][2];		DOWN[1][0] = BACK[1][2];		DOWN[2][0] = BACK[0][2];
		//윗면(임시배열) -> 뒷면
		BACK[0][2] = temp[2];			BACK[1][2] = temp[1];			BACK[2][2] = temp[0];
		
		//왼쪽면 모든 요소가 시계반대방향으로 회전
		//가장자리 회전
		temp[0] = LEFT[0][0];
		LEFT[0][0] = LEFT[0][2];	LEFT[0][2] = LEFT[2][2];	LEFT[2][2] = LEFT[2][0];	LEFT[2][0] = temp[0];
		//나머지 회전
		temp[0] = LEFT[0][1];
		LEFT[0][1] = LEFT[1][2];	LEFT[1][2] = LEFT[2][1];	LEFT[2][1] = LEFT[1][0];	LEFT[1][0] = temp[0];		
	}
	
	public void Right_Clock()		//상하전후 회전, 오른쪽면 시계방향으로 회전
	{
		//윗면 맨오른쪽줄 복사
		char temp[] = new char[3];
		temp[0] = UP[0][2];
		temp[1] = UP[1][2];
		temp[2] = UP[2][2];
		
		//앞면 -> 윗면
		UP[0][2] = FRONT[0][2];			UP[1][2] = FRONT[1][2];			UP[2][2] = FRONT[2][2];
		//아랫면 -> 앞면
		FRONT[0][2] = DOWN[0][2];		FRONT[1][2] = DOWN[1][2];		FRONT[2][2] = DOWN[2][2];
		//뒷면 -> 아랫면
		DOWN[0][2] = BACK[2][0];		DOWN[1][2] = BACK[1][0];		DOWN[2][2] = BACK[0][2];
		//윗면(임시배열) -> 뒷면
		BACK[2][0] = temp[0];			BACK[1][0] = temp[1];			BACK[0][0] = temp[2];
		
		//오른쪽면 모든 요소가 시계방향으로 회전
		//가장자리 회전
		temp[0] = RIGHT[0][0];
		RIGHT[0][0] = RIGHT[2][0];	RIGHT[2][0] = RIGHT[2][2];	RIGHT[2][2] = RIGHT[0][2];	RIGHT[0][2] = temp[0];
		//나머지 회전
		temp[0] = RIGHT[0][1];
		RIGHT[0][1] = RIGHT[1][0];	RIGHT[1][0] = RIGHT[2][1];	RIGHT[2][1] = RIGHT[1][2];	RIGHT[1][2] = temp[0];
	}
	
	public void Right_CounterClock()	//상하전후 회전, 오른쪽면 시계반대방향으로 회전
	{
		//윗면 맨오른쪽줄 복사
		char temp[] = new char[3];
		temp[0] = UP[0][2];
		temp[1] = UP[1][2];
		temp[2] = UP[2][2];
		
		//뒷면 -> 윗면
		UP[0][2] = BACK[2][0];			UP[1][2] = BACK[1][0];			UP[2][2] = BACK[0][0];
		//아랫면 -> 뒷면
		BACK[0][0] = DOWN[2][2];		BACK[1][0] = DOWN[1][2];		BACK[2][0] = DOWN[0][2];		
		//앞면 -> 아랫면
		DOWN[0][2] = FRONT[0][2];		DOWN[1][2] = FRONT[1][2];		DOWN[2][2] = FRONT[2][2];
		//윗면(임시배열) -> 앞면
		FRONT[0][2] = temp[0];			FRONT[1][2] = temp[1];			FRONT[2][2] = temp[2];
		
		//오른쪽면 모든 요소가 시계반대방향으로 회전
		//가장자리 회전
		temp[0] = RIGHT[0][0];
		RIGHT[0][0] = RIGHT[0][2];	RIGHT[0][2] = RIGHT[2][2];	RIGHT[2][2] = RIGHT[2][0];	RIGHT[2][0] = temp[0];
		//나머지 회전
		temp[0] = RIGHT[0][1];
		RIGHT[0][1] = RIGHT[1][2];	RIGHT[1][2] = RIGHT[2][1];	RIGHT[2][1] = RIGHT[1][0];	RIGHT[1][0] = temp[0];		
	}
	
	public void Up_Print()
	{
		System.out.print(UP[0][0]);
		System.out.print(UP[0][1]);
		System.out.print(UP[0][2]);
		System.out.println();
		
		System.out.print(UP[1][0]);
		System.out.print(UP[1][1]);
		System.out.print(UP[1][2]);
		System.out.println();
		
		System.out.print(UP[2][0]);
		System.out.print(UP[2][1]);
		System.out.print(UP[2][2]);
		System.out.println();
	}
	public void Down_Print()
	{
		System.out.print(DOWN[0][0]);
		System.out.print(DOWN[0][1]);
		System.out.print(DOWN[0][2]);
		System.out.println();
		
		System.out.print(DOWN[1][0]);
		System.out.print(DOWN[1][1]);
		System.out.print(DOWN[1][2]);
		System.out.println();
		
		System.out.print(DOWN[2][0]);
		System.out.print(DOWN[2][1]);
		System.out.print(DOWN[2][2]);
		System.out.println();
	}
	public void Left_Print()
	{
		System.out.print(LEFT[0][0]);
		System.out.print(LEFT[0][1]);
		System.out.print(LEFT[0][2]);
		System.out.println();
		
		System.out.print(LEFT[1][0]);
		System.out.print(LEFT[1][1]);
		System.out.print(LEFT[1][2]);
		System.out.println();
		
		System.out.print(LEFT[2][0]);
		System.out.print(LEFT[2][1]);
		System.out.print(LEFT[2][2]);
		System.out.println();
	}
	public void Right_Print()
	{
		System.out.print(RIGHT[0][0]);
		System.out.print(RIGHT[0][1]);
		System.out.print(RIGHT[0][2]);
		System.out.println();
		
		System.out.print(RIGHT[1][0]);
		System.out.print(RIGHT[1][1]);
		System.out.print(RIGHT[1][2]);
		System.out.println();
		
		System.out.print(RIGHT[2][0]);
		System.out.print(RIGHT[2][1]);
		System.out.print(RIGHT[2][2]);
		System.out.println();
	}
	public void Front_Print()
	{
		System.out.print(FRONT[0][0]);
		System.out.print(FRONT[0][1]);
		System.out.print(FRONT[0][2]);
		System.out.println();
		
		System.out.print(FRONT[1][0]);
		System.out.print(FRONT[1][1]);
		System.out.print(FRONT[1][2]);
		System.out.println();
		
		System.out.print(FRONT[2][0]);
		System.out.print(FRONT[2][1]);
		System.out.print(FRONT[2][2]);
		System.out.println();
	}
	public void Back_Print()
	{
		System.out.print(BACK[0][0]);
		System.out.print(BACK[0][1]);
		System.out.print(BACK[0][2]);
		System.out.println();
		
		System.out.print(BACK[1][0]);
		System.out.print(BACK[1][1]);
		System.out.print(BACK[1][2]);
		System.out.println();
		
		System.out.print(BACK[2][0]);
		System.out.print(BACK[2][1]);
		System.out.print(BACK[2][2]);
		System.out.println();
	}
	public void Print() {
		System.out.println("------UP------");
		Up_Print();
		System.out.println("------DOWN------");
		Down_Print();
		System.out.println("------LEFT------");
		Left_Print();
		System.out.println("------RIGHT------");
		Right_Print();
		System.out.println("------FRONT------");
		Front_Print();
		System.out.println("------BACK------");
		Back_Print();
	}
}