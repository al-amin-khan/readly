package me.alaminkhan.readly;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
public class MvcConfig {
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    exposeDirectory("photos", registry);
  }

  private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
    Path uploadDir = Paths.get(dirName);
    String uploadPath = uploadDir.toFile().getAbsolutePath();

    if (dirName.startsWith("../")) dirName = dirName.replace("../", "");

    registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
  }
}
