
public class c7_1A_IntSet {
	private int max;	//������ �ִ� ����
	private int num;	//������ ��� ����
	private int[] set;	//���� ��ü
	
	//������
	public c7_1A_IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; //���� �迭 ����
		}
		catch (OutOfMemoryError e) { //�迭 ���� ����
			max = 0;
		}
	}
	
	//���� �ִ� ����
	public int capacity() {
		return max;
	}
	
	//������ ��� ����
	public int size() {
		return num;
	}
}
