package core.general;

import java.util.function.Consumer;
import java.util.stream.Stream;
import core.OrionSimpleObject;

public class OrionStream<T> extends OrionSimpleObject
{
    @SuppressWarnings("unchecked")
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        stream.forEach((Consumer<? super T>)action);
    }
}