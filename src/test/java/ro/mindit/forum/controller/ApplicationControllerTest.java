package ro.mindit.forum.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import ro.mindit.forum.spring.config.RootContextConfig;
import ro.mindit.forum.spring.config.WebMvcContextConfig;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootContextConfig.class, WebMvcContextConfig.class})
public class ApplicationControllerTest {

    @Autowired
    private ApplicationController applicationController;

    @Test
    public void testConfigEndpoint() {
        Map<String, String> res = applicationController.config();

        Assert.notNull(res, "result is null");
        Assert.notEmpty(res, "result is empty");
        Assert.isTrue(res.size() == 3, "result size is not 3");
    }
}
