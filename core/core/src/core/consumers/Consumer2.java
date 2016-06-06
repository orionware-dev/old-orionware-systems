package core.consumers;

@FunctionalInterface
public interface Consumer2<T1, T2> extends OrionConsumer
{
    public void run(T1 t1, T2 t2);
}