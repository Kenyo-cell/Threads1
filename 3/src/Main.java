import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static Integer[] randomGenerator(int capacity, int max) {
        Random random = new Random();
        Integer[] res = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            res[i] = random.nextInt(max);
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(randomGenerator(10000000, 100));
        ForkJoinPool executor = new ForkJoinPool(100);
        long start = System.currentTimeMillis();
        int s = executor.invoke(new CalableSum(l));
        System.out.printf("Time for executing is %d ms\n", System.currentTimeMillis() - start);
        System.out.println(s);
        System.out.println(new Sum(l).sum());
    }
}
