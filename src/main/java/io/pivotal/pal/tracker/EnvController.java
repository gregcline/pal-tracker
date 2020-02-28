package io.pivotal.pal.tracker;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String instanceIndex;
    private String instanceAdder;

    public EnvController(
            @Value("${port:NOT SET}")String port,
            @Value("${memory.limit:NOT SET}")String memoryLimit,
            @Value("${cf.instance.index:NOT SET}")String instanceIndex,
            @Value("${cf.instance.addr:NOT SET}")String instanceAdder
            ) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.instanceIndex = instanceIndex;
        this.instanceAdder = instanceAdder;
            }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return Map.of(
                "PORT", port,
                "MEMORY_LIMIT", memoryLimit,
                "CF_INSTANCE_INDEX", instanceIndex,
                "CF_INSTANCE_ADDR", instanceAdder
            );
    }
}
