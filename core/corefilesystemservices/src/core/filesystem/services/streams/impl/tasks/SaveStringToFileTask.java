package core.filesystem.services.streams.impl.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import core.filesystem.FileSystemObject;
import core.filesystem.FileSystemTask;
import core.filesystem.services.streams.FileSystemStreamsService;

public class SaveStringToFileTask extends FileSystemObject implements FileSystemTask
{
    private String lineSeparator;
    private BufferedWriter output;
    private int numberOfLines;
    private int lineCounter;
    private boolean error;


    public SaveStringToFileTask()
    {
        this.lineSeparator = System.lineSeparator();
        this.error = false;
    }


    public boolean run(FileSystemStreamsService fileSystemStreamsService, String filePath, String fileString)
    {
        this.output = (BufferedWriter)fileSystemStreamsService.getWritterForFile(filePath);
        String[] lines = fileString.split(lineSeparator);
        this.numberOfLines = lines.length;
        this.lineCounter = 1;

        try
        {
            Arrays.stream(lines).forEach(this::writeLineToFile);
        }
        finally
        {
            fileSystemStreamsService.closeResource(output);
        }

        return error;
    }


    private void writeLineToFile(String lineToWrite)
    {
        try
        {
            output.write(lineToWrite);

            //we avoid an empty line at the end of the file
            if(lineCounter != numberOfLines)
            {
                output.write(lineSeparator);
            }
        }
        catch(FileNotFoundException exception)
        {
            error = true;
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            error = true;
            exception.printStackTrace();
        }
    }
}