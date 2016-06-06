package core.functions;

@FunctionalInterface
public interface Function3x1<T1, T2, T3, R> extends OrionFunction
{
    public R run(T1 t1, T2 t2, T3 t3);
}