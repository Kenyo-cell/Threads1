import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<MyCallable> callables = Arrays.asList(new MyCallable[] {
                new MyCallable("Garry"),
                new MyCallable("Kim"),
                new MyCallable("Kenny"),
                new MyCallable("Hardy")
        });

        executor.invokeAll(callables).forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e.getMessage());
            }
        });

        System.out.println(executor.invokeAny(callables));

        executor.shutdown();
    }
}
