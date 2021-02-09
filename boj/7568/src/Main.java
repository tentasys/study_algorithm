import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person arr[] = new Person[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Person(x, y);
		}
		
		int count = 0;	//등수 정보 셀 배열 
		int sub_count = 0;	//그 등수 정보가 몇명인지 
		ArrayList<Person> list = new ArrayList<Person>();	//대표로 하나씩만 
		int order_count[] = new int[51];
		
		//각 요소에 대해서, 키가 크지만 몸무게가 작으면 같은 등수 
		for(int i=0; i<N; i++) {
			//등수 정보가 세팅되어있으면 건너뛰기 
			if(arr[i].order != -1)		continue;
			arr[i].order = count;
			count++;
			sub_count = 1;

			list.add(arr[i]);
		
			for(int j=i; j<N; j++) {
				if((arr[i].x >= arr[j].x && arr[i].y <= arr[j].y) || (arr[i].x <= arr[j].x && arr[i].y >= arr[j].y))
				{
					arr[j].order = count;
					sub_count++;
				}			
			}
			order_count[count] = sub_count;
		}
		
		Collections.sort(list);
		int order[] = new int[51];
		
		order[list.get(0).order] = 1;
		for(int i=1; i<count; i++) {
			int cur = list.get(i).order;
			int before = list.get(i-1).order;
			order[cur] = order_count[before]+order[before]-1;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(order[arr[i].order]+" ");
		}
	}
}
class Person implements Comparable<Person>{
	int x;	//몸무게 
	int y;	//키 
	int order;	//등수 
	Person(int x, int y){
		this.x = x;	this.y = y;	this.order = -1;
	}
	@Override
	public int compareTo(Person o) {
		return o.x - this.x;
	}
}