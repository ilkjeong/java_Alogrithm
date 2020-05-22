import java.util.Scanner;

public class c8_3_KMPmatch {
	static int kmpMatch(String txt, String pat) {
		int pt = 1;
		int pp = 0;
		int[] skip = new int[pat.length()+1];
		
		//�ǳʶٱ� ǥ
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt)==pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp==0)
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}
		
//		System.out.println("SKIP�迭");
//		for(int i = 0; i < pat.length()+1 ; i++)
//			System.out.print(skip[i]+ " ");
//		System.out.println();
		
		//�˻� 
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {//��ġ�ϸ� �Ѵ� �����ϴٰ�
				pt++;
				pp++;
			} else if (pp == 0) //Ʋ������ pp�� Ȯ��, ��ġ�� ������ pt�� ���ڸ� �ڷ�
				pt++;
			else
				pp = skip[pp]; //pp�� ���� ������ ��ġ�� �κ� -> �� �ڿ����� �˻��ϱ�
			//System.out.println("pt: "+pt+",pp: "+pp);
		}
		
		if(pp==pat.length())
			return pt - pp;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("�ؽ�Ʈ : ");
		String s1 = stdIn.next();
		
		System.out.print("���� : ");
		String s2 = stdIn.next();
		
		int idx = kmpMatch(s1, s2);
		if(idx == -1)
			System.out.println("�ؽ�Ʈ ������ �����ϴ�.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i+1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx+1) + "��° ���ں��� ��ġ�մϴ�.");
			System.out.println("�ؽ�Ʈ : "+s1);
			System.out.printf(String.format("���� : %%%ds\n", len),s2);
		}
	}
}