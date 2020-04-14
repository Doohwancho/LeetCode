package thirtyDayChallenge;

public class PerformStringShifts {
	
	/*
	//<����Ǯ��1>
	
	//31 / 31 test cases passed.
	//Status: Accepted
	//Runtime: 0 ms
	//Memory Usage: 37.3 MB
	
    public String stringShift(String s, int[][] shift) {
    	//step01 : �������� ����������, �������̸� ��ĭ�� ������� ���Ѵ�.
        int dir = 0;
        
        for(int i = 0; i < shift.length; i++){
            if(shift[i][0]==0){
                dir-=shift[i][1];
            } else {
                dir+=shift[i][1];
            }
        }
        
        //step02 : dir���� -�� ����, +�� ������. �ű⿡ ���缭 stringbuilder�� �̿��Ͽ� string�� �߶� �̾�����.
        StringBuilder sb = new StringBuilder();
        int move = dir%s.length();
        char[] sChar = s.toCharArray();
        
        if(move<0) {
			sb.append(sChar, -move, s.length()+move).append(sChar, 0, -move);
		} else {
			sb.append(sChar, s.length()-move, move).append(sChar, 0, s.length()-move);
		}
        return sb.toString();
    }
    */
	
    
    //<����Ǯ�� by rock>
    
    //���� ����, �� ����� �ڵ�
    
    public String stringShift(String s, int[][] shift) {
        int pos = 0, len = s.length();
        for (int[] sh : shift) {
            pos += sh[0] == 0 ? sh[1] : -sh[1];
        }
        pos = (pos % len + len) % len;
        return s.substring(pos) + s.substring(0, pos); //"unhappy".substring(2) returns "happy"
    }
}
