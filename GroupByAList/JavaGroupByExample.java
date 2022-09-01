package com.sedintechnologies.workbook.model.adminconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaGroupByExample {
  private Map<String, List<Developer>> getDevsMapByDefault(List<Developer> developers) {
    Map<String, List<Developer>> developerMap =
        new HashMap<String, List<Developer>>();
    developers.forEach(developer -> {
      if (!developerMap.containsKey(developer.getDesignation())) {
        List<Developer> list = new ArrayList<Developer>();
        list.add(developer);
        developerMap.put(developer.getDesignation(), list);
      } else {
        developerMap.get(developer.getDesignation()).add(developer);
      }
    });
    return developerMap;
  }

  private Map<String, List<Developer>> getDevsMapByStreams(List<Developer> developers) {
    return developers.stream().collect(Collectors.groupingBy(Developer::getDesignation));
  }
}
