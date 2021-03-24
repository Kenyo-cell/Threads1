import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class CalableSum extends RecursiveTask<Integer> {
    private final int MIN = 100;
    private List<Integer> array;

    public CalableSum(List<Integer> array) {
        this.array = array;
    }



    private int recursiveSum() {
        int sum = 0;
        if (array.size() > MIN) {
            CalableSum c1 = new CalableSum(array.subList(0, array.size() / 2));
            CalableSum c2 = new CalableSum(array.subList(array.size() / 2, array.size()));

            invokeAll(c1, c2);
            sum += c1.join() + c2.join();
        } else {
            sum += IntStream.of(array.stream().mapToInt(Integer::intValue).toArray()).sum();
        }
        return sum;
    }

    @Override
    public Integer compute()  {
        return recursiveSum();
    }
}
