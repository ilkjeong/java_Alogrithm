import java.util.Scanner;
public class c2_8a_CardConvRev {
	static int cardconvR(int x, int r, char[] d) {
		//정수값 x를 r진수로 변환
		//배열 d에 아랫자리부터 넣어두고 자릿수를 반환
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while(x!=0);
		return digits;
	}
	
	public static void main(String[] args) {
		char[] d = new char[10];
		
		System.out.print(d[0]+d[1]+d[2]+d[3]);
	}
}
