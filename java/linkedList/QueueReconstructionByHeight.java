package juneChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

	/*
	//<Trial01>
	
	//�Ӹ������ʹ�
	
	//��ǲ��.
	//[[5,2], [7,0], [4,4], [7,1], [5,0], [6,1]]

    //step01) k + h �� key�λ�� treemap�� ������������ ���

    //    o     o
    //    o o   o
    //o o o o   o
    //o o o o o o
    //o o o o o o
    //o o o o o o
    //o o o o o o (h)
    //0 2 0 1 4 1 (k)
	//5 7 7 7 8 8 (k+h)
	
	//step02) k+h�� ���������� ������� ��´�. 
	
	//��� ����� �ִ���� 8�� ����� 8�� int[]�� �������, [5,0]->[5,2]->[7,0]->[6,1]->... ������ treemap�� ����
	
	//0���� a[i][0]���� �������� +1���ش�.
	
	//�׷� ��, a[i][0] > k�̸�, ������ swap. --> 
	  
	//�� �������� �����ϴ��� �𸣰ڳ�. ����ӤӤӤӤӤӤӤ����������������������������������������󤿤�������������������������������������������
	
    //  o       o
    //  o   o   o
    //o o o o   o
    //o o o o o o
    //o o o o o o
    //o o o o o o
    //o o o o o o
    //0 0 2 1 4 1
    

    public static int[][] reconstructQueue(int[][] people) {
    	List<int[]> rst = new ArrayList<>();
    	
        TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
        for(int[] ppl : people) {
        	int key = ppl[0]+ppl[1];
        	if(tm.containsKey(key)) {
        		tm.
        		List<int[]> tmp = tm.get(key);
        		tmp.add(ppl);
        		tm.put(key, tmp);
        	} else {
        		List<int[]> tmp = new ArrayList<>();
        		tmp.add(ppl);
        		tm.put(key, tmp);
        	}
        }
        
        for(Map.Entry<Integer, List<int[]>> entry : tm.entrySet()) {
//        	int key = entry.getKey();
        	List<int[]> valList = entry.getValue();
        	
        	Arrays.sort(valList, new Comparator<List<int[]>>() {
                @Override
                public int compare(List o1, List o2) {
                    return o1.get(0)[1] - o2.get(0)[1];
                }
            });
        	
        	for(int[] ea : valList) {
        		if(rst.isEmpty()) {
        			rst.add(ea);
        		} else {
            		for(int i = 0, larger = 0; i < rst.size(); i++) {
            			if(rst.get(i)[0] > ea[0]) {
            				larger++;
            			}
            			if(larger > ea[1]) {
            				
            			}
            		}
        		}
        	}
        	
        	System.out.println();
        }
    	
    	return people;
    }
    */
	
	
	//<����Ǯ��1 by yubad2000>
	
	//{h, k}
	
	//int[][] people = {{5,2},{7,0},{4,4},{7,1},{5,0},{6,1}};
	
	//Arrays.sort() -> h�� �ٸ��� h���� �������� ����, h�� ������ k���� �������� ����
	
	//h���� �������� û���ϴ� ������(==ū�� ���� ���� ������), linkedlist�� .add()�� �߰��� ���Խ�, ū�� �����ְ� �� ���� ������ ��������.
	
	//������ ������ ū�� �տ� �;� ���ݾ�
	
	//{{7 0},{7 1},{6 1},{5 0},{5 2},{4 4}}
	
	//Runtime: 11 ms
	//Memory Usage: 52.2 MB
    
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
           public int compare(int[] p1, int[] p2){
               return p1[0]!=p2[0]?Integer.compare(p2[0],p1[0]): Integer.compare(p1[1],p2[1]); 
           }
        });
        
        List<int[]> list = new LinkedList();
        for (int[] ppl: people) list.add(ppl[1], ppl);
        return list.toArray(new int[people.length][] );
    }
    
	public static void main(String[] args) {
		int[][] people = {{5,2},{7,0},{4,4},{7,1},{5,0},{6,1}};
		System.out.println(reconstructQueue(people));
	}
}
