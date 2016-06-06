package core.functions;

@FunctionalInterface
public interface Function1x1<T1, R> extends OrionFunction
{
    public R run(T1 t1);
}