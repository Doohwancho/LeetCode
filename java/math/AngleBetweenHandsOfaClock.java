package julyChallenge;

public class AngleBetweenHandsOfaClock {

	//<����Ǯ��1>
	
	//minutes/60�ϸ� 60�� �ƴ��̻� 0�ۿ� �ȳ��ͼ�, ����ȯ���Ἥ ��ȸ��.
	
	//Runtime: 0 ms
	//Memory Usage: 38.7 MB
	
    public double angleClock(int hour, int minutes) {
        double h = ((30 * hour) + (30 * ((double)minutes/60))) % 360;
        double m = 6 * minutes;
        return Math.abs(h-m) < 180 ? Math.abs(h-m) : 360 - Math.abs(h-m);
    }
    
    
}
