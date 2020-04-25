package thirtyDayChallenge;

public class JumpGame {
	
	//<����Ǯ��1>
	
	//75 / 75 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 41.1 MB
	
    public boolean canJump(int[] nums) {
        for(int i = 0, maxJump = 0; i < nums.length; i++){
            maxJump = Math.max(maxJump, nums[i] + i);   //���� ��ġ�� ���� �ִ� ������ �� �ִ� �ε��� �� loop���� ������Ʈ
            if(i < nums.length-1 && maxJump == i) return false; //���� i�� �������� �ƴѵ�, �ִ�� ������ �� �ִ� �ε����� ���� ��ġ�� i���, ���̻� �� �� ���ٴ� ���̹Ƿ� return false
        }
        return true; //������ ������ return true
    }
}
