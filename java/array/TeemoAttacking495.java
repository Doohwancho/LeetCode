package array;

public class TeemoAttacking495 {
	
	//<����Ǯ��1>
	
	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Teemo Attacking.
	//Memory Usage: 41.6 MB, less than 11.11% of Java online submissions for Teemo Attacking.
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //��ȿ���˻�
        if(timeSeries.length == 0) return 0;
        
        int posTime = 0;
        for(int i = 1; i < timeSeries.length; i++){
            if((timeSeries[i-1]+duration) <= timeSeries[i]){ //i�� i-1���� ���̰� duration���� �� Ŭ ���, poison�� �� ���� ��, ������ ���� ������, �׳� poison�� �ɸ��� �ð��� ������
                posTime += duration;
            }
            else{
                posTime += (timeSeries[i]-timeSeries[i-1]);//timeSeries==[1,2], duration=2 �� ���, 1->2���� �Ѿ ��, 2���� poison�� ����� �ϴϱ� �տ����� �ڿ��� ���̸�ŭ ���ָ� ��
            }
        }
        return posTime+duration; //�� �������� ��� ���� poison ������ �¾ƾ� �ϱ� ������, �� �ð��� ������
    }

}
