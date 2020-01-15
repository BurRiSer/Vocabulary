package comparator;

import entity.Word;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {
    @Override
    public int compare(Word o1, Word o2) {
        return o1.getWord().compareToIgnoreCase((o2.getWord()));
    }
}
