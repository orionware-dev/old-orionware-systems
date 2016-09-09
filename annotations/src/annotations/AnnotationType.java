package annotations;

import core.abstraction.OrionEnumeration;

public enum AnnotationType implements OrionEnumeration
{
    CLASS,
    INSTANCE_VARIABLE,
    CONSTRUCTOR,
    METHOD;


    @Override
    public String get()
    {
        return null;
    }
}