package augustChallenge;

public class ValidPalindrome {
	
	//<Trial01>
	
	//� ���ڵ� ������?
	
	//� ".,"������ while�� �������� i�� j�� ������ �Ѿ������ index not found�����߳�?
	
	public static boolean isPalindrome(String s) {
		char[] s_ = s.toCharArray();
		for(int i = 0, j = s_.length-1; i < j; i++, j--) {
			while(!Character.isAlphabetic(s_[i])) i++;
			while(!Character.isAlphabetic(s_[j])) j--;
			if(Character.toLowerCase(s_[i]) != Character.toLowerCase(s_[j])) return false;
		}
		return true;
    }
	
	
	//<����Ǯ��1>
	
	//�̰Űŵ�~
	
	//Runtime: 2 ms
	//Memory Usage: 39.4 MB
	
    public boolean isPalindrome(String s) {
        char[] s_ = s.toCharArray();
        int len = s_.length;
        
		for(int i = 0, j = s_.length-1; i < j; i++, j--) {
			while(i < len-1 && !Character.isLetterOrDigit(s_[i])) i++;
			while(j > 0 && !Character.isLetterOrDigit(s_[j])) j--;
			if(i < j && Character.toLowerCase(s_[i]) != Character.toLowerCase(s_[j])) return false;
		}
		return true;
    }
}
