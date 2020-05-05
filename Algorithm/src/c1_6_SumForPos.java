import java.util.Scanner;

public class c1_6_SumForPos {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		
		do {
			System.out.print("n의 값 : ");
			n = stdIn.nextInt();
		} while (n<=0);
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum+= i;
		}
		
		System.out.println("합계는 "+sum+"입니다.");
	}
}
