package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Event<T> {
    private final List<Consumer<T>> handlers = new ArrayList<Consumer<T>>();

    public void addListener(Consumer<T> handler) {
        handlers.add(handler);
    }

    public void removeListener(Consumer<T> handler) {
        handlers.remove(handler);
    }

    public void invoke(T args) {
        for (Consumer<T> handler : new ArrayList<>(handlers)) {
            handler.accept(args);
        }
    }

    public void clear() {
        handlers.clear();
    }
}
