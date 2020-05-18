//각 열에 1개의 퀸을 배치하는 조합
public class c5_7_QueenB {
	static int[] pos = new int[8];//각 열의 퀸의 위치
	
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
//총 16,777,216개의 조합 , 시간이 아주 오래 걸림!!
//나열할 수 있는 모든 가짓수로 8퀸의 답은 되지 못한다.