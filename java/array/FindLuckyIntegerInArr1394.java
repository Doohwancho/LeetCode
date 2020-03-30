package array;

import java.util.Arrays;

public class FindLuckyIntegerInArr1394 {
	
	//<����Ǯ��1>
	
	//�ϴ� �ڼ��ΰ� �������� �����ϰ�,
	
	//�� �ڿ������� lucky �������� ���µ�,
	
	//���� [...3,3,3] �̶��, �� ��3�� �ε����� 5��� �ϸ�, ù��° 3�� �ε����� 
	
	//�� ���� 3�� �ε��� - 3 + 1
	
	//�̰� �ϴ� �´��� Ȯ���ϰ�, �´ٸ� �̰�
	
	//[...3,3,3,3,3,3]�̶� �ɸ�����, �ƴϸ�
	
	//[...2,3,3,3] ó�� lucky�ѹ��� �ɸ����� �� ���� if������ Ȯ��
	
	//���� 3�� lucky�ѹ��� �ƴϿ��ٸ�, �ش� ���ڴ� ���̻� �� �ʿ� �����Ƿ� while������ �ǳʶپ���
	
	//�� int[]�� �ھƳ��� �ڿ������� ī�����Ҳ� �׷���
	
	//Runtime: 1 ms, faster than 99.90% of Java online submissions for Find Lucky Integer in an Array.
	//Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Find Lucky Integer in an Array.
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        for(int i = arr.length-1; i >= 0; i--){
            int n = arr[i];
            if(i-n+1 >= 0 && n == arr[i-n+1]){
                if(i-n < 0 || (i-n>=0 && n != arr[i-n])){
                    return arr[i];
                }
            }
            while(i > 0 && arr[i] == arr[i-1]){
                i--;
            }
        }
        return -1;
    }
}
