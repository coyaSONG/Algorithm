import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int n = scanner.nextInt();
		Point2D[] points = new Point2D[n];

		for(int i = 0 ; i < n ; i++)
		{
			int x=  scanner.nextInt();
			int y=  scanner.nextInt();
			points[i] = new Point2D(x, y);
		}

		// points => N개의 좌표 배열
		int minDist = Integer.MAX_VALUE; // 좌표중 가장 짧았던 거리
		int minCount = 0; // 좌표들 중에서 minDist에 담긴 가장 짧은 거리인 좌표 갯수
		
		for(int i = 0; i < n ; i++){
			for(int j = 0 ; j < i; j++){
				// 좌표 (i,j)는 i는 0~n-1이고 j<i인 모든 좌표
				// j < i 인 이유
				// 1. 좌표값이 자기 자신인 값 제외
				// 2. 좌표가 (i,j)일때나 (j,i) 인 경우는 제외
				int sqd = points[i].getSquaredDistanceTo(points[j]);
				if(sqd<minDist){
					// 최소거리가 갱신 된 경우는 카운트 1개로 초기화
					minDist = sqd;
					minCount = 1;
				}else if(sqd == minDist){
					//최소거리가 갱신되진 않았지만 최소거리를 가진 좌표 발견한 경우
					minCount++;
				}
			}
		}
		
		System.out.printf("%.1f\n", Math.sqrt(minDist));
		System.out.printf("%d",minCount);
		
	}
}

class Point2D{
	int x;
	int y;
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * 2차원 평면 상에서 점 this부터 점 target까지 거리의 제곱을 계산하는 함수
	 * @param target
	 * @return
	 */
	
	// 좌표값은 정수만 들어오기 때문에 정수끼리의 + - * 연산은 정수 결과만 나옴
	// 정수로만 계산하여 비교가 가능할땐 정수로만 연산하는것이 좋음.
	public int getSquaredDistanceTo(Point2D target)
	{
		int deltaX = this.x - target.x;
		int deltaY = this.y - target.y;
		return deltaX*deltaX + deltaY*deltaY;
	}

	// 굳이 정확한 거리값이 필요할땐 정수함수값에 제곱근만 해주면 됨.
	public double getDistanceTo(Point2D target)
	{
		return Math.sqrt(this.getSquaredDistanceTo(target));
	}

}
