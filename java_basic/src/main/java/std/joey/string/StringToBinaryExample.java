package std.joey.string;


import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringToBinaryExample1 {

    public static void main(String[] args) {

        String input = "사랑";
        String result = convertStringToBinary(input);

        // pretty print the binary format
        System.out.println(prettyBinary(result, 8, " "));
        
       //pringString(result);
        
        System.out.println("org : "+result);
        List<String> love = new ArrayList<String>();
        love.add("1100000010101100");
        love.add("1011011110010001");

        List<String> hope = new ArrayList<String>();
        hope.add("1100000110001100");
        hope.add("1011100111011101");
        
        List<String> faith = new ArrayList<String>();
        faith.add("1011101111111111");
        faith.add("1100011101001100");
        
        
        
        String str1 ="";
        
        for(String str : faith) {
        	int k = Integer.parseInt(str, 2);
        	str1 += (char) k;
        }
        System.out.println(str1);
        
        str1 ="";
        for(String str : hope) {
        	int k = Integer.parseInt(str, 2);
        	str1 += (char) k;
        }
        System.out.println(str1);
        str1 ="";
        for(String str : love) {
        	int k = Integer.parseInt(str, 2);
        	str1 += (char) k;
        }
        System.out.println(str1);
        System.out.println();
    }

    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();

    }

    public static String prettyBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }
    
    public static void pringString( String bits) {
    			String printTaget = new String(
    			    ByteBuffer.allocate(4).putInt(
    			        Integer.parseInt(bits, 2)
    			    ).array(), 
    			    StandardCharsets.UTF_8
    			);
    			
    			System.out.println("printTaget : " +printTaget);
    }
}