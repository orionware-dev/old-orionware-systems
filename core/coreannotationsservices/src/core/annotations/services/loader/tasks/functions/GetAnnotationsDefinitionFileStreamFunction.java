package core.annotations.services.loader.tasks.functions;

import java.io.InputStream;
import core.filesystem.streams.FileSystemServiceImpl;
import core.functions.OrionAbstractFunction;

public class GetAnnotationsDefinitionFileStreamFunction extends OrionAbstractFunction
{
    public InputStream run(String libraryAnnotationsDefinitionFilePath)
    {
        return new FileSystemServiceImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
    }
}