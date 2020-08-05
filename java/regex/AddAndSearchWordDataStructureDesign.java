package augustChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddAndSearchWordDataStructureDesign {
	
	//<Trial01>
	
	//Input:
	//["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
	//[[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
	//Output: [null,null,null,true,true,true,true,true,true]
	//Expected: [null,null,null,true,true,false,true,false,false]

	//�̰� �� Ʋ��?
	
	//"aa"�� �� false��? addWord("a") �ι������� "aa"�� �Ǿ��ϴ°� �Ƴ�?
	
	//�� .append("a")�� �ι��ϸ�
	
	//�������� �ٴ°� �ƴ϶� ���� �ٸ� ���� ����ض� �̰ǰ�?
	
	class WordDictionary {

	    StringBuilder sb;
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        sb = new StringBuilder();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        sb.append(word);
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        StringBuilder tmp = new StringBuilder();
	        tmp.append(".*(");
	        
	        for(char c : word.toCharArray()){
	            if(c == '.'){
	                tmp.append("[a-z]");
	            } else {
	                tmp.append(c);
	            }
	        }
	        tmp.append(").*");
	        String pattern = tmp.toString();
	            
	        return sb.toString().matches(pattern);
	    }
	}
	
	

	//<Trial02 - Time Limit Exceeded>
	
	//�ϴ� TLE���� �Դ�.
	
	//�ϴ� �ܾ���� ������ �����̽��ٷ� �س�.
	
	//����ǥ���Ŀ��� \s�� �����̽����̳�, �ڹٿ��� \s�ϸ� ������. �׵��� ���ٰ�. \t(��), \n(����)���� �ִµ� �����̽��ٰ� ���� �?
	
	//sb.toString().matches("\s�� �� regex pattern"); �ϸ� ������.
	
	//�׷��� �Ʒ�������� �ٲ�.
	
	//Pattern pattern=Pattern.compile(tmp.toString());
    //Matcher match=pattern.matcher(sb.toString());
    //match.find();
	
	//Pattern.compile();�� \\s�� ������ �� �� �ϸ� ������ �ȳ�. 
	
	//�������� ��������.
	
	//+ : �ּ� 1�� Ȥ�� �� �̻� n��
	
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	
	class WordDictionary {

	    StringBuilder sb;
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        sb = new StringBuilder(" ");
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        sb.append(word);
	        sb.append(" ");
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        StringBuilder tmp = new StringBuilder();
	        
	        tmp.append("[\\s]+(");
	        
	        for(char c : word.toCharArray()){
	        	tmp.append(c);
	        	/*
	            if(c == '.'){
	                tmp.append("[a-z]");
	            } else {
	                tmp.append(c);
	            }
	            */
	        }
	        tmp.append(")[\\s]+");
	        Pattern pattern=Pattern.compile(tmp.toString());
		    Matcher match=pattern.matcher(sb);
	        return match.find();
	    }
	}
					
	//<Trial03 - TLE>
	
	//map�� ���� �ձ��� �������� �־ �ȵǳ�?
	
	//regex�ӵ��� ������ �϶��ǰ�?
	
	//�װ� �Ұ������� �ʳ�?
	
	//regex�� ���� �����ǰ�? 
	
	//�׷� .�� ��� ó���� ����
	
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	class WordDictionary {

	    Map<Character, StringBuilder> map;
	    StringBuilder sb;
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        map = new HashMap<>();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        Character key = word.charAt(0);
	        if(!map.containsKey(key)){
	            map.put(key, new StringBuilder(" "));
	        }
	        map.get(key).append(word+" ");
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        Character key = word.charAt(0);
	        
	        if(map.containsKey(key)){
	            StringBuilder tmp = new StringBuilder();
	            
	            tmp.append("[\\s]+(");

	            for(char c : word.toCharArray()){
	                tmp.append(c);
	            }
	            tmp.append(")[\\s]+");

	            Pattern pattern=Pattern.compile(tmp.toString());
	            Matcher match=pattern.matcher(map.get(key));
	            return match.find();
	            
	        } else if(key == '.'){
	            for( Map.Entry<Character, StringBuilder> ele : map.entrySet() ){
	                StringBuilder tmp = new StringBuilder();
	            
	                tmp.append("[\\s]+(");

	                for(char c : word.toCharArray()){
	                    tmp.append(c);
	                }
	                tmp.append(")[\\s]+");

	                Pattern pattern=Pattern.compile(tmp.toString());
	                Matcher match=pattern.matcher(ele.getValue());
	                if(match.find()) return true;
	            }
	        }
	        return false;
	    }
	}


}
