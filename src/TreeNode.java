
public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
	String name;
	String pron;
	String cont;

    public TreeNode(){
        this.left = null;
        this.right = null;
    }
    
    public TreeNode (String name,String pron, String cont){
        this.name = name;
        this.pron = pron;
        this.cont = cont;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    
    public void setNode(String name,String pron,String cont) {
      this.name = name;
      this.pron = pron;
      this.cont = cont;

    }

}
