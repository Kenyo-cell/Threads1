public class Result {
    private String name;
    private int count;


    public Result(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String toString() {
        return String.format("From %s thread %d messages", name, count);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
