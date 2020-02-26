package array;

public class MyCalendarI729 {
    
	/*
	//<Trial01 - memory limit exceeded>
	
	//start and end are integers in the range [0, 10^9]. ��淡 new int[1000000000]�����ߴµ� �ȵǳ�.
	 
	//�� �׳� ��ǻ�� �������� �缭 ���� �ȵų�
	
	
	//book�Ҷ� �� ������ ��ġ�� double booking�� �Ǵ°��̶�, �� ������ ������ booking�س����͸� ��ġ���� Ȯ���ϸ� ��.
	
	//���� �����ִٸ� false�� ��ȯ�ϰ�, �������� �ʴٸ�, starting point�� ending point�� üũ�س��� true��� �ϴ� ��ȯ��.
	
	//��ȯ �ϰ� ���� ����������  reordering()�� ����, üũ�س��� ���� ���� ���ڵ��� 1�� �ٲٰ� �ͱ� �ѵ�,
	
	//���������� ���Բ��ϴ°� �����Ƿ�, �ϴ� else���� return ���� �־����.
	
	int[] container = new int[100000000];
    
	public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
    	if(this.container[start] > 0 || this.container[end-1] > 0){
            return false;
        }
        else{
            this.container[start]++;
            this.container[end]--;    
            reordering(start, end);
            return true;
        }
    }
    
    private void reordering(){
        for(int i = start+1; i < end+1; i++){
            this.container[i] += this.container[i-1];
        }
    }
    */
	
	/*
	//<����Ǯ��1 by alexander>
	
	//[3,7], [start = 5, end = 10] -> false
	
	//[3,7], [start = 8, end = 10] -> true
	
	//����
	
	//Runtime: 75 ms, faster than 24.64% of Java online submissions for My Calendar I.
	//Memory Usage: 42.1 MB, less than 100.00% of Java online submissions for My Calendar I.
	
    private List<int[]> books = new ArrayList<>();
    public boolean book(int start, int end) {
        for (int[] b : books)
            if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
        books.add(new int[]{ start, end });
        return true;
    }
	
	*/
}
