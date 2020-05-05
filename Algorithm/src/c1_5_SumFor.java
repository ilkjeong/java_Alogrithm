import java.util.Scanner;

public class c1_5_SumFor {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 N까지의 합을 구합니다");
		System.out.print("N의 값 : ");
		int n = stdIn.nextInt();
		
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum+=i;
		}
		
		System.out.println("합계는 "+sum+"입니다.");
	}
}
