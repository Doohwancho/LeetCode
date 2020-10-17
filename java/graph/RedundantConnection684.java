package graph;

public class RedundantConnection684 {
	
	//<����Ǯ��1>
	
	//union circle
	
	//undirected-graph���� �ϴ� n����ŭ separate�� ���� connected�� ����,
	
	//�־��� int[][] edges�� iterate�ϸ鼭 �ϳ��ϳ��� ����.
	
	//���� ��, edge[0]�� ������, edge[1]�� ������ �� ����, ���� end point��
	
	//���� ���� ���̾���������, endpoint�� �ٸ�. �׷��� ���� �̾���.
	
	//���� ���� �̹� �̾��� �־����� endpoint�� ������? �׷��� undirected graph�� i��° edge�ʿ� ������ edge��ȯ����
	
	//�������� If there are multiple answers, return the answer that occurs last in the given 2D-array. ��� �߰�
	
	//input�� �̻ڰ� �����°� ������, uc.connect()���������� �տ��� ������� ������ �ʿ䵵 ���� ���ٸ�
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Redundant Connection.
	//Memory Usage: 39.2 MB, less than 5.17% of Java online submissions for Redundant Connection.
	
    class UnionCircle {
        int[] connected;

        UnionCircle(int n){
            connected = new int[n];

            for(int i = 0; i < n; i++){
                connected[i] = i;
            }
        }

        private int find(int n){
            while(connected[n] != n) n = connected[n];
            return n;
        }

        public int[] connect(int[] i){
            int i_ = find(i[0]-1);
            int j_ = find(i[1]-1);
            if(i_ == j_){
                return i;    
            } 
            connected[i_] = j_;
            return null;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        UnionCircle uc = new UnionCircle(n);

        for(int[] edge : edges){
            int[] tmp = uc.connect(edge);
            if(tmp != null){
                return tmp;
            }
        }
        return null;
    }
}
