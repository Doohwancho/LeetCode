package juneChallenge;

public class IsSubSequence {
	
	//<����Ǯ��1>
	
	//bruteforce�� �ѵ� ���ɵ� ������ �ʰ� �� �Ǳ� �ϳ�
	
	//Runtime: 1 ms
	//Memory Usage: 37.4 MB
	
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        for(int i = 0, j_ = -1; i < s.length(); i++){
            for(int j = j_+1; j < t.length(); j++){
                if(sChar[i] == tChar[j]){
                    if(i == s.length()-1) return true;
                    j_ = j;
                    break;
                }
                if(j == t.length()-1 && i != s.length()-1){
                    return false;
                }
            }
        }
        return false;
    }
    
    
    //<����Ǯ��2 by fhqplzj>
    
    //�̰� �� �� ������
    
    //String.indexOf(char, fromIndex)�ϸ�,
    
    //char�� fromIndex���� ������ �߿� ���Ե������� �ش� char�� �ε����� ��ȯ�ϰ�, ������ -1�� ��ȯ��.
    
    //��� -1�� ��ȯ�ϸ�, �ٷ� false return���ָ� �ǰ�
    
    //������, ���� char�� üũ�Ҷ� Ȯ���ؾ� �ϴ� t�� ������ ������ ���ݾ�
    
    //�״ϱ� fromIndex+1���� �������� ������Ʈ ��Ű��. 
    
    //Runtime: 0 ms
    //Memory Usage: 39.1 MB
    
    public boolean isSubsequence(String s, String t) {
        int fromIndex = 0;
        for (char c : s.toCharArray()) {
            fromIndex = t.indexOf(c, fromIndex);
            if (fromIndex++ < 0) {
                return false;
            }
        }
        return true;
    }
}
