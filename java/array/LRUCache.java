package thirtyDayChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	
	/*
	//<Trial01>
	
//	["LRUCache","get","put","get","put","put","get","get"]
//	[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
//	Output: [null,-1,null,-1,null,null,2,-1]
//	Expected: [null,-1,null,-1,null,null,2,6]
	
	//[[1,5],[2,6]]�� �ִ� map�� [1,2]�� ������, �ƹ��ϵ� ���Ͼ���Ѵ�. �ֳ��ϸ� ��������
	//put(key, value) - Set or insert the value if the key is not already present.
	
	//��� �߱� ������, if the key is already present, DO ?
	
	//��� ���� ����.
	
	//�� ���� �´� ���̶��, �� �������� 2,6���� �����°� �ƴ϶�, 5,6���� ������ �Ѵ�.
	
	//put [2,6] -> [[2,6]]
	//put [1,5] -> [[1,5],[2,6]]
	//put [1,2] -> [[1,5],[2,6]] -- Do Nothing
	//get(1) = 4
	//get(2) = 6
	
	//���� testcase�� ��������, 
	//1) Set or insert the value even if the key is already present.
	//��� ������ �ٲ��� �Ѵ�.
	
	//������ ����.
	  
	
	
    Map<Integer, Integer> map;
    List<int[]> list;
    int limit;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new ArrayList<>();
        limit = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	int idx = 0;
        	for(int i = 0; i < list.size(); i++) {
        		if(list.get(i)[0] == key) {
        			idx = i;
        			break;
        		}
        	}
            int[] tmp = list.get(idx);
            list.remove(idx);
            list.add(0, tmp);
            
            
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        list.add(0, new int[] {key,value});

        if(list.size() > limit){
        	int[] tmp = list.remove(list.size()-1);
        	int deleteKey = -1;
            for(int mapKey : map.keySet()){
                if(mapKey == tmp[0] && map.get(mapKey) == tmp[1]) {	
                	deleteKey = mapKey;
                	break;
                }
            }
            map.remove(deleteKey);
        }
    }
    */
	
	//<����Ǯ��1 by HelloWorld123456>
	
	//÷ ������ arraylist.add(0, key)�ϸ� �����ϱ� linkedlist�� �ϸ� ��� �ߴµ�
	
	//���� �����Ϸ��� �������� ������� ��� �����ؾ� �ϳ� �ϰ� ��Ÿ���� �׳� arraylist��µ�
	
	//�̰� linkedlist(�߿����� doublely linked list) ������� �� �س���
	
	//18 / 18 test cases passed.
	//Status: Accepted
	//Runtime: 13 ms
	//Memory Usage: 47.7 MB
	
	class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    HashMap<Integer, Node> map;
    int capicity, count;
    Node head, tail; //head�� �� ù��° ��� �տ��ִ� ���. tail�� ���������� �� �ڿ��ִ� ��� �ڿ� �ִ� ���.
    
    public void deleteNode(Node node) { //��� �ش� element����, element.pre�� element.next �������ִ� �޼���
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node; //���� �� �տ� �ִ� ���.pre�� head���� �Ķ���ͷ� ���Ӱ� ���� ���� �ٲ��
        node.pre = head; //���� �� �տ� �ִ� ��� �տ� head��尡 �ٴ´�.
        head.next = node;
    }
    
    public LRUCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }
    
    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value); 
            map.put(key, node);
            if (count < capicity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
    
    
	public static void main(String[] args) {
		int capacity = 2;
		LRUCache obj = new LRUCache(capacity);
		obj.put(1, 1);
		obj.put(2, 2);
		obj.get(1);
		obj.put(3, 3);    // evicts key 2
		obj.get(2);       // returns -1 (not found)
		obj.put(4, 4);    // evicts key 1
		obj.get(1);       // returns -1 (not found)
		obj.get(3);       // returns 3
		obj.get(4);  
		
		System.out.println(obj);
	}
}
