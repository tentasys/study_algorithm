import java.io.*;
import java.util.*;

public class Main {

	static int MAX_PERMU = 40320;	//8!�� ��
	static int permu_list[][] = new int[MAX_PERMU][9];
	static int total_count = 0;		//���� ���� ����
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());		//�̴�
		int score[][] = new int[N][9];		//n��° �̴׿��� �� �� �ִ� ����
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Permutation(new int[8], new boolean[9], 0);
		
		int max = Integer.MIN_VALUE;
		
		for(int cur=0; cur<MAX_PERMU; cur++)	//���� �� Ž��
		{
			int cur_score = 0;	//���� ����
			int inning = 0;		//���� �̴�
			boolean base[]= new boolean[4];	//1��, 2��, 3��
			int out = 0;		//�ƿ� ��
			int player = 0;		//�÷��̾� ��ȣ
			
			while(inning < N)	//�̴� �������� ����
			{
				int state = score[inning][permu_list[cur][player]];	//���� ������ �󸶳� ġ����
				
				if(state == 0)
				{
					out++;
				}
				else if(state == 1)
				{
					if(base[3] == true)	{base[3] = false;	cur_score++;}		//3�翡 ����� ������ ���� ����
					if(base[2] == true)	{base[2] = false;	base[3] = true;}	//2�翡 ����� ������ 3��� �̵�
					if(base[1] == true)	{base[1] = false;	base[2] = true;}	//1�翡 ����� ������ 2��� �̵�
					base[1] = true;		//1�翡 ��� ����
				}
				else if(state == 2)
				{
					if(base[3] == true)	{base[3] = false;	cur_score++;}
					if(base[2] == true)	{base[2] = false;	cur_score++;}
					if(base[1] == true)	{base[1] = false;	base[3] = true;}
					base[2] = true;
				}
				else if(state == 3)
				{
					if(base[3] == true)	{base[3] = false;	cur_score++;}
					if(base[2] == true)	{base[2] = false;	cur_score++;}
					if(base[1] == true)	{base[1] = false;	cur_score++;}
					base[3] = true;
				}
				else	//state == 4
				{
					if(base[3] == true)	{base[3] = false;	cur_score++;}
					if(base[2] == true)	{base[2] = false;	cur_score++;}
					if(base[1] == true)	{base[1] = false;	cur_score++;}
					cur_score++;
				}
				
				if(out == 3)
				{
					inning++;	out = 0;	//�ƿ� 3���̸� �ƿ� �ʱ�ȭ�ϰ� �̴� �ѱ��
					base[0] = false;	base[1] = false;	base[2] = false;	base[3] = false;
				}
				
				player++;		//���� �÷��̾�
				if(player == 9)
					player = 0;
			}
			
			max = Math.max(max, cur_score);
			
		}
		
		System.out.println(max);
		
		br.close();
	}

	//8!�� �̸� ���س���
	static void Permutation(int[] permu, boolean visit[], int count) {	//���� ���� ����Ʈ, �湮 �迭, �ε���
		if(count == 8)		//1�� ��ġ�� ������ �����Ƿ�
		{
			//�迭 ����
			for(int i=0; i<3; i++)
				permu_list[total_count][i] = permu[i];
			
			permu_list[total_count][3] = 0;
			
			for(int i=3; i<8; i++)
				permu_list[total_count][i+1] = permu[i];
			
			total_count++;	//������ ���� ����
		}
		
		for(int i=1; i<9; i++)
		{
			if(visit[i] == true)	continue;
			
			visit[i] = true;
			permu[count] = i;
			Permutation(permu, visit, count+1);
			visit[i] = false;
		}
	}
}
