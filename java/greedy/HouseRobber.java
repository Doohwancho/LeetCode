package september;

public class HouseRobber {
	
	//<����Ǯ��1 by jianchao-li>
	
	//pre�� i-2���� �ִ�
	
	//cur�� i-1���� �ִ�
	
	//temp�� (i-2 + i)�� (i-1)�� ���� �ִ�
	
	//temp�� ���Ӱ� ���ŵǸ�, ������°�� �Ѿ�� �ϴϱ�, 

	//pre = cur; cur = temp;�ؼ� �ڷ� ��ĭ�� �о���
	
	//Runtime: 0 ms
	//Memory Usage: 37.1 MB
	
    public int rob(int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            final int temp = Integer.max(pre + num, cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
