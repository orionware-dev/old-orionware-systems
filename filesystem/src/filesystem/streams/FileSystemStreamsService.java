package filesystem.streams;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import filesystem.FileSystemService;

public interface FileSystemStreamsService extends FileSystemService
{
    public InputStream getFileStream(String fileLocation);


    public void closeResource(Closeable stream);


    public Reader getReaderForFile(String filePath);


    public Writer getWritterForFile(String filePath);
}