
public class c2_10_PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0;
		int ptr = 0; //ã�� �Ҽ��� ����
		int[] prime = new int[500];
		
		prime[ptr++] = 2;
		
		for(int n = 3; n <=1000; n+= 2) {//Ȧ���� ����̶� 2��������Ŵ
			int i ;
			for(i = 1; i< ptr; i++) {
				counter++; //������ Ƚ��
				if(n % prime[i] == 0)
					break;
			}
			if(ptr==i)//�Ҽ� ã�� . ���������� ������ �������� ���� 
				prime[ptr++] = n; //�Ҽ���� �迭�� ����
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("�������� ������ Ƚ�� : "+counter);
	}
}
