package october;

public class SerializeAndDeserializeBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//System.out.println(sb.toString());
	
	//<Trial01>
	
	//[41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]
    
	//訊走?
	
	//焼たたたたたたたたたたたたた
	
	//preOrder()馬檎 
	
	//[41,37,44,24,39,42,48,1,35, ... ] 戚訓縦生稽 蟹人醤 馬澗汽
	
	//奄撹 stringbuilder拭 垣陥 .append()背辞
	
	//413724102439765811101615121314191817202221233530292625272832313433363938404442434846454749 戚訓縦生稽 蟹人辞 何績 
	
	//輯忽 舛重託軒切 庁姥醤
	
	private StringBuilder preOrder(TreeNode root){
		if (root == null) return null;
		
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        
		StringBuilder l = preOrder(root.left);
		if (l != null) sb.append(l);
        
		StringBuilder r = preOrder(root.right);
		if (r != null) sb.append(r);
		return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return new String();
		return preOrder(root).toString();
    }

    private void insertBST(TreeNode parent, TreeNode root, int n, boolean left){
        if(root == null){
            TreeNode tmp = new TreeNode(n);
            if(left){
                parent.left = tmp;    
            } else {
                parent.right = tmp;
            }
            return;
        }
        if(n < root.val){
            insertBST(root, root.left, n, true);
        } else {
            insertBST(root, root.right, n, false);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null; 
        
        char[] dataCharset = data.toCharArray();
        TreeNode rst = new TreeNode(Integer.parseInt(String.valueOf(dataCharset[0])));
        
        for(int i = 1; i < data.length(); i++){
            insertBST(rst, rst, Integer.parseInt(String.valueOf(dataCharset[i])), true);
        }
        return rst;
    }
    
    
    
    
    
    
    //<庚薦熱戚 1 by naveen_kothamasu>
    
    //戚庁姥澗 preOrder稽 儀 陥製, bst号縦拭 限惟 増嬢隔醸革?
    
    //訊走?
    
    //湛匙魚亜 serialize(root)拭辞 root税 湛匙魚櫛 旭焼醤 背辞 益訓亜?
    
    //inorder澗 践 拙精蕉亜 湛匙魚亜 鞠亀系 竺舛鞠赤舘源醤 trial01拭辞
    
    //悦汽 preorder床檎 湛匙魚亜 伍 坦製拭 級嬢亜艦猿 益訓亜?
    
    //限澗牛.
    
    
    //PS: I have i=0 as class variable but it is not used for storing any state. I think the "state" in the question is talking about variables shared across serialize and deserialize calls.
    
    //戚庁姥研 庚薦研 戚係惟 背汐梅姥幻

    //Runtime: 11 ms
    //Memory Usage: 39.8 MB
    
    
    public String serialize(TreeNode root) {
        return preOrder(root);
    }
    private String preOrder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()){
            while(curr != null){
                sb.append(curr.val+" ");
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            curr = curr.right;
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] s = data.split(" ");
        return decode(s, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    int i = 0;
    private TreeNode decode(String[] s, Integer min, Integer max){
        if(i == s.length) return null;
        int val = Integer.parseInt(s[i]);
        if(val < min || val > max) {
            return null;
        }
        TreeNode curr = new TreeNode(val);
        ++i;
        curr.left = decode(s, min, curr.val);
        curr.right = decode(s, curr.val, max);
        return curr;            
    }
    
    
    //<庚薦熱戚2>
    
    //Trial01拭辞 preorder宜 凶 .append()稽 蒋及 姥歳亀 照馬壱 陥 細食獄形辞 戚雌廃 衣引葵戚 蟹神澗 災雌紫 背衣.
    
    //Runtime: 10 ms
    //Memory Usage: 39.6 MB
    
	private StringBuilder inOrder(TreeNode root){
		if (root == null) return null;
		
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+" ");
        
		StringBuilder l = inOrder(root.left);
		if (l != null) sb.append(l);
        
		StringBuilder r = inOrder(root.right);
		if (r != null) sb.append(r);
		return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return new String();
		return inOrder(root).toString().trim();
    }

    private void insertBST(TreeNode parent, TreeNode root, int n, boolean left){
        if(root == null){
            TreeNode tmp = new TreeNode(n);
            if(left){
                parent.left = tmp;    
            } else {
                parent.right = tmp;
            }
            return;
        }
        if(n < root.val){
            insertBST(root, root.left, n, true);
        } else {
            insertBST(root, root.right, n, false);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null; 
        String[] dataString = data.split(" ");
        
        TreeNode rst = new TreeNode(Integer.parseInt(dataString[0]));
        
        for(int i = 1; i < dataString.length; i++){
            insertBST(rst, rst, Integer.parseInt(dataString[i]), true);
        }
        return rst;
    }
}
