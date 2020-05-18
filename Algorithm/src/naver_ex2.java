import java.util.StringTokenizer;

public class naver_ex2 {
	public static int solution(String S) {
        // write your code in Java SE 8
		int len = S.length();
		int cnt = 0;
		int ans = 0;
		char[] c = S.toCharArray();
		for (int i = 1; i < len; i++) {
			if(c[i]==c[i-1]) cnt++;
			if(cnt==3) {
				if(c[i]==c[i+1]) c[i]='z';
				else c[i-1]='z';
				cnt=0;
				ans++;
			}
		}
        return ans;
    }
	
	public static void main(String[] args) {
		String S = "baaaaa";
		int i = solution(S);
		System.out.println(i);
	}

}
