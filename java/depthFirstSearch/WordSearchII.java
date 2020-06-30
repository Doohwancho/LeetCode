package juneChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
	
	//<Trial01>
	
	//brute-force
	
	//dfs�������� dfs�� ���� ������, visited�� �� iterate���� deepcopy�ؾ� �Ѵٴ� ������ �� ��ȿ�� ���� �� ����.
	
	//�̰� ������ Ǭ �����߿� � �ȶ��̰� �볻 ȿ�����̰� deepcopy�� �ڵ鸵�� ���̽��� �ֱ� �߾��µ� ��������?
	
    //���ʿ� int[26]�� board�� �ִ� ���ĺ� �󵵼� �ھ� ���� ������ String�� �ִ� ���ĺ� �ϳ��ϳ��� �󵵼��� wordcount�� �¾ƶ��������� ������ �ϳ�?
    
    //�װ͵� ���� ��ȿ�����ΰŰ��� �ѵ�;
	
	private boolean[][] deepCopy(boolean[][] original) {
        if (original == null) {
            return null;
        }

        boolean[][] result = new boolean[original.length][original[0].length];
        
        for (int i = 0; i < original.length; i++) {
            for(int j = 0; j < original[0].length; j++){
                result[i][j] = original[i][j];    
            }
        }
        return result;
    }
    
	private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int idx){
        if(idx == word.length()) return false;
        else if(idx == word.length()-1){
            return true;
        }
        
        visited[i][j] = true;    
        boolean flag = false;
        
        if(i < board.length-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i+1, j, idx+1);
        if(j < board[0].length-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i, j+1, idx+1);
        if(i > 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i-1, j, idx+1);
        if(j > 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i, j-1, idx+1);
        
        return flag;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
    	if(board == null) return new ArrayList<>();
    	
        int m = board.length;
        int n = board[0].length;
        
        List<String> rst = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){ 
            char key = words[i].charAt(0);
            if(map.containsKey(key)){
                List<String> tmp = map.get(key);
                tmp.add(words[i]);
                map.put(key, tmp);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(words[i]);
                map.put(key, tmp);    
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map.containsKey(board[i][j])){
                    List<String> list = map.get(board[i][j]);
                    
                    for(int p = 0; p < list.size(); p++){
                        String str = list.remove(0);
                        if(dfs(board, new boolean[m][n], str, i, j, 0)){
                            rst.add(str);
                            list.remove(str);
                        } else {
                            list.add(str);
                        }        
                    }
                }
            }
        }
        return rst;
    }
    
    
    //<Trial02>
    
    //TLE�㶧 input�� �� "aaaaaaaaaaaaaaaaaaaaaaaab"�̵��� �ֱ淡
    
    //�ܾ� �󵵼� üũ ���� �ؼ� �󵵼��� board�� ������ ���ĺ� �󵵼���ŭ �����¾ֵ鸸 validStrings�� ���� ���� �־��µ��� �ȵų�
    
    
	private boolean[][] deepCopy(boolean[][] original) {
        if (original == null) {
            return null;
        }

        boolean[][] result = new boolean[original.length][original[0].length];
        
        for (int i = 0; i < original.length; i++) {
            for(int j = 0; j < original[0].length; j++){
                result[i][j] = original[i][j];    
            }
        }
        return result;
    }
    
	private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int idx){
        if(idx == word.length()) return false;
        else if(idx == word.length()-1){
            return true;
        }
        
        visited[i][j] = true;    
        boolean flag = false;
        
        if(i < board.length-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i+1, j, idx+1);
        if(j < board[0].length-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i, j+1, idx+1);
        if(i > 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i-1, j, idx+1);
        if(j > 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(idx+1)) flag |= dfs(board, deepCopy(visited), word, i, j-1, idx+1);
        
        return flag;
    }
    
    private int[] wordCount(String word){
        int[] a = new int[26];
        for(char c : word.toCharArray()){
            a[c-97]++;
        }
        return a;
    }
    
    private boolean valid(int[] wc, Map<Integer, Integer> alphabet){
        for(int i = 0; i < 26; i++){
            if(wc[i] > 0 && alphabet.getOrDefault(i, 0) < wc[i]){
                return false;
            }
        }
        return true;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
    	if(board == null) return new ArrayList<>();
    	
        int m = board.length;
        int n = board[0].length;
        
        List<String> rst = new ArrayList<>();
        Map<Integer, Integer> alphabet = new HashMap<>();
        
        
        for(int i = 0; i < m; i++){ 
            for(int j = 0; j < n; j++){
                alphabet.put(board[i][j]-97, alphabet.getOrDefault(board[i][j]-97, 0)+1);
            }
        }
        
        Map<Character, List<String>> validStrings = new HashMap<>();
        
        for(String word : words){
            if(valid(wordCount(word), alphabet)){
                if(validStrings.containsKey(word.charAt(0))){
                    List<String> tmp = validStrings.get(word.charAt(0));
                    tmp.add(word);
                    validStrings.put(word.charAt(0), tmp);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(word);
                    validStrings.put(word.charAt(0), tmp);
                }
                
            }
        }
        
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(validStrings.containsKey(board[i][j])){
                    
                    List<String> list = validStrings.get(board[i][j]);
                    
                    for(int p = 0; p < list.size(); p++){
                        String str = list.remove(0);
                        if(dfs(board, new boolean[m][n], str, i, j, 0)){
                            rst.add(str);
                            list.remove(str);
                        } else {
                            list.add(str);
                        }        
                    }
                }
            }
        }
        return rst;
    }
    
    //<����Ǯ��1 by yavinci> 
    
    //�� �̷� �������� �������� ���� hard����
    
    //���� �볻 �߳�����
    
    //"aaaaaaaaaaaaaaaab"�� "aaaaaaaaaaaaaaaac"�� tree�� �������� �ھƹ���. �� �ؿ��� �簥�� b,c�� ������ �ϰ� ���� a�� ������.
    
    //�׸��� p.next[c - 'a'] == null �� a�� ������ �������� b�� b�� �ִ����� Ȯ����. b�� ������ ������ ���ĺ��� �ְ� ����.
    
    //�̰� ������ TLE�� �ȶ�. �Ӹ� �볪 ����
    
    //�׸��� dfs�� Ư���� ������ ���ٰ� üũ����� �Ǵµ�, �׷��� boolean visited = new boolean[board.length][board[0].length]��
    
    //�� iterate���� [i][j]������ ���� �̹� �Դٰ� true�ڰ� ī���ؼ� ��ߵǴµ�,
    
    //shallow copy�ع����� ���ٰ� ������ �ٸ����Ⱕ�� ������ ��ġ�ϱ� deepcopy�ؾ���.
    
    //�ٵ� �� iterate���� deepcopy�� �ع����� �ð� �볻�ɸ� 
    
    //�ٵ� �갡 �� ����� �� iterate���� board�� shallow copy�� �ϴ� �Դ� �� ���� '#'�ڰ� �����¿�dfs������ ������ �ٽ� board[i][j] = c�� ���󺹱� �������ν�
    
    //�߰��� ���ٰ� ������ �ٽ� ���󺹱� ��Ŵ. 
    
    //��������
    
    //Runtime: 8 ms
    //Memory Usage: 48.4 MB
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    

}
