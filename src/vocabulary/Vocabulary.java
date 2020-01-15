package vocabulary;

import comparator.WordComparator;
import entity.TextPart;
import entity.Word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Vocabulary {
    private SortedSet<Word> words;

    public SortedSet<Word> getWords() {
        return words;
    }

    public void setWords(SortedSet<Word> words) {
        this.words = words;
    }

    public Vocabulary() {
    }

    /*Add words from list of text parts*/
    public SortedSet<Word> addWordsFromParts(List<TextPart> textParts){
        for (TextPart textPart : textParts) {
            if (textPart instanceof Word) {
                addWord(((Word) textPart));
            }
        }
        return words;
    }

    /*Create treeSet with comparator and add word*/
    public void addWord(Word word) {
        if (words == null) {
            words = new TreeSet<>(new WordComparator());
        }
        words.add(word);
    }

    /*Prints words to file*/
    public void printToFile(String filename) {
        if (words != null) {
            BufferedWriter writer;
            String letter = "";
            boolean redLine = true;
            boolean firstLine = true;
            try {
                writer = new BufferedWriter(new FileWriter(filename));
                for (Word word : words) {
                    if (!word.getWord().substring(0, 1).toLowerCase().equals(letter.toLowerCase())) {
                        redLine = true;
                        letter = word.getWord().substring(0, 1);
                    }
                    if (redLine) {
                        if (!firstLine) {
                            writer.newLine();
                        }
                        writer.write("\t" + word.getWord());
                    } else {
                        writer.write(" " + word.getWord());
                    }
                    firstLine = false;
                    redLine = false;
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Cannot write to the file " + filename);
            }
        } else {
            System.out.println("Vocabulary is empty!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vocabulary{");
        sb.append("words=").append(words);
        sb.append('}');
        return sb.toString();
    }
}
