package myfiche;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Component;

import myfiche.model.File;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class FileRelProvider implements RelProvider {

@Override
  public String getCollectionResourceRelFor(final Class<?> type) {
    return "files";
  }

  @Override
  public String getItemResourceRelFor(final Class<?> type) {
    return "file";
  }

  @Override
  public boolean supports(final Class<?> delimiter) {
    return File.class.isAssignableFrom(delimiter);
  }
}

