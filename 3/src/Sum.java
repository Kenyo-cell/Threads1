import java.util.Arrays;
import java.util.List;

public class Sum {
    private List<Integer> array;

    public Sum(List<Integer> array) {
        this.array = array;
    }

    public int sum() {
        long start = System.currentTimeMillis();
        int s = Arrays.stream(array.stream().mapToInt(Integer::intValue).toArray()).sum();
        long end = System.currentTimeMillis();
        System.out.printf("Time for executing is %d ms\n", end - start);
        return s;
    }

}
