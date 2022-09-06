package acronym.generator.controller;

import acronym.generator.service.AcronymService;
import io.opentelemetry.api.OpenTelemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acronym")
// TODO: Keep following this example - https://github.com/open-telemetry/opentelemetry-java-docs/tree/03099e4e39cb307f19ea19217ff381e07c9284ce/javaagent
public class AcronymController {
    private final AcronymService acronymService;
    private final OpenTelemetry openTelemetry;

    @Autowired
    public AcronymController(AcronymService acronymService, OpenTelemetry openTelemetry) {

        this.acronymService = acronymService;
        this.openTelemetry = openTelemetry;
        System.out.println("Hello");
        System.out.println("Test");
    }

    @GetMapping("/generate")
    public List<String> generateAcronym(@RequestParam("word") String word) {
        return acronymService.generateAcronym(word.toLowerCase());
    }
}
