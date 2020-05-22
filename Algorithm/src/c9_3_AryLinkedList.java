import java.util.Comparator;
//Ŀ���� ���� ����Ʈ �����
public class c9_3_AryLinkedList<E> {
	//���
	class Node<E>{
		private E data;	//������
		private int next;	//����Ʈ�� ���� ������
		private int dnext;	//free ����Ʈ�� ���� ������
		
		//data�� next�� ����
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E>[] n;
	private int size;
	private int max;
	private int head;
	private int crnt;
	private int deleted;
	private static final int NULL = -1;
	
	//������ 
	public c9_3_AryLinkedList(int capacity) {
		head = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++)
				n[i] = new Node<E>();
			size = capacity;
		}
		catch (OutOfMemoryError e) {
			size = 0;
		}
	}
	
	//������ �����ϴ� record�� �ε����� ���� 
	private int getInsertIndex() {
		if (deleted == NULL) {
			if (max<size)
				return ++max;
			else
				return NULL;
		} else {
			int rec = deleted;
			deleted = n[rec].dnext;
			return rec;
		}
	}
	
	//record idx�� free ����Ʈ�� ���
	private void deleteIndex(int idx) {
		if(deleted == NULL) { //������ ����Ʈ�� ����
			deleted = idx;		 // idx�� free����Ʈ��
			n[idx].dnext = NULL; //�Ӹ��� ���
		} else {
			int rec = deleted;  // idx�� free����Ʈ��
			deleted = idx;		//�Ӹ��� ����
			n[rec].dnext = rec;
		}
	}
	
	//��带 �˻�
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;
		while (ptr != NULL) {
			if(c.compare(obj, n[ptr].data)==0) {
				crnt = ptr;
				return n[ptr].data; //�˻� ����
			}
			ptr = n[ptr].next; //���� ��忡 �ָ�
		}
		return null;
	}
	
	//�Ӹ��� ��带 ����
	public void addFirst(E obj) {
		int ptr = head;	//���� ���� �Ӹ� ���
		int rec = getInsertIndex();
		if (rec != NULL) {
			head = crnt = rec; //�ε��� rec�� record�� ����
			n[head].set(obj, ptr);
		}
	}
	
	//������ ��带 ����
	public void addLast(E obj) {
		if(head == NULL)
			addFirst(obj);
		else {
			int ptr = head;
			while (n[ptr].next != NULL)
				ptr = n[ptr].next;
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[ptr].next = crnt = rec;
				n[rec].set(obj, NULL);
			}
		}
	}
	
	//�Ӹ� ��带 ����
	public void removeFirst() {
		if(head != NULL) {
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
		}
	}
	
	//���� ��带 ����
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL) //��尡 �ϳ��� ������
				removeFirst(); //�Ӹ���� ����
			else {
				int ptr = head; //��ĵ ���� ��� 
				int pre = head; //��ĵ ���� ����� ���� ��� 
				
				while(n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL;
				deleteIndex(pre);
				crnt = pre;
			}
		}
	}
	
	//record p�� ���� 
	public void remove(int p) {
		if(head != NULL) {
			if(p==head) //p�� �Ӹ� ����
				removeFirst(); //�Ӹ� ��带 ����
			else {
				int ptr = head;
				
				while(n[ptr].next != p) {
					ptr = n[ptr].next;
					if(ptr == NULL) return; //p�� ����Ʈ�� �����ϴ�.
				}
				n[ptr].next = NULL;
				deleteIndex(ptr);
				n[ptr].next = n[p].next;
				crnt = ptr;
			}
		}
	}
	
	//���� ��带 ����
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//��� ��带 ����
	public void clear() {
		while (head != NULL)
			removeFirst();
		crnt = NULL;
	}
	
	//���� ��带 �ϳ� �������� �̵� 
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false;
		crnt = n[crnt].next;
		return true;
	}
	
	//���� ��带 ��� 
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("���� ��尡 �����ϴ�.");
		else
			System.out.println(n[crnt].data);
	}
	
	//��� ��带 ���
	public void dump() {
		int ptr = head;
		
		while(ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
}
