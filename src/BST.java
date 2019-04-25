public class BST {
	private static TreeNode root = new TreeNode();
	public TreeNode getRoot() {
		return root;
	}
	public TreeNode insertKey(TreeNode root, String x, String pron, String cont) {
		TreeNode p = root;
		TreeNode newNode = new TreeNode(x,pron,cont);
		if(p == null || p.name==null){
			return newNode;
		}else if(p.name.compareToIgnoreCase(newNode.name)>=0){
			p.left = insertKey(p.left, x,pron,cont);
			p.left.parent = p;
			return p;
		}else if(p.name.compareToIgnoreCase(newNode.name)<0){
			p.right = insertKey(p.right, x,pron,cont);
			p.right.parent = p;
			return p;
		}else{ 
			return p;
		}
	}
	public void insertBST(String x,String pron, String cont){
		root = insertKey(root, x,pron,cont);
	}
	public void inorder(TreeNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.name + " ");
			inorder(root.right);
		}
	}
	public void printBST(){
		inorder(root);

		System.out.println();
	}
	public TreeNode searchBST(String x){
		TreeNode p = root;
		while(p!=null){
			if(x.compareToIgnoreCase(p.name)<0) p = p.left;
			else if(x.compareToIgnoreCase(p.name)>0) p = p.right;
			else return p;
		}
		return p;
	}
	
	public TreeNode TreeDelete(TreeNode z) {
		TreeNode x=null,y=null;
		if(z.left==null||z.right==null) 
			y=z; 
		else y=getSuccessor(z); 

		if(y.left!=null) 
			x=y.left;  
		else  
			x=y.right; 

		if(x!=null) 
			x.parent=y.parent; 

		if(y.parent==null) 
			root=x;
		else if(y==y.parent.left)
			y.parent.left=x;
		else y.parent.right=x;

		if(y!=z) {
			z.name=y.name;
			z.cont=y.cont;
			z.pron=y.pron;
		}
		return y;
	}

	public TreeNode getSuccessor(TreeNode deleleNode){
		TreeNode successsor =null;
		TreeNode current = deleleNode.right;
		while(current!=null){
			successsor = current;
			current = current.left;
		}
		return successsor;
	}
}
