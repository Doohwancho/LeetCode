package augustChallenge;

import java.util.PriorityQueue;

public class IteratorForCombination {

	//<����Ǯ��1>
	
	//n-pointer
	
	//.next()�Ҷ����� �����͸� ��ĭ�� �о��ִ� ���.
	
	//Runtime: 10 ms
	//Memory Usage: 41.2 MB
	
	class CombinationIterator {

	    String s;
	    int len = 0;
	    boolean flag;
	    int cl = 0;
	    int[] index;
	    
	    
	    public CombinationIterator(String characters, int combinationLength) {
	        s = characters;
	        len = characters.length();
	        flag = true;
	        cl = combinationLength;
	        index = new int[len];
	        for(int i = 0; i < combinationLength; i++){
	            index[i] = 1;
	        }
	    }
	    
	    public String next() {
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < index.length; i++){
	            if(index[i] == 1){
	                sb.append(s.charAt(i));    
	            }
	        }
	        moveDigit(1);
	        return sb.toString();
	    }
	    
	    public boolean hasNext() {
	        return flag;
	    }
	    
	    private void moveDigit(int last){
	        if(last == cl+1 || last == len){
	            flag = false;
	            return;
	        }
	        if(index[len-last] == 1){
	            moveDigit(last+1);
	        } else{
	            for(int i = len-last; i > 0; i--){
	                if(index[i-1] == 1){
	                    index[i-1] = 0;
	                    if(last >= 1){ 
	                        for(int j = i; j < len; j++){
	                            index[j] = last-- > 0 ? 1 : 0;
	                        }
	                    }
	                    break;
	                }
	            }
	        }
	    }
	}
	
	//<����Ǯ��2 by Poorvank>
	
	//brute-force
	
	//÷���� �곽 �ð��ɸ����� string�� ���� ������ �ѹ��� �ְ� .next()�� .hasNext()�� �볻���� ���� �̹���� ���°� ������.
	
	//Runtime: 14 ms
	//Memory Usage: 41.5 MB
	
	PriorityQueue<String> pq = new PriorityQueue<>();
    public CombinationIterator(String s, int k) {
        generateSub(s,k,0,new StringBuilder());
    }
    private void generateSub(String s ,int len,int start,StringBuilder result) {
        if (len == 0){
            pq.add(result.toString());
            return;
        }
        for (int i = start; i <= s.length()-len; i++){
            result.append(s.charAt(i));
            generateSub(s, len-1, i+1, result);    //��� ������ ���� ����������
            result.deleteCharAt(result.length()-1); //�� �������� �Ѱ� ���� �����ɷ� �Ѿ
        }
    }
    public String next() {
        return pq.poll();
    }
    public boolean hasNext() {
        return !pq.isEmpty();
    }
	
}
