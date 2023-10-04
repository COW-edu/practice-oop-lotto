package lotto;

public class Application {
    private Counter counter;
    public void run(){
        counter = new Counter();
        counter.run();
    }
    public static void main(String[] args) {
        Application main = new Application();
       main.run();
    }
}
