package juneChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ReconstructItinerary {
	
	//<Trial01>
	
	//Input: [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
	//Output: ["JFK","KUL"]
	//Expected: ["JFK","NRT","JFK","KUL"]
	//Stdout: {NRT=[JFK], JFK=[KUL, NRT]}
	
	//�ϴ� �� �̾����°� �켱�ε� ���������� ���� Ƣ�����°� ���� ���� ���̴� �� ���̾����� �߰��� ����
	
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.size() == 0) return new ArrayList<>();
        List<String> rst = new ArrayList<>();
        rst.add("JFK");
        Map<String,List<String>> m = new HashMap<>();
        
        for(List<String> list : tickets){
            if(m.containsKey(list.get(0))){
                List<String> tmp = m.get(list.get(0));
                tmp.add(list.get(1));
                m.put(list.get(0), tmp);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(list.get(1));
                m.put(list.get(0), tmp);
            }
        }
        
        String next;
        
        do{
            String key = rst.get(rst.size()-1);
            
            if(m.get(key).size() > 1){
                List<String> tmp = m.get(key);
                next = tmp.get(0);
                for(String s : tmp){
                    if(s.compareTo(next) < 0){
                        next = s;
                    }
                }
                tmp.remove(next);
                m.put(key, tmp);
                rst.add(next);
            } else {
                next = m.remove(key).get(0);
                rst.add(next);
            }
        } while(m.containsKey(next));
        
        return rst;
    }
	
    
    //<Trial02>
    
    //doubly linked list�� �ɱ�? �; ����ٰ� �ٽû����غ��ϱ� ���� �ȳ����µ�?
    
    //binary tree�� �ϴ� �����س��� �̾ƾߵǳ�
    
    class Solution {
        
        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        
        //JFK-1.SFO, 2.ATL
        //SFO-1.ATL
        //ATL-1.JFK, 2.SFO
        
        //JFK-SFO-ATL-JFK
        //           -SFO   
        //   -ATL-JFK
        //       -SFO
        
        class DoublyLinked{
            DoublyLinked prev;
            List<DoublyLinked> next;
            String node;
            
            DoublyLinked(String s){
                node = s;
                prev = null;
                next = null;
            }
            
            public void addNext(DoublyLinked nextNode){
                next = nextNode;
                nextNode.prev = this;
            }
            
            public void addPrev(DoublyLinked prevNode){
                prev = prevNode;
                prevNode.next = this;
            }
            
            public void deleteNode(DoublyLinked removeNode){
                removeNode.prev.next =removeNode.next.prev;
            }
        }
        
        public List<String> findItinerary(List<List<String>> tickets) {
            if(tickets.size() == 0) return new ArrayList<>();
            DoublyLinked dl = new DoublyLinked("JFK");
            for(List<String> list : tickets){
                
                dl.addNext(list.get(0));
            }
        }
    }
    
    
    //<Trial03>
    
    //�ƴ� binary tree�� �� ���� ������ ������ �̾�� �ϴ°���? ������ �̾����°͵� �����ٵ�?
    
    //�׸��� �����غ��ϱ� list����� 10000�ε� {"JFK","ABC"}�� 10000��° ������ list.remove(0)�ϰ� list.add()�� 10000���Ѵٴ°��ݾ�?
    
    //�ð��ʰ��ϰڳ�? �ù�
    
    //�׷����� �ؾߵɰŰ�����
    

    class StringBinaryTree{
        
        String val;
        List<StringBinaryTree> children;
        Set<String> set;
        
        
        StringBinaryTree(String s){
            val = s;
            children = new LinkedList<>();
            set = new HashSet<>();
            set.add(s);
        }
        
        public void addChild(String key, String val){
            set.add(s);
            
            /*
            //if key is found
            
            StringBinaryTree child = new StringBinaryTree(s);
            int l = 0, r = children.size();
            while(l<r){ 
                int m = (l+r)/2;
                String mVal = children.get(m).val;
                if(s.compareTo(mVal) >= 0){ //add child according to lexiconical order
                    r = m;
                } else {
                    l = m+1;
                }
            }
            children.add(l, child);
            */
        }
        
        public void containsKey(String s){
            return set.contains(s);
        }
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.size() == 0) return new ArrayList<>();
        StringBinaryTree tr = new StringBinaryTree("JFK");
        
        while(!tickets.isEmtpy()){
            List<String> tmp = tickets.remove(0);
            if(tr.containsKey(tmp.get(0))){
                tr.addChild(tmp.get(0), tmp.get(1));
            } else {
                tickets.add(tmp);
            }
        }
        
        //tr leftmost && size == tickets to List<String> and return
    }
    
    
    
    //<����Ǯ��1 by StefanPochmann>	
    
    //Hierholzer��s Algorithm
    
    //https://m.youtube.com/watch?v=qZrfK2iE4UA 
    
    //���� ���� ��������. 
    
    //�ϴ� ���ٰ� ������ �κ��� ���Դµ�, ��� ��带 �� ���� �ʾ�����,
    
    //������ ������ ���ư��� �ٸ� ��� ����. �ٽ� ����������.
    
    //�ٽ� ���ٰ� �� �����µ� ��� ��带 �� �ȵ�������, ������� �ݺ�.
    
    //��� ��带 ���� ����������.
    
    //��� ��带 ���� �������ϱ�, starting point�� �˸� ��� ��带 �� �̾����� �� �� ����.
    
    //Eulerian path. Greedy DFS, building the route backwards when retreating.
    
    //targets = {'JFK': ['D', 'A'], 'A': ['C'], 'B': ['C'], 'C': ['JFK', 'D'], 'D': ['B', 'A']}
    //route = []	
	//stack = ['JFK']
    
	//First point at which we get stuck:
	//targets = {'JFK': ['D'], 'A': [], 'B': ['C'], 'C': ['JFK', 'D'], 'D': ['B']}
	//route = []
	//stack = ['JFK', 'A', 'C', 'D', 'A']
    
	//Update route:
	//targets = {'JFK': ['D'], 'A': [], 'B': ['C'], 'C': ['JFK'], 'D': ['B']}
	//route = ['A']
	//stack = ['JFK', 'A', 'C', 'D']
    
	//Search forward again until stuck:
	//targets = {'JFK': [], 'A': [], 'B': [], 'C': [], 'D': []}
	//route = ['A']
	//stack = ['JFK', 'A', 'C', 'D', 'B', 'C', 'JFK', 'D']
    
	//Update route:
	//targets = {'JFK': ['D'], 'A': [], 'B': [], 'C': ['JFK'], 'D': []}
	//route = ['A', 'D', 'JFK', 'C', 'B', 'D', 'C', 'A', 'JFK']
	//stack = []
    
	//Return route in reverse:
	//route = ['JFK', 'A', 'C', 'D', 'B', 'C', 'JFK', 'D', 'A']
    
    //Runtime: 5 ms
    //Memory Usage: 40 MB
    
    Map<String, PriorityQueue<String>> targets = new HashMap<>(); 
    List<String> route = new LinkedList();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        visit("JFK");
        return route;
    }

    void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }
    
    
}
