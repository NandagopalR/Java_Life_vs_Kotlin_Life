class KotlinConvertingAListExample {
  fun getDevsByPartition(developers: List<Developer>): Pair<List<Developer>, List<Developer>> {
    val (androidDevs, iosDevs) = developers
      .partition { developer -> developer.platform == Developer.Platform.ANDROID }
    return Pair(androidDevs, iosDevs)
  }
}