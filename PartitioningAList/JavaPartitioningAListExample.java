package com.sedintechnologies.workbook.model.adminconfig;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaPartitioningAListExample {

  private Pair<List<Developer>, List<Developer>> getDevsByDefault(List<Developer> developers) {
    List<Developer> androidDevelopers = new ArrayList<>();
    List<Developer> iosDevelopers = new ArrayList<>();

    for (int i = 0, size = developers.size(); i < size; i++) {
      Developer developer = developers.get(i);
      if (developer.getPlatform() == Developer.Platform.ANDROID) {
        androidDevelopers.add(developer);
      } else {
        iosDevelopers.add(developer);
      }
    }

    return Pair.create(androidDevelopers, iosDevelopers);
  }

  private Pair<List<Developer>, List<Developer>> getDevsByStreams(List<Developer> developers) {
    Map<Boolean, List<Developer>> developersMap =
        developers.stream()
            .collect(Collectors.partitioningBy(
                developer -> developer.getPlatform() == Developer.Platform.ANDROID));

    List<Developer> androidDevelopers = developersMap.get(true);
    List<Developer> iosDevelopers = developersMap.get(false);
    return Pair.create(androidDevelopers, iosDevelopers);
  }
}
