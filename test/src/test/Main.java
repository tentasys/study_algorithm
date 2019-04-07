package test;


public class Main {

	public static void main(String[] args) {

		System.out.println("Before : " + 1 + " " + 2);
		
		Point p = cal_next_point(1, 2, 0);
		
		System.out.println("After : " + p.x + " " + p.y);
	}

	static Point cal_next_point(int x, int y, int d)
	{
		Point result;
		
		if(d == 0)		//����
			result = new Point(x, y-1);
		else if(d == 1)	//����
			result = new Point(x-1, y);
		else if(d == 2)	//����
			result = new Point(x, y+1);
		else//(d == 3)	����
			result = new Point(x-1, y);
		
		return result;
	}
	
	
}

class Point{
	int x;
	int y;
	Point(){};
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}