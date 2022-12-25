package an.poliakov.example3;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone (String result);
}
