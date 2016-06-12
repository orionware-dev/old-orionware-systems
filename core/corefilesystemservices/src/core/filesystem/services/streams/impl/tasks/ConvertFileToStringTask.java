package core.filesystem.services.streams.impl.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;

public class ConvertFileToStringTask extends FileSystemObject implements FileSystemTask
{
    public String run(String filePath, BufferedReader input)
    {
        String currentLine = null;
        StringBuilder fileStringBuilder = new StringBuilder();

        try
        {
            while((currentLine = input.readLine()) != null)
            {
                fileStringBuilder.append(currentLine);
                fileStringBuilder.append(System.lineSeparator());
            }
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            CloseResourceTask.run(input);
        }

        return fileStringBuilder.substring(0, fileStringBuilder.length() - 2).toString();
    }
}