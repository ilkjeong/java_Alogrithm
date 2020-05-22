import java.util.Scanner;
//�����˻�Ʈ�� Ŭ���� BinTree<K,V>�� �̿� ��
public class c10_2_BinTreeTester {
	static Scanner stdIn = new Scanner(System.in);
	
	//������ (ȸ����ȣ+�̸�)
	static class Data {
		public static final int NO = 1;
		public static final int NAME = 2;
		
		private Integer no;
		private String name;
		
		//Ű ��
		Integer keyCode() {
			return no;
		}
		
		//���ڿ��� ��ȯ�մϴ�.
		public String toString() {
			return name;
		}
		
		//�����͸� �Է��մϴ�.
		void scanData(String guide, int sw) {
			System.out.println(guide+"�� �����͸� �Է��ϼ���.");
			
			if((sw & NO) == NO) {
				System.out.print("��ȣ : ");
				no = stdIn.nextInt();
			}
			if((sw & NAME) == NAME) {
				System.out.print("�̸� : ");
				name = stdIn.next();
			}
		}
	}
	
	//�޴� ������
	enum Menu {
		ADD("����"),
		REMOVE("����"),
		SEARCH("�˻�"),
		PRINT("ǥ��"),
		TERMINATE("����");
		
		private final String message; 	//����� ���ڿ�
		static Menu MenuAt(int idx) {//������ idx�� ���Ÿ� ��ȯ
			for (Menu m : Menu.values())
				if(m.ordinal() == idx)
					return m;
			return null;
		}
		
		Menu(String string){//������ 
			message = string;
		}
		
		String getMessage() {
			return message;
		}
	}
	
	//�޴� ����
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s ",m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();
		c10_1_BinTree<Integer, Data> tree = new c10_1_BinTree<Integer, Data>();
		
		do {
			switch (menu = SelectMenu()) {
			case ADD :
				data = new Data();
				data.scanData("����", Data.NO | Data.NAME);
				tree.add(data.keyCode(), data);
				break;
				
			case REMOVE :
				temp.scanData("����", Data.NO);
				tree.remove(temp.keyCode());
				break;
				
			case SEARCH :
				temp.scanData("�˻�", Data.NO);
				ptr = tree.search(temp.keyCode());
				if (ptr != null)
					System.out.println("�� ��ȣ�� �̸��� "+ ptr+"�Դϴ�.");
				else
					System.out.println("�ش� �����Ͱ� �����ϴ�.");
				break;
				
			case PRINT :
				tree.print();
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
}
