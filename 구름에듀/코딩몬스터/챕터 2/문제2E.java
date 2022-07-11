import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	/**
    * 주어진 숫자가 소수인지 판별하는 함수 
    *
    * @param N 
    * @return true   소수라면 
    * @return false  소수가 아니라면
    */
	
	// 시간 복잡도는 홀수일 경우 최악 O(N)
	// 짝수일 경우는 O(1)
	public static boolean isPrime(int N)
	{
		// 1은 소수가 아님
		// 2는 소수임
		// 2를 제외한 모든 짝수는 소수가 아님
		if(N == 1) return false;
		if(N == 2) return true;
		else if( N % 2 == 0) return false;
		
		int count = 0; // 1 과 N이 약수인 경우는 굳이 세지 않음
		// i =3은 위에서 2일땐 약수라고 조건이 있기떄문에 3부터 시작
		for(int i = 3; i <= Math.sqrt(N); i+=2){ 
			// N의 소수는 1과 N 외의 약수를 갖지 않는 수를 뜻함
			// 1과 N을 제외한 수의 범위 [2, N-1]에서
			// 어떤수 a와 b를 곱해서 N이 나오는 경우 중 
			// a가 가장 큰 값이 될 경우는 a * a = N 인 경우임.
			// 즉, a^2 = N --> a = sqrt(N) 이 될 수 있음
			// 그럼 a의 범위는 1 <= a <= sqrt(N) 이 되고
			// b의 범위는 sqrt(N) <= b <= N이 된다.
			// N의 약수는 항상 a 와 b를 곱한 페어 상태이기 떄문에
			// b의 최대범위까지 구할필요없이 a의 최대범위까지만 구해서
			// a 의 범위에서 1과N을 제외한 단 하나의 약수가 나오는 순간 N은 소수가 아님을 증명.
			
			// i <= [2, sqrt(N)] 사이의 모든 정수 범위
			if(N % i == 0){
				// i == 1 ~ N 사이의 모든 N의 약수 차례로
				count++;
				break;
			}
		}
		
		// 1 과 N은 굳이 세지 않았고 그 후에도 나온 약수가 없다면 해당 N은 소수임.
		return count == 0;
	}

	public static void testCase(int caseIndex)
	{
		int n = scanner.nextInt();
		boolean result = isPrime(n);

		System.out.printf("Case #%d\n", caseIndex);
		if(result)
		{
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}
