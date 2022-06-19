import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	/**
     * 주어진 배열이 오름차순인지 검사하는 함수
     * @param data
     * @param n     데이터의 수
     * @return      data[0] ~ data[n-1]이 오름차순이라면 true, else false
     */
	public static boolean isOrdered(int[] data, int n)
	{
		int cnt = 0; // data의 조건을 통과한 갯수
		
		//단 하나라도 i <= i+1 이 만족하지 않으면 break
		for(int i=0;i+1<n; i+=1){
			if(data[i]<=data[i+1])
			{
				cnt++;
			}
			else break;
		}
		//n-1개가 cnt의 갯수면 이 배열은 오름차순임.
		return cnt == n-1;
	}


	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			data[i] = scanner.nextInt();
		}

		boolean result = isOrdered(data, n);

		if(result)
		{
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}

	}

}
