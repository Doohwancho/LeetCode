package mayChallenge;

public class CheckIfStraightLine {

	/*
	//<Trial01>
	
	//���� [[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]] ��������� ���������� ������
	
	//�ٵ� �׷��ٰ� x���� �ΰ� �������� �����ؼ� �����ڴ�, �ð��� �����ɸ���, x�� �����ε� y���� �ٲ��������
	
	//�� y���ΰ� �������� �����ؼ� �ٽ� ������ �ϴϱ�, �� ����� �ȉ�.
	
    public boolean checkStraightLine(int[][] coordinates) {
        int xDiff = coordinates[1][0] - coordinates[0][0];
        int yDiff = coordinates[1][1] - coordinates[0][1];
        
        for(int i = 1; i < coordinates.length; i++){
            if(coordinates[i][0]-coordinates[i-1][0] != xDiff ||
               coordinates[i][1]-coordinates[i-1][1] != yDiff){
                return false;
            }
        }
        return true;
    }
    
    //<Trial02>
    
    //���Ŷ� �Ĳ��� x,y�� ������ �׵� �߿� �ּڰ��� ���̷� ������ ����?
    
    //�� �ƴϾ�~
    
    //[[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]]
    public boolean checkStraightLine(int[][] coordinates) {
        Set<Integer> xList = new HashSet<>();
        Set<Integer> yList = new HashSet<>();
        int xMin = coordinates[1][0] - coordinates[0][0];
        int yMin = coordinates[1][1] - coordinates[0][1];
        xList.add(xMin);
        yList.add(yMin);
        
        for(int i = 1; i < coordinates.length; i++){
            int xDiff = coordinates[i][0]-coordinates[i-1][0];
            int yDiff = coordinates[i][1]-coordinates[i-1][1];
            xMin = Math.min(xMin, xDiff);
            yMin = Math.min(yMin, yDiff);
            xList.add(xDiff);
            yList.add(yDiff);
            for(int p : xList){
                if(p % xMin != 0){
                    return false;
                }
            }
            for(int q : yList){
                if(q % yMin != 0){
                    return false;
                }
            }
        }
        return true;
    }
    */
	
	//<����Ǯ��1>
	
	//���⸦ ���
	
	//������ ���� ģ����
	
	//int ������ int���� ��, 3/5�ϸ� 0.6�� �ƴ϶� 0�� ���ͼ� �˻��� �ô���,
	
	//�Ҽ������� ������ �Ϸ��� ���ڶ� �и��� �ϳ��� float�̿��� �ϰ�, �޴� ������ Ÿ���� double�̸� �ȴٳ�
	
	//66 / 66 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 39.4 MB
    public boolean checkStraightLine(int[][] coordinates) {
    	double slant = (coordinates[1][1] - coordinates[0][1]) / (float)(coordinates[1][0] - coordinates[0][0]);
        
        for(int i = 1; i < coordinates.length; i++){
            float x_ = (float)(coordinates[i][0]-coordinates[i-1][0]);
            int y_ = coordinates[i][1]-coordinates[i-1][1];
            if(y_/x_ != slant) return false;
        }
        return true;
    }
    
    
    
    //<����Ǯ��2 by 
    
    //���� ����
    
    //(y - y1) / (x - x1) = (y1 - y0) / (x1 - x0) 
    
    //�̰�
    
    //(x1 - x0) * (y - y1) = (x - x1) * (y1 - y0)
    
    //�̰Ŷ� ���� �̰�
    
    //dx * (y - y1) = dy * (x - x1), where dx = x1 - x0 and dy = y1 - y0
    
    //�̰Ŷ� �����ϱ�, �������Ҷ� Ÿ���� double�� ���� float���� ������� ���� �� ������ ���� ��
    
    //�� ����� ����Ǯ��1���� �� ������, division by zero������ ���� �� ����

	//66 / 66 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 38.9 MB
    
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], 
            x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}
