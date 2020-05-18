import java.util.ArrayList;

public class naver_ex3 {
	public static int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
		int ans=0;
		//ABCD , ABDC , ACBD, ACDB ADBC ADCB
		if (10*A+B<24) {
			if(10*C+D<60) ans++;
			if(10*D+C<60) ans++;
		}
		if (10*A+C<24) {
			if(10*B+D<60) ans++;
			if(10*D+B<60) ans++;
		}
		if (10*A+D<24) {
			if(10*C+B<60) ans++;
			if(10*B+C<60) ans++;
		}
		//BACD BADC BCAD BCDA BDCA BDAC
		if (10*B+A<24) {
			if(10*C+D<60) ans++;
			if(10*D+C<60) ans++;
		}
		if (10*B+C<24) {
			if(10*A+D<60) ans++;
			if(10*D+A<60) ans++;
		}
		if (10*B+D<24) {
			if(10*C+A<60) ans++;
			if(10*A+C<60) ans++;
		}
		//C
		if (10*C+A<24) {
			if(10*B+D<60) ans++;
			if(10*D+B<60) ans++;
		}
		if (10*C+B<24) {
			if(10*A+D<60) ans++;
			if(10*D+A<60) ans++;
		}
		if (10*C+D<24) {
			if(10*B+A<60) ans++;
			if(10*A+B<60) ans++;
		}
		//D
		if (10*D+A<24) {
			if(10*B+C<60) ans++;
			if(10*C+B<60) ans++;
		}
		if (10*D+B<24) {
			if(10*C+A<60) ans++;
			if(10*A+C<60) ans++;
		}
		if (10*D+C<24) {
			if(10*B+A<60) ans++;
			if(10*A+B<60) ans++;
		}
		
		int cnt = 0;
		
		int[] arr = new int[4];
		arr[0] = A;
		arr[1] = B;
		arr[2] = C;
		arr[3] = D;
		System.out.println(ans);
		for (int i = 0; i < 3; i++) {
			cnt=1;
			for (int j = i+1; j < 4; j++) {
				if(arr[i]==arr[j]) cnt++;
			}
			System.out.println("I: "+i+",cnt="+cnt);
			if(cnt==3) cnt=6;
			if(cnt==4) cnt=12;
			ans/=cnt;
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int i = solution(2,3,3,2);
		System.out.println(i);
	}
}
