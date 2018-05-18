/*
接口是通用功能的抽象，比如 comparable 接口
把栈写成接口，是为了让其他类也能实现

*/
public interface Stack<T> {
    int getSize();

    boolean isEmpty();

    void push(T e);

    T pop();

    T peak();
}
