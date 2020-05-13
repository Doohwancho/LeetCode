package mayChallenge;

import java.util.Stack;

public class RemoveKDigits {
	
	/*
	//<Trial01>
	
	//�Ƥ���������
	
	//String�� �����ȵǰ� �� ���ڰ� �������� Integer.parseInt()�� �ȸ���. Integer.MAX_VALUE�� �Ѿ��
	
	//���̰�
	
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";
        char[] n = num.toCharArray();
        
        while(k > 0){
            Character p = null; 
            for(int i = 0; i < n.length; i++){
                if(p == null){
                    p = n[i];
                } else{
                    if(p < n[i]){
                        StringBuilder sb = new StringBuilder();
                        for(int j = 0; j < n.length; j++){
                            if(j!=i){
                                sb.append(n[j]);
                            }
                        }
                        n = Integer.valueOf(sb.toString()).toString().toCharArray();
                        break;
                    } else if(p > n[i]){
                        if(n[i]=='0' && i == 1){
                            n = String.valueOf(n).substring(2).toCharArray();
                            break;
                        }
                        n = String.valueOf(n).substring(1).toCharArray();
                        break;
                    } else if(i == n.length-1){
                        return String.valueOf(n).substring(n.length-1-k).toString();
                    }

                }
            }
            k--;
        }
        return n.length == 0 ? "0" : String.valueOf(n);
    }
    */
    
    //<����Ǯ��1 by my3m>
    
    //Stack
    
	//Runtime: 5 ms
	//Memory Usage: 39.9 MB
    
    public static String removeKdigits(String num, int k) {
        Stack<Character> chars = new Stack<Character>();
        for(char c : num.toCharArray()) {
            while(chars.size() > 0 && k > 0 && chars.peek() > c) { //i > i+1 �̸�, i�� ���ش�.
                k--;
                chars.pop();
            }
            chars.add(c);
        }
        while(k > 0 && chars.size() > 0) { //2223, k=2 ó�� i <= i+1�̶� ������ ���� k�� �����ִ� ���, ���� ū ���� ���������� k��ŭ ���ش�.
            chars.pop();
            k--;
        }
        int j = 0;
        while(j < chars.size() && chars.elementAt(j) == '0') //0�� ���� �ľ�
            j++;
        if(j == chars.size()) //���� ������ �� 0�̸� "0"�� ��ȯ
            return "0";
        System.out.println(chars);
        System.out.println(j);
        
        StringBuilder sb = new StringBuilder(); 
        while(j < chars.size()) { //num = "10101", k = 2�̸�, 0�տ��ִ� 1 �ΰ��� ���� "001"�� ���� j = 2. j�� �տ��ִ� 0�� ������ ���ϴ�, index j���Ŀ� ���ڸ� ��Ƽ� ��ȯ���ָ� �� 
            sb.append(chars.elementAt(j));
            j++;
        }
        return sb.toString(); 
    }
    
    public static void main(String[] args) {
    	String num = "10101";
    	int k = 2;
    	System.out.println(removeKdigits(num, k));
	}
}
