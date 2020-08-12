package augustChallenge;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	
	//<����Ǯ��1>
	
	//EEEEEEEEEZZZZZZZZZZZZZZZZZZZZZZZ
	
	//Runtime: 0 ms
	//Memory Usage: 37 MB
	
    public List<Integer> getRow(int rowIndex) {
        int[] a = new int[rowIndex+1];
        a[0] = 1;
        int idx = 0;
        while(idx < rowIndex){
            for(int i = 1, prev = 1, tmp = 0; i < idx+1; i++){
                tmp = a[i];
                a[i] += prev;
                prev = tmp;
            }
            a[idx+1] = 1;
            idx++;
        }
        List<Integer> rst = new ArrayList<>(a.length);
        for(int i : a){
            rst.add(i);
        }
        return rst;
    }
    
    
    //<����Ǯ��2>
    
    //�Ȱ����ǵ�, int[] -> arraylist��ȯ�� ������ �ȳ���
    
    //Arrays.asList()�� �ٲ�.
    
    //int[] -> ArrayList�� �ٲٰ� ������, Arrays.asList() ���� �ȵǴµ�,
    
    //Integer[] -> ArrayList��, Arrays.asList()���� ��.
    
    //ArrayList�� primitive type�޴°� �ƴ϶� reference type�޾Ƽ� �׷���.
    
    //���� Arrays.fill(a, 0);�� ��� ���Ҹ� 0���� �ʱ�ȭ ���ִ� ���ִ°� ����.
    
    //������ �ʾҴµ�, .get()�ؼ� �θ����� �ϸ� null pointer exception�߱� ����.
    
    //Runtime: 0 ms
    //Memory Usage: 37.1 MB
    
    public List<Integer> getRow(int rowIndex) {
        Integer[] a = new Integer[rowIndex+1];
        //Arrays.fill(a, 0);
        a[0] = 1;
        int idx = 0;
        while(idx < rowIndex){
            for(int i = 1, prev = 1, tmp = 0; i < idx+1; i++){
                tmp = a[i];
                a[i] += prev;
                prev = tmp;
            }
            a[idx+1] = 1;
            idx++;
        }
        return Arrays.asList(a);
    }
    
    
    
    //<����Ǯ��3 by jeantimex>
    
    //�� �ڿ������� �߳�. �׷��� tmp�� prev������ �̸��ְ� �����ְ� ���ص� �ǰ� ����ϰ� ��������
    
    //clean code ����
    
    //Runtime: 0 ms
    //Memory Usage: 37.2 MB
    
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        return Arrays.asList(arr);
    }
}
