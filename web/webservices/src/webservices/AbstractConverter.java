package webservices;

public abstract class AbstractConverter<SOURCE, TARGET>
{
    public TARGET convert(SOURCE source, TARGET target)
    {
        return target;
    }
}