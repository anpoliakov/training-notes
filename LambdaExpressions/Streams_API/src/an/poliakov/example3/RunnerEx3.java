package an.poliakov.example3;

/**
 * Пример задачи с использованием функц. интерфейсов и лябда-выражений
 * */
public class RunnerEx3 {
    public static void main(String[] args) {
        OnTaskDoneListener listener = n -> System.out.println(n + " - OK");
        Worker worker = new Worker(listener);
        worker.start();
    }
}
