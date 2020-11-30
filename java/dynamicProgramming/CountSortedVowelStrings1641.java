package dynamicProgramming;

import java.util.Arrays;

public class CountSortedVowelStrings1641 {
	
	//<����Ǯ��1>
	
	//����ã��	
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
	//Memory Usage: 35.8 MB, less than 65.80% of Java online submissions for Count Sorted Vowel Strings.
	
    public int countVowelStrings(int n) {
        int[] c = new int[5];
        Arrays.fill(c, 1);
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j < 5; j++){
                c[j] += c[j-1];
            }    
        }
        
        return c[4];
    }
}
