package array;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack1560 {

	//<����Ǯ��1>
	
	//brute-force
	
	//� ����� �������ٰ� �̰ź��ϱ� ���̵��� ����?
	
	//Runtime: 2 ms, faster than 82.62% of Java online submissions for Most Visited Sector in a Circular Track.
	//Memory Usage: 39.5 MB, less than 92.88% of Java online submissions for Most Visited Sector in a Circular Track.
	
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] a = new int[n];
        int max = 0;
        int adder = 1;
        
        for(int i = 1; i < rounds.length; i++){
            if(rounds[i-1] <= rounds[i]){
                for(int j = rounds[i-1]-adder; j < rounds[i]-adder; j++){ //adderó�� �ϴ� ������, �� ÷�� 0,1,2���� ����, �� ����� ������ ����+1���� ���ߵǼ�.
                    a[j]++;
                    adder = 0;
                }
            } else {
                for(int x = rounds[i-1]-adder; x < n; x++){
                    a[x]++;
                    adder = 0;
                }
                for(int y = 0; y < rounds[i]; y++){
                    a[y]++;
                    adder = 0;
                }
            }
        }
        for(int ele : a){
            max = Math.max(max, ele); //���� �󵵼� �����ָ� �̾�
        }
        
        List<Integer> rst = new ArrayList<>();
        
        for(int p = 0; p < n; p++){
            if(a[p] == max){ //���� �󵵼� �����ֺ��� ������� �־�
                rst.add(p+1);
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by lee215>
    
    //brain teaser.
    
    //if start <= end,
    
	//s --------------------- n
	//1 ---------------e
	
    //start~end���� ������ �ȴ�.
    
    
    //if ends < start,
    
	//                s ----- n 
	//1 --------------------- n //����� ��� �ִ� ���õ�
	//1 --------------------- n //����� ��� �ִ� ���õ�
	//1 ----- e
    
    //start���� ������, 1���� end���� ������ �ȴ�.
    
    //Runtime: 1 ms, faster than 97.57% of Java online submissions for Most Visited Sector in a Circular Track.
    //Memory Usage: 39.6 MB, less than 89.47% of Java online submissions for Most Visited Sector in a Circular Track.
    
    public List<Integer> mostVisited(int n, int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A[0]; i <= A[A.length - 1]; ++i) //if ends < start, �� for���� ���õ�.
            res.add(i);
        if (res.size() > 0) return res; //if ends < start, �� if���� ���õ�.
        for (int i = 1; i <= A[A.length - 1]; ++i) //if start <= ends, �� for���� ���õ�. 
            res.add(i);
        for (int i = A[0]; i <= n; ++i) //if starts <= ends, �� for���� ���õ�
            res.add(i);
        return res;
    }
}
