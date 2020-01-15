package entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<Line> lines;
    private String filePath;

    public Book(String filePath) {
        this.filePath = filePath;
        readTextFromFile();
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void readTextFromFile() {
        try {
            lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(new Line(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("lines=").append(lines);
        sb.append("}");
        return sb.toString();
    }
}
