package mayChallenge;

public class KthSmallestElementInABST {

	//<����Ǯ��1>
	
	//�Ӹ� �θŰ� ������̾��µ� �׳� �����Ѱſ���.
	
	//binary search tree��� �����ϱ� inorder�� ���� ���� ���� ���ڴ�� ������� ���ðžƳ�
	
	//cnt�� ���° ���� �������� �ľ��� ������, k��° ���� ���ڰ� �����ϸ� rst�� �־ ����ϸ� ����
	
	//�ٵ� ���⼭ �ѹ�¦ �� ���ư���
	
	//bst(root.right, k)�� ��, if(cnt < k)�� �߰����Ѽ� optimize��Ŵ. (mach7�� ���̵��)
	
	//�̹� cnt==k�� �Ǿ��ٸ�, ���̻� right node�� �ʿ���� �ٷ� root�� �ö󰡸� ���ڳ�
	
    int cnt = 0;
    int rst = Integer.MAX_VALUE;
    
    private void bst(TreeNode root, int k){
        if(root == null) return;
        bst(root.left, k);
        cnt++;
        if(cnt == k){
            rst = root.val;
        }
        //bst(root.right, k); //will also do.
        if(cnt < k) bst(root.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        bst(root, k);
        return rst;
    }
    
    
    //<����Ǯ��2 by miaow>
    
    //global variable ����ϴ°� �������ٸ�, cnt, rst���� ��ſ� int[]Ÿ���� counter, result�� �̿��ϴ� ����� �ִ�.
    
    public int kthSmallest(TreeNode root, int k) {
        int [] counter = new int[]{0};
        int [] result = new int[]{0};
        inOrder(root, k, counter, result);
        return result[0];
    }

    private void inOrder (TreeNode root, int k, int[] counter, int[] result) {
        if (root != null) {
            inOrder(root.left, k, counter, result);
            counter[0]++;
            if (counter[0] == k) {
                result[0] = root.val;
                return;
            }
            inOrder(root.right, k, counter, result);
        }
    }
    
    //<����Ǯ��3 by ... �̸��� ���� ���ι� ģ��>
    
    //stack�� �̿��� ���
    
    //in-order recursive�� ���� ���
    
    //�̱� �ѵ�, cnt�� ã�ڸ��� return���شٴ� ������ 
    
    //in-order���� ��~�� �� ����
    
    //root���� �ٽ� �ȿö󰡵� ���ڳ�
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        int cnt = 0;
        
        while(!st.isEmpty() || p != null){
            if(p != null){
                st.push(p);
                p = p.left;
            } else {
                TreeNode node = st.pop();
                if(++cnt == k) return node.val;
                p = node.right;
            }
        }
        return 0;
    }
}
