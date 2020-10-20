package graph;

public class NumberOfOperationsToMakeNetworkConnected1319 {

	
	//<����Ǯ��1>
	
	
	//union circle
	
	//union circle�� uc.union����, i_==j_ ���� ���ٸ� �̹� �̾��� �ֶ�� ���̴ϱ�, �׿� Ŀ�ؼ�+1
	
	//un.union���� �ֵ� �� �հ�, uc.standAlone()���� ȥ���� �ֵ� ���� ����.
	
	//�̶� �����Ұ� �׷� �ȿ� �� ���������� �����θ� ����Ű�� �ֱ� ������, 
	
	//���� �׷�A, �׷�B, ȥ���ξ� C �̷��� ������ uc.standAlone()����� 3�� ����. 3�� �ٸ� �׷��̴ϱ�.
	
	//��׵��� �ּҰ����� �������� 2���� ������ �Ǵϱ�, loner-1�� �����ϴ� ��.
	
	//Runtime: 25 ms, faster than 31.90% of Java online submissions for Number of Operations to Make Network Connected.
	//Memory Usage: 53.7 MB, less than 5.10% of Java online submissions for Number of Operations to Make Network Connected.
	
	class UnionCircle{
        int[] connected;
        int leftOver = 0;
        
        UnionCircle(int len){
            connected = new int[len];
            
            for(int i = 0; i < len; i++){
                connected[i] = i;
            }
        }
        
        private int find(int x){
            while(connected[x] != x) x = connected[x];
            return x;
        }
        
        public void union(int i, int j){
            int i_ = find(i);
            int j_ = find(j);
            if(i_ == j_){
                leftOver++;
                return;
            }
            connected[i_] = j_;
        }
        
        public int standAlone(){
            int cnt = 0;
            for(int i = 0; i < connected.length; i++){
                if(i == connected[i]) cnt++;
            }
            return cnt;
        }
        
        public int getLeftOver(){
            return this.leftOver;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        UnionCircle uc = new UnionCircle(n);
        for(int[] connection : connections){
            uc.union(connection[0], connection[1]);    
        }
        int loner = uc.standAlone();
        int lefty = uc.getLeftOver();
        
        return lefty >= (loner-1) ? loner-1 : -1;
    }
}
