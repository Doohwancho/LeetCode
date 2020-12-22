package dynamicProgramming;

public class PiRatio {
	
	//Q.8.14
	
	//n~m���� ������ ��ȯ�ϴ� classify()�� ������ȹ�� �˰����� dp()�� ����� ���
	
	//dp()�� 
	
	//���̰� 3�� �κм��� + ������ ������ ���� ������
	//���̰� 4�� �κм��� + ������ ������ ���� ������
	//���̰� 5�� �κм��� + ������ ������ ���� ������
	
	//�� ��, ���� ���� ��
	
	//�Ƶ� ���Ƶ���
	
	
	
//	static String N = "12341234";
//	static String N = "11111222";
	static String N = "12122222";
//	static String N = "22222222";
//	static String N = "12673939";
	
	
	static int[] mem = new int[10002];
	
	public static int classify(int a, int b) {
		String M = N.substring(a, b);
		
		StringBuilder sb = new StringBuilder();
		boolean levelOne = true;
		boolean levelTwo = true;
		boolean levelFour = true;
		boolean levelFive = true;
		
		Integer stairs = null;
		Character prevPrev = null;
		Integer diff = null;
		
		for(char m: M.toCharArray()) {
			if(sb.length() > 0) {
				char last = sb.charAt(sb.length()-1);
				if(levelOne && m != last) {
					levelOne = false;
				}
				if(levelTwo && stairs != null && m-last != stairs) {
					levelTwo = false;
				}
				if(levelFour && prevPrev != null && m != prevPrev) {
					levelFour = false;
				}
				if(levelFive && diff != null && (m-last) != diff) {
					levelFive = false;
				}
				stairs = m-last;
				prevPrev = last;
				diff = m - last;
			}
			sb.append(m);
		}
		if(levelOne) return 1;
		else if(levelTwo) return 2;
		else if(levelFour) return 4;
		else if(levelFive) return 5;
		else return 10;
	}
	
	public static int dp(int begin) {
		if(begin == N.length()) return 0;
		if(mem[begin] != -1) return mem[begin];
		mem[begin] = 987654321;
		
		for(int l = 3; l <= 5; ++l) {
			if(begin+l <= N.length()) {
				mem[begin] = Math.min(mem[begin], classify(begin, begin+l) + dp(begin+l));				
			}
		}
		return mem[begin];
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < mem.length; i++) {
			mem[i] = -1;
		}
		
		System.out.println(dp(0));
	}
}
