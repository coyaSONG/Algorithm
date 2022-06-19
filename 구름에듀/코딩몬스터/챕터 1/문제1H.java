import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);


	/**
    * 평균과의 차가 가장 작은 데이터의 번호를 반환하는 함수
    * 여러 가지라면 가장 빠른 번호를 반환한다.
    *
    * @param data 
    * @param n 
    * @return int  가장 평균과 가까운 데이터의 번호 (1번부터 시작)
    */
	public static int findIndex(int[] data, int n)
	{
		int S = 0;
		int x = 0;
		for(int i=0;i<n;i++){
			S += data[i];
		}
		for(int i=0;i<n;i++){
			int di = Math.abs(S - n*data[i]);
			int dx = Math.abs(S - n*data[x]);
			
			if(di < dx){
				x = i;
			}
		}
		
		return x+1;
	}

	public static void main(String[] args)
	{
		int n = scanner.nextInt();
		int[] data = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			data[i] = scanner.nextInt();
		}

		int answer = findIndex(data, n);
		int index = answer - 1;
		System.out.printf("%d %d\n", answer, data[index]);
	}

}
