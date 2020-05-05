package mayChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FirstUniqueCharacterInAString {
	
	//<����Ǯ��1 by ZachC>
	
	//���� ������ ���.
	
	//loop �ι��� ���� ���ݾ�. �ٵ� �츰 �����ʹϱ� �ٸ� ����� ã��.
	
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
	
	
	//<����Ǯ��2>
	
	//104 / 104 test cases passed.
	//Status: Accepted
	//Runtime: 13 ms
	//Memory Usage: 39.8 MB
	
    public int firstUniqChar(String s) {
		char[] s_ = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(!set.contains(s_[i]) && sb.indexOf(s_[i]+"", i+1) < 0) { //ó�� �����ϸ鼭, i+1���Ŀ��� �������� �ʴ´ٸ�, �ش� ���ĺ��� �ε��� ��ȯ.
				return i;
			}
            set.add(s_[i]); //�ѹ��̶� ���������� set�� ���Խ�Ų��.
		}
        return -1;
    }
    
	
    
    //<����Ǯ��3>
    
    //���ʿ��� ����ȯ�� ���༭ ������ �ǳ�. ���� �̰� �����
    
	//104 / 104 test cases passed.
	//Status: Accepted
	//Runtime: 21 ms
	//Memory Usage: 39.8 MB
    
    public int firstUniqChar(String s) {
        if(s.length()==0) return -1;
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(set.add(s.charAt(i))) {
        		list.add(s.charAt(i)-97);
        	} else {
                list.remove((Integer)(s.charAt(i)-97));
        	}
        }
    	return list.isEmpty() ? -1: s.indexOf((char)(list.get(0)+97));
    }
    
	
	//<����Ǯ��4 by tsuvmxwu>
	
	//����Ǯ��3�� ���ĺ��� �ε����� ��� ǥ���ұ� ����ϴٰ� ������ ���� ������ ��µ�, 
	
	//��� int[]�� �ε����� ������ ��, �ѹ��� �ȳ��°� 0, �ߺ��Ǽ� ���°� 1, �ѹ��� ���°� ~index�� �ִ´�.
	
	//~n�� �ϸ�, �տ� ���̳ʽ��� �޾��ش�. (��Ʈ��������. ƿƮ�����ڶ�� ��.) 
	
	//s�� "leetcode"�� ����־��� ��, indexes�� �Ʒ��� ���� ���´�.
	
	//0 0 -5 -7 1 0 0 0 0 0 0 -1 0 0 -6 0 0 0 0 -4 0 0 0 0 0 0
	
	//a,b,c,d,...,x,y,z �޷���̰�
	
	//���� c�� �ε����� 5�ε�, ~i�� ���༭ -5�� ����Ȱ� �� �� �ִ�.
	
	//�ι�° for�������� ����� ���߿� 0�� 1�� �ƴ� �͵�(�ѹ��� ���� �͵�) �� ���� ���� ���� �̴´�.
	
	//���� �������� ���� ���� ��ġ�� �ֱ� ����.
    
    //��� ���� ������ �����鼭 ������ ������. ��-��

	//104 / 104 test cases passed.
	//Status: Accepted
	//Runtime: 7 ms
	//Memory Usage: 39.4 MB
	
    public int firstUniqChar(String s) {
        int[] indexes = new int[26];
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-'a';
            indexes[ch] = indexes[ch]==0 ? ~i : 1;
        }
        int min = Integer.MAX_VALUE;
        for(int index : indexes) {
        	if(index<0) {
        		min=Math.min(min, ~index);
        	}
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    
    public static void main(String[] args) {

	}
}
