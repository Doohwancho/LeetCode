package augustChallenge;

public class PathSumIII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	//<����Ǯ��1>
	
	//preorder traversal
	
	//Runtime: 11 ms
	//Memory Usage: 40.9 MB

    private void preorder(TreeNode root, int sum,List<Integer> arr, int[] rst){
        if(root == null) return;
        
        arr.add(root.val);
        for(int i = arr.size()-1, j = 0; i >= 0; i--){
            j += arr.get(i);
            if(j == sum){
                rst[0]++;
            }
        }
        List<Integer> rightArr = new ArrayList<>(arr);
        preorder(root.left, sum, arr, rst);
        preorder(root.right, sum, rightArr, rst);
    }
    
    public int pathSum(TreeNode root, int sum) {
        int[] rst = new int[1];
        preorder(root, sum, new ArrayList<>(), rst);
        return rst[0];
    }
    
    
    //<����Ǯ��2 by jiangsichu>
    
    //brute-force + dfs
    
    //Runtime: 21 ms
    //Memory Usage: 39.6 MB
    
    //return sum of root.val's starting from the root
    private int dfs(TreeNode root, int sum){
        if(root == null) return 0;
        return (root.val == sum ? 1 : 0) + dfs(root.left, sum-root.val) + dfs(root.right, sum-root.val);
    }
    
    //visit every node and trigger dfs()
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum); 
    }
    
    
    
    //<����Ǯ��3 by xuyirui>
    
    //prefix sum hashmap
    
    //����Ǯ��1�� ��������, ���ɰ���.
    
    //Runtime: 2 ms
    //Memory Usage: 39.4 MB
    
    private int count = 0;
    public int pathSum(TreeNode root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //root.val�� �ٷ� sum�϶�, sum - root.val�ϸ� 0���ڳ�~ �׷� +1����� ���ڳ�~. �׸��� sum�� �������� �����ִٰ� sum-target�ؼ� 0�ǵ� +1����� ���ڳ�~
        pathSumHelper(map, root, 0, target);
        return count;
    }
    
    private void pathSumHelper(Map<Integer, Integer> prefixSumMap, TreeNode root, int sum, int target) {
        if (root == null) {
            return;
        }
        sum += root.val;
        count += prefixSumMap.getOrDefault(sum - target, 0);
        prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        pathSumHelper(prefixSumMap, root.left, sum, target);
        pathSumHelper(prefixSumMap, root.right, sum, target);
        prefixSumMap.put(sum, prefixSumMap.get(sum) - 1); //���� �� ���� ���������� ���� �� ���� ������ ����.
        //�̰� ���� pathSum(helper.left)�� pathSum(helper.right)���̿� �־�� �� �� ������,
        //���� �� ������ �������� left,right child��� null�̱� ������, ������ sum����� ���������� �Ѿ�� ������ ������.
    }
}
