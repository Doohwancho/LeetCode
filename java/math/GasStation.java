package september;

public class GasStation {
	
	//<����Ǯ��1>
	
	//brute-force
	
	//Runtime: 23 ms
	//Memory Usage: 39.7 MB

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        
        int[] gas_ = new int[len*2];
        int[] cost_ = new int[len*2];
        
        for(int i = 0; i < len; i++){
            gas_[i] = gas_[i+len] = gas[i];
            cost_[i] = cost_[i+len] = cost[i];
        }
        
        for(int i = 0; i < len; i++){
            int start = gas[i];
            for(int j = i; j < len+i; j++){
                start -= cost_[j];
                if(start < 0){
                    break;
                } else if(j == len+i-1){
                    return i;
                }
                start += gas_[j+1];
            }
        }
        return -1;
    }
    
    
    //<����Ǯ��2 by Cheng_Zhang>
    
    //���������� ������ ���.
    
    //gas[i]-cost[i]�� �����Ѱ� ���̳ʽ���, �츮�� ã�� �ε����� 0~i���� ���� ���� �� ����.
    
    //�ֳĸ�, i�������� �����ؼ� ���������� ���� ������ �������� ���̳ʽ� �����ٴ� �����ݾ�.
    
    //tank�� ���̳ʽ��϶����� idx�� i+1�� ������. greedy���.
    
    //total�� gas[i]-cost[i]�� ��ü ���̸� ��Ÿ��.
    
    //��¥�� �ѹ��� �� ������, gas�� �� �� - cost�� ���� �ؼ� 0�̶� ���ų� ũ�� �츮�� ã�� idx�� �ִ°Ű�
    
    //���̳ʽ��� ������Ƶ� ���°Ŵ� return -1�̴ϱ�,
    
    //return total < 0 ? -1 : idx;
    
    //�ȶ��ϱ���
    
    //Runtime: 0 ms
    //Memory Usage: 39.8 MB
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0, tank = 0, total = 0, len = gas.length;
        for(int i = 0; i < len; i++){
            int diff = gas[i] - cost[i];
            tank += diff;
            if(tank < 0){
                idx = i+1;
                tank = 0;
            }
            total += diff;
        }
        return total < 0 ? -1 : idx;
    }
}
