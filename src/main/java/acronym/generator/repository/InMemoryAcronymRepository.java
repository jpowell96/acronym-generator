package acronym.generator.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Repository
public class InMemoryAcronymRepository implements AcronymRepository {
    private static final String WORD_FILE_NAME = "words.txt";
    Map<Character, List<String>> characterToWords = new HashMap<>();


    public InMemoryAcronymRepository() {

    }

    @PostConstruct
    public void populateWordMap() throws Exception {
        // 1. Get the file
        InputStream is = getClass().getClassLoader().getResourceAsStream(WORD_FILE_NAME);
        BufferedReader wordsFileReader = new BufferedReader(new InputStreamReader(is));

        wordsFileReader.lines()
                .forEach(word -> {
                    Character firstChar = word.charAt(0);
                    if (characterToWords.containsKey(firstChar)) {
                        characterToWords.get(firstChar).add(word);
                    } else {
                        List<String> wordList = new ArrayList<>();
                        wordList.add(word);
                        characterToWords.put(firstChar, wordList);
                    }
                });
    }

    @Override
    public List<String> getAcronym(String word) {
        List<String> result = new ArrayList<>();
        // 1. Split to characters
        char[] asChars = word.toCharArray();
        for (char c : asChars) {
            result.add(getRandomWordForCharacter(c, characterToWords.getOrDefault(c, Collections.emptyList())));
        }
        return result;
    }

    private String getRandomWordForCharacter(Character c, List<String> words) {
        if (words.isEmpty()) {
            return "";
        }
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}
