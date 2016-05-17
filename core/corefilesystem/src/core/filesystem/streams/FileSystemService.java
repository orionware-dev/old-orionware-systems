package core.filesystem.streams;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import core.filesystem.OrionFileSystemService;

public interface FileSystemService extends OrionFileSystemService
{
    public InputStream getFileStream(String fileLocation);
    
    
    public String convertFileToString(String filePath);


    public boolean saveStringToFile(String filePath, String fileString);
    
    
    public void emptyDirectory(String directory);
    
    
    public void closeResource(Closeable stream);
    
    
    public Reader getReaderForFile(String filePath);
    
    
    public Writer getWritterForFile(String filePath);
}