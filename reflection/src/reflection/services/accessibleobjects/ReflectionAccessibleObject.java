package reflection.services.accessibleobjects;

import core.abstraction.OrionEnumeration;

public enum ReflectionAccessibleObject implements OrionEnumeration
{
    ANY_INSTANCE_VARIABLE,
    DECLARED_INSTANCE_VARIABLE,
    PRIVATE_INSTANCE_VARIABLE,
    DECLARED_PROTECTED_INSTANCE_VARIABLE,
    DECLARED_PUBLIC_INSTANCE_VARIABLE,
    INHERITTED_INSTANCE_VARIABLE,
    DECLARED_CONSTRUCTOR,
    PUBLIC_CONSTRUCTOR,
    ANY_METHOD,
    DECLARED_METHOD,
    PRIVATE_METHOD,
    DECLARED_PROTECTED_METHOD,
    DECLARED_PUBLIC_METHOD,
    INHERITTED_METHOD;
    

    @Override
    public String get()
    {
        return null;
    }
}