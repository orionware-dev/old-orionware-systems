package configuration;

import core.tuples.Entry;

public class ConfigurationEntry<T1, T2> extends Entry<T1, T2>
{
    public ConfigurationEntry()
    {

    }


    public ConfigurationEntry(Object key, Object value)
    {
        setKey(key);
        setValue(value);
    }
}