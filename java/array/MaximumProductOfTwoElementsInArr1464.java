package array;

public class MaximumProductOfTwoElementsInArr1464 {
	//<����Ǯ��1>
	
	//�� ū�� �ΰ��� ���ؾ� �ϴϱ�, ���� a,b�������ְ�
	
	//a�� ù��°�� ū ��, b�� �ι�°�� ū����� ������ ��,
	
	//nums�� iterate�ϸ鼭 ������ ���ڵ���, �ϴ� �ι�° ������ ���ų� ū�� Ȯ��.
	
	//���ų� ũ�ٸ�, �������� ���� ū �� a���� ū�� Ȯ��.
	
	//a���� ũ��, a�� b�� �ű� ��, a�� �� ū���� ������Ʈ ��Ű��,
	
	//a���� �۴ٸ�, b�� ������Ʈ ����.
	
	//nums�� ������ ��� ���ڵ��� ������̶�, ������ ���������� �ʾ���. ���� ������ ���Դٸ�,
	
	//�������� ���ϴ°Ŷ� ������� ���ϴ°Ŷ��� ����ؾ� �߾����ٵ�.
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Product of Two Elements in an Array.
	//Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Maximum Product of Two Elements in an Array.
	
    public int maxProduct(int[] nums) {
        int a = 0;
        int b = 0;
        for(int n : nums){
            if(n >= b){
                if(n >= a){
                    b = a;
                    a = n;
                } else {
                    b = n;
                }
            }

        }
        return (a-1)*(b-1);
    }
}
