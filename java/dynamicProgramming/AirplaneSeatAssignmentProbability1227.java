package dynamicProgramming;

public class AirplaneSeatAssignmentProbability1227 {

	//<����Ǯ��1 by rock>
	
	//������ ����.
	
	//�ٵ� brain-teaser�������� �����ϸ� �� n>=2 �϶� ���� 1/2�� �� �� �ۿ� �������� �˰ڴ�.
	
	//ù��° ����� �����ϰ� �ڸ��� �ɴ´�. �� �ڸ��� �ȾɾҴٰ� ��������.
	
	//�׷� �ι�°, ����° �°��� �ͼ� �ڸ��� �ɴٰ�, �ڱ��ڸ��� ù��° ����� �ɾ��ֳ�? �ϸ�, �i�Ƴ��� �ڱ��ڸ��� �ɴ´�.
	
	//(���������� �ڱ� �ڸ��� �ɾ��ִ� ù��° �°��� �i�Ƴ��°� �ƴ϶�, ��? �� �ڸ��� �����? �ϰ� �ٸ� ������ �ڸ��� �ɴ� ������ �Ǿ��ִ�.
	
	//�׷���, �̷��� �����ϴ� �� ����, �ڱ� �ڸ��� ã������, ù��° �°��� �i�Ƴ���, ù��° �°����� �ٸ� �ڸ��� �����ϰ� ����� �ϴ°� �� �����ϱ� �����ϴ�.)
	
	//�׷��� �̸��i��� ���� �i��� ù��° �°���, ������ n��° �մ��� ���� ��, �����ڸ��� ù��° �°��� �ڸ�, ������ �°��� �ڸ��ۿ� �ȳ��� �����Ƿ�,
	
	//n��° �մ��� �ڸ��� ù���� �մ��� �ɾ����� Ȯ���� 1/2�̴�.
	
	//Runtime: 36 ms, faster than 6.90% of Java online submissions for Airplane Seat Assignment Probability.
	//Memory Usage: 44.7 MB, less than 7.76% of Java online submissions for Airplane Seat Assignment Probability.
	
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1.0d;
        return 1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
    }
}
