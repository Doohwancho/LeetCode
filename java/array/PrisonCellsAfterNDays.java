package julyChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
	
	//<Trial01 - time limit exceeded>
	
	//brute-force
	
	//game of life�ε�
	
	//�̰� N�� ������ prediction�� ������ �ſ���?
	
	//���� ������ �����������ϱ� �����ҰŰ��� �ѵ� ����?
	
    public int[] prisonAfterNDays(int[] cells, int N) {
        while(N > 0){
            for(int i = 1, i_ = 0, j = cells[0]; i < cells.length-1; i++){
                i_ = cells[i];
                cells[i] = j ^ cells[i+1] ^ 1;
                j = i_;
            }
            cells[0] = cells[cells.length-1] = 0;
            N--;
        }
        return cells;
    }
    
    
    //<����Ǯ��1 by lee215>
    
    //�;� �Ƕ��ΰ�
    
    //cells�� ��� �ٲ�°� Arrays.toString���� map�� �ھƳְ�
    
    //�Ȱ����� �ǳ�����, (������ ���� ��° - N)�ؼ� �������� N���� �� ��� �ɷ��� ���ڸ��� ���ư����� �ľ��ϰ�
    
    //�װ� ���� N���� ������ŭ ���� ��, �������� ����.
    
    //Arrays.toString()�� ���⿡ ����. ��������
    
    //Runtime: 9 ms
    //Memory Usage: 41.8 MB
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }
    
    //<����Ǯ��2 by lee215>
    
    //�ݺ��Ǵ� ������ ã�ҵ�.
    
    //��� ã�ҳİ�?
    
    //lee215's avatar
//    lee215
//    January 9, 2019 2:38 PM
//
//    Read More
//    I brute force all cases.
    
    //�밡�� �ߵ� ����
    
    //1��°, 7��°, 14��°�� �Ȱ��� �ݺ��ȵ�
    
    //�̸��� 1��° �ݺ��Ǵ� �ֵ� 7��° �ݺ��Ǵ� �ֵ� 14��°�� ������ �ݺ��ȴٴ� ���̴ϱ�,
    
    //%14�� �ݺ��Ǵ¾ֵ� �ڸ��� ������ �ֵ鸸 game of life�� ������ �ȵ�
    
    //�ݺ��Ǵ� ���� ã���� ������� ��
    
    //Runtime: 1 ms
    //Memory Usage: 40.3 MB
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        for (N = (N - 1) % 14 + 1; N > 0; --N) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        return cells;
    }
}
