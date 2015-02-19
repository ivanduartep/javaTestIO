package com.uabc.dowa.io;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileCharacterCounter {

   private static final String fileName = "chewie.txt";

    public static int countNumberOfOccurrencesInFile(char character) {

        String fileName = FileCharacterCounter.fileName;
        List<String> lines = FileCharacterCounter.getLinesByFile(fileName);

        int counter = 0;

        for(String currentLine : lines){

            for (char currentCharacter : currentLine.toCharArray()) {
                  if (currentCharacter == character) {
                    counter++;
                  }
            }
        }

        return counter;
    }

    private static List<String> getLinesByFile(String fileName)
    {
        String currentLine;
        List<String> lines = new ArrayList<String>();

        try (InputStream in = FileCharacterCounter.class.getResourceAsStream(fileName);
             InputStreamReader inR = new InputStreamReader(in);
             BufferedReader reader = new BufferedReader(inR);) {

            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
           System.out.println(e);
        }

        return lines;
    }

    public static List<String> getLinesInReverseOrder()
    {

        String fileName = FileCharacterCounter.fileName;
        List<String> lines = FileCharacterCounter.getLinesByFile(fileName);

        List<String> newLines =  new ArrayList<String>();

        for(String currentLine : lines){
            newLines.add(0, currentLine);
        }

        return newLines;

    }

}
