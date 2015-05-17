
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Deothan
 */
public class Encode {  
    public static void main(String[] args) throws Exception {
        BitInputStream in = new BitInputStream(new FileInputStream("C:\\Users\\Deothan\\Documents\\Code\\dm507_del_2\\src\\in.txt"));
	BitOutputStream out = new BitOutputStream(new FileOutputStream("C:\\Users\\Deothan\\Documents\\Code\\dm507_del_2\\src\\out.txt"));
        
        int[] input = new int[256];
        int bit;
        StringBuilder bits = new StringBuilder();
        
        //Indlæs
        while ((bit = in.readBit()) != -1) {
            bits.append(bit);
            if (bits.length() % 8 == 0) {
                input[Integer.parseInt(bits.toString(), 2)] += 1;
                bits.delete(0, 8);
            }  
        }

        in = new BitInputStream(new FileInputStream("C:\\Users\\Deothan\\Documents\\Code\\dm507_del_2\\src\\in.txt"));
        
        //Lav huffmankode tabel
        String[] huffmanCode = Huffman.createCode(input);

        //Læs, oversæt og skriv
        while ((bit = in.readBit()) != -1) {
            bits.append(bit);
            if (bits.length() % 8 == 0) {
                String temp = huffmanCode[Integer.parseInt(bits.toString(), 2)];

                for(int i = 0; i < temp.length(); i++){
                    out.writeBit(Integer.parseInt(temp.substring(i, i+1)));
                }
                bits.delete(0, 8);
            }
        }      
        
        in.close();
	out.close();       
    }
}
