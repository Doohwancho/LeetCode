package september;

public class MaximumProductSubarray {
	
	//<Trial01 - Memory Limit Exceeded>
	
	//2託据 壕伸聖 1託据生稽 匝戚檎 鞠畏革?
	
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] matrix = new int[n][n];
        int rst = Integer.MIN_VALUE;
        
        for(int p = 0; p < n; p++){
            matrix[p][p] = nums[p];
            rst = Math.max(rst, nums[p]);
        }
        
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                matrix[i][j] = matrix[i][j-1] * nums[j];
                rst = Math.max(rst, matrix[i][j]);
            }
        }
        return rst;
    }
    
    
    //<庚薦熱戚1>
    
    //brute-force
    
    //O((N^2)/2)
    
    //Runtime: 230 ms
    //Memory Usage: 39.2 MB
    
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] matrix = new int[n];
        int rst = matrix[0] = nums[0];
        
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                matrix[j] = matrix[j-1] * nums[j];
                rst = Math.max(rst, matrix[j]);
            }
            if(i+1 < n){
                matrix[i+1] = nums[i+1];
                rst = Math.max(rst, matrix[i+1]);
            }
        }
        return rst;
    }
    
    
    //<庚薦熱戚2 by lee215>
    
    //笑亀旋昔 失管託戚革 せせせ
    
    //析舘 A拭 収切亜 乞砧 丞呪檎, 陥 咽廃葵聖 鋼発馬檎 喫.
    
    //幻鉦 iterate馬陥亜 0戚 蟹神檎, 0戚蟹紳楕 軒実馬壱 陥製暗採斗 陥獣 刊旋生稽 咽背捜
    
    //Q. 幻鉦 [-1,2,2,2, ...]檎, l戚 原戚格什採斗 咽馬艦猿 照鞠澗暗 焼劃?
    
    //益君檎 r戚 神献楕拭辞採斗 陥 咽馬檎辞 級嬢人辞 右諾製.
    
    //Q. 益軍 [-1,2,2,2,-1]精 嬢多黄汽? l亀 原戚格什採斗 咽馬壱 r亀 原戚格什採斗 咽馬摂焼?
    
    //原戚格什亜 砧鯵檎 巴君什 鞠艦猿 右諾製
    
    //Q. 益軍 [-1,2,2,2,-1,2,2,-1]精?
    
    //丞魁舘拭 原戚格什葵 源壱, 掻娃拭 原戚格什亜 筈呪鯵 蟹紳陥檎,  筈呪鯵 奄層生稽 図楕拭 践 笛 刊旋葵戚 l戚壱, 神献楕 践 笛 刊旋葵戚 r戚艦猿,
    
    //Math.max(l,r)馬檎 喫.
    
    //丞魁照拭 原戚格什葵 源壱, 掻娃税 原戚格什亜 側呪鯵 蟹紳陥檎, 原戚格什研 側呪腰 咽馬檎 嬢促杷 巴君什艦猿 陥 咽背爽檎 喫.
    
    //袴軒 鯵疏革 人 松 せせせせ
    
    //Runtime: 1 ms
    //Memory Usage: 39.3 MB
    
    public int maxProduct(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}
