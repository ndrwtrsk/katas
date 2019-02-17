package nd.rw;


import java.util.Optional;
import java.util.stream.Stream;

class StringCalculator {

  public int add(String numbersAsString) {
    if (numbersAsString == null || numbersAsString.isBlank()) {
      return 0;
    }

    var maybeDelimiter = checkForCustomDelimiter(numbersAsString);

    var stringStream = maybeDelimiter.isPresent()
        ? Stream.of(numbersAsString.substring(4))
        : Stream.of(numbersAsString);

    var delimiter = maybeDelimiter.orElse(',');
    var splitRegex = "\n|" + delimiter;

    return stringStream
        .map(s -> s.split(splitRegex))
        .flatMap(Stream::of)
        .mapToInt(Integer::parseInt)
        .peek(this::assertNotNegative)
        .filter(value -> value <= 1000)
        .sum();
  }

  private void assertNotNegative(int value) {
      if (value < 0) {
        throw new IllegalArgumentException("Negatives not allowed " + value);
      }
  }

  private Optional<Character> checkForCustomDelimiter(String numbersAsString) {
    return numbersAsString.startsWith("//")
        ? Optional.of(numbersAsString.charAt(2))
        : Optional.empty();
  }

}
