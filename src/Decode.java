
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deothan
 */
public class Decode {
    public static void main(String[] args) throws Exception {
        BitInputStream in = new BitInputStream(new FileInputStream("C:\\Users\\Deothan\\Documents\\Code\\dm507_del_2\\src\\out.txt"));
        BitOutputStream out = new BitOutputStream(new FileOutputStream("C:\\Users\\Deothan\\Documents\\Code\\dm507_del_2\\src\\out2.txt"));

        int[] input = new int[256];
        int bit;
        StringBuilder bits = new StringBuilder();
        
        for(int i = 0; i < input.length; i++){
            input[i] = in.readInt();
        }
        
        String[] codes = Huffman.createCode(input);
        HashMap<String, Integer> originals = new HashMap();
        
        for(int i = 0; i < codes.length; i++){
            if(codes[i] != null)
                originals.put(codes[i], i);
        }
        
        while ((bit = in.readBit()) != -1) {
            bits.append(bit);
            System.out.println("bits: "+bits);
            if (originals.containsKey(bits.toString())) {
                System.out.println("result: " + bits.toString());
                //out.writeBit(originals.get(bits.toString()));
                bits.delete(0, bits.length());
            }  
        }
        
        in.close();
	out.close(); 
    }    
}
