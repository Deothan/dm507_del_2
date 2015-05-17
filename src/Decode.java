
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
        int bit, read = 0, written = 0;
        StringBuilder bits = new StringBuilder();
        
        for(int i = 0; i < input.length; i++){
            input[i] = in.readInt();
        }
        
        for(int i : input){
            if(i > 0){
                read += i;
            }
        }
        
        String[] codes = Huffman.createCode(input);
        HashMap<String, Integer> originals = new HashMap();
        
        for(int i = 0; i < codes.length; i++){
            if(codes[i] != null)
                originals.put(codes[i], i);
        }
        
        while ((bit = in.readBit()) != -1 && written  <= read) {
            bits.append(bit);
            if (originals.containsKey(bits.toString())) {
                String temp = Integer.toString(originals.get(bits.toString()), 2); //Wrong method
                
                while(temp.length() != 8){
                    temp = "0"+temp;
                }

                for(int i = 0; i < temp.length(); i++){
                    out.writeBit(Integer.parseInt(temp.substring(i, i+1)));
                }
                written++;
                bits.delete(0, bits.length());
            }  
        }
        
        in.close();
	out.close(); 
    }    
}
