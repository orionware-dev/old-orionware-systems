package filesystem.files.impl.tasks;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import filesystem.FileSystemObject;
import filesystem.FileSystemTask;
import filesystem.streams.impl.tasks.CloseResourceTask;
import filesystem.streams.impl.tasks.GetWriterForFileTask;

public class SaveStringToFileTask extends FileSystemObject implements FileSystemTask
{
    private static boolean addEmptyLineAtTheEndOfTheFile = false;
    private static String lineSeparator = System.lineSeparator();
    private static BufferedWriter output;
    private static int numberOfLines;
    private static int lineCounter;
    private static boolean areThereErrors = false;


    public static boolean run(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile)
    {
        SaveStringToFileTask.addEmptyLineAtTheEndOfTheFile = addEmptyLineAtTheEndOfTheFile;
        return run(filePath, fileString);
    }


    public static boolean run(String filePath, String fileString)
    {
        output = (BufferedWriter)GetWriterForFileTask.run(filePath);
        String[] lines = fileString.split(lineSeparator);
        numberOfLines = lines.length;
        lineCounter = 1;

        try
        {
            for(String line : lines)
            {
                writeLineToFile(line);
            }
        }
        finally
        {
            CloseResourceTask.run(output);
        }

        return areThereErrors;
    }


    private static void writeLineToFile(String lineToWrite)
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