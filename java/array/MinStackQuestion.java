package thirtyDayChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MinStackQuestion {
	
	/*
	//<����Ǯ��1>
	
	//�̳� ������ �ϴ� �ȴ�.
	
	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 1118 ms
	//Memory Usage: 45.9 MB
	class MinStack {

	    Stack st;
	    List<Integer> list;
	    public MinStack() {
	        st = new Stack();
	        list = new ArrayList<>();
	    }
	    
	    public void push(int x) {
	        st.push(x);
	        list.add(x);
	    }
	    
	    public void pop() {
	        st.pop();
	        list.remove(list.size()-1);
	    }
	    
	    public int top() {
	        return (int)st.peek();
	    }
	    
	    public int getMin() {
	        int minNum = Integer.MAX_VALUE;
	        for(int i : list) minNum = Math.min(minNum, i);
	        return minNum;
	    }
	}
	*/
	
	/*
	//<����Ǯ��2>
	
	//���� �Ƚᵵ �ɰŰ���
	
	//�ٵ� �̰� ���� �ƴѰ���. �̳� �����ϱ�.
	
	//getMin()������ �����Ű�����

	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 949 ms
	//Memory Usage: 45.6 MB
	
	class MinStack {

	    List<Integer> list;
	    public MinStack() {
	        list = new ArrayList<>();
	    }
	    
	    public void push(int x) {
	        list.add(x);
	    }
	    
	    public void pop() {
	        list.remove(list.size()-1);
	    }
	    
	    public int top() {
	        return list.get(list.size()-1);
	    }
	    
	    public int getMin() {
	        int minNum = Integer.MAX_VALUE;
	        for(int i : list) minNum = Math.min(minNum, i);
	        return minNum;
	    }
	}
	*/

	/*
	//<����Ǯ��3>
	
	//�̰���!!!!!!
	
	//1118ms -> 10ms
	
	//ũ..�������ȵ�
	
	//�� ������ �ٽ��� getMin()��. ���� ������ ���� �� arraylist���� ���� �� �ִµ�,
	
	//getMin()������ �ð� ������ ����
	
	//�׷��� ���� ���� ���ڸ� �׻� ������Ʈ ������ �÷��� ���İ� �ʿ���
	
	//�װ� TreeMap��
	
	//TreeSet, TreeMap �Ѵ� .add, .put���� ���� ����������
	
	//������������ �������� �־, .first()�ϸ� ���� ���� ���� ����
	
	//TreeSet���� TreeMap�� ������, TreeSet�غôµ� �ߺ��Ǵ� ���ڰ� ������
	
	//TreeSet�� �⺻������ Set�̶� �ߺ����ڸ� �����ؼ� ������� �̻��ϰ� ����
	
	//0,1,0 �־��µ� set�̴� ���� 0,1�ۿ� �ȵ�..
	
	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 10 ms
	//Memory Usage: 41 MB
	
	class MinStack {

	    List<Integer> list;
	    TreeMap<Integer, Integer> tr;
	    
	    public MinStack() {
	        list = new ArrayList<>();
	        tr = new TreeMap<>();
	    }
	    
	    public void push(int x) {
	        list.add(x);
	        tr.put(x, tr.getOrDefault(x, 0)+1);
	    }
	    
	    public void pop() {
	        int n = list.remove(list.size()-1);
	        if(tr.get(n) > 1){
	            tr.put(n, tr.get(n)-1);
	        }
	        else{
	            tr.remove(n); 
	        }
	        
	    }
	    
	    public int top() {
	        return list.get(list.size()-1);
	    }
	    
	    public int getMin() {
	        return tr.firstKey();
	    }
	}
	*/
	
	//<����Ǯ��4 by ivtoskov>
	
	//�̰��� �ٷ� ���ͺ� ���ϴ� �������� stack ������

	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 4 ms
	//Memory Usage: 41.5 MB
	
	class MinStack {

	    class Node{
	        int val;
	        int min;
	        Node next;
	        
	        Node(int val, int min){
	            this.val = val;
	            this.min = min;
	            this.next = null;
	        }
	        
	        Node(int val, int min, Node node){ //�� ��� �߰��Ҷ� ������带 �����.next�� �ٿ�
	            this.val = val;
	            this.min = min;
	            this.next = node;
	        }
	    }
	    private Node head;

	    public void push(int x) {
	        if(head == null){
	            head = new Node(x, x);
	        } else {
	            head = new Node(x, Math.min(head.min, x), head); //���������� min tracking�ϴ°� ���ȴ�
	        }
	    }

	    public void pop() {
	        head = head.next; //���ϰ��� ��� ��������
	    }

	    public int top() {
	        return head.val;
	    }

	    public int getMin() {
	        return head.min;
	    }
	}
}
