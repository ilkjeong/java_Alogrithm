
public class naver_ex1 {
	static int solution(int N) {
        int largest = N;
        int shift = 0;
        int temp = N;
        for (int i = 1; i < 30; i++) {
            int index = (temp & 1);
//            System.out.println("i:"+i+", index: "+index);
            temp = ((temp >>> 1) | (index << 29));
//            System.out.println("i:"+i+", index: "+index);
//            System.out.println("i:"+i+", temp: "+temp);
            if (temp > largest) {
                largest = temp;
                shift = i;
            }
        }
        return shift;
    }
	
	public static void main(String[] args) {
		int x = 9736;// 
		int i = solution(x);
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(i);
	}
}
