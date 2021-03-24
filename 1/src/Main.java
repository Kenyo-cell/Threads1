public class Main {

    public static void main(String[] args) throws Exception{
    	ThreadGroup group = new ThreadGroup("main");
	    new MyThread("Garry", group).start();
	    new MyThread("Kim", group).start();
	    new MyThread("Kenny", group).start();
	    new MyThread("Hardy", group).start();
	    Thread.sleep(15000);
	    group.interrupt();
    }
}
