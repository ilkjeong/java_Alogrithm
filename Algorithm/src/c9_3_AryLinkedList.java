import java.util.Comparator;
//커서로 연결 리스트 만들기
public class c9_3_AryLinkedList<E> {
	//노드
	class Node<E>{
		private E data;	//데이터
		private int next;	//리스트의 뒤쪽 포인터
		private int dnext;	//free 리스트의 뒤쪽 포인터
		
		//data와 next를 설정
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
	
	//생성자 
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
	
	//다음에 삽입하는 record의 인덱스를 구함 
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
	
	//record idx를 free 리스트에 등록
	private void deleteIndex(int idx) {
		if(deleted == NULL) { //삭제할 리스트가 없음
			deleted = idx;		 // idx를 free리스트의
			n[idx].dnext = NULL; //머리에 등록
		} else {
			int rec = deleted;  // idx를 free리스트의
			deleted = idx;		//머리에 삽입
			n[rec].dnext = rec;
		}
	}
	
	//노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;
		while (ptr != NULL) {
			if(c.compare(obj, n[ptr].data)==0) {
				crnt = ptr;
				return n[ptr].data; //검색 성공
			}
			ptr = n[ptr].next; //다음 노드에 주목
		}
		return null;
	}
	
	//머리에 노드를 삽입
	public void addFirst(E obj) {
		int ptr = head;	//삽입 전의 머리 노드
		int rec = getInsertIndex();
		if (rec != NULL) {
			head = crnt = rec; //인덱스 rec인 record에 삽입
			n[head].set(obj, ptr);
		}
	}
	
	//꼬리에 노드를 삽입
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
	
	//머리 노드를 삭제
	public void removeFirst() {
		if(head != NULL) {
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
		}
	}
	
	//꼬리 노드를 삭제
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL) //노드가 하나만 있으면
				removeFirst(); //머리노드 삭제
			else {
				int ptr = head; //스캔 중인 노드 
				int pre = head; //스캔 중인 노드의 앞쪽 노드 
				
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
	
	//record p를 삭제 
	public void remove(int p) {
		if(head != NULL) {
			if(p==head) //p가 머리 노드면
				removeFirst(); //머리 노드를 삭제
			else {
				int ptr = head;
				
				while(n[ptr].next != p) {
					ptr = n[ptr].next;
					if(ptr == NULL) return; //p가 리스트에 없습니다.
				}
				n[ptr].next = NULL;
				deleteIndex(ptr);
				n[ptr].next = n[p].next;
				crnt = ptr;
			}
		}
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드를 삭제
	public void clear() {
		while (head != NULL)
			removeFirst();
		crnt = NULL;
	}
	
	//선택 노드를 하나 뒤쪽으로 이동 
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false;
		crnt = n[crnt].next;
		return true;
	}
	
	//선택 노드를 출력 
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("선택 노드가 없습니다.");
		else
			System.out.println(n[crnt].data);
	}
	
	//모든 노드를 출력
	public void dump() {
		int ptr = head;
		
		while(ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
}
