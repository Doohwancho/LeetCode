package augustChallenge;

import java.util.LinkedList;

public class LargestTimeForGivenDigits {

	
    //<Trial01>
	
	//brute-force
	
	//[0,6,2,6]���� ����
	
	//06:26�ؾ� �ϴµ�,
	
	//20:6 ���� return ""�ع�����..
	
    private int visited(int[] A, int digit, int limit){
        for(int i = 0, j = -1; i < A.length; i++){
            if(A[i] <= limit && A[i] > digit){
                if(j != -1){
                    A[j] = digit;
                }
                j = i;
                digit = A[i];
                A[i] = -1;
            }
        }
        return digit;
    }
    
    public String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();
        
        int first = visited(A, -1, 2);
        
        if(first == -1){
            return "";
        } else {
            sb.append(first);
        }
        
        
        if(first == 2){
            int second = visited(A, -1, 3);
            
            if(second == -1){
                return "";
            } else {
                sb.append(second);
                sb.append(':');
            }
        } else {
            int second = visited(A, -1, 9);
            
            sb.append(second);
            sb.append(':');
        }
        
        int third = visited(A, -1, 5);
        
        if(third == -1){
            return "";
        } else {
            sb.append(third);
        }
        
        for(int i = 0; i < A.length; i++){
            if(A[i] != -1){
                sb.append(A[i]);
                break;
            }
        }
        
