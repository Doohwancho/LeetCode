package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumOfSortedSubarraySums1508 {
	
	//<Trial01>
	
	//brute-force
	
	//input: [100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100]
	//1000
	//1
	//500500
	
	//Output : -463169184
	//Expected : 716699888
	
	//마이너스가 나온다고?
	
	//이유 : 다 더하면 rst가 16716700000가 나옴.
	
	//근데 int의 최대범위가 2147483647임.
	
	//음;;;
	
	
    public int rangeSum(int[] nums, int n, int left, int right) {
    	
        List<Integer> list = new ArrayList<>();
        for(int i = 0, continuous = 0; i < n; i++){
            list.add(nums[i]);
            continuous = nums[i];
            for(int j = i+1; j < n; j++){
                list.add(continuous + nums[j]);
                continuous += nums[j];
            }
        }
        int[] newNums = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	newNums[i] = list.get(i);
        }
        
        Arrays.sort(newNums);
        int rst = 0;
        
        for(int i = left-1; i < right; i++) {
        	rst += newNums[i];
        }
        
        return rst;
    }
    
    //<문제풀이1 by aayushgarg>
    
    //오버플로우 핸들링하기 위해 쥰나 크고 소수인 1000000007로 나눈 나머지값을 사용함.
    
	//[PS기초] 왜 1000000007(1e9+7)로 나눈 나머지를 고집할까? (feat. 모듈러 곱셈 역원)
	//
	//많은 문제에서는 어떤 값으로 나눈 나머지를 출력 또는 반환값으로 요구하는 경우가 많습니다.
	//그 값 중 가장 대표적인 값은 1000000007, 1000000009이 있습니다.
	//
	//왜 이런 값을 사용할까요??
	//
	//여러가지 이유가 있습니다.
	//
	//## 1. int와 long long의 범위를 생각해봅시다.
	//
	//C/C++에서 수의 표현은 사실 매우 제한적입니다. 가장 많이 사용하는 정수 자료형인 int와 long long를 봅시다.
	//
	//- int는 4바이트(32비트)로 -2^31에서 2^31-1만큼 표현할 수 있습니다. 이는 -2147483648 ~ 2147483647입니다. 이는 2e9로 근사할 수 있습니다.
	//- long long은 8바이트(64비트)로 -2^63에서 2^63만큼 표현할 수 있습니다. 이는 9.22337204e18 ~ +9.22337204e18 입니다. 이는 이미 근사했지만 9e18로 근사할 수 있습니다.
	//
	//하지만 21!만해도 long long의 범위를 넘어 버립니다. 그렇다면 조합이나 가짓수를 세는 문제에서는 쉽게 오버플로가 되는 것이죠.
	//
	//그렇다면 매우 큰 결과를 표현하고, 이를 체크하기 위해서는 어떤 방법이 있을까요? 물론 문자열로 수를 표현하여 이를 비교하는 방법도 있겠지만, 이는 문제의 본질을 흐리는 방법입니다. 세터(문제출제자)는 큰 수를 표현하는 방법을 묻고 싶은게 아니니까요. (물론 그런 문제도 종종 있습니다. 그럴 때는 Java의 빅인티저 또는 파이썬을 사용하는 것을 추천합니다)
	//
	//그렇기에 이를 효율적으로 나타내기 위해 모듈러 연산을 사용하는 것입니다.
	//
	//## 2. 그러나 왜 굳이 1e9+7일까 : 크기와 암기
	//
	//하지만 모듈러가 지나치게 작다면 이는 언어의 표현력을 비효율적으로 사용하는 것입니다.
	//
	//그렇기에 int가 표현할 수 있는 내용을 최대한 활용하기 위해서는 int의 max값에 가까워야 합니다.
	//
	//그렇기에 약 2e9의 값을 사용할 수도 있습니다. 하지만 덧셈 연산과 뺄셈 연산에서 2e9에 근사하는 값들의 연산을 한다면 어떨까요? 역시 2e9+2e9 = 4e9가 되어 오버플로우가 발생합니다. 뺄셈도 마찬가지입니다. 그렇기에 2^30에 근사하는 값을 가져야 합니다. 이는 1e9에 가까운 값 중에 소수인 1e9+7을 사용하는 것입니다. 이 값은 곱해도 long long의 범위를 넘지 않는다는 장점 또한 가지고 있습니다.
	//
	//또한 이 수는 모양이 매우 단순하여 암기가 편하다는 장점이 있습니다. 그렇다면 왜 소수일까요?
	//
	//## 3. 소수의 중요성
	//
	//소수는 매우 다양한 장점을 가지고 있습니다.
	//
	//1. 풀이의 정확도를 더욱 요구한다.
	//2. 모듈러 곱셈 역을 구하는 방법이 간단하다.
	//
	//소수가 아닌 경우는 약수의 크기에 따라 모듈러 연산의 결과가 겹칠 확률이 보다 높습니다. 그렇기에 소수를 사용하는 것이 문제의 결과 정확도를 더욱 높입니다. (세터 입장)
	//
	//그리고 많은 문제에서 모듈러 곱셈 역원을 구해야하는 경우가 있습니다. 이 경우 페르마 소정리를 이용하면 쉽게 구할 수 있습니다.
    
    //모듈러 곱셈 역원이란 a와 M이 주어지고 ax = 1 (mod M)인 x를 구하는 문제입니다. 이는 a^(M-1) = 1 (mod M) when M is prime이라는 페르마 소정리을 안다면 a^(M-2) = a^(-1) = x (mod M)인 것을 알 수 있습니다. 물론 확장 유클리드 알로리즘으로도 구할 수 있으나 이게 훨씬 간단합니다.
    
    //reference : 알고리즘에 고통받는 취준생을 위한 안내서
    
    //Runtime: 473 ms, faster than 12.15% of Java online submissions for Range Sum of Sorted Subarray Sums.
    //Memory Usage: 97.9 MB, less than 100.00% of Java online submissions for Range Sum of Sorted Subarray Sums.
    
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD=1000000007;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sum=nums[i];
            al.add(sum);
            for(int j=i+1; j<n; j++){
                sum+=nums[j];
                al.add(sum);
            }
        }
        Collections.sort(al);
        int ans=0;
        while(left<=right){
            ans=(ans%MOD + al.get(left-1))%MOD;
            left++;
        }
        return ans;
    }
}
