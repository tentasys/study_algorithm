완전탐색에 쓰이는 것 : BFS, DFS

플로이드-워셜 알고리즘 : 모든 점의 각 정점까지의 최단경로를 구할 때

다익스트라 알고리즘 : 특정 점에서 각 정점까지의 최단경로

연결 요소(connected component)는 연결이 안 된 정점도 포함! 그림에서 2개

![00](src\00.PNG)



temp 선언 없이 숫자 바꾸기

```java
int a = 2;     // a : 2
int b = 4;     // b : 4

a = a + b;     // a : 6  |  b : 4
b = a - b;     // a : 6  |  b : 2
a = a - b;     // a : 4  |  b : 2
```

```java
int a = 2;    // a : 2 (0010)
int b = 4;    // b : 4 (0100)

a = a ^ b;    // a : 6 (0110)  |  b : 4 (0100)
b = a ^ b;    // a : 6 (0110)  |  b : 2 (0010)
a = a ^ b;    // a : 4 (0100)  |  b : 2 (0010)
```

Java 배열 채우기

```java
Arrays.fill(dist, 0);	//c언어의 memset과 같음
System.arraycopy(temp, 0, dist, 0, dist.length);	//배열 그대로 복사
```

상하좌우 이동하기

```java
static int[] dy = {1,-1, 0, 0};
static int[] dx = {0, 0, 1,-1};
for (int i = 0; i < 4; i++) {
	int nY = p.y + dy[i];
	int nX = p.x + dx[i];
				
	if (nY >= N || nX >= N || nY < 0 || nX < 0)
		continue;
    arr[nY][nX] = temp;
}
```

compareTo 중요!!

꼭 써보자