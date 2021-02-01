import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(0, N-1, cur, list));
		}
	}

	public static int binarySearch(int low, int high, int target, ArrayList<Integer> list) {
		//여기서 조건을 불만족시키면 없는 수
		if(low > high)
			return 0;
		
		int mid = (low+high)/2;
		
		//타겟이 중간값보다 작으면 왼쪽 탐
		if(target == list.get(mid))
			return 1;
		else if(target < list.get(mid))
			return binarySearch(low, mid-1, target, list);
		else 
			return binarySearch(mid+1, high, target, list);
	}
}
