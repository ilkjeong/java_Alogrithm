import java.util.Scanner;
import java.util.Stack;

public class c6_10_QuickSort2 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//����������� ������~~ ��������.
	static void quickSort(int[] a, int left, int right) {
		Stack<Integer> lstack = new Stack<Integer>();
		Stack<Integer> rstack = new Stack<Integer>();
		
		lstack.push(left);
		rstack.push(right);
		
		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left+right)/2];
			
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if(left < pr) {
				lstack.push(left); //���ʱ׷����
				rstack.push(pr); //�ε��� Ǫ��
			}
			if(pl < right) {
				lstack.push(pl); //�����ʱ׷����
				rstack.push(right); //�ε��� Ǫ��
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("�� ����");
		System.out.print("��ڼ� :");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx ; i++) {
			System.out.print("x["+i+"] :");
			x[i] = stdIn.nextInt();
		}
		
		quickSort(x, 0, nx - 1); //����Ʈ~
		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < nx; i++) 
			System.out.println("x["+i+"]= "+x[i]);
	}
}
