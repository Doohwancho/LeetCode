package september;

public class RobotBoundedInCircle {
	
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 3 ms
	//Memory Usage: 39 MB

    public boolean isRobotBounded(String instructions) {
        int[] cur = new int[2];
		
		int[][] directions = new int[4][2];
		directions[0] = new int[] {-1,0};
		directions[1] = new int[] {0,1};
		directions[2] = new int[] {1,0};
		directions[3] = new int[] {0,-1};
		
		for(int i = 0, dir = 1; i < 4; i++) {
            for(int j = 0; j < instructions.length(); j++){
                if(dir == 4) {
                    dir = 0;
                } else if(dir == -1) {
                    dir = 3;
                }
                
                if(instructions.charAt(j) == 'L'){
                    dir--;
                } else if(instructions.charAt(j) == 'R'){
                    dir++;
                } else {
                    cur[0] += directions[dir][0];
                    cur[1] += directions[dir][1];
                }
            }
            if(cur[0] == 0 && cur[1] == 0) return true;
		}
        return false;
    }
    
    //<����Ǯ��2 by lee215>
    
    //���ڸ��� ���ƿ� ���(x == 0 && y == 0)�� ���������� ���صǴµ�,
    
    //���ڸ��� ���ƿ��� �ʾҴµ�, ������ �ȹٶ� ���, 4�� ���� iterate�ȿ� ������ ���ڸ��� ���ƿ´ٴ� �� ��� ��������?
    
    //Runtime: 0 ms
    //Memory Usage: 39.4 MB
    
    public boolean isRobotBounded(String ins) {
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0; 
    }
}
