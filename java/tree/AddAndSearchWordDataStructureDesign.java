package augustChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddAndSearchWordDataStructureDesign {
	
	/*
	//<Trial01>
	
	//Input:
//	["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
//	[[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
	//Output: [null,null,null,true,true,true,true,true,true]
	//Expected: [null,null,null,true,true,false,true,false,false]

	//�̰� �� Ʋ��?
	
	//"aa"�� �� false��? addWord("a") �ι������� "aa"�� �Ǿ��ϴ°� �Ƴ�?
	
	//�� .append("a")�� �ι��ϸ�
	
	//�������� �ٴ°� �ƴ϶� ���� �ٸ� ���� ����ض� �̰ǰ�?
	
	class WordDictionary {

	    StringBuilder sb;
	    
	    public WordDictionary() {
	        sb = new StringBuilder();
	    }
	    
	    public void addWord(String word) {
	        sb.append(word);
	    }
	    
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
	    
	    public WordDictionary() {
	        sb = new StringBuilder(" ");
	    }
	    
	    public void addWord(String word) {
	        sb.append(word);
	        sb.append(" ");
	    }
	    
	    public boolean search(String word) {
	        StringBuilder tmp = new StringBuilder();
	        
	        tmp.append("[\\s]+(");
	        
	        for(char c : word.toCharArray()){
	        	tmp.append(c);
	        	
//	            if(c == '.'){
//	                tmp.append("[a-z]");
//	            } else {
//	                tmp.append(c);
//	            }
	            
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
	    
	    public WordDictionary() {
	        map = new HashMap<>();
	    }
	    
	    public void addWord(String word) {
	        Character key = word.charAt(0);
	        if(!map.containsKey(key)){
	            map.put(key, new StringBuilder(" "));
	        }
	        map.get(key).append(word+" ");
	    }
	    
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
                StringBuilder tmp = new StringBuilder();
                tmp.append("[\\s]+(");
                for(char c : word.toCharArray()){
                    tmp.append(c);
                }
                tmp.append(")[\\s]+");
                Pattern pattern=Pattern.compile(tmp.toString());
                
	            for( Map.Entry<Character, StringBuilder> ele : map.entrySet() ){
	                Matcher match=pattern.matcher(ele.getValue());
	                if(match.find()) return true;
	            }
	        }
	        return false;
	    }
	}
	*/


	//<����Ǯ��1 by LHearen>
	
	//tree
	
	//Runtime: 65 ms
	//Memory Usage: 77.9 MB
	class WordDictionary {
	    
	    static class Trie{
	        Trie[] alphabet = new Trie[26];
	        boolean isWord = false;
	    }
	    
	    Trie tr;
	
	    public WordDictionary() {
	        tr = new Trie();
	    }
	    
	    public void addWord(String word) {
	        Trie root = tr;
	        for(char c : word.toCharArray()){
	            int key = c-'a';
	            if(root.alphabet[key] == null){
	                root.alphabet[key] = new Trie();
	            }
	            root = root.alphabet[key];
	        }
	        root.isWord = true;
	    }
	
	    public boolean search(String word) {
	        return wordSearch(word, tr, 0);
	    }
	    
	    public boolean wordSearch(String word, Trie root, int i){
	        if(root == null) return false;
	        if(i == word.length()) return root.isWord;
	        int key = word.charAt(i)-'a';
	        if(key == -51){
	            for(int j = 0; j < 26; j++){
	                if(wordSearch(word, root.alphabet[j], i+1)){
	                    return true;
	                };
	            }
	            return false;
	        }
	        return root.alphabet[key] != null && wordSearch(word, root.alphabet[key], i+1);
	    }
	}
	
	
	//<����Ǯ��2 by ElementNotFoundException>
	
	//�� �굵 Hashmap��µ� �볻 â�����̰� key�� word.length()�� �س�����
	
	//TLE�㶧 input�� ��
	
	//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	
	//�̵����� �����ŵ�.
	
	//����Ǯ��1�� �����ϱ� �ѵ� 2�� ��Ʈ�ֳ�
	
	//Runtime: 36 ms
	//Memory Usage: 50.6 MB
	
	public class WordDictionary {
		private HashMap<Integer, HashSet<String>> map = new HashMap<>();

		public void addWord(String word) {
		    int L = word.length();
		    if(map.containsKey(L)) {
		        map.get(L).add(word);
		    }
		    else {
		        HashSet<String> set = new HashSet<>();
		        set.add(word);
		        map.put(L, set);
		    }
		}

		public boolean search(String word) {
		    int L = word.length();
		    if(!map.containsKey(L)) return false;
		    HashSet<String> set = map.get(L);
		    for(String str : set) {
		        int i = 0, LL = word.length();
		        while(i<LL) {
		            if(word.charAt(i)!='.' && str.charAt(i)!=word.charAt(i)) break; //.�̸� �� �ǳʶ�
		            ++i;
		        }
		        if(i==LL && (word.charAt(i-1)=='.' || str.charAt(i-1)==word.charAt(i-1))) return true;
		    }
		    return false;
		}
		}
}
