//�� ���� 1���� ���� ��ġ�ϴ� ����
public class c5_7_QueenB {
	static int[] pos = new int[8];//�� ���� ���� ��ġ
	
	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}
	
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			pos[i] = j;
			if(i==7)
				print();
			else
				set(i+1);
		}
	}
	
	public static void main(String[] args) {
		set(0);
	}
}
//�� 16,777,216���� ���� , �ð��� ���� ���� �ɸ�!!
//������ �� �ִ� ��� �������� 8���� ���� ���� ���Ѵ�.