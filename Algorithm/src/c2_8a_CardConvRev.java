import java.util.Scanner;
public class c2_8a_CardConvRev {
	static int cardconvR(int x, int r, char[] d) {
		//������ x�� r������ ��ȯ
		//�迭 d�� �Ʒ��ڸ����� �־�ΰ� �ڸ����� ��ȯ
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
