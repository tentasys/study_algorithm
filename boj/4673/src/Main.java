public class Main {

	public static void main(String[] args) {
		boolean check[] = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			int temp = cal(i);
			if(temp <= 10000)	check[temp] = true;
		}

		for(int i=1; i<=10000; i++)
			if(check[i] == false)	System.out.println(i);
	}

	public static int cal(int num) {
		int sum = num;
		int temp = num;

		while (temp > 0) {
			sum += temp % 10;
			temp /= 10;
		}

		return sum;
	}
}