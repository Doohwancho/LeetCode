package mayChallenge;

public class ConstructBinarySearchTreeFromPreorderTraversal {

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

	// <Trial01>
	
	//�̷л� �Ϻ��ѵ�? �ϰ� ���ȴµ�,
	
	//������� []�� ����. �ϰ͵� �ȵ�.
	
	//�޼��尡 ������, �޼��� �ȿ��� ����� ����, ��ü�� ���ư�. 
	
	//void�� �����߱� ������, ������ ��ü�� ��ȿ������ �޼����� {}�� ������ ����, �������µ�.
	
	//System.identityHashCode(root)�� ��ü�ּҸ� Ȯ���� ����,
	
	//root = null�϶�, root�� �ּҰ� 0�̾��ٰ�, bst()�޼���� ���� 
	
	//root = new TreeNode(val)�� �ؼ� �̾��� ��, root�� �ּڰ��� ��������, 
	
	//bst()�޼��尡 ������ ����, void������ �ƹ��͵� �������� �ʾ����Ƿ�, new TreeNode(val)�� ��ü�ּҰ� ���ư������� 
	
	//�ٽ� root�� �ּҰ� 0���� ���µǴ°� Ȯ�� ����.
	
	TreeNode root = null;

	public void bst(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else if (val < root.val) {
			bst(root.left, val);
		} else {
			bst(root.right, val);
		}
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		for (int p : preorder) {
			bst(root, p);
		}
		return root;
	}
	
	//<����Ǯ��1>
	
	//Trial01���� �ణ ����
	
	//return ���� �༭ root = bst(root, p)�� �ٿ�������, �޼���{}�ȿ��� ����Ȱ� �ȳ��ư��� ����.
	
	//=�� �޼��� �ٱ��� �־ �޼��尡 �� ������, ������ �����̰� ���̴� ������ �ϳ���.
	
	//trial01���� root = new TreeNode(val);�Ҷ�, =�� ���̱� �ߴµ�,
	
	//�޼��尡 �����鼭, =�����ڵ� ������ �Ȱ��� {}�ȿ����� ��ȿ�ϱ� ������, {}�� �������, ���� ���������.
	
	//�ٵ� ����Ǯ��1���� root = bst(root, p);�� �޼��尡 �������� return root�Ѱ� �޼��� �ٱ����� �ٿ��������ϱ�, ����ִµ�.
	
	//Runtime: 0 ms
	//Memory Usage: 37.6 MB
	
	public TreeNode bst(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		} else if (val < root.val) {
			root.left = bst(root.left, val);
		} else {
			root.right = bst(root.right, val);
		}
        return root;
	}

	public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        
		for (int p : preorder) {
			root = bst(root, p);
		}
		return root;
	}
	
	
	//<����Ǯ��2>
	
	//���� ���۽��� ������
	
	//��� �������� root�� �ٿ��ִ°ǵ�
	
	//addNode()�޼��尡 ������ �پ��ֳ�?
	
	//Runtime: 0 ms
	//Memory Usage: 37.6 MB
	
	TreeNode root = null;
	
	public void addNode(int key) {
        TreeNode newNode = new TreeNode(key);

        if (root == null) {
            root = newNode; // Ʈ���� ��������� root �� ����
        } else {
            TreeNode focusNode = root;  //  Ž���� ���
            TreeNode parent;            //  Ž���� ����� �θ� ���

            while(true) {
                parent = focusNode; //  �̵�

                if (key < parent.val) {             //  �����Ϸ��� Ű�� ���� ��庸�� ������
                    focusNode = parent.left;   //  �������� �̵�

                    if (focusNode == null) {        //  ���� ��尡 ���������
                        parent.left = newNode; //  ���� ��忡 ����
                        return;
                    }
                } else {                            //  �����Ϸ��� Ű�� ���� ���� ���ų� ũ�ٸ�
                    focusNode = parent.right;  //  ���������� �̵�

                    if (focusNode == null) {        //  ������ ��尡 ���������
                        parent.right = newNode;//  ������ ��忡 ����
                        return;
                    }
                }
            }
        }
    }
	
    public TreeNode bstFromPreorder(int[] preorder) {
        
        for(int p : preorder){
            addNode(p);
        }
        return root;
    }
    
    
    
    //<����Ǯ��3 by lee215>
    
    //bound�� �̿��ϴ� ���
    
    //left child will take preorder[i] smaller than bound(parent.val)
    
    //right child will take preorder[i] smaller than bound(Integer.MAX_VALUE)
    
    //Runtime: 0 ms
    //Memory Usage: 37.2 MB
    
    int i = 0;
    
    private TreeNode bst(int[] preorder, int bound){
        if(i >= preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bst(preorder, root.val);
        root.right = bst(preorder, bound);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
		return bst(preorder, Integer.MAX_VALUE);
	}
}
