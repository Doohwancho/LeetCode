package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge721 {

	
	//<Trial01>
	
	//Union Circle
	
	//��� �Ʊ���
	
	//�ִ°� ���� �ߴµ� �� �������� ������ ��
	
	//smith->ny->00���� 
	
	//00���� ������ 
	
	//[00],[smith,ny]�̷������� �־���.
	
	//undirected graph�� ��ȸ�ϴ� ����� �˾ƾ� �ϴµ� bool[] visited ���� ������� �ߴٰ� �׾�;;
	
    class UnionCircle{
        List<List<String>> rst;
        Map<String, String> map;
        Map<String, Boolean> visited;
        
        public UnionCircle(List<List<String>> accounts){
            rst = new ArrayList<>();
            map = new HashMap<>();
            visited = new HashMap<>();
            
            for(List<String> list : accounts){
                String user = list.get(0);
                for(int i = 1; i < list.size(); i++){
                    String nameAndEmail = user+" "+list.get(i);
                    map.put(nameAndEmail, nameAndEmail);
                    visited.put(nameAndEmail, false);
                }
            }
        }
        
        private String find(String x){
            while(!map.get(x).equals(x)) x = map.get(x);
            return x;
        }
        
        public void union(String s1, String s2){
            String s1_ = find(s1);
            String s2_ = find(s2);
            if(s1_.equals(s2_)) return;
            map.put(s1_, s2_);
        }
        
        public void helper(List<String> container, String key){
            while(!map.get(key).equals(key)){
                visited.put(key, true);
                key = map.get(key);
                if(visited.get(key) == false){
                    container.add(key.split(" ")[1]);    
                }
            }
            visited.put(key, true);
            Collections.sort(container);
            return;
        }
        
                
        public void extract(){
            for( Map.Entry<String, String> elem : map.entrySet() ){
                if(visited.get(elem.getKey()) == false){
                    List<String> list = new LinkedList<>();
                    String[] SplittedStr = elem.getKey().split(" ");
                    
                    list.add(SplittedStr[1]);
                    helper(list, elem.getKey());
                    list.add(0, SplittedStr[0]);
                    rst.add(list);
                }

            }
        }
        
        
        public List<List<String>> returnAns(){
            return rst;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionCircle uc = new UnionCircle(accounts);
        for(List<String> account : accounts){
            for(int i = 1; i < account.size()-1; i++){
                uc.union(account.get(0)+" "+account.get(i), account.get(0)+" "+account.get(i+1));
            }
        }
        uc.extract();
        return uc.returnAns();
    }
    
    
    //<����Ǯ��1 by legendaryengineer>
    
    //union-circle
    
    //�Ʊ�� ���ر��� �ƴϾ�������;
    
    //accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
    
    //�̰� ���÷� ���,
    
    //�ּڰ�: 0x1 �̸�:John �̸���:"johnsmith@mail.com"(0x2�� ���� �ּ��ξְ� �����Ҷ� ������), "john00@mail.com"
    
    //�ּڰ�: 0x2 �̸�:John �̸���:"johnsmith@mail.com", "john_newyork@mail.com"
    
    //�ּڰ�: 0x3 �̸�:John(��������) �̸���:"johnnybravo@mail.com"
    
    //0x1 -> 0x2
    
    //�׷��� 0x1 != parent(0x1) ��. parent(0x1)�� 0x2�ϱ�. �׷��� �Ƶ���� parent�� 0x2�� .addAll()�� �̸��� ��������.
    
    //�� ������� undirected graph���� A->B->C���� C�� ���� Ƣ������ A�� �������� Ƣ���ͼ� [C],[A,B]���� ����� ���� �ذ�
    
    //Runtime: 33 ms, faster than 75.55% of Java online submissions for Accounts Merge.
    //Memory Usage: 47.2 MB, less than 5.08% of Java online submissions for Accounts Merge.
    
    class Person {
        String name;
        Set<String> emails;
        public Person(String name) {
            this.name = name;
            this.emails = new HashSet<>();
        }
        public List<String> toList() {
            List<String> list = new ArrayList<>();
            list.addAll(emails);
            Collections.sort(list);
            list.add(0, name);
            return list;
        }
    }
    
    private Map<Person, Person> parents;
    private Map<String, Person> map;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new HashMap<>();
        map = new HashMap<>();
        
        for (List<String> list : accounts) {
            Person p = new Person(list.get(0));
            parents.put(p, p);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                p.emails.add(email);
                if (map.containsKey(email)) {
                    unite(map.get(email), p); //["John", "johnsmith@mail.com", "john00@mail.com"], ��� ["John", "johnsmith@mail.com", "john_newyork@mail.com"], �꿡�� johnsmith@mail.com�� �����ϱ� ��� ���� ��������̴� �̾���.
                }
                map.put(email, p);
            }
        }
        
        Set<Person> parentSet = new HashSet<>();
        for (Person p : parents.keySet()) { //�� A->B->C��� undirected graph���� B->C�̹� ���Ƽ� [B,C] A->null->null �̷��� �Ǵ°� �������µ�, ��� A->B->C���� parent(A)���̸� A�� �ٸ���(C) ������ ������ �ֵ��� parent�� ��� .addAll()���ִ°� �ȶ��ϳ� �̰�
            Person parent = parent(p);
            if (p != parent) {
                parent.emails.addAll(p.emails);
            }
            parentSet.add(parent);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Person p : parentSet) res.add(p.toList());
        return res;
    }
    
    private void unite(Person p1, Person p2) {
        parents.put(parent(p1), parent(p2));
    }
    
    private Person parent(Person p) {
        while (parents.get(p) != p) {
            //parents.put(p, parents.get(parents.get(p))); //�̰� ��� �ߵ��ư�. �Ƴ� �������� ��ο� �������Ҹ� ���ݾ� �������� 
            p = parents.get(p);
        }
        return parents.get(p);
    }
    
}
