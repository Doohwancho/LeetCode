package augustChallenge;

public class ExcelSheetColumnNumber {
	
	//<����Ǯ��1>
	
	//EEEEEEEEEEEEEZZZ
	
	//Runtime: 1 ms
	//Memory Usage: 38.1 MB
	
    public int titleToNumber(String s) {
        int size = s.length();
        int rst = 0;
        for(char c : s.toCharArray()){
            rst += (c-65+1) * Math.pow(26, --size);
        }
        return rst;
    }
}
