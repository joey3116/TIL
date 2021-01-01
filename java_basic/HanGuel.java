package ana.joey.study.SpringStudy;

import java.io.UnsupportedEncodingException;

public class HanGuel {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string = "한글";  
		HanGuel  hg = new HanGuel();
		
		String myString = "";
		for (int i = 0; i < string.length(); i++) {  
		    System.out.print(String.format("U+%04X ", string.codePointAt(i)));
		    myString += String.format("U+%04X ", string.codePointAt(i));
			System.out.println( String.format("U+%04X ", string.codePointAt(i)));
			System.out.println("HANGUEL:");
			System.out.println(hg.decode(myString));
		}
		System.out.println(myString);
		
		
		String str = myString.split(" ")[0];
		str = str.replace("\\","");
		String[] arr = str.split("U+");
		String text = "";
		for(int i = 1; i < arr.length; i++){
		    int hexVal = Integer.parseInt(arr[i], 16);
		    text += (char)hexVal;
		}
		
		System.out.println(text);
		
		
	}
	
	public String decode(String in)
	{
	    String working = in;
	    int index;
	    index = working.indexOf("\\u");
	    while(index > -1)
	    {
	        int length = working.length();
	        if(index > (length-6))break;
	        int numStart = index + 2;
	        int numFinish = numStart + 4;
	        String substring = working.substring(numStart, numFinish);
	        int number = Integer.parseInt(substring,16);
	        String stringStart = working.substring(0, index);
	        String stringEnd   = working.substring(numFinish);
	        working = stringStart + ((char)number) + stringEnd;
	        index = working.indexOf("\\u");
	    }
	    return working;
	}
}
