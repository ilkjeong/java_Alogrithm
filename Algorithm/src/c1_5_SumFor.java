import java.util.Scanner;

public class c1_5_SumFor {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1���� N������ ���� ���մϴ�");
		System.out.print("N�� �� : ");
		int n = stdIn.nextInt();
		
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum+=i;
		}
		
		System.out.println("�հ�� "+sum+"�Դϴ�.");
	}
}
