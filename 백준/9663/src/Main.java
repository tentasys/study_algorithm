import java.io.*;

public class Main {

	static int result = 0;
	static int row[];
	static int num;		//�� ����
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		row = new int[num];		//�ະ�� ����
		
		backtracking(0);
		System.out.print(result);
		
		br.close();
	}

	static void backtracking(int cur) {		//�ٺ��� �������� ��ġ�� ������. cur�� n������
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
			if(row[i] == c)		//����ϰ� �ִ� ���� �ִ���?
				return false;
			if(Math.abs(r-i) == Math.abs(row[i]-c) )	//���� ���� �ش� ����Ʈ���� ���Ⱑ 1 Ȥ�� -1����(�밢������)
				return false;
		}
		return true;
	}
}