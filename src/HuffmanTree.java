

public class HuffmanTree { 
    String[] codes = new String[256];
    private Node root;
    private int size;
    
    public HuffmanTree(Node root, int size){
        this.root = root;
        this.size = size;
    }

    //Left = 0
    //Right = 1
    public String[] generateCode() {
        inorderTreeWalk(root);
        
        return codes;      
    }
    
    private void setCode(Node n){
        Node x = root;
        StringBuilder code = new StringBuilder("");
        
        while(x != null){
            if(n.getKey() < x.getKey()){
                code.append("0");
                x = x.getLeft();
            }
            else if(n.getData() == x.getData()){
                System.out.println(code);
                codes[n.getData()-1] = code.toString();
            }
            else{
                code.append("1");
                x = x.getRight();
            }
        }
    }
    
    private void inorderTreeWalk(Node x){
        if(x != null){
            inorderTreeWalk(x.getLeft());
            setCode(x);
            inorderTreeWalk(x.getRight());
        }        
    }
}
