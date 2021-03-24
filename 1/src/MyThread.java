public class MyThread extends Thread{

    public MyThread(String name, ThreadGroup group) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.printf("Hello! I'm %s\n", getName());
                Thread.sleep(2500);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.printf("%s - ended!\n", getName());
        }
    }
}
