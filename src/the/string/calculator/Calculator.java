package the.string.calculator;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Divy
 */
public class Calculator {
    
    //Add(String,String) method accept the input string with delimiter and
    //check if input string is empty or not if input string is empty then return 0 and
    //if input string is not empty then check input string startwith "//" or not 
    //if input string is start with "//" then split the string with "\n" and store in array string 
    //and find the different delimiter that exist in string using parseDelimiter() method pass input string of 1st position 
    //and then again pass input string of 2nd position of array string and new delimiter in add(string,string) method
    //hole process start again
    //if input string not start with "//" then split the input string with delimiter and store in array string
    //and then pass the array string to calculate the sum using Final_Sum() method
    private static int Add(String input, String delimiter){
	if(input.equals(""))
        {
            return 0;
	}
        else if(input.startsWith("//"))
        {
            String[] h = input.split("\n", 2);
            delimiter = parseDelimiter(h[0]);
            int ans = Add(h[1], delimiter);
            return ans;
        }
	else
        {
            String num[] = input.split(delimiter+"|\n");
            return Final_Sum(num);
        }
    }
    
    
    //Add(string) accept the input string that pass by the TestCalculate.java file
    //then pass this input string with default delimiter="," to Add(string,string) method
    public static int Add(String input)
    {
        return Add(input, ",");
    }
    
    //parseDelimiter(string) method accept string then
    //remove the "//" form the string 
    //if string length is 1 then return 
    //if string length is more then one then find the delimiter that contain multiple delimiter
    //then return new delimiter
    public static String parseDelimiter(String header)
    {
	String delimiter = header.substring(2);
        if(delimiter.length()==1)
        {
            return delimiter;
        }
        if (delimiter.startsWith("["))
        {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
	}
        return Stream.of(delimiter.split("]\\[")).map(Pattern::quote).collect(Collectors.joining("|"));
    }

    //Final_Sum() method return the sum of number that given in string
    //if number is nagative then throw the IllegalArgumentException
    //if number is greater then 1000 then this number should be ignored
    //otherwise return the the sum of all the nmumber
    private static int Final_Sum(String[] numbers)
    {
 	int final_total = 0;
        String NegativeString = "";

        for(String number : numbers)
        {
            if(Integer.parseInt(number) < 0)
            {
        	if(NegativeString.equals(""))
                {
                    NegativeString = number;
                }   
        	else
                {
                    NegativeString += ("," + number);
                }
            }
            if(Integer.parseInt(number) < 1000)
            {
                final_total += Integer.parseInt(number);
            }
        }

	if(!NegativeString.equals(""))
        {
            throw new IllegalArgumentException("Negatives not allowed: " + NegativeString);
	}
        return final_total;
    }
}
