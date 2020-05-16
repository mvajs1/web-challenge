package com.automationpractice.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.List;

public class FileWriter {

    public void writeDataToFile(List<String> data, String fileName) {
        if (data.isEmpty()) {
            return;
        }

        File file = new File(String.format("target/%s", fileName));
        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("Unable to find file: %s.", file.getAbsoluteFile()), e);
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        for (int i = 0; i < data.size(); i++) {
            try {
                writer.write(data.get(i));
                if (i != data.size() - 1) {
                    writer.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to write data to file.", e);
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to close BufferedWriter.", e);
        }
    }
}
