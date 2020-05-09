package array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumOfCandies1431 {
	
	//<����Ǯ��1>
	
	//���� for���� ���鼭, ���� ���� ���� �ְ� ��� �ľ�
	
	//�ι�° for�� ���� ���� �� �� �ִ� ĵ���� �ִ뷮(extraCandies)�� ���� ���̰����ֲ��� ���̸�ŭ Ŀ�� �������� ����, 
	
	//3�׿����� �̿��ؼ� ������ true, �ƴϸ� false ����
	
//	Runtime: 0 ms
//	Memory Usage: 39.2 MB
	
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> rst = new ArrayList<>();
        int max = -1;
        for(int c : candies) max = Math.max(max, c);
        for(int i = 0; i < candies.length; i++){
            rst.add(max-candies[i] <= extraCandies ? true : false);
        }
        return rst;
    }
}
