
class Id {
	private static int counter = 0;
	private int id;
	
	//������
	public Id() {
		id = ++counter;
	}
	
	//���̵� ��ȯ�ϴ� �ν��Ͻ� �޼���
	public int getId() {
		return id;
	}
	
	public static int getCounter() { return counter; }
}

public class c3_c1_IdTester {
	public static void main(String[] args) {
		Id a = new Id();
		Id b = new Id();
		
		System.out.println("a�� ���̵� : "+a.getId());
		System.out.println("b�� ���̵� : "+b.getId());
		
		System.out.println("�ο��� ���̵��� ���� : "+Id.getCounter());
	}
}
