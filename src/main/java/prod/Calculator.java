package prod;

import java.util.Arrays;

public class Calculator {
    public int Add(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
