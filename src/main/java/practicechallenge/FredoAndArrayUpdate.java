package practicechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FredoAndArrayUpdate {
    static MyOperator<Integer> operator;
    static List<Integer> tmpNumbers ;
    public static void main(String[] args) {
        operator = new MyOperator<> ();

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < testCase; i++) {
            numbers.add(scanner.nextInt());
        }
        tmpNumbers = (List<Integer>) ((ArrayList<Integer>) numbers).clone();
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println((numbers.stream().filter(num1 -> isValid(num1,sum)).collect(Collectors.toList())).get(0));
    }

    //sum of this new array is strictly greater than the sum of the initial array
    public static Boolean isValid(int num,int sum) {
        operator.varc1=num;
        tmpNumbers.replaceAll(operator);
        return ((tmpNumbers.stream().reduce(0, Integer::sum)) > sum);
    }

    static class MyOperator<T> implements UnaryOperator<T> {
        T varc1;

        public T apply(T varc) {
            return varc1;
        }
    }
}
