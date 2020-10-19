package graph;

public class MostStonesRemovedWithSameRowOrColumn947 {

	//<����Ǯ��1 by NorthernMystic>
	
	//union circle
	
	//���ȴ� �κ�: What is the largest possible number of moves we can make?
	
	//������ �翬�ϰ� 'least possible moves'�ΰɷ� �޾Ƶ���
	
	//����ȭ �Ϸ��� �˰��� ¥�µ� �� ���� ��ȿ������ ����� ã����°��� �𸣰�����, ����ư.
	
	
	//��ü n�� - (�ƹ��ֶ��� �� �̾��� ȥ�� ���������ִ¾� + �ٸ��ֵ��̶� �̾��� �׷��߿� �ϳ�) = ��
	
	//union circle������,
	
	//�ƹ��ֶ��� �� �̾��� �ִ� connected[i] = i; �״��. �մ��� ���� ����.
	
	//�ٸ��ֵ��Ͼ� �̾��� �׷��� �ϳ���, �ش� �׷��� pointer(?) �� ������ ������ ���� ��.
	
	//���ο� �ְ� �׷쿡 ���ö����� connected[i_] = j_; �̰� �ϴϱ�, �ϳ��� �׷�� �ѳ��� ������ connecetd[j_] = j_�� ���ݾ�.
	
	//��ģ���� '�ٸ��ֵ��̶� �̾��� �׷����� �ϳ�', �ٸ����� �ϸ� �ش� �׷��� ������ �� �Ǵ°�
	
	//���⼭ �ش� �׷��� �����Ͷ�� ����, �� �׷��� � element�� ��ȸ�ص�, union.find()�� ������ �������� ������ �������� ����.
	
	//Runtime: 22 ms, faster than 56.98% of Java online submissions for Most Stones Removed with Same Row or Column.
	//Memory Usage: 39.2 MB, less than 11.23% of Java online submissions for Most Stones Removed with Same Row or Column.
	
    class UnionCircle{
        int[][] matrix;
        int[] connected;
        
        public UnionCircle(int[][] stones, int n){
            matrix = stones;
            connected = new int[n];
            for(int i = 0; i < n; i++){
                connected[i] = i;
            }
        }
        
        private int find(int n){
            while(connected[n] != n) n = connected[n];
            return n;
        }
        
        public void union(int i, int j){
            int i_ = find(i);
            int j_ = find(j);
            if(i_ == j_) return;
            connected[i_] = j_;
        }
        
        public int getLeftOvers(){
            int count = 0;
            for (int i = 0; i < connected.length; i++){
                if (connected[i] == i) count++;
            }
            return count;
        }
    }
    
    public int removeStones(int[][] stones) {
        int len = stones.length;
        UnionCircle uc = new UnionCircle(stones, len);
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){ //������, ���� ���� ���,
                    uc.union(i, j);        
                }
            }
        }
        return len - uc.getLeftOvers(); 
    }
}
