import java.util.Scanner;

public class c8_3_KMPmatch {
	static int kmpMatch(String txt, String pat) {
		int pt = 1;
		int pp = 0;
		int[] skip = new int[pat.length()+1];
		
		//건너뛰기 표
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt)==pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp==0)
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}
		
//		System.out.println("SKIP배열");
//		for(int i = 0; i < pat.length()+1 ; i++)
//			System.out.print(skip[i]+ " ");
//		System.out.println();
		
		//검색 
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {//일치하면 둘다 증가하다가
				pt++;
				pp++;
			} else if (pp == 0) //틀려지면 pp를 확인, 겹치지 않으면 pt만 한자리 뒤로
				pt++;
			else
				pp = skip[pp]; //pp에 값이 있으면 겹치는 부분 -> 이 뒤에부터 검사하기
			//System.out.println("pt: "+pt+",pp: "+pp);
		}
		
		if(pp==pat.length())
			return pt - pp;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = stdIn.next();
		
		System.out.print("패턴 : ");
		String s2 = stdIn.next();
		
		int idx = kmpMatch(s1, s2);
		if(idx == -1)
			System.out.println("텍스트 패턴이 없습니다.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i+1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx+1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : "+s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len),s2);
		}
	}
}
