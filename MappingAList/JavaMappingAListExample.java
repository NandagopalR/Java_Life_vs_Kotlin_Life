package com.sedintechnologies.workbook.model.adminconfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaMappingAListExample {
  private Map<Long, Developer> getDevMapByDefault(List<Developer> developers) {
    Map<Long, Developer> developerMap = new HashMap<>();
    developers.forEach(developer ->
        developerMap.put(developer.getDeveloperId(), developer));
    return developerMap;
  }

  private Map<Long, Developer> getDevMapByStreams(List<Developer> developers) {
    return developers
        .stream()
        .collect(Collectors.toMap(Developer::getDeveloperId, Function.identity()));
  }
}
