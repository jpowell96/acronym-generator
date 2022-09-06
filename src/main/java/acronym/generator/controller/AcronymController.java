package acronym.generator.controller;

import acronym.generator.service.AcronymService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acronym")
public class AcronymController {
    AcronymService acronymService;

    public AcronymController(AcronymService acronymService) {

        this.acronymService = acronymService;
        System.out.println("Hello");
    }

    @GetMapping("/generate")
    public List<String> generateAcronym(@RequestParam("word") String word) {
        return acronymService.generateAcronym(word.toLowerCase());
    }
}
