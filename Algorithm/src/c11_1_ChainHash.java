
public class c11_1_ChainHash<K,V> {
	//해시를 구성하는 노드
	class Node<K,V> {
		private K key;
		private V data;
		private Node<K,V> next;
		
		//생성자
		Node(K key, V data, Node<K,V> next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		//키 값을 반환합니다.
		K getKey() {
			return key;
		}
		
		//데이터를 반환합니다.
		V getValue() {
			return data;
		}
		
		//키의 해시 값 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;
	private Node<K,V>[] table; //해시 테이블
	
	//생성자
	public c11_1_ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해시값 구하기
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//키 값 key를 갖는 요소의 검색 (데이터의 반환)
	public V search(K key) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while (p != null) {
			if (p.getKey().equals(key))
				return p.getValue();
			p = p.next;
		}
		return null; //검색 실패
	}
	
	//키 값 key, 데이터 data를 갖는 요소의 추가
	public int add(K key, V data) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while (p != null) {
			if (p.getKey().equals(key))
				return 1;
			p = p.next;
		}
		Node<K,V> temp = new Node<K,V>(key,data,table[hash]);
		table[hash] = temp;
		return 0;
	}
	
	//키 값 key를 갖는 요소의 삭제
	public int remove(K key) {
		int hash = hashValue(key);	//삭제할 데이터의 해시 값
		Node<K,V> p = table[hash];	//선택 노드
		Node<K,V> pp = null;		//바로 앞의 선택 노드
		
		while (p != null) {
			if (p.getKey().equals(key)) {
				if (pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;
		}
		return 1;
	}
	
	//해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i<size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d ",i);
			while (p!=null) {
				System.out.printf("-> %s (%s) ",p.getKey(),p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}
