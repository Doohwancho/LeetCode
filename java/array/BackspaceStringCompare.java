package thirtyDayChallenge;

public class BackspaceStringCompare {
	
	//<����Ǯ��1>
	
	//104 / 104 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 37.5 MB
    private static String filter(String str) {
		StringBuilder sb = new StringBuilder(); //stringbuilder�� ���ĺ� �ϳ��ϳ��� �������� .append()�� ����!
		
        for(int i = 0; i < str.length(); i++) {
        	if(str.charAt(i)-97 >= 0) { //'a'-97�� 0�̰� 'z'-97�� 26�ΰ�? 25�ΰ� �׷��Ű� '#'-97�� ���̳ʽ����̱� ����. ������ .alpha()������ �ߴµ�, String type(wrapper class)�� char type(primitive type)���� �ٲٴ�, .alpha()�Լ��� ������ �ȵǼ� �̷��� ��.
        		sb.append(str.charAt(i)); //���ĺ��̸� stringbuilder�� ���̰�
        	} else {
        		if(sb.length() > 0) sb.deleteCharAt(sb.length()-1); //���ĺ��� �ƴϸ�(=='#'�̸� stringbuilder���� �ϳ� ��. �ٵ� stringbuilder�� ���µ� �ϳ���� array out of bound �����ߴϱ�, stringbuilder�� �������� ��.
        	}
        }
        return sb.toString(); //stringbuilder�� String type���� ����ȯ �ϴ°� ���� ����
	}
	
    public boolean backspaceCompare(String S, String T) {
    	return filter(S).equals(filter(T)); //��¥�� S�� T�� ���� ������ loop�����°ǵ� �޼ҵ� �ϳ��� �� ġ��. �׸��� ==���� .equals()�� ����� ==�� ��ü�� �ּҸ� ���ϴµ� .equals()�� ������ ���ϱ� ����.
    }
}
