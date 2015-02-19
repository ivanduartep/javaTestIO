package com.uabc.dowa.io;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileCharacterCounter {

   private String fileName = "chewie.txt";

    public static int countNumberOfOccurrencesInFile(char character) {

        FileCharacterCounter characterCounter = new FileCharacterCounter();

        String fileName = characterCounter.getFileName();
        LinkedList<String> lines = FileCharacterCounter.getLinesByFile(fileName);

        int counter = 0;

        for(int linePosition = 0; linePosition < lines.size(); linePosition++){

            String currentLine = lines.get(linePosition);

            for (int charPosition = 0; charPosition < currentLine.length(); charPosition++) {
                  if (currentLine.charAt(charPosition) == character) {
                    counter++;
                  }
            }
        }

        return counter;
    }

    public static LinkedList<String> getLinesByFile(String fileName)
    {
        String currentLine;
        LinkedList<String> lines = new LinkedList<>();

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

    public static LinkedList<String> getLinesInReverseOrder()
    {
        FileCharacterCounter characterCounter = new FileCharacterCounter();

        String fileName = characterCounter.getFileName();
        LinkedList<String> lines = FileCharacterCounter.getLinesByFile(fileName);

        LinkedList<String> newLines =  new LinkedList<>();

        for(int linePosition = 0; linePosition < lines.size(); linePosition++){
            newLines.add(lines.get(lines.size() - linePosition - 1));
        }

        return newLines;

    }

    public void setFileName(String newFileName){
        this.fileName = newFileName;
    }

    public String getFileName(){
        return this.fileName;
    }

}
