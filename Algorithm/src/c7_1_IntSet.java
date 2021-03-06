
public class c7_1_IntSet {
	private int max;	//집합의 최대 개수
	private int num;	//집합의 요소 개수
	private int[] set;	//집합 본체
	
	//생성자
	public c7_1_IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; //집합 배열 생성
		}
		catch (OutOfMemoryError e) { //배열 생성 실패
			max = 0;
		}
	}
	
	//집합 최대 갯수
	public int capacity() {
		return max;
	}
	
	//집합의 요소 개수
	public int size() {
		return num;
	}
	
	//집합에서 n을 검색하여 index 반환
	public int indexOf(int n) {
		for(int i=0; i<num; i++)
			if(set[i]==n)
				return i;
		return -1;
	}
	
	//집합에 n이 있는지 없는지 확인
	public boolean contains(int n) {
		return (indexOf(n)!=-1) ? true : false;
	}
	
	//집합에 n추가
	public boolean add(int n) {
		if(num>= max||contains(n)==true) //가득찼거나 이미 n이 존재
			return false;
		else {
			set[num++] = n;
			return true;
		}
	}
	
	//집합에서 n을 삭제
	public boolean remove(int n) {
		int idx;
		
		if(num <= 0|| (idx = indexOf(n))==-1)
			return false;
		else {
			set[idx]=set[--num];
			return true;
		}
	}
	
	//집합 s에 복사
	public void copyTo(c7_1_IntSet s) {
		int n = (s.max<num) ? s.max : num;
		for(int i = 0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	
	//집합 s를 복사
	public void copyFrom(c7_1_IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for(int i = 0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	//집합s와 같은지 확인
	public boolean equalTo(c7_1_IntSet s) {
		if(num != s.num)
			return false;
		
		for(int i = 0; i<num; i++) {
			int j = 0;
			for( ; j<s.num; j++)
				if(set[i]==s.set[j])
					break;
			if(j==s.num)
				return false;
		}
		return true;
	}
	
	//집합 s1과 s2의 합집합 복사
	public void unionOf(c7_1_IntSet s1, c7_1_IntSet s2) {
		copyFrom(s1);
		for(int i = 0; i<s2.num; i++)
			add(s2.set[i]);
	}
	
	//"{a b c}" 형식의 문자열로 표현 바꾸기
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for(int i = 0; i<num; i++)
			temp.append(set[i]+" ");
		temp.append("}");
		return temp.toString();
	}
}
