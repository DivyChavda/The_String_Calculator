package the.string.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Divy
 */

public class TestCalculate {
    public static void main(String args[])
    {
      org.junit.runner.JUnitCore.main("the.string.calculator.TestCalculate");
    }
    
    
    //Q-1
    //The method can take 0(empty),single and up to two numbers, separated by commas(,) and will return their sum
    @Test
    public void TestingEmptyString()
    {
	assertEquals(0, Calculator.Add(""));
        assertEquals(1, Calculator.Add("1"));
        assertEquals(3, Calculator.Add("1,2"));
    }
    
    //Q-2
    //The method can handle an unknown amount of numbers separated by commas(,) and will return their sum
    @Test
    public void TestingMultipleNumbers()
    {
    	assertEquals(6, Calculator.Add("1,2,3"));
    }

    //Q-3
    //The method can handle new lines between numbers (instead of commas) and will return their sum
    @Test
    public void TestingNewLine_Between_Number()
    {
    	assertEquals(6, Calculator.Add("1\n2,3"));
    }
    
    //Q-4
    //The method can handle different delimiters and will return their sum
    @Test
    public void TestingSingleDelimiter(){
    	assertEquals(3, Calculator.Add("//;\n1;2")); //h[0]=; and h[1]=1;2
    }
    

    //Q-5
    //The method can handle negative number will throw an exception “negatives not allowed”
    @Test
    public void TestingNegativeNumver()
    {
	try
        {
            Calculator.Add("-1,2");
	}
	catch (IllegalArgumentException e)
        {
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
	}
    }
   
    //Q-6
    //The method can handle Numbers bigger than 1000 should be ignored and will return their sum
    @Test
    public void TestingOverThousand(){
    	assertEquals(2, Calculator.Add("1000,2"));
    }
    
    //Q-7
    //The method can handle Delimiters can be of any length and will return their sum
    @Test
    public void TestingSingleDelimiterOfAnyLength(){
    	assertEquals(6, Calculator.Add("//[***]\n1***2***3"));
    }
    
    //Q-8
    //The method can handle multiple delimiters and will return their sum
    @Test
    public void TestingMultipleDelimiter(){
        System.gc();
    	assertEquals(6, Calculator.Add("//[*][%]\n1*2%3"));
    }
    
    //Q-9
    //The method can handle multiple delimiters with length longer than one char and will return their sum
    @Test
    public void TestingMultipleDelimiterOfAnyLength(){
    	assertEquals(6, Calculator.Add("//[foo][boo]\n1foo2boo3"));
    }
}
