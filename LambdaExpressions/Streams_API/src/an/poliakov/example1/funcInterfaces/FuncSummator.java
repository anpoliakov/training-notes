package an.poliakov.example1.funcInterfaces;

@FunctionalInterface
public interface FuncSummator {
    int sum(int a, int b);

    //может содержать static методы
    static void meth1() {
        //тело метода
    }

    //может содержать default методы
    default void meth2() {
        //тело метода
    }
}