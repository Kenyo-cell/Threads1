import java.util.concurrent.Callable;

public class MyCallable implements Callable<Result> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Result call() {
        Thread.currentThread().setName(name);
        long start = System.currentTimeMillis();
        int counter = 0;
        try {
            while (System.currentTimeMillis() - start < 15_000) {
                System.out.printf("Hello! I'm %s\n", Thread.currentThread().getName());
                Thread.sleep(2500);
                counter++;
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } finally {
           System.out.printf("%s - ended!\n", Thread.currentThread().getName());
        }
        return new Result(name, counter);
    }
}
