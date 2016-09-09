package reflection;

public class OrionClass
{
    private Class<?> thisClass;
    private String classPackage;
    private String className;
    private String classFullName;


    public OrionClass(Class<?> aClass)
    {
        setThisClass(aClass);
        setClassPackage(getThisClass().getPackage().getName());
        setClassName(getThisClass().getSimpleName());
        setClassName(getThisClass().getName());
    }


    public Class<?> getThisClass()
    {
        return this.thisClass;
    }


    public void setThisClass(Class<?> thisClass)
    {
        this.thisClass = thisClass;
    }


    public String getClassPackage()
    {
        return this.classPackage;
    }


    public void setClassPackage(String classPackage)
    {
        this.classPackage = classPackage;
    }


    public String getClassName()
    {
        return this.className;
    }


    public void setClassName(String className)
    {
        this.className = className;
    }


    public String getClassFullName()
    {
        return this.classFullName;
    }


    public void setClassFullName(String classFullName)
    {
        this.classFullName = classFullName;
    }
}