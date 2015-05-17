

public class HuffmanTree { 
    private Node root;
    private String[] codes = new String[256];
    
    public HuffmanTree(int[] input){
        PQHeap queue = new PQHeap(input.length);
        int size;
        
        for(int i = 0; i<input.length; i++){
            if(input[i] > 0){
                Node n = new Node(input[i], i);
                queue.insert(new Element(input[i], n));
            }
        }
        
        size = queue.size();
        
        for(int i = 1; i < size; i++ ){
            Element x = queue.ExtractMin(), y = queue.ExtractMin();

            int key = x.key+y.key;

            Node n = new Node(key, -1);
            n.setLeft(x.data);
            n.setRight(y.data);

            queue.insert(new Element(key, n)); 
        }
        
        
        root = queue.ExtractMin().data;
    }
    
    private void createHuffmanTree(int[] input){

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
