package augustChallenge;

public class StreamOfCharacters {
	
	
	//<Trial01>
	
	//�ִ°� �� ������ ������,
	
	//ã������ �Žñ����
	
	//�ٷ� ������ ���� ĳ���ͷ� �ϸ� �Žñ� �� �� �˾Ҵµ� �Žñ� ��
	
	//�Ƶ� �Žñ� ���
	
	class StreamChecker {
	    
	    class Trie{
	        Trie[] children = new Trie[26];
	        boolean end = false;
	    }

	    Trie root;
	    Trie prev;
	    Character prevC;
	    
	    public StreamChecker(String[] words) {
	        root = new Trie();
	        
	        for(String word : words){
	            Trie tmp = root;
	            for(int i = 0; i < word.length(); i++){
	                char c = word.charAt(i);
	                if(tmp.children[c-'a'] == null){ //�̰� ���ϸ� ������ ����� ������ ������ �̾������ ���ư�����
	                    tmp.children[c-'a'] = new Trie();    
	                }
	                tmp = tmp.children[word.charAt(i)-'a'];
	            }
	            tmp.end = true;
	        }
	    }
	    
	    public boolean query(char letter) {
	        if(prev == null){
	            prev = root;
	            if(prev.children[letter-'a'] != null){
	                prev = prev.children[letter-'a'];
	                prevC = letter;
	                return prev.end;
	            } else {
	                return false;
	            }
	        } else {
	            if(prev.children[letter-'a'] != null){
	                prev = prev.children[letter-'a'];
	                prevC = letter;
	                return prev.end;
	            } else {
	                if(prevC == letter){
	                    return root.children[letter-'a'] != null && root.children[letter-'a'].end;
	                } else {
	                    prev = null;    
	                    return root.children[letter-'a'] != null && root.children[letter-'a'].end;
	                }
	            }
	        }
	    }
	}
	
	
	//<����Ǯ��1 by Self_learner>
	
	//�� �ܾ ��ٷ� ����
	
	//stringbuilder�� ������� ���̰�
	
	//�� �ڿ��� ���� ���鼭 query()�� �Ķ���ͷ� �� ĳ���Ͱ� ���������� ���� ��
	
	//���� ��ٷ� �ȳְ� ������� �־�����, abcde�ؼ� e �ȵǸ� de����, �� �ȵǸ� cde����, �� �ȵǸ� bcde���� 
	
	//�̰� root���� ��� ������ �Ǽ� n^2���� �� ��ȿ����
	
	//Runtime: 202 ms
	//Memory Usage: 138.6 MB
	
	
	class StreamChecker {
	    
	    class TrieNode {
	        boolean isWord;
	        TrieNode[] next = new TrieNode[26];
	    }

	    TrieNode root = new TrieNode();
	    StringBuilder sb = new StringBuilder();

	    public StreamChecker(String[] words) {
	        createTrie(words);
	    }

	    public boolean query(char letter) {
	        sb.append(letter);
	        TrieNode node = root;
	        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
	            char c = sb.charAt(i);
	            node = node.next[c - 'a'];
	            if (node != null && node.isWord) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private void createTrie(String[] words) {
	        for (String s : words) {
	            TrieNode node = root;
	            int len = s.length();
	            for (int i = len - 1; i >= 0; i--) {
	                char c = s.charAt(i);
	                if (node.next[c - 'a'] == null) {
	                    node.next[c - 'a'] = new TrieNode();
	                }
	                node = node.next[c - 'a'];
	            }
	            node.isWord = true;
	        }
	    }
	}
}
