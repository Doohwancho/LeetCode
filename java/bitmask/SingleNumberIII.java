package julyChallenge;

public class SingleNumberIII {
	
	//<����Ǯ�� by zhiqing_xiao>
	
	//�ȶ��ϳ� ���˷�ٰ�
	
	//Runtime: 1 ms
	//Memory Usage: 42.1 MB
	
    public int[] singleNumber(int[] nums) { 
        if (nums == null || nums.length < 2) return new int[0];
        int t = 0; 
        for (int n: nums) t ^= n; //t = a^b
        t &= -t;  //find the least significant different bit between a and b.
        
//      System.out.println(7&-7); //1
//		System.out.println(Integer.toBinaryString(7)); //111
//		System.out.println(Integer.toBinaryString(-7)); //11111111111111111111111111111001
//		System.out.println(Integer.toBinaryString(1)); //1
//		
//		System.out.println(10&-10); //2
//		System.out.println(Integer.toBinaryString(10)); //1010
//		System.out.println(Integer.toBinaryString(-10)); //11111111111111111111111111110110
//		System.out.println(Integer.toBinaryString(2)); //10
//		
//		System.out.println(8&-8); //8
//		System.out.println(Integer.toBinaryString(8)); //1000
//		System.out.println(Integer.toBinaryString(-8)); //11111111111111111111111111111000
//		System.out.println(Integer.toBinaryString(8)); //1000
        
        //�ϴ� a^b�� a�� b�� bitwise ���̾�. ���� t(==a^b)�� 0�̸�, ���� ���̰� ���ٴ� ���̴ϱ�, a�� b�� ���� ���ڰ� �ǰ���.
        
        //t�� a^b�� ���� ���� bit���ݾ�?. t�� a�� b�� �����߿� ���� ���� ��Ʈ��
        
        //�׷��� t�� a�� b�� �����߿� ���� ���� ��Ʈ��� �����ϱ�, 
        
        //a^t�ϰ� b^t������ ���� �ϳ��� 0���� ũ��, �������� 0�� ��������?
        
        //�׷� a^num[i]�̶� b^num[i]�� ��� �����ϴ���.
        
        //num[i]�� �� �׷����� �����°�, ���� �ݹ� �� ������ ���� �ʿ䰡 ����
        
        //���� t&n > 0�̸�, �ֱ���â �� if�� �� ���� ����.
        
        //�׷��� �������. ��׷��� ���ʿ� �򸮵� ��¥�� ������ xor�ϸ� 0�Ǵϱ�.
      
        int[] ret = new int[2];
        for (int n: nums) {
            if ((t & n) > 0) ret[0] ^= n;
            else ret[1] ^= n;
        }
        return ret;
    }
	
	
}
