package designpatterns.services.designpatternsobject;

import core.services.OrionService;

public interface DesignPatternsObjectProcessorService extends OrionService
{
    public boolean registerDesignPatternsConfiguration();


    public boolean registerPipelineConfiguration();
}