package september;

public class FindTheDifference {
	
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 2 ms
	//Memory Usage: 37.2 MB
	
    public char findTheDifference(String s, String t) {
        int[] alpha = new int[26];
        int sLen = s.length();
        int tLen = t.length();
        
        for(int i = 0, j = 0; i < sLen || j < tLen; ){
            if(i < sLen){
                alpha[s.charAt(i)-'a']++;
                i++;
            }
            if(j < tLen){
                alpha[t.charAt(j)-'a']++;
                j++;
            }
        }
        
        for(int p = 0; p < 26; p++){
            if(alpha[p] % 2 == 1){
                return (char)('a'+p); 
            }
        }
        return 'a';
    }
    
    //<����Ǯ��2>
    
    //�̸�...����...!
    
    //�ҷ���..hoxy...õ�������� ����?
    
    //Runtime: 1 ms
    //Memory Usage: 39.9 MB
    
    public char findTheDifference(String s, String t) {
    	char xor = 0;
        for(char c : s.toCharArray()) xor ^= c;
        for(char c : t.toCharArray()) xor ^= c;
        return xor;
    }
}
