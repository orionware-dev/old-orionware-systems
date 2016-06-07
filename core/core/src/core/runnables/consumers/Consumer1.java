package core.runnables.consumers;

@FunctionalInterface
public interface Consumer1<T1> extends OrionConsumer
{
    public void run(T1 t1);
}