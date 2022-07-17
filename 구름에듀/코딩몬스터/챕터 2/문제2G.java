import java.lang.*;
import java.util.*;


public class 문제2G {
	public static final Scanner scanner = new Scanner(System.in);

	public static void bubbleSort(int[] data, int n)
	{
		for(int i = 0 ; i < n ; i++) {
      //스왑된 횟수 카운트
			int count = 0;
      // j => 0 ~ N - i - 1 까지의 범위까지만 스왑시킴.
      // i 가 커질수록 제일 뒤의 배열은 정렬이 된 상태이기때문에 -i 만큼 점점 범위를 줄임.
			for(int j  = 0; j + 1 < n - i ; j++) {
				if( data[j] > data[j+1]) {
					// 오름차순이 아닌 경우 발생
					// 해당 값의 위치를 서로 바꿔줌(스왑)
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
					count++;
				}
			}
			if(count == 0){
				// data[0] ~ data[n-i-1]의 모든 범위에서 항상 오름차순이었음.
				// data[n-i] ~ data[n-1]까지 이미 정렬된 상태임.
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			data[i] = scanner.nextInt();
		}

		bubbleSort(data, n);

		for(int i = 0 ; i < n ; i++)
		{
			if( i > 0 )
			{
				System.out.print(" ");
			}
			System.out.print(data[i]);
		}
	}

}
