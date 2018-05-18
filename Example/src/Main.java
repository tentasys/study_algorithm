import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		//줄 읽어들이기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		//배열 선언
		int arr2d[][] = new int[N][N];
		int arr1d[] = new int[N];
		
		//배열 테스팅
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
				System.out.print(arr2d[i][j]);
			System.out.println();
		}
		
		//foreach 구문
		for(int a : arr1d)
		{
			System.out.print(a);
		}
	}
	
	//약수 구하는 법
	void calculateDiv(int n) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int i=1; i<=Math.sqrt(N); i++)
		{
			if(N%i == 0)
			{
				q.add(i);
				if(i != N/i)
					q.add(N/i);
			}
		}
		
		while(!q.isEmpty())
			System.out.print(q.poll() + " ");	
	}
	

	//정렬
	void sorting() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(2);	arr.add(3);	arr.add(8);	arr.add(1);	arr.add(9);
		
		for(Integer a : arr)
			System.out.print(a + " ");
		
		System.out.println();
		
		//오름차순
		Ascending as = new Ascending();
		Collections.sort(arr, as);
		for(Integer a : arr)
			System.out.print(a + " ");
		
		System.out.println();
		
		//내림차순
		Descending d = new Descending();
		Collections.sort(arr, d);
		for(Integer a : arr)
			System.out.print(a + " ");
		
		System.out.println();
	}
}


//정렬 클래스
class Ascending implements Comparator<Integer>{
	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg0.compareTo(arg1);
	}
}

class Descending implements Comparator<Integer>{
	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg1.compareTo(arg0);
	}
}
