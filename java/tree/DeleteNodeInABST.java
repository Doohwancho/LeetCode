package augustChallenge;

public class DeleteNodeInABST {
	

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
	
	//<����Ǯ��01>
	
	//binary search tree
	
	//key = key.right�� �����, key.left�� pre-order-traversal�� ���鼭 key.right�� �ϳ��ϳ� insert�ϴ� ���
	
	//�ణ �˲����ѰŰ����ѵ� ���� ������ ���� ��.
	
	//Runtime: 0 ms
	//Memory Usage: 40 MB
	
	
	//pre-order-traversal�� key.left�� ���鼭, �ϳ��ϳ� key�� ��� key.right�� bst��Ģ�� �°� �־���
    private void dfs(TreeNode tmpLeft, TreeNode root){ //dfs�� ���� �Ķ���ʹ� insert���� key.left�̰�, ������ �Ķ���ʹ� root�� ��� key.right��
        if(tmpLeft == null) return;
        addLeft(root, tmpLeft.val);
        dfs(tmpLeft.left, root);
        dfs(tmpLeft.right, root);
    }
    
    private void addLeft(TreeNode root, int key){
        if(root == null) return;
        
        TreeNode newNode = new TreeNode(key); 
        TreeNode x = root; 
        TreeNode y = null; 

        while (x != null) { 
            y = x; 
            if (key < x.val) 
                x = x.left; 
            else
                x = x.right; 
        } 
        
        if(y == null){
            y = newNode;
        }
        else if(key < y.val){
            y.left = newNode;
        } else {
            y.right = newNode;
        }
        
        return;
    }
    
    private TreeNode findNode(TreeNode root, TreeNode prev, int key){
        if(root == null) return null;
        
        //if found, node = node.right, add previous root.left to updated root according to BST rules
        if(root.val == key){
            if(root.right != null){
                TreeNode tmp = root.left; //���ʾֵ� �ϴ� ������
                root = root.right; //root�� root.right�� ����Ἥ key�� ��������
                if(prev == null){  //ù������ key�� ���, ����ó��
                    TreeNode tmpRoot = root;
                    dfs(tmp, root); //dfs�� ���� �Ķ���ʹ� insert���� key.left�̰�, ������ �Ķ���ʹ� root�� ��� key.right��
                    return tmpRoot;
                }
                else if(prev.val > key){
                    prev.left = root;
                } else {
                    prev.right = root;
                }
                dfs(tmp, root);
                return null;
            } else {
                if(prev == null){
                    return root.left;
                }
                else if(prev.val < root.val){
                    prev.right = root.left;
                } else {
                    prev.left = root.left;
                }
                return null;
            }
        }
        
        prev = root;
        
        //find node on bst
        if(key < root.val){
            findNode(root.left, prev, key);
        } else {
            findNode(root.right, prev, key);
        }
        
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return findNode(root, null, key);
    }
    
    
    
    
    
    //<����Ǯ��2 by booboohsu>
    
    //�� �̺е� ��ģ��������.
    
    //key�� ã�Ҵµ�, key.left == null�̸�, key = key.right�Ƹ� �ǰ�,
    
    //key.right == null�̸�, key = key.left�ϸ� �Ǵµ�,
    
    //key.left�� key.right�� �� �� ��������� ��� �ұ ������ ���ݾ�?
    
    //�� key = key.right�� �����, key.left�� pre-order-traversal�� ���鼭 key.right�� �ϳ��ϳ� insert�ϴ� ����� ��µ�,
    
    //��� key.left�� ���� �ΰ�, key.right�� �� ���� ���� ã�� ��, key�� �ھƹ���.
    
    //(key.left�� �ִ� �������� key.right�� �� ���������� ������ ���� �� �ۿ� ���� ����)
    
    //�׸��� key.right�� ���� �Ʊ� ���� key.right�� �� ���� ���� ã�� ���ֹ���.
    
    //���� ���� structure�� ������ ���ִ� ����ε�.
    
    //80�پ��� 30�ٿ� �ذ��߳�. �׸��� ������ if-else�� �Ⱦ� + ���� ��� �����ϴ� prev�� �Ⱦ�. ��� �� ��ü.
    
    //Runtime: 0 ms
    //Memory Usage: 40.2 MB
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
