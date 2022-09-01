class KotlinGroupByAListExample {
  fun getDevsMap(developers: List<Developer>): Map<String, List<Developer>> {
    return developers.groupBy { developer -> developer.designation }
  }
}