package graph;

import java.util.ArrayList;
import java.util.List;

public class FriendCircles {
	
	//<Trial01>
	
	//�ϴ� M�� ����� ����� �ִ��� ����Ʈ�� ���.
	
	//�������� ��͵Ǵ� circle�� ã�ƾ� ���ݾ�?
	
	//�׷����� ó�� �������� ����� �ľ��� ����(orig)
	
	//��� ���鼭 ����Ʈ�� ���� �ϳ��� �߰��ϴٰ�
	
	//ó�� ������(orig)�� ���ƿ�����, ����Ʈ �ȿ� �߰��� ���ҵ��� circle�̶�� ���̴ϱ�, 
	
	//ó���� ���� �� ��� ����Ʈ���� circle�� ��� ���� rst+1�ϴ� ������ Ǯ����.
	
	
	//input:  [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
	
	//output: 2
	
	//expected: 1
	
	public int findCircleNum(int[][] M) {
        List<Integer> list = new ArrayList<>();
        int rst = 0;
        
        //add candidates
        for(int i = 0; i < M.length; i++){
            list.add(i);
        }
        
        while(!list.isEmpty()){
            int orig = list.remove(0);
            
            List<Integer> tmp = new ArrayList<>();
            tmp.add(orig);
            
            int next = orig;
            do {
                for(int j = 0; j < M[0].length; j++){
                    if(j != next && M[next][j] == 1){
                        next = j;
                        tmp.add(next);
                        break;
                    }
                }
                if(next == orig){
                    rst++;
                    if(tmp.size() > 1){
                        list.removeAll(tmp);
                    }
                    break;
                }
            } while(orig != next);
        }
        return rst;
    }
	
	
	//<Trial02 - Memory Limit Exceeded>
	
	//input: [[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]
	
	//������ �¾Ҵµ� ������ �ſ� ������
	
    public int findCircleNum(int[][] M) {
        List<Integer> list = new ArrayList<>();
        int rst = 0;
        
        //add candidates
        for(int i = 0; i < M.length; i++){
            list.add(i);
        }
        
        while(!list.isEmpty()){
            int orig = list.remove(0);
            
            List<Integer> tmp = new ArrayList<>();
            tmp.add(orig);
            
            int next = orig;
            do {
                int prev = next;
                
                for(int j = 0; j < M[0].length; j++){
                    if(j != next && M[next][j] == 1){
                        M[j][next] = 0; //�Դ��� �����ֱ�**
                        next = j;
                        tmp.add(next);
                        break;
                    }
                }
                if(next == orig || prev == next){ //���ڸ��� �԰ų�(next == orig), ���� �ܿ� ģ���� �ƹ��� ���ų� �̤�(next == orig), ���ٸ� �濡 �����ų�(prev == next)
                    rst++;
                    if(tmp.size() > 1){
                        list.removeAll(tmp);
                    }
                    break;
                }
            } while(orig != next);
        }
        return rst;
    }
    
    
    //<����Ǯ��1 by fang2018>

    //union circles
    
    //https://www.youtube.com/watch?v=n_t0a_8H8VY&ab_channel=TusharRoy-CodingMadeSimple
    
    //ó���� ���� ������ ģ���ϱ�, 3���� �ִٰ� �ϸ� �� 3���� ģ���� �ִٰ� ����(union.count = 3)
    
    //2�� for�� ���鼭 �ڱ� �����ΰ� �̾������� return(skip)�ϰ�, �ٸ� �ֶ� �̾�������,
    
    //i = i ���� i = j�� �ٲ۴�. 
    
	//[[1,1,0],
	// [1,1,1],
	// [0,1,1]]
    
    //�� ������ (0,1)���� path[]�� [0,1,2]������ [1,1,2]�� ��. �̾����ٴ� ��. �׸��� 0�ϰ� 1�� �̾������ϱ�,
    
    //�� ���� �����ߴ� 3���� �̾��� �ѽ� + 2��° �� �ؼ� �� 2�� �ȴ�.
    
    //���������� (1,2)���� 1���� 2���� �̾����� path�� [1,2,2]�� �ǰ�, �ѹ� �� �̾������� ���� count-1�ؼ� 1�� �ȴ�.
    
    
    
    //��ü�� ���μ��� : ó���� �� ȥ�� ģ����� ����. 3���̸� count = 3.
    
    //�ѽ־� �̾��������� count-1�� ����.
    
    
    //Runtime: 1 ms, faster than 75.85% of Java online submissions for Friend Circles.
    //Memory Usage: 39.7 MB, less than 14.65% of Java online submissions for Friend Circles.
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionCircle uc = new UnionCircle(n);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    uc.check(i, j);    
                }
            }
        }
        return uc.getCnt();
    }
    class UnionCircle{
        int[] connected;
        int cnt = 0;
        
        UnionCircle(int n){
            connected = new int[n];
            cnt = n;
            
            for(int i = 0; i < n; i++){
                connected[i] = i;
            }
        }
        
        private int find(int i){
            while(connected[i] != i) i = connected[i];
            return i;
        }
        
        public void check(int i, int j){
            int i_ = find(i);
            int j_ = find(j);
            if(i_ == j_) return;
            connected[i_] = j_; //**connected[i] = j�� �ƴ϶� connected[i_] = j_ �� ������,  a->b->c  +d�� ����, c���� d�� �����͸� �ű�� ����. �� �׷츶�� �Ϸķ� �� �̾��� ģ���� ���� ���ܿ� �����Ͱ� ��ġ��.
            cnt--;
        }
        
        private int getCnt(){
            return this.cnt;
        }
    }
}
