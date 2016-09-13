package designpatterns.designpatternsobject;

import core.services.OrionService;

public interface DesignPatternsObjectProcessorService extends OrionService
{
    public boolean registerDesignPatternsConfiguration();


    public boolean registerPipelineConfiguration();
}