package augustChallenge;

import java.util.ArrayList;
import java.util.List;

public class LargestComponentSizeByCommonFactor {

	//<Trial01>
	
	//Input: [4,6,15,35], �̰Ŷ� [20,50,9,63] �̰� �Ǵµ�
	
	//Your input: [2,3,6,7,4,12,21,39]
	//Your answer : 6
	//Expected answer : 8
	
	//���⼭ ����. �ͱ�?
	
	class Solution {
	    
	    class Graph{
	        List<Graph> connect;
	        int val = 0;
	        
	        Graph(){
	            connect = new ArrayList<>();
	        }
	        
	        Graph(int n){
	            this.val = n;
	            connect = new ArrayList<>();
	        }
	        
	        public void add(Graph node){
	            connect.add(node);
	        }
	    }
	    
	    public int gcd(int a, int b){
	        while(b != 0){
	            int temp = a % b;
	            a = b;
	            b = temp;
	        }
	        return Math.abs(a);
	    }

	    public boolean checkGcd(Graph mother, Graph node){
	        boolean flag = false;
	        
	        if(gcd(mother.val, node.val) > 1){
	            mother.add(node);
	            flag = true;
	        }

	        int len = mother.connect.size();
	        
	        for(int i = 0; i < len; i++){
	            Graph curr = mother.connect.get(i);
	            if(curr.val != node.val){
	                flag |= checkGcd(curr, node);    
	            }
	        }
	        return flag;
	    }   

	    public int checkMaxSize(Graph node){
	        int max = 0;
	        
	        if(node.connect.size() == 0){
	            return 1;
	        }
	        
	        for(Graph child : node.connect){
	            max = Math.max(max, checkMaxSize(child));
	        }
	        return max+1;
	    }
	    
	    public int largestComponentSize(int[] A) {
	        Graph mother = new Graph();
	        
	        for(int a : A){
	            Graph node = new Graph(a);
	            if(mother.connect.size() > 0){
	                int len = mother.connect.size();
	                for(int i = 0; i < len; i++){
	                    if(!checkGcd(mother.connect.get(i), node)){
	                        mother.add(node);
	                    }
	                }
	            } else {
	                mother.add(node);
	            }
	        }
	        
	        return checkMaxSize(mother)-1;
	    }
	}
	
	
	
	//<����Ǯ��1 by serdaroquai>
	
	//Runtime: 761 ms
	//Memory Usage: 125.2 MB
	
	class Solution {
	    
	    public int largestComponentSize(int[] A) {
	    
	        Map<Integer, Node> nodes = new HashMap<>();
	        for (int a : A) nodes.put(a, new Node(a));
	        for (int a : A) connectFactorsOf(a, nodes); //2���� ��Ʈa���� ������, a�� ���� �� �ִ� ���� �ν־� nodes��� �ʿ� �־���. ���� ���� A ��̿� ������ exist = false�� �־���. ���߿� �̾��� graph���ڼ��� ī��Ʈ ���ϰ�.
	        
	        Set<Node> visited = new HashSet<>();
	        int max = 0;
	        for (Node n : nodes.values()) {
	            max = Math.max(max, sink(n, visited)); //�����Ǵ°� �ƴ϶� ���ο� hashmap�� �� iterate���� ����ǳ�����.
	        }
	        return max;
	    }
	    
	    //dfs - count the # of connected graphs
	    private int sink(Node n, Set<Node> visited) {
	        if (visited.contains(n)) return 0; //if current node is already visited & counted, skip.
	        visited.add(n);
	        
	        int count = n.exists ? 1 : 0; //skip the node that does not exist in the array
	        for (Node next : n.neighbors) {
	            count += sink(next, visited);
	        }
	        return count;
	    }
	    
	    private void connectFactorsOf(int a, Map<Integer,Node> nodes) {
	        Node self = nodes.get(a);
	        
	        for (int i=2; i <= (int) Math.sqrt(a); i++) {
	            if (a%i == 0) {
	                Node factor = nodes.get(i);
	                factor = factor == null ? new Node(i, false) : factor;
	                factor.neighbors.add(self);
	                self.neighbors.add(factor); //�ϴ� array�� �ִ� ���� neighbors�� ����. ��, ���� array�� �����ִ� exist�� false�� �־����� ������, sink()���� ī��Ʈ �ȵ�.
	                
	                nodes.put(i, factor);
	                
	                int other = a/i;
	                factor = nodes.get(other);
	                factor = factor == null ? new Node(other, false) : factor;
	                factor.neighbors.add(self);
	                self.neighbors.add(factor);
	                
	                nodes.put(other, factor);
	                
	            }
	        }
	    }
	    
	    public class Node {
	        int val;
	        boolean exists;
	        Set<Node> neighbors = new HashSet<>();
	        
	        public Node(int val) {this(val, true);}
	        public Node(int val, boolean exists) {
	            this.val = val;
	            this.exists = exists;
	        }
	    }
	}
	
}
