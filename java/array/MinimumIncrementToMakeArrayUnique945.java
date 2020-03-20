package array;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumIncrementToMakeArrayUnique945 {
	
	/*
	//<Trial01>
	
	//�����ϰ� �̾ǹ��� �ߴµ��� �ȵǳ� ����
	
	public int minIncrementForUnique(int[] A) {
        int[] container = new int[40000];
        Queue<Integer> q = new LinkedList<>();
        
        int rst = 0;
        int maxNum = 0;
        boolean flag = false;
        
        for(int element : A){
            container[element]++;
            maxNum = Math.max(maxNum, element);
        }

        for(int i = 0, idx = -1; i < maxNum+1; i++){
            if(container[i] > 1){
                flag = true;
                if(container[i] > 1){
                    q.add(i);
                }
            } else if(flag && container[i] == 0){
                if(idx == -1 && q.size() > 0){
                    idx = q.poll();
                } else {
                    continue;
                }
                
                if(container[idx] == 2){
                    rst += (i - idx);
                    idx = -1;
                } else {
                    rst += (i - idx);
                    container[idx]--;
                }
            }
        }
        if(q.size()>0){
            int lastIdx = q.poll();
            int additionals = container[lastIdx]-1;
            if(additionals % 2 == 0){
                return rst + (additionals+1) * (additionals/2) + (maxNum - lastIdx) * additionals;
            } else {
                return rst + additionals * ((additionals-1)/2) + additionals + (maxNum - lastIdx) * additionals;
            }
        } else {
            return rst;
        }
    }
    */
	
	/*
	//<����Ǯ��1>
	
	//�����ǿ������������˿��ˤ�����������
	
	//�̰Űŵ�~
	
	//Runtime: 6 ms, faster than 92.45% of Java online submissions for Minimum Increment to Make Array Unique.
	//Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Minimum Increment to Make Array Unique.
	
    public int minIncrementForUnique(int[] A) {
    	//0 <= A.length <= 40000, 0 <= A[i] < 40000 �ε� �� �������� �з��� ��õ�� �� ������ �־ �˳��� ������ ��
    	//container���� �� ���ں� �󵵼��� ���� ����
        int[] container = new int[50000]; 
        int rst = 0;
        int maxNum = 0;  

        for(int element : A){
            container[element]++; //�󵵼� 
            maxNum = Math.max(maxNum, element); 
            //���� ū ���ڸ� ���ϴ� ������, ���¼����� ��ū���� 3�̸�, [x, x, x, x]���� index 3���� �󵵼��� �������� �����Ŷ�. ���� �и��� index3 �̻����� �Ѿ������.
            //��� container.length 5���� �����ϰ� �ٵ����� 6ms������
            //Runtime: 12 ms, faster than 81.25% of Java online submissions for Minimum Increment to Make Array Unique.
        }

        //[1,2,0,1,0] <- �� ���� �־��� A��� ġ��
        //[0,0,1,1,2] <- �̰� ������� �����Ѱ� �̰��ݾ�?
        //[2,2,1]  //�װ� container�� �󵵼��� �°� ������ �̰Ű�
        //�׷� �� ��쿣 index0���� ���°� �Ѱ��� �̰� ó���Ϸ��� index3�� �ϳ� �׾ƾ� �ϳ�?
        //�׷� �ε������� ���༭ 3-0�ϸ� 3��ŭ �������� �ϴϱ�, result�� +3����/
        //�ٵ� ���࿡ [3,2,1]�̶� 0�� ���� �־��µ� �ϳ� index3���� �ű�Ŷ��?
        //�װ� �迭�� ���� [0,0,0,1,1,2] -> [0,0,1,1,2,3]�� �Ȱų�? result�� 3�̰�
        //�ٵ� 0 �ϳ� ���Űܾ� ���ݾ�? ����? ���Ӱ� 0�� ��Ÿ���� index��������.
        //�׷� 0�� ���Ӱ� Ƣ�����, ���Ӱ� ���� index - 0�� index��ŭ(�� ��� 4-0=4) result�� �����ָ� �ǰ���?
        //�׷� result�� 7�̵ǰ� ������ ó���ؾ��� 1�� �Ѿ.
        //�ٵ� 2�� �̻� �󵵼��� ������ ������� �׾Ƽ� ó���ؾ� ���ݾ�? �װ�
        //�ؿ� queue�� �������� �װ�, �� ó���ͺ��� �ϳ��ϳ���
  
        Queue<Integer> q = new LinkedList<>();

        int i = 0;
        int anchor = -1;

        while(i < maxNum+1 || q.size() > 0 || anchor != -1){ //�� ������ ������ �ƹ��͵� �Ƚ׿��ٸ� ���� �ִ����(maxNum)�̻� �� �ʿ� �����ϱ� i < maxNum+1. ���� �� ���� ���ΰ� �� �������� q.size() > 0 �ߵ�, Ȥ�� ���ΰ� queue�� ���µ� �� �������� anchor�� ������ anchor != -1 �ߵ�.
            if(container[i] > 1){ //���ΰ� ������ 
                q.add(i);         //queue�� �������� �״´� 
            } 
            else if(container[i] == 0){ //���� �󵵼��� 0�ε�
                if(anchor == -1 && q.size() > 0) anchor = q.poll(); //anchor�� -1�̰� qũ�Ⱑ 1�̻��̸�, i index���� ������ �׿� ���� if���� �ߵ���ٴ� �ǹ��̹Ƿ�, anchor�� ������ �ش�
                if(anchor != -1){ //���� anchor�� ������ �� ���¸�
                    rst += (i-anchor); //�ε����� ���̸�ŭ rst�� �����ְ�
                    container[anchor]--; //�ϳ��� �̵��������� �󵵼��� �ϳ� �ٿ��ְ�
                    if(container[anchor] == 1) anchor = -1;  //�󵵼��� �� �پ 1�̵Ǹ� ���� anchor�� �Ѿ�� ���� anchor�� -1���� �ʱ�ȭ ���ش�.
                }
                else{
                    i++;  //continue�ϸ� �ؿ� i++;�� ���ô��ؼ� while�� �����.
                    continue; 
                }
            }
            i++;
        }
        return rst;
    }
    */
	
	//�ణ �������� �����Ȱ� �ѹ� ���ø�����
    
    public int minIncrementForUnique(int[] A) {
		Queue<Integer> q = new LinkedList<>();
        int[] container = new int[50000]; 
        int rst = 0, maxNum = 0, i = 0, anchor = -1;

        for(int element : A){
            container[element]++; 
            maxNum = Math.max(maxNum, element); 
        }
		
        while(i < maxNum+1 || q.size() > 0 || anchor != -1){ 
            if(container[i] > 1) q.add(i);
            else if(container[i] == 0){ 
                if(anchor == -1 && q.size() > 0) anchor = q.poll();
                if(anchor != -1){ 
                    rst += (i-anchor); 
                    container[anchor]--; 
                    if(container[anchor] == 1) anchor = -1;  
                }
            }
            i++;
        }
        return rst;
    }
}
