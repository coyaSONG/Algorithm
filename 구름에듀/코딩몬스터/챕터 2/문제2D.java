class StringUtil {
	
	public static int compare(char[] s1, char[] s2){
		/* 두 문자열 s1, s2를 비교하여 일치하면 0, 
		s1이 사전순으로 앞서면 음수
		s2가 사전순으로 앞서면 양수를 반환하는 함수
		*/
		
		// 1. 서로 다른 문자가 등장하는 위치가 존재 하는 경우
		int n = Math.min(s1.length, s2.length);
		
		for(int i = 0; i < n; i++){
			if(s1[i] != s2[i]){
				return (int)s1[i] - s2[i];
			}
		}
			
		
		// 2. 서로 다른 문자가 등장하지 않은 경우 ( 길이가 같은 경우와 다른 경우 존재 )
		// a. 둘의 길이가 같은가? -> 전체 문자 일치하는가? -> 문자열 동일
		
		return s1.length - s2.length;
	}
	
	public static boolean equals(char[] s1, char[] s2){
		/* 두 문자열 s1, s2가 일치하면 true
		 일치하지 않으면 false를 반환하는 함수
		*/
		
		// hash는 같은 데이터면 값은 값을 가짐
		// 해시를 통한 가지치기
		
		if(s1.length != s2.length){
			return false;
		}
		
		for(int i=0; i<s1.length;i++){
			if(s1[i] != s2[i]){
				return false;
			}
		}
		return true;
	}
}

public class Main {

	public static void main(String[] args) {
		// 이 공간에서는 자유롭게 테스트 및 출력을 해도 됩니다 
		char[] s1 = "algorithm".toCharArray();
		char[] s2 = "allergy".toCharArray();
		
		System.out.printf("compare() Result : %d\n", StringUtil.compare(s1,s2) );
		System.out.printf("equals() Result : %b\n", StringUtil.equals(s1,s2) );
	}
}
