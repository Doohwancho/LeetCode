package array;

public class LongestTurbulentSubarray978 {
	
	//<����Ǯ��1>
	
	//�̰���
	
	//Runtime: 4 ms, faster than 95.62% of Java online submissions for Longest Turbulent Subarray.
	//Memory Usage: 43.9 MB, less than 62.50% of Java online submissions for Longest Turbulent Subarray.
    public static int maxTurbulenceSize(int[] A) {
        boolean flag = true; int t1 = 1, t2 = 1, rst = 1; // t1�� ><><>... t2�� <><><... 1 <= A.length <= 40000�ϱ� �ּ� �ϳ��� �ִٴ� ���̹Ƿ� t1,t2,rst�� 1�� ����
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1]){
                if(flag){ //t1�� ><><>�� �ɼ��� �ְ�, t2�� ><><>�� �ɼ��� �ִ°� flag�� ���� ����.
                    t1++;
                    t2 = 1;
                    flag = false;
                } else {
                    t2++;
                    t1 = 1;
                    flag = true;
                }
            } else if(A[i] < A[i-1]){
                if(flag){
                    t2++;
                    t1 = 1;
                    flag = false;
                } else {
                    t1++;
                    t2 = 1;
                    flag = true;
                }
            } else { //�����ſ� ������ �Ѵ� 1�� �ʱ�ȭ
                t1 = 1;
                t2 = 1;
            }
            rst = Math.max(rst, Math.max(t1, t2));
        }
        return rst;
    }
    
    public static void main(String[] args) {
//		int[] test = new int[] {9,4,2,10,7,8,8,1,9};
    	int[] test = new int[] {4,8,12,16};
		System.out.println(maxTurbulenceSize(test));
	}
}
