package core.tuples;

public class Entry<T1, T2> extends KeyValuePair<T1, T2>
{
    private Object key;
    private Object value;


    public Entry()
    {

    }


    public Entry(Object key, Object value)
    {
        setKey(key);
        setValue(value);
    }


    public Object getKey()
    {
        return this.key;
    }


    public void setKey(Object key)
    {
        this.key = key;
    }


    public Object getValue()
    {
        return this.value;
    }


    public void setValue(Object value)
    {
        this.value = value;
    }
}