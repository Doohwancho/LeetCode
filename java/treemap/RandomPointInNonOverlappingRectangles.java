package augustChallenge;

import java.util.Random;
import java.util.TreeMap;

	class Solution {

	    Random rand;
	    Random rand2;
	    int n = 0;
	    int[][] c;
	    
	    public Solution(int[][] rects) {
	        rand = new Random();
	        rand2 = new Random();
	        n = rects.length;
	        c = rects;
	    }
	    
	    public int[] pick() {
	        int[] obj = c[rand.nextInt(n)];
	        int minX = obj[0];
	        int maxX = obj[2];
	        int minY = obj[1];
	        int maxY = obj[3];
	        
	        int xRange = Math.abs(Math.abs(maxX)-Math.abs(minX));
	        int yRange = Math.abs(Math.abs(maxY)-Math.abs(minY));
	        
	        return new int[] {
	            xRange == 0 ? minX : minX + rand2.nextInt(xRange), //rand.nextInt(0)�ϸ� ������. java.lang.IllegalArgumentException: bound must be positive
	            yRange == 0 ? minY : minY + rand2.nextInt(yRange)
	        };      
	    }
	}
	
	
	//<����Ǯ��1 by wangzi6147>
	
	//treemap
	
	//Runtime: 59 ms
	//Memory Usage: 46.5 MB

	import java.util.Random;

	class Solution {

	    int[][] rects;
	    Random rand;
	    TreeMap<Integer, int[]> tm;
	    int area = 0;
	    
	    
	    public Solution(int[][] rects) {
	        this.rects = rects;
	        rand = new Random();
	        tm = new TreeMap<>();
	        
	        for(int[] rect : rects){
	            area += (rect[2]-rect[0]+1) * (rect[3]-rect[1]+1); //+1���ִ� ������ ������ 0�̸� �ݴ����� ���� ���̰� 0�Ǵϱ�.
	            tm.put(area, rect); //�������� �־���� rand.nextInt(area)���� �յ��ϰ� ����
	        }
	    }
	    
	    public int[] pick() {
	        int randomPointInRect = rand.nextInt(area);
	        int targetRect = tm.higherKey(randomPointInRect);
	        int[] targetRectCoord = tm.get(targetRect);
	        return new int[]{
	        	targetRectCoord[0] + (targetRect - randomPointInRect - 1) % (targetRectCoord[2] - targetRectCoord[0] + 1), //targetRectCoord[0] + (targetRect - randomPointInRect - 1) / (targetRectCoord[3] - targetRectCoord[1] + 1),  �̷��� �ؾ� ��Ȯ�� x���� ���;� �� �� ������, �׷����ϸ� pass�ȵ�. 
	            targetRectCoord[1] + (targetRect - randomPointInRect - 1) / (targetRectCoord[2] - targetRectCoord[0] + 1)        
	        };
	        /*
	                return new int[]{
			            targetRectCoord[0] + (targetRect - randomPointInRect - 1) / (targetRectCoord[3] - targetRectCoord[1] + 1),
			            targetRectCoord[1] + (targetRect - randomPointInRect - 1) % (targetRectCoord[3] - targetRectCoord[1] + 1)        
			        };
	        		
	        		(x2-x1)���� �̷��� �ݴ�� �ص� �Ǳ� �ϴµ�, (y2-y1)
	        		�� �������ΰ���
	        		�
	        		
	        		Serialize a point (x,y) in the rectangle to an integer:

						Points can be mapped row by row, from bottom to top;
						In each row, there are width points;
						So point (x,y), can be mapped as follows:
						id = number-of-rows * width + index-in-the-last-row, or id = (y-y0) * width + (x - x0)
						So (y-y0) = id / width, (x-x0) = id % width

					---
					��
					
					targetRectCoord[0]�� ���� ���� �簢���� x1�̰�
					targetRect�� �� �������� ū �簢���� �����ε�
					�� ������ ���̰� (targetRect - randomPointInRect - 1),
					�ٵ� �� ������ ���̴� ���� ���簢���� x������ ��� �� ���ݾ�?
					�׷��� ���� ���簢���� ����(width)�� (targetRectCoord[2] - targetRectCoord[0] + 1) �� %���ָ�
					���� ���簢�� ����(targetRectCoord[2] - targetRectCoord[0] + 1) ���� ���ϴ� ���� ������ ���� ��������?
					�װ� x1�� ���� �Ʒ� �������� targetRectCoord[0]�� �����ִ°Ű�.
	         */
	    }
	}
}
