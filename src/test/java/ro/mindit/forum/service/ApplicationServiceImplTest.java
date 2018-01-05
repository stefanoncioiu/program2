package ro.mindit.forum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import ro.mindit.forum.spring.config.RootContextConfig;
import ro.mindit.forum.spring.config.WebMvcContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootContextConfig.class, WebMvcContextConfig.class})
public class ApplicationServiceImplTest {

	@Autowired
	private ApplicationService applicationService;
	
	@Test
	public void testConfigParams() {
		Assert.notNull(applicationService.getProjectName(), "projectName is null");
		Assert.notNull(applicationService.getProjectAuthor(), "projectAuthor is null");
		Assert.notNull(applicationService.getProjectWebsite(), "projectWebsite is null");
	}
	
}
