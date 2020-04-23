package challenge;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SentenceProcessorTest {

    @Test
    public void testLongestWordHappyPath() {
        SentenceProcessor processor = new SentenceProcessor();
        String longestWord = processor.getLongestWordInSentence("The cow jumped over the moon.");
        assertThat(longestWord).isEqualTo("jumped 6");
    }

    @Test
    public void testOneWordSentence() {
        SentenceProcessor processor = new SentenceProcessor();
        String result = processor.getLongestWordInSentence("yes");
        assertThat(result).isEqualTo("yes 3");
    }
}