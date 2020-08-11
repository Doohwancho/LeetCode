package augustChallenge;

public class HIndex {

	//<����Ǯ��1 by logan138>
	
	//���簡 ���� ���ع���.
	
	//Runtime: 1 ms
	//Memory Usage: 37.7 MB
	
    public int hIndex(int[] citations) {
        Arrays.sort(citations); //sort the array to make sure the papers that appear behind the i can't have more than citations than i
        int N = citations.length;
        int index = 0;
        while(index < N && N - index > citations[index]){
            index++;
        }
        return N - index;
    }
}
