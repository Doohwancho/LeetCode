package array;

public class CountGoodTriplets1534 {
	
	//<Trial01>
	
	//�������� ���� �� �ʿ䰡 ����?
	
    // [7,3,7,3,12,1,12,2,3]
    // 5
    // 8
    // 1
    //[1,2,3,3,3,7,7,12,12]
	
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int rst = 0;
        
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i+1; j < arr.length-1; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) rst++;        
                }
            }
        }
        
        return rst;
    }
    
    
    
    //<Trial02>
    
    //�����غ��ϱ� a,b,c�� �������ΰ� �ƴ϶� i,j,k�̶� a,b,c���� �������ֳ�?
    
    
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int rst = 0;
        int largest_c = Math.max(a,Math.max(b,c));
        int second_b = a == largest_c ? Math.max(b,c) : b == largest_c ? Math.max(a,c) : Math.max(a,b);
        int first_a = a+b+c - (largest_c + second_b);
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int l = 0, r = arr.length-1, at = -1;
            while(l <= r){
                int m = (l+r)/2;
                if(arr[m]-arr[i] == largest_c){
                    at = m;
                    break;
                } else if(arr[m]-arr[i] < largest_c){
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
            if(at != -1){
                for(int j = i+1; j < at; j++){
                    if(Math.abs(arr[j]-arr[i]) <= first_a && Math.abs(arr[at]-arr[j]) <= second_b) rst++;
                }
            } else{
                if(l == arr.length) l--;
                for(int j = i+1; j < l; j++){
                    if(Math.abs(arr[j]-arr[i]) <= first_a && Math.abs(arr[l]-arr[j]) <= second_b) rst++;
                }
            }
        }
        
        return rst;
    }
    
    
    //<����Ǯ��1>
    
    //����� ��ư� ���Ƽ� �����߳�;;
    
    //Runtime: 14 ms, faster than 80.00% of Java online submissions for Count Good Triplets.
    //Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Count Good Triplets.
    
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int rst = 0;
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i+1; j < arr.length-1; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) rst++;        
                }
            }
        }
        
        return rst;
    }
    
    //<����Ǯ��2 by foobarfoo>
    
    //������ �������� ����ؼ� ������ ��� ����
    
    //Runtime: 33 ms, faster than 20.00% of Java online submissions for Count Good Triplets.
    //Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Count Good Triplets.
    
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int rst = 0;
    
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i+1; j < arr.length-1; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(isGood(new int[]{arr[i],arr[j],arr[k]}, a,b,c)) rst++;        
                }
            }
        }
        
        return rst;
    }
    
    private boolean isGood(int[] arr, int a, int b, int c){
        if(Math.abs(arr[0]-arr[1]) <= a &&
           Math.abs(arr[1]-arr[2]) <= b &&
           Math.abs(arr[0]-arr[2]) <= c) return true;
        return false;
    }
    
    
    //<����Ǯ��3 by SleepyFarmer>
    
    //� �𸣰ڴ� ����Ƴ�
    
    //Runtime: 4 ms, faster than 100.00% of Java online submissions for Count Good Triplets.
    //Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Count Good Triplets.
    
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        int[] pre = new int[1001];
        int[] post = new int[1001];  // stores suffix sum
        pre[arr[0]] = 1;
        for(int i = n-1; i > 1; i--) {
            post[arr[i]]++;            //arr[i]��+1�� �Ǹ�
        }
        for(int i = 1; i <= 1000; i++) {
            post[i] = post[i-1] + post[i]; //�� �����͵��� �������� +1��
        }
        
        for(int j = 1; j < n-1; j++) {
            int v = arr[j]; //��� ����
            int p1 = Math.max(0, v-a);   //��� ���ڿ��� +-a ���� p1~p2
            int p2 = Math.min(1000, v+a);
            int t1 = Math.max(0, v-b); //��� ���ڿ��� +-b ���� t1~t2
            int t2 = Math.min(1000, v+b);
            
            for(int s = p1; s <= p2; s++) { //s�� ��� ���ڿ��� +-a ���� p1~p2
                if (pre[s] == 0) continue; //? - pre[s]�� �ѹ��� ������ ���� �ʾ����� �ϴ� �н� 
                int m1 = Math.max(t1, s-c); //+-b������ +-c�������� ��ġ�� �κ� m1~m2
                int m2 = Math.min(t2, s+c);
                if (m2 >= m1) { //�̰��� �߰� element�������� a,b,c�� ��ġ�� sweetspot
                    if (m1 == 0) { //m1�� 0�̶�� ���� b������ c������ ���ʺκ��� ���� index0��� ��
                        ans += pre[s] * post[m2]; //��¥�� 0���� m2�����ϱ� post[m2]��ŭ ����. post�� �ϳ� �ö󰥶����� +1�̾���, �߰��� arr[i]�� �������� +1�� �� �����Ǵ� ����̾���. pre[s]�� ���ϴ� ������, �갡 ���¸�ŭ [(3,0,1), (3,0,1),...] ���� �ݺ��Ǵ� �ֵ鸸ŭ �����ִ� �� 
                    } else {
                        ans += pre[s] * (post[m2] - post[m1-1]); //��� 0���Ͱ� �ƴ϶� b~c�� ������ �߰��� �������� �� ª�� ��ȿ�Ÿ� �ȿ� �ִ¾ֵ��� �� ���̴ϱ�, m2 - (m1-1)����
                    }
                }
            }
            pre[v]++; //������ ����+1
            for(int i = arr[j+1]; i <= 1000; i++) {
                post[i]--; //���ϴ°��� �̰�
            }
        }
        return ans;
    }
}
