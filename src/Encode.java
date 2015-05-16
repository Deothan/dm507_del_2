
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Deothan
 */
public class Encode {  
    public static void main(String[] args) throws Exception {
        int[] input = new int[256];
        int data;
        
	BitInputStream in = new BitInputStream(new FileInputStream(args[0]));
	BitOutputStream out = new BitOutputStream(new FileOutputStream(args[1]));
       
        do{
           data = in.readInt();
           input[data-1] += 1;
        }
        while(data != -1);
       
        

	in.close();
	out.close();        
    }
}
