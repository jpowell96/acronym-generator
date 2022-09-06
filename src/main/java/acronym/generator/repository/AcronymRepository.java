package acronym.generator.repository;

import java.util.List;

public interface AcronymRepository {
    List<String> getAcronym(String word);
}
