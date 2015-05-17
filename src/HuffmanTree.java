

public class HuffmanTree { 
    private Node root;
    private String[] codes = new String[256];
    
    public HuffmanTree(Node root){
        this.root = root;
    }
    
    public String[] getCodes(){
        inorderTreeWalk(root, "");
        return codes;
    }
    
    private void inorderTreeWalk(Node x, String code){
        if(x != null){
            inorderTreeWalk(x.getLeft(), code+"0");
            inorderTreeWalk(x.getRight(), code+"1");
            
            if(x.getData() != -1){
                codes[x.getData()] = code;
            }
        }        
    }
}
