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
        
        
        HuffmanTree tree = new HuffmanTree(queue.ExtractMin().data);
        
        return tree.getCodes();
    }    
}
