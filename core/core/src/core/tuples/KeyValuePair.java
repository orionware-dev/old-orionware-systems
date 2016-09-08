package core.tuples;

public class KeyValuePair<T1, T2> implements Pair<T1, T2>
{
    private Object first;
    private Object second;


    public KeyValuePair()
    {

    }


    public KeyValuePair(Object first, Object second)
    {
        setFirst(first);
        setSecond(second);
    }


    public Object getFirst()
    {
        return this.first;
    }


    public void setFirst(Object first)
    {
        this.first = first;
    }


    public Object getSecond()
    {
        return this.second;
    }


    public void setSecond(Object second)
    {
        this.second = second;
    }
}