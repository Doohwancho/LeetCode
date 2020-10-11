package october;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

	//<Trial01>
	
	//���ĺ� ���� �츮��°� �־��� s�� �ִ��� �츮�鼭 �츮��� ���̾�����
	
	//���� �ȵǰڳ�
	
	//����...����...����!!
	
	//�� ���
	
	//You must make sure your result is the smallest in lexicographical order among all possible results.
	
	//Input: s = "cbacdcbc"
	//Output: "acdb"
	
	//�̰� �� "bacd"�� �Ƴ�?
	
	//�� b�� �ȶ��� �� �ڿ� ���̴°���?
	
	//"bcad","acdb","adcb","adbc" ���߿� ���������� �� �տ��ִ°� "acdb"��� ���̱���
	
    public String removeDuplicateLetters(String s) {
        int[] alphabet = new int[26];
        for(char c : s.toCharArray()){
            alphabet[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(alphabet[i] > 0){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
    
    
    //<Trial02>
    
    //yet
    
    private String helper(StringBuilder sb, int len, StringBuilder s, int idx, StringBuilder accum){
        StringBuilder curr = s.substring(s.indexOf(sb.indexOf(idx))+1);
        if(curr.length == s.length) return null;
        if(len == 0) return accum.toString();
        
        StringBuilder tmp = new StringBuilder(curr);
        
        while(idx < s.length){
            while(tmp.length != curr.length){
                accum.append(sb.indexOf(idx));
                String rst = helper(sb, len-1, tmp, idx+1, accum);
                if(rst != null) return rst;

                accum.deleteCharAt();
                curr = new StringBuilder(tmp);
                tmp = s.substring(tmp.indexOf(sb.indexOf(idx))+1);
            } 
            idx++;
        }
    }
    
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        for(char c :sChar){
            if(sb.indexOf(c) < 0){
                sb.append(c);
            }
        }
        int len = sChar.length;
        
        return helper(sb, len, new StringBuilder(s), 0, new StringBuilder());
    }
    
    
    
    
    public static void main(String[] args) {
//		Set<Character> set = new HashSet<>();
//		set.add('b');
//		Set<Character> set2 = new HashSet<>(set);
//		System.out.println(set);
//		System.out.println(set2);
//		set.remove('b');
//		System.out.println(set);
//		System.out.println(set2);
    	
//    	StringBuilder sb = new StringBuilder();
//    	
//    	sb.append('c');
//    	sb.append('b');
//    	sb.append('a');
//    	
//    	System.out.println(sb.indexOf("z"));
    	
    	String s = "aabbbcc";
    	
    	StringBuilder sb = new StringBuilder(s);
    	
    	System.out.println(sb);
    	
//    	sb.deleteCharAt(sb.indexOf("b"));
//    	System.out.println(sb);
//    	
//    	sb.deleteCharAt(sb.indexOf("b"));
//    	System.out.println(sb);
//    	
//    	sb.deleteCharAt(sb.indexOf("b"));
//    	System.out.println(sb);
    	
//    	System.out.println(sb.substring(sb.indexOf("b")+1));
    	sb.deleteCharAt(index)
	}
}
