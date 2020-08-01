package julyChallenge;

public class DetectCapital {
	
	//<����Ǯ��1>
	
	//�� �ٵ� ���� �������� �ʾ�.

	//���� ������.
	
	//true: ABC, Abc, abc
	//false: aBc, abC
	
	//filter1) aBc
	//filter2) abC
	
	//Runtime: 2 ms
	//Memory Usage: 39.7 MB
	
    public boolean detectCapitalUse(String word) {
        char[] w = word.toCharArray();  
        
        //filter1
        if(w.length > 1 && Character.isLowerCase(w[0]) && Character.isUpperCase(w[1])){
            return false;
        }
        //filter2
        for(int i = 2; i < w.length; i++){
            if(Character.isUpperCase(w[i]) != Character.isUpperCase(w[i-1])){
                return false;
            }
        }
        return true;
    }
    
    //<����Ǯ��2 by lixx2100>
    
    //�̰���
    
    //[A-Z]+ : �빮�� �ּ� �Ѱ� �̻��� �ܾ�
    // | : or
    //[a-z]+ : �ҹ��� �ּ� �Ѱ� �̻��� �ܾ�
    //[A-Z][a-z]* : �빮�ڷ� �����ϰ� �� ���� �ҹ��ڰ� 0��~n�� �پ��ִ� �ܾ�.
    
    //Runtime: 9 ms
    //Memory Usage: 39.7 MB
    
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]*");
    }
    
    //<����Ǯ��3 by compton_scatter>
    
    //�� �̰͵� �����ϳ�
    
    //Runtime: 4 ms
    //Memory Usage: 39.2 MB
    
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) || word.equals(word.toLowerCase()) || Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
    }
    
    
    //<����Ǯ��4 by compton_scatter>
    
    //�̰� ���� �� ����. ��Ʈ�� �ְ�.
    
    //Runtime: 1 ms
    //Memory Usage: 37.9 MB
    
    public boolean detectCapitalUse(String word) {
        int a = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)) a++;
        }
        if(a == 1) return Character.isUpperCase(word.charAt(0));
        return a == 0 || a == word.length();
    }
    
}
