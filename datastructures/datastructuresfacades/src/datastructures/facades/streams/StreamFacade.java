package datastructures.facades.streams;

import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructure;
import datastructures.DataStructuresFacade;
import datastructures.lists.OrionList;
import datastructures.sets.OrionSet;

public interface StreamFacade<T> extends DataStructuresFacade
{
    public void forEach(Stream<T> stream, Consumer<?> action);
}