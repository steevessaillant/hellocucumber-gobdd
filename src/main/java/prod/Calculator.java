package prod;

public class Calculator {
    public int Add(Integer[] numbers) {
        Integer acc = 0;
        for (int i = 0; i < numbers.length; i++){
            acc += numbers[i];
        }
        return acc;

    }
}
