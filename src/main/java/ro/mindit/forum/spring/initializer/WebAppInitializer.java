package ro.mindit.forum.spring.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ro.mindit.forum.spring.config.RootContextConfig;
import ro.mindit.forum.spring.config.WebMvcContextConfig;

/**
 * This is the java version of the web.xml
 *
 * @author adrian.dafinoiu
 * @since 1/3/2018
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootContextConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcContextConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}