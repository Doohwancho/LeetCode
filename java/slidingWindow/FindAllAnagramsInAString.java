package mayChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllAnagramsInAString {
	
	//<Trial01 - time limit exceeded>
	
	//brute-force
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len = p.length();
        char[] c2 = p.toCharArray();
        Arrays.sort(c2);
        
        for(int i = 0; i < s.length()-len+1; i++){
            char[] c1 = s.substring(i, i+len).toCharArray();
                
            Arrays.sort(c1);  
            
            for (int j = 0; j < len; i++) {
            	if(c1[j] != c2[j]) {
            		break;
            	}
            	if(j == len-1) {
            		list.add(i);
            	}
            }
        }
        return list;
    }
    
    //<Trial02>
    
    //�𸣰͵� ���� �ٿ°Ű��� �ѵ�
    
    //sliding window�ϸ� �ɰŰ�����
    
    class Solution {
        // s: "cba e bab acd" p: "abc"
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> rst = new ArrayList<>();
            Queue<Integer> q = new LinkedList();
            
            char[] sChar = s.toCharArray();
            
            int[] alphabet = new int[26];
            for(char c : p.toCharArray()){
                alphabet[c-'a']++;
            }
            
            for(int i = 0, j = 0,lastDigit = 0; i < sChar.length; i++){
                // System.out.println("i: "+sChar[i]);
                
                
                if(i >= p.length()){
                    lastDigit = sChar[i-p.length()]-'a'; 
                    if(set.contains(lastDigit)) alphabet[lastDigit]++; //
                }
                
                if(alphabet[sChar[i]-'a'] > 0){
                    // System.out.println("if");
                    alphabet[sChar[i]-'a']--;
                    j++;
                }
                else {
                    if(sChar[i]-'a' == lastDigit){
                        continue;
                    } else {
                        j = 0;    
                    }
                }
                if(j == p.length()){
                    rst.add(i-p.length()+1);
                    j = p.length()-1;
                }
                for(int pq : alphabet){
                    System.out.print(pq+" ");
                }
                System.out.println();
                System.out.println("rst: "+rst+"  j: "+j);
            }
            
            return rst;
        }
    }
    
    //<����Ǯ��1 by Shevchenko_7>
    
    //�̰͵� brute-force�� �ѵ�, if (copy[c - 'a'] < 0) return false; �̰ɷ� �ٷ� �����༭ pass�ȵ�
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length()) return res;
        int m = s.length();
        int n = p.length();
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i <= m - n; i++) {
            int[] copy = count.clone();
            if (helper(copy, s, i, n)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean helper(int[] copy, String s, int index, int n) {
        for (int i = index; i < index + n; i++) {
            char c = s.charAt(i);
            copy[c - 'a']--;
            if (copy[c - 'a'] < 0) return false;
        }
        return true;
    }
    
    
    //<����Ǯ��2 by star1993>
    
    //sliding window
    
    //�� int[] map�� p�� �����ϴ� ���ĺ� ��� ���س��ٰ�, s loop���鼭 �ϳ��� ���
    
    //�� map�� ��簪�� �� 0�̵Ǹ� �ٽ� refill()�Լ��� �ٽ� �����ĺ�µ�
    
    //�׳� s loop���� sliding window�� p.length()������ŭ �ֵ鸸 ���, check()�Լ��� map�� ����� �������� ���� �Ǵ°ſ��� 
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length())
            return res;
        char[] sStr = s.toCharArray();
        int[]map = new int[26];
        for(char ch:p.toCharArray())
            map[ch - 'a']++;
        int n = s.length(), m = p.length();;
        int j = 0;
        for(j=0; j<m-1; j++)
            map[sStr[j] - 'a']--;
        for(int i=0; j<n; i++, j++){
            map[sStr[j] - 'a']--;
            if(check(map))
                res.add(i);
            map[sStr[i] - 'a']++;
        }
        return res;
    }
    public boolean check(int[]map){
        for(int n:map)
            if(n > 0)   return false;
        return true;
    }
    
}