        return sb.toString();
    }
    
    
    //<����Ǯ��1 by ambuj_kumar>
    
    //brute-force
    
    //A���� ���� �� �ִ� ��� ����� ���� �� �ð����� �ٲ㼭 Math.max()�ϴ� ���
    
    //00:00 ���� ���ų� ũ�� 23:59���� ���ų� ������ ���ڸ� �ٽ� STring���� ��ȯ�ؼ� ����. 
    
    //Runtime: 9 ms
    //Memory Usage: 38.1 MB
    
    public String largestTimeFromDigits(int[] A) {
        int[][] sequences = new int[][]{
            {0, 1, 2, 3},
            {0, 1, 3, 2},
            {0, 2, 1, 3},
            {0, 2, 3, 1},
            {0, 3, 1, 2},
            {0, 3, 2, 1},
            {1, 0, 2, 3},
            {1, 0, 3, 2},
            {1, 2, 0, 3},
            {1, 2, 3, 0},
            {1, 3, 0, 2},
            {1, 3, 2, 0},
            {2, 0, 1, 3},
            {2, 0, 3, 1},
            {2, 1, 0, 3},
            {2, 1, 3, 0},
            {2, 3, 0, 1},
            {2, 3, 1, 0},
            {3, 0, 1, 2},
            {3, 0, 2, 1},
            {3, 1, 0, 2},
            {3, 1, 2, 0},
            {3, 2, 0, 1},
            {3, 2, 1, 0}
        };
        
        int i, j;
        int max = -1;
        for(i = 0; i < 24; i++){
            max = Math.max(max, getMinutes(A[sequences[i][0]], A[sequences[i][1]], A[sequences[i][2]], A[sequences[i][3]]));
        }
        
        if(max < 0)
            return "";
        else{
            int minutes = max % 60;
            int hours = max / 60;
            
            String result = "";
            if(hours < 10)
                result += "0" + hours;
            else
                result += hours;
            
            result += ":";
            
            if(minutes < 10)
                result += "0" + minutes;
            else
                result += minutes;
            
            return result;
        }
    }
    
    private int getMinutes(int a, int b, int c, int d){
        int hours = 10*a + b;
        int minutes = 10*c + d;
        
        if(hours < 0 || hours > 23 || minutes < 0 || minutes > 59)
            return -1;
        else
            return (60 * hours + minutes);
    }
    
    
    //<����Ǯ��2 by rock>
    
    //brute-force
    
    //����Ǯ��1�� �Ȱ��� �����ε�, �ڵ��� �縸 ���̰� �������� ���� ����.
    
    //String ���ϱ� �峭���� �����ϰ� .compareTo()�峭���� �����ؼ� ����Ǯ��1���� ������ ����.
    
    //Runtime: 20 ms
    //Memory Usage: 40.5 MB
    
    public String largestTimeFromDigits(int[] A) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
                    String h = "" + A[i] + A[j], m = "" + A[k] + A[6 - i - j - k], t = h + ":" + m; // hour, minutes, & time.
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) ans = t; // hour < 24; minute < 60; update result.
                }
            }
        }
        return ans;
    }
    
    
    //<����Ǯ��3 by Self_Learner>
    
    //backtracking
    
    //�ȶ��ϱ���
    
    //Runtime: 13 ms
    //Memory Usage: 37.7 MB
    
    String time;
    int[] max = {2, 3, 5, 9}; //�� �ð��� �ڸ��� �ִ�ġ�� ���س��� �̰� �̻��̸� �Ѿ.
    
    public String largestTimeFromDigits(int[] A) {
        
        int[] cur = new int[4];
        Arrays.fill(cur, -1);
        
        findLargest(A, new boolean[4], cur, 0);
        return time == null ? "" : time;
    }
    
    private void findLargest(int[] A, boolean[] used, int[] cur, int pos) {
        if (pos == 4) { //�ð� 4�ڸ����� �� ä�����ٸ�,
            String s = "" + cur[0] + cur[1] + ":" + cur[2] + cur[3];
            if (time == null || time.compareTo(s) < 0) { //time�� �ִ����� �����ϰ� return
                time = s;
            }
            return;
        }
        if (pos == 1) {
            if (cur[0] == 1 || cur[0] == 0){
                max[1] = 9; //23:59���� �ι�° �ڸ��� ù��° �ڸ��� 2�϶� 3�� �ִ�ġ������, 0�̳� 1�϶��� 9�� �ִ�ġ �̱� ������ ������Ʈ.
            } else if (cur[0] == 2) {
                max[1] = 3;
            }
        }
        for (int j = 0; j < 4; j++) {
            if (used[j] || A[j] > max[pos]) continue; //�� �ڸ��� �ִ�ġ �̻��̸� �Ѿ.
            cur[pos] = A[j];
            used[j]  = true;
            findLargest(A, used, cur, pos + 1);
            cur[pos] = -1; //[0,1,2,3] ������� �� ��ٸ�, [0,1,2,?] -> [0,1,?,?] -> [0,1,3,2] (if used[j]���� �̹� ���Ȱ� �ɷ����� ����)  
            used[j] = false;
        }
    }
    
    
    
    //<����Ǯ�� 4 by tyuan73>
    
    //backtracking
    
    //�굵 ���� �Ź��Ѱ�, ����Ǯ��3������ A�� ��� ����� ���� ���鼭
    
    //�� �ڸ����� ���ٵ��� ������ �����ؼ� 4*3*2*1 = 24���,
    
    //��� �ð� 24���߿� �Ǵ¾� * �� 60���߾� �Ǵ¾� �ؼ� 1440�� ����.
    
    //���� �굵 ���ǿ� �´¾ָ� ���ұ� ������, ����Ǯ��3�� ū ���̴� ����.
    
    //Runtime: 17 ms
    //Memory Usage: 39.7 MB
    
    public String largestTimeFromDigits(int[] A) {
        int[] count = new int[10];
        for(int a : A) count[a]++;
        for(int i = 23; i >= 0; i--) {
            int a = i / 10, b = i % 10;
            count[a]--;
            count[b]--;
            if (count[a] >= 0 && count[b] >= 0) {
                for(int j = 59; j >= 0; j--) {
                    int p = j / 10, q = j % 10;
                    count[p]--;
                    count[q]--;
                    if (count[p] >= 0 && count[q] >= 0)
                        return a + "" + b + ":" + p + "" + q;
                    count[p]++;
                    count[q]++;
                }
            }
            count[a]++;
            count[b]++;
        }
        return "";
    }
    

}
