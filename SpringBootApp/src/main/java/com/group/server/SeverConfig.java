package com.group.server;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class SeverConfig implements EmbeddedServletContainerCustomizer{

	public void customize(ConfigurableEmbeddedServletContainer container) {
		MimeMappings mimeMappings = new MimeMappings();
		mimeMappings.add("html", "text/html;charset=utf-8");
		mimeMappings.add("json", "text/html;charset=utf-8");
		container.setMimeMappings(mimeMappings);
		/*container.setPort(2018);*/
		/*container.setContextPath("/SpringBootApp");*/
		container.setDisplayName("Testing BootApp");
		/*new ErrorPage(HttpStatus.OK, "/405.html");*/
	}
	
	

}
