package mayChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {
	
	/*
	//<Trial01>
	
	//N = 4, dislikes = [[1,2],[1,3],[2,4]]
	
	//[1,4],[2,3]
	
	//2,3 1,4
	//1   2
	
	//x,0,1,2,3,4
	//0   
	//1   x x,x o
	//2   x x o x
	//3   x   x
	//4		x   x
	
	//dislikes = [[1,2],[1,3],[2,3]]
	
	//x,0,1,2,3
	//0   
	//1   x x,x
	//2   x x x
	//3   x x x
	
	
	//dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
	
	//1,2,3,4,5
	
	//[1,3],[2,4]
	
	//x,0,1,2,3,4,5
	//0   
	//1   x x     x
	//2   x x x  
	//3     x x x
	//4       x x x
	//5   x     x x
	
	//dislikes = [[1,2],[2,3],[3,4],[4,5]]
	
	//[1,3,5],[2,4]
	
	//x,0,1,2,3,4,5
	//0   
	//1   x x     
	//2   x x x  
	//3     x x x
	//4       x x x
	//5         x x
	
	//����
	
    
    //<Trial02>
	
	//���ѤѤѹ�
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] check = new int[N+1][N+1];
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        
        for(int i = 1; i < N+1; i++){
            a.add(i);
        }

        for(int[] g : dislikes){
            if(a.contains(g[0]) && a.contains(g[1])){
                int transfer = a.remove(a.indexOf(g[1]));
                b.add(transfer);
                check[transfer][g[0]]++;
            }
        }
        
        for(int i = b.size()-1; i >= 0; i--){
            for(int j = 1; j < N+1; j++){
                if(check[b.get(i)][j] > 0 && !a.contains(j)){
                    a.add(b.remove(b.indexOf(b.get(i))));
                }
            }
        }
        
        for(int[] g : dislikes){
            if(b.contains(g[0]) && b.contains(g[1])){
                return false;
            }
        }
        return true;
    }
    */
	
    //<����Ǯ��1 by trustno1>
    
    //Runtime: 12 ms
	//Memory Usage: 47.7 MB
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N + 1]; //�ٱ���. a�� ������ 1, b�������� 2�� ǥ��. ���� �ȴ������ 0���� ǥ��.
        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) adj.add(new ArrayList<Integer>()); //dislikes[i][0]�� �Ⱦ��ϴ� ��� dislikes[i][1]�� ���, �ݴ뵵 ����
        for(int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        
        for(int i = 1; i <= N; i++) { //dislikes�� ���ؼ� color�� ��´�.(1�� ���, 2�� ���.)
            if(color[i] == 0) { //���� �ȴ���� ������
                color[i] = 1; //�ϴ� 1�� ��Ƴ�.
                Queue<Integer> q = new LinkedList<>(); //
                q.add(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int hate : adj.get(cur)) { //i�� �Ⱦ��ϴ� �ֵ��� hate�ε�,
                        if(color[hate] == 0) { //hate�� ���� �ȴ���ִٸ�,
                            color[hate] = color[cur] == 1 ? 2 : 1; //i�� 1�� ����� ������, nb�� 2�� ���, �ƴϸ� i�� �ݴ��� 2�� ���.
                            q.add(hate); //�׸��� hate�� �Ⱦ��ϴ¾ֶ� ���� ������� �� ������, �ٽ� q�� ��� Ȯ���Ѵ�.
                        } else {
                            if(color[hate] == color[cur]) return false; //���� i�� �Ⱦ��ϴ� nb�� �̹� �ѹ� ���İ��� 1�̳� 2�� ����� �ִµ�, ���� ���� ����� ������, return false
                        }
                    }
                }
            }
        }
        return true;
    }
    
}
