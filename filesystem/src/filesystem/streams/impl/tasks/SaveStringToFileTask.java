package filesystem.streams.impl.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;

public class SaveStringToFileTask extends FileSystemObject implements FileSystemTask
{
    private boolean addEmptyLineAtTheEndOfTheFile;
    private String lineSeparator;
    private BufferedWriter output;
    private int numberOfLines;
    private int lineCounter;
    private boolean areThereErrors;


    public SaveStringToFileTask()
    {
        this.addEmptyLineAtTheEndOfTheFile = false;
        this.lineSeparator = System.lineSeparator();
        this.areThereErrors = false;
    }


    public boolean run(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile)
    {
        this.addEmptyLineAtTheEndOfTheFile = addEmptyLineAtTheEndOfTheFile;
        return run(filePath, fileString);
    }


    public boolean run(String filePath, String fileString)
    {
        this.output = (BufferedWriter)new GetWriterForFileTask().run(filePath);
        String[] lines = fileString.split(lineSeparator);
        this.numberOfLines = lines.length;
        this.lineCounter = 1;

        try
        {
            for(String line : lines)
            {
                writeLineToFile(line);
            }
        }
        finally
        {
            new CloseResourceTask().run(output);
        }

        return areThereErrors;
    }


    private void writeLineToFile(String lineToWrite)
    {
        try
        {
            output.write(lineToWrite);

            // we avoid an empty line at the end of the file
            if(lineCounter != numberOfLines || addEmptyLineAtTheEndOfTheFile)
            {
                output.write(lineSeparator);
            }
        }
        catch(FileNotFoundException exception)
        {
            areThereErrors = true;
            exception.printStackTrace();
        }
        catch(IOException exception)
        {
            areThereErrors = true;
            exception.printStackTrace();
        }
    }
}