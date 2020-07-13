package by.gsu.winter20.utils;

public interface ThrowableConsumer<T> {

    void accept(T t) throws Exception;
}
