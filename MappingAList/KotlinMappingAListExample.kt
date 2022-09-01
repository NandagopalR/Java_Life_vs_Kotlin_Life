class KotlinMappingAListExample {
  fun getDevMap(developers: List<Developer>): Map<Long, Developer> {
    return developers.associateBy { developer -> developer.developerId }
  }
}