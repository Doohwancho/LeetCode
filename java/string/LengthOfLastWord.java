package september;

public class LengthOfLastWord {
	
	//<����Ǯ��1>
	
	//trim�� �糡�ܿ� ���ʿ��� ���� �����ִ� ��
	
	//"a " �̷��� ������ ��� ���
	
	//Runtime: 1 ms
	//Memory Usage: 39.5 MB
	
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
