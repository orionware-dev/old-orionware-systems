package core.functions;

@FunctionalInterface
public interface Function2x1<T1, T2, R> extends OrionFunction
{
    public R run(T1 t1, T2 t2);
}