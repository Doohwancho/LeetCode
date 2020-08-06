package augustChallenge;

public class FindAllDuplicatesInArr {
	
	//<����Ǯ��1>
	
	//� ȫ�뺴 �ɷȳ� ����� ������ �� bitmask���� �����ϰ�����
	
	//Runtime: 7 ms
	//Memory Usage: 63.8 MB
	
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        int[] a = new int[nums.length+1];
        for(int n : nums){
            a[n]++;
            if(a[n] > 1){
                rst.add(n);
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by YuxinCao>
    
    //� ������ Ǯ�����µ� �� ������
    
    //https://www.youtube.com/watch?v=aMsSF1Il3IY&feature=youtu.be
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i])-1; //�ǳ����� �ִ� ���̳ʽ� ���̴ϱ� Math.abs()
            
            if(nums[idx] < 0){ //idx�� 3 �ѹ� ������ -�� �ٲٰ���. �׷���  �ι�° �������� ���̳ʽ� �����״ϱ�
                rst.add(idx+1);  //idx+1�� ������. ���� nums[i]�� idx+1�̴ϱ�.
            }
            
            nums[idx] = -nums[idx];
        }
        return rst;
    }
    
   
}
