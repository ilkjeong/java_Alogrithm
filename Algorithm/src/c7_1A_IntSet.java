
public class c7_1A_IntSet {
	private int max;	//집합의 최대 개수
	private int num;	//집합의 요소 개수
	private int[] set;	//집합 본체
	
	//생성자
	public c7_1A_IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; //집합 배열 생성
		}
		catch (OutOfMemoryError e) { //배열 생성 실패
			max = 0;
		}
	}
	
	//집합 최대 개수
	public int capacity() {
		return max;
	}
	
	//집합의 요소 개수
	public int size() {
		return num;
	}
}
