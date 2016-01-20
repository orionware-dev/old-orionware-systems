package core.filesystem;

import core.filesystem.tasks.CloseResourceTask;
import core.filesystem.tasks.ConvertFileToStringTask;
import core.filesystem.tasks.EmptyDirectoryTask;
import core.filesystem.tasks.GetFileStreamTask;
import core.filesystem.tasks.GetReaderFromFileTask;
import core.filesystem.tasks.GetWriterForFileTask;
import core.filesystem.tasks.SaveStringToFileTask;
import core.general.ObjectDependenciesBuilder;

public class FileSystemServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(FileSystemServiceImpl object)
    {
        object.setGetFileStreamTask(new GetFileStreamTask());
        object.setConvertFileToStringTask(new ConvertFileToStringTask());
        object.setSaveStringToFileTask(new SaveStringToFileTask());
        object.setEmptyDirectoryTask(new EmptyDirectoryTask());
        object.setCloseResourceTask(new CloseResourceTask());
        object.setGetReaderFromFileTask(new GetReaderFromFileTask());
        object.setGetWriterForFileTask(new GetWriterForFileTask());
    }
}