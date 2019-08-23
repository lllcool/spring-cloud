package com.post.cloud.reference.ribbon;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaReferenceRibbonController {
    @Autowired
    private EurekaReferenceRibbonService ribbonService;

    // http://localhost:3333/getUser1
    @RequestMapping(value = "/getUser1", method = RequestMethod.GET)
    public String getUser() {
        return ribbonService.getUser();
    }

    // http://localhost:3333/add1
    @RequestMapping(value = "/add1", method = RequestMethod.GET)
    public String add() {
        return ribbonService.add();
    }
}
