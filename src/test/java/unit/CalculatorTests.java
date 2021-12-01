package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import prod.Calculator;

public class CalculatorTests {

    private Calculator sut;

    @Before
    public void setup()
    {
        sut = new Calculator();
    }

    @Test
    public void AddShouldReturnSevenWhenPassedThreeAndThree(){

        int expected = 12;
        int[] numbers = {2,2,2,2,2,2};

        int actual = sut.Add(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void AddShouldReturnSumOfArrayPassed(){

        int[] numbers = {3,4,3};

        int actual = sut.Add(numbers);

        Assert.assertEquals(10, actual);
    }
}
