package filesystem.services.streams.impl.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class ConvertFileToStringTask extends FileSystemObject implements FileSystemTask
{
    public String run(BufferedReader input)
    {
        String fileAsString = "";
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
            new CloseResourceTask().run(input);
        }
        
        fileAsString = fileStringBuilder.toString();
        
        if(fileAsString.endsWith(System.lineSeparator()))
        {
            fileAsString.substring(0, fileAsString.length() - 2);
        }

        return fileAsString;
    }
}