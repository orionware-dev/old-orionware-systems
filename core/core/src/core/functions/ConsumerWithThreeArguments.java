package core.functions;

@FunctionalInterface
public interface ConsumerWithThreeArguments<T1, T2, T3> extends OrionConsumer
{
    public void accept(T1 t1, T2 t2, T3 t3);
}