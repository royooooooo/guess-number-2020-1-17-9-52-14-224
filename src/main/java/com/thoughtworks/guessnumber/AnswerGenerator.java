package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnswerGenerator {

  public static Integer[] generate() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    Collections.shuffle(numbers);
    return (Integer[]) Arrays.copyOfRange(numbers.toArray(), 0, 4);
  }
}
