package core.general;

public class Triple<T1, T2, T3>
{
    private T1 one;
    private T2 two;
    private T3 three;
    
    
    public Triple(){}
    
    
    public Triple(T1 one, T2 two, T3 three)
    {
        setOne(one);
        setTwo(two);
        setThree(three);
    }


    public T1 getOne()
    {
        return this.one;
    }


    public void setOne(T1 one)
    {
        this.one = one;
    }


    public T2 getTwo()
    {
        return this.two;
    }


    public void setTwo(T2 two)
    {
        this.two = two;
    }


    public T3 getThree()
    {
        return this.three;
    }


    public void setThree(T3 three)
    {
        this.three = three;
    }
}