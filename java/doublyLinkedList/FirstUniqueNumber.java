package thirtyDayChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FirstUniqueNumber {
	
	/*
	//<Trial01>
	
	//�����ڶ� add�޼��忡 ��������.
	
	//���� q�� ������ ����� ������ ������� �ߴµ�,
	
	//���� ���ڰ� 3�� ���´ٸ�?
	
	//�ְ����������ϱ� �ִٰ� ����. ���� 2�� �̻󳪿ͼ� ���ٰ� ���;� �ϴµ�.
	  
	//**������ ���߿�, �ߺ� ������ map�� value���� null�� ����� �������μ� �ذ���. ����Ǯ��1����.
	
	static class FirstUnique {

	    Queue<Integer> q;
	    
	    public FirstUnique(int[] nums) {
	        q = new LinkedList<>();
	        for(int n : nums){
	            if(q.contains(n)){
	                q.remove(n);
	            } else{
	                q.add(n);
	            }
	        }
	    }
	    
	    public int showFirstUnique() {
	    	if(q.isEmpty()) return -1;
	        return q.peek();
	    }
	    
	    public void add(int value) {
	        if(q.contains(value)){
	            q.remove(value);
	        } else {
	            q.add(value);
	        }
	    }
	    
	}
	*/
	
	/*
	//<Trial02 memory limit exceeded>
	
	//���̰� �Ӹ��� ��� ģ���� �߸��л�����������
	  
	 
	class FirstUnique {
	    Queue<Integer> q;
	    int[] dup;
	    
	    public FirstUnique(int[] nums) {
	        q = new LinkedList<>();
	        dup = new int[100000000];
	        
	        for(int n : nums){
	            dup[n]++;
	        }
	        for(int n : nums){
	            if(dup[n]==1){
	                q.add(n);
	            }
	        }
	        
	    }
	    
	    public int showFirstUnique() {
	        if(q.isEmpty()) return -1;
	        return q.peek();
	    }
	    
	    public void add(int value) {
	        if(dup[value]==0){
	            dup[value]++;
	            q.add(value);
	        }else if(dup[value]==1){
	            dup[value]++;
	            q.remove(value);
	        } 
	    }
	 }
    */
	
	/*
	//<Trial03 - Time limit exceeded>
	
	//map�ᵵ �ȵų�
	
	class FirstUnique {

	    Queue<Integer> q;
	    Map<Integer, Integer> m;
			
	    
	    public FirstUnique(int[] nums) {
	        q = new LinkedList<>();
	        m  = new HashMap<>();
	        for(int n : nums){
	            m.put(n, m.getOrDefault(n, 0)+1);
	        }
	        for(int n : nums){
	            if(m.get(n)==1){
	                q.add(n);
	            }
	        }
	    }
	    
	    public int showFirstUnique() {
	        if(q.isEmpty()) return -1;
	        return q.peek();
	    }
	    
	    public void add(int value) {
	        if(m.get(value) != null){
	            q.remove(value);
	        } else {
	            m.put(value, 1);
	            q.add(value);
	        }
	    }
	}
	*/
	
	//<����Ǯ��1 by Knowledge Center>
	
	//17 / 17 test cases passed.
	//Status: Accepted
	//Runtime: 111 ms
	//Memory Usage: 78.2 MB
	
	class FirstUnique {
	    
	    private class ListNode{
	        ListNode _next;
	        ListNode _prev;
	        int _val;
	        public ListNode(int val){
	            _val = val;
	            _next = null;
	            _prev = null;
	        }
	    }
	    
	    private class MyDLL{ //DLL stands for Doubly Linked List
	        private ListNode _head;
	        private ListNode _tail;
	        
	        public MyDLL(){
	            _head = new ListNode(-1); //head�� ����,
	            _tail = new ListNode(-1); //tail�� ����. head.next�� ù ����, tail.prev�� ������ �����.
	            _head._next = _tail;
	            _tail._prev = _head;
	        }
	        
	        public ListNode getFirst(){
	            return _head._next;
	        }
	        
	        public boolean isEmpty(){
	            return _head._next == _tail;
	        }
	        
	        public void remove(ListNode node){
	            ListNode prev = node._prev;   //�ϴ� �Ķ���ͷ� ���� ����� �հ� �� ��带 �ȾƳ�
	            ListNode next = node._next;
	            prev._next = next;          //�� ����� next�� �޳���
	            next._prev = prev;          //�� ����� prev�� �ճ����ϸ�, ���̿� ���ִ� ������ ��尡 �����. �ٵ� �޸𸮻󿡴� �Ȼ�����ݾ�? � ���� ���غ��±��
	        }
	        
	        public ListNode append(int num){
	            ListNode node = new ListNode(num); //�ϴ� ��峢�� ��������ִ°Ŵϱ�, ��带 �������.
	            ListNode prev = _tail._prev;  //tail�� �տ� ���� �� �ڿ� ������?
	            prev._next = node;         //�� ���� ����� ������ �Ķ���ͷ� ���� ���� ������
	            node._prev = prev;         //�׸��� �� ��忡 prev�� ��� ���� �������ν� ���� �̾���.
	            node._next = _tail;        //���������� �����Ѱ� ����. ���� �� �ڿ� ��尡 �� ���� next�� tail�� ����
	            _tail._prev = node;        //�׸��� �翬�� tail�� �� �ڿ� ���� �ٿ���
	            
	            return node;
	        }
	    }
	    
	    private MyDLL _keys;
	    private Map<Integer, ListNode> _map;
	    
	    public FirstUnique(int[] nums) {
	        _keys = new MyDLL();
	        _map = new HashMap<>();
	        
	        for(int n : nums){
	            add(n);        //�Ʒ��� ������ add�޼���� DLL�� map�� ���ÿ� ����. ** �����ڿ��� �޼��� �ٷ� �� �� �ִ�...!
	        }
	    }
	    
	    public int showFirstUnique() {
	        if(_keys.isEmpty()){
	            return -1;
	        }
	        return _keys.getFirst()._val;
	    }
	    
	    public void add(int value) {
	        if(_map.containsKey(value)){
	            if(_map.get(value) != null){
	                _keys.remove(_map.get(value));
	                _map.put(value, null);          //2�� �̻� ��Ÿ�� ������ value�� ��� null������ ó���Ѵ�.
	            }
	        }
	        else{
	            ListNode node = _keys.append(value);
	            _map.put(value, node);
	        }
	    }
	}
    
//	public static void main(String[] args) {
//		int[] test = {2,3,5};
//		FirstUnique firstUnique = new FirstUnique(test);
//		System.out.println(firstUnique.showFirstUnique()); // return 2
//		firstUnique.add(5);            // the queue is now [2,3,5,5]
//		System.out.println(firstUnique.showFirstUnique()); // return 2
//		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
//		System.out.println(firstUnique.showFirstUnique()); // return 3
//		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
//		firstUnique.showFirstUnique(); // return -1
//		
//	}

}
