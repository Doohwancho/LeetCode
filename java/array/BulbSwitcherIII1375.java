package array;

public class BulbSwitcherIII1375 {
	
	/*
	//<����Ǯ��1>
	
	//ũ...ũ��....
	
	//"����"�� ��..."power"��...ũ...ũ��...
	
	//"�ý�"�ϱ��� �ⷡ...ũ...ũ��
	
	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Bulb Switcher III.
	//Memory Usage: 51.6 MB, less than 100.00% of Java online submissions for Bulb Switcher III.
	
	public static int numTimesAllBlue(int[] light) {
        //light = [3,2,4,1,5]
        //00100
        //01100
        //01110
        //22220
        //22222
		
        int highest = 0;
        int cnt = 0; //3�̸� 3���� ���� �� 1,2�� ���ö����� ��鼭 0�϶� rst+1����
        int rst = 0;
        
        for(int ele : light){
            if(ele > highest){
                int prev_highest = highest;
                highest = ele;
                if(cnt == 0 && ele == (prev_highest+1)){ //[3,2,1,4,7, ...]����, 1���� 4�� �Ѿ�� ���� ���� ���� �׳� +1�ȰŴ�, cnt�� 0���� �����Ͽ� cnt���� ���� rst+1�ϰ� ����
                    cnt = 0;
                } 
                else { 
                	//prev_highest == 0�� ���� ó�������� ��. �̶� cnt�� ele-1���ִµ�, ������ ele�� 3�̸� 2(3-1)�� �ؾ�, 1�̶� 2�������� cnt�� �ι���� rst�� +1�Ǳ� ����.
                	//���� index0�� �ƴ϶��, ������� [3,2,1,4,7, ...]���� 4->7�� �Ѿ��, ������ 5,6 �ι��� �� ������ �Ǵϱ�, 7-4-1�ؼ� 2�� ����. 
                	//prev_highest�� 0�� �ƴ� ��Ȳ����, ������� [3,1,5,..]���� 1->5�� �Ѿ ��, 2�� ���� �ȳ��Ա� ������, ���� cnt(1)+ ������ �ʿ��� cnt(5-3-1 == 1) �ؼ� 2�� ���
                    cnt = prev_highest == 0 ? ele-1: cnt + (ele - prev_highest - 1);
                }
            }
            else{
                cnt--; //���࿡ highest���� �������ڰ� �������� cnt�� �ϳ� ���ش�.
            }
            if(cnt == 0){ //cnt�� 0�̸� ������ ��� ���, �ش� ���� �������� ��� ���� �����ٴ� ���̹Ƿ� rst+1
                rst++;
            }
        }
        return rst;
	}
	*/
	
	//<����Ǯ��2 by lee215>
	
	//����.. �ٴ³����� ���³��ֱ���
	
	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Bulb Switcher III.
	//Memory Usage: 50.7 MB, less than 100.00% of Java online submissions for Bulb Switcher III.
	
    public static int numTimesAllBlue(int[] A) {
        int right = 0, res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, A[i]);
            if (right == i + 1) ++res; //i+1���� ���������� ���Դ� ���� �߿� ���� ū��(right)�� i+1�� ���ٸ�, ������ ��� �Ǿ��� �ش� �ε������� ������ ��� ������ ���� ���� ���̴�.
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] test = new int[] {3,2,4,1,5};
		System.out.println(numTimesAllBlue(test));
	}
}
