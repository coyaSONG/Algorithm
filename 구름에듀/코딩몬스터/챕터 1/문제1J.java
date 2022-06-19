import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * 1부터 M까지의 자연수의 합을 계산하는 함수
	 * @param M
	 * @return
	 */


	/**
	 * N에 대한 정답을 계산하는 함수
	 * @param N
	 * @return
	 */
	public static long getAnswer(int N)
	{
		int S = 0;
		for(int i=1;i<=N;i++){
			S += (i*(i+1))/2;
		}
		return S;
	}


	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		long answer = getAnswer(n);
		System.out.println(answer);
	}

}
