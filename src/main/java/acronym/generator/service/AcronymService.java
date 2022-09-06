package acronym.generator.service;

import acronym.generator.repository.AcronymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcronymService {
    private final AcronymRepository acronymRepository;

    public AcronymService(AcronymRepository acronymRepository) {
        this.acronymRepository = acronymRepository;
    }

    public List<String> generateAcronym(String word) {
        return acronymRepository.getAcronym(word);
    }
}
