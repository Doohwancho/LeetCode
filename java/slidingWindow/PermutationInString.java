package mayChallenge;

public class PermutationInString {
	
	//<����Ǯ��1>
	
	//���� ������ ������ ���� �Ȱ�����?
	
	//sliding window
	
	//
	
    private boolean check(int[] alphabet){
        for(int i : alphabet){
            if(i > 0) return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] alphabet = new int[26];
        for(char c : s1.toCharArray()){
            alphabet[c-'a']++;
        }
        
        int i = 0;
        for(i = 0; i < s1.length()-1; i++){
            alphabet[s2.charAt(i)-'a']--;
        }
        
        for(int j = 0; i < s2.length(); i++, j++){
            alphabet[s2.charAt(i)-'a']--;
            if(check(alphabet)) return true;
            alphabet[s2.charAt(j)-'a']++;
        }
        return false;
    }
}
