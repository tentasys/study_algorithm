import java.io.*;
import java.util.*;

public class Main {
	//상(0), 하(1), 좌(2), 우(3) 
	static final int dr[] = {-1, 1, 0, 0};
	static final int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		boolean apples[][] = new boolean[N+1][N+1];		//사과 위치는 배열로 관리. 인덱스 관리 편하게 하기 위해 N+1로 할당 
		for(int i=0; i<K; i++)
		{
			String str[] = br.readLine().split(" ");
			apples[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = true;
		}
		
		char[] timeline = new char[10001];
		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++)
		{
			String str[] = br.readLine().split(" ");
			timeline[Integer.parseInt(str[0])] = str[1].charAt(0);
		}
		br.close();
		//----------초기화 끝 ----------------
		
		//뱀 생성 
		Deque<Node> snake = new LinkedList<Node>();
		snake.addFirst(new Node(1, 1, 3));
		int time = 0;
		
		//게임 시작 
		while(time <= 10000)
		{	
			//뱀 머리 정보 
			Deque<Node> temp_snake = new LinkedList<Node>();
			Node head = null;
			Node tail = snake.getLast();
			tail = new Node(tail.r, tail.c, tail.dir);
			boolean isHead = true;
			boolean ateApple = false;
			boolean gameover = false;
			
			int nextdir = -1;
			
			//뱀 돌면서 확인 
			while(!snake.isEmpty())
			{
				Node cur = snake.pollFirst();
				int nr = cur.r + dr[cur.dir];
				int nc = cur.c + dc[cur.dir];
				
				//다음 위치가 벽을 넘으면 게임오버 
				if(nr < 1 || nc < 1 || nr > N || nc > N) {
					gameover = true;
					break;
				}
				
				//머리일 경우 다음 머리 위치 설정 & 사과 먹기 
				if(isHead == true) {
					
					//가는 위치가 꼬리이면 안됨 
					if(!snake.isEmpty()) {
						Node temp = snake.getLast();
						if(temp.r == nr && temp.c == nc) {
							gameover = true;
							break;
						}
					}
					
					//방향 설정 
					int temp_dir = cur.dir;
					nextdir = cur.dir;
					if(timeline[time] != '\0') {
						temp_dir = rotate(cur.dir, timeline[time]);
					}
					head = new Node(nr, nc, temp_dir);
					temp_snake.add(head);
					
					//사과가 있다면 먹는다 
					if(apples[nr][nc] == true) {
						apples[nr][nc] = false;
						ateApple = true;
					}
					
					isHead = false;
				}
				//머리가 아닐 경우 머리랑 부딪히는지 확인 
				else {
					if(nr == head.r && nc == head.c) {
						gameover = true;
						break;
					}
					
					temp_snake.add(new Node(nr, nc, nextdir));
					nextdir = cur.dir;
				}
				
			}
			
			if(gameover == true)	break;
			
			//사과를 먹었으면 꼬리 길이 더하기 
			if(ateApple == true)
			{
				//더했는데 이동한 머리 위치면 게임 오버 
				if(head.r == tail.r && head.c == tail.c)
					break;
				
				temp_snake.add(tail);
			}
			
			snake = temp_snake;
			
			//디버깅 
			snake = printSnake(N, time, snake, apples);
			
			time++;
		}
		
		System.out.print(time);
	}
	
	static int rotate(int input, char dir) {
		int result = input;
		//상(0), 하(1), 좌(2), 우(3) 
		switch(input) {
		case 0:
			if(dir == 'L')	result = 2;
			else			result = 3;
			break;
		case 1:
			if(dir == 'L')	result = 3;
			else			result = 2;
			break;
		case 2:
			if(dir == 'L')	result = 1;
			else			result = 0;
			break;
		case 3:
			if(dir == 'L')	result = 0;
			else			result = 1;
			break;
		default:
			result = input;
		}
		
		return result;
	}
	
	static Deque<Node> printSnake(int N, int time, Deque<Node> snake, boolean[][] apples) {
		
		Deque<Node> temp = new LinkedList<Node>();
		
		System.out.println("----------time : "+time+"-------------");
		boolean[][] map = new boolean[N+1][N+1];
		while(!snake.isEmpty()) {
			Node cur = snake.poll();
			temp.add(cur);
			map[cur.r][cur.c] = true;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == true)	System.out.print("■");
				else if(apples[i][j] == true)	System.out.print("●");
				else System.out.print("□");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		
		return temp;
	}

}

//좌표 클래스 
class Node{
	int r;	int c; int dir;
	Node(int r, int c, int dir){
		this.r = r;	
		this.c = c;
		this.dir = dir;
	}
}