import java.util.Comparator;
public class c9_1_LinkedList<E> {
	//노드
	class Node<E>{
		private E data; //데이터
		private Node<E> next; //뒤쪽 포인터
		
		//생성자
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; //머리노드
	private Node<E> crnt;//선택노드
	
	//생성자
	public c9_1_LinkedList() {
		head=crnt=null;
	}
	
	//노드검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; //현재 스캔중인 노드
		
		while(ptr != null) {
			if(c.compare(obj, ptr.data)==0) {//검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	public void addFirst(E obj) {
		Node<E> ptr = head; //삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);
	}
	
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		if(head==null)
			addFirst(obj); //리스트가 비어있으면 머리에 삽입
		else {
			Node<E> ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj,null);
		}
	}
	
	//머리노드 삭제
	public void removeFirst() {
		if(head != null)
			head = crnt = head.next;
	}
	
	//꼬리노드 삭제
	public void removeLast() {
		if(head != null) {
			if(head.next==null) //노드가 하나만 있으면 머리노드 삭제
				removeFirst();
			else {
				Node<E> ptr = head; //스캔중인 노드
				Node<E> pre = head; //스캔중인 노드 앞 노드
				
				while (ptr.next != null) {
					pre=ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				crnt = pre;
			}
		}
	}
	
	//노드 p 삭제
	public void remove(Node p) {
		if(head != null) {
			if (p==head)
				removeFirst(); //p가 머리노드면 머리노드 삭제
			else {
				Node<E> ptr = head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) return;
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든노드 삭제
	public void clear() {
		while(head != null)
			removeFirst();
		crnt = null;
	}
	
	//선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(crnt == null || crnt.next ==null)
			return false;
		crnt = crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	//모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}
