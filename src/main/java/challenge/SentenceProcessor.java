package challenge;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class SentenceProcessor {

    private static final String DELIMITER = " ";

    public String getLongestWordInSentence(String sentence) {
        TreeMap<Integer, String> sortedGroupings = getWordsGroupedByLength(sentence);
        return sortedGroupings.get(sortedGroupings.lastKey()) + " " + sortedGroupings.lastKey();
    }

    private TreeMap<Integer, String> getWordsGroupedByLength(String sentence) {
        String[] wordsInPhrase = sentence.split(DELIMITER);
        List<String> wordsAsList = Arrays.asList(wordsInPhrase);
        Map<Integer, String> wordsGroupedByLength = wordsAsList.stream()
                .collect(groupingBy(String::length, joining(" ")));

        TreeMap<Integer, String> sortedGroupings = new TreeMap<>(wordsGroupedByLength);
        return sortedGroupings;
    }
}
