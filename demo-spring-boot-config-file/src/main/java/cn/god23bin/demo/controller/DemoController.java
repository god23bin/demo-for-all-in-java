package cn.god23bin.demo.controller;

import cn.god23bin.demo.config.DemoCustomConfig;
import cn.god23bin.demo.config.DemoPropertiesSourceConfig;
import cn.god23bin.demo.config.SystemCustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author god23bin
 * @created 2023/3/22 23:17
 */
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private DemoCustomConfig demoCustomConfig;

    @Autowired
    private SystemCustomConfig systemCustomConfig;

    @Autowired
    private DemoPropertiesSourceConfig demoPropertiesSourceConfig;

    @GetMapping("/getCustomValue")
    public ResponseEntity<String> getCustomValue() {
        return ResponseEntity.ok(demoCustomConfig.getAuthor() + "说：" + demoCustomConfig.getDescription());
    }

    @GetMapping("/getSystemVersion")
    public ResponseEntity<String> getSystemVersion() {
        return ResponseEntity.ok(systemCustomConfig.getName() + "版本：" + systemCustomConfig.getVersion());
    }

    @GetMapping("/getCustomFileVersion")
    public ResponseEntity<String> getCustomFileVersion() {
        return ResponseEntity.ok(demoPropertiesSourceConfig.getDescription() + "版本：" + demoPropertiesSourceConfig.getVersion());
    }

}
