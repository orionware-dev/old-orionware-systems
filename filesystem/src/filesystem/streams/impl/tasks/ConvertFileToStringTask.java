package filesystem.streams.impl.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import core.utilities.strings.impl.CoreStringsServiceImpl;
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

            fileStringBuilder = new CoreStringsServiceImpl().deleteLineSeparatorFromTheEnd(fileStringBuilder);
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

        return fileAsString;
    }
}