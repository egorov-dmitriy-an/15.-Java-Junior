import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Task_1 {
    public static void main(String[] args) {

        // * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000))
                .limit(1_000).toList();
        System.out.println(list);

        // * 1.1 Найти максимальное
        Integer maximal = list.stream().max(Integer::compare).get();
        System.out.println("max = " + maximal);

        // * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        Integer summa = list.stream()
                .filter(it -> it > 500_000)
                .map(it -> it * 5 - 150)
                .reduce(Integer::sum).get();
        System.out.println("sum = " + summa);

        //  * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        long counter = list.stream()
                .filter(it -> it * it < 100_000)
                .count();
        System.out.println("count = " + counter);
    }
}