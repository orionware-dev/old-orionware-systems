package core.runnables.functions;

@FunctionalInterface
public interface Function4x1<T1, T2, T3, T4, R> extends OrionFunction
{
    public R run(T1 t1, T2 t2, T3 t3, T4 t4);
}