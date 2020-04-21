package thirtyDayChallenge;

import java.util.List;

public class LeftMostColumnWithAtLeastaOne {

//	interface BinaryMatrix {
//		public int get(int x, int y) {}
//		public List<Integer> dimensions(){}
//	};
	
	//<����Ǯ��1>
	
	//�̰Űŵ�
	
	//binary search
	
	//�ϴ� �߰� column�� ��ĵ ��.
	
	//��ĵ�ߴµ� 1�� ������ �������� ��ĵ��. left most�� ��ĵ�� ����+1�� ��Ƽ�.
	
	//��ĵ�ߴµ� 1�� ������ ���ʿ� �� ���� �� �����ϱ� right most�� ��ĵ�� ���� -1�� ��Ƽ� �ٽ� ��ĵ�غ�.

	//37 / 37 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 40.1 MB
	
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> xy = binaryMatrix.dimensions();
		int n = xy.get(0);
		int m = xy.get(1);

		int l = 0;
		int r = n;
		int mid;
		int rst = -1;
        
		while(l<=r) {
			mid = (l+r)/2;
			int i = 0;
            if(l == r && rst == -1) return -1;
			while(i < n) {
				if(binaryMatrix.get(i, mid) == 1){
                    rst = mid;
                    break;
                }
				i++;
			}
			if(rst == mid) {
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		
		return rst;
	}
}
