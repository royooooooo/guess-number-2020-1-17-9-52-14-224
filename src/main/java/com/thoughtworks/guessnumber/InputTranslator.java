package com.thoughtworks.guessnumber;

import java.util.Arrays;

public class InputTranslator {

  static int[] translateInput(String userInput) {
    String[] answerStr = userInput.split(" ");
    return Arrays.stream(answerStr).mapToInt(Integer::parseInt).distinct().toArray();
  }
}
