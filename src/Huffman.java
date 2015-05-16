/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deothan
 */
public class Huffman {
    public static String[] createCode(int[] input){
        PQHeap queue = new PQHeap(input.length);
        int size;
        
        for(int i = 0; i<input.length-1; i++){
            if(input[i] > 0){
                Node n = new Node(input[i]);
                n.setData(i);
                queue.insert(new Element(input[i], n));
            }
        }
        size = queue.size();
        
        for(int i = 1; i < queue.size(); i++ ){
            Element x = queue.ExtractMin(), y = queue.ExtractMin();
            
            int key = x.key+y.key;

            Node n = new Node(key);
            n.setLeft(x.data);
            n.setRight(y.data);

            queue.insert(new Element(key, n));   
        }
        
        HuffmanTree tree = new HuffmanTree(queue.ExtractMin().data, size);
        
        return tree.generateCode();
    }    
}
