package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.SneakyThrows;

public class NumberGuessGame {

  private Integer[] correctAnswer;
  private Counter counter;
  private final int MAX_INPUT_TIMES = 6;
  private Map<String, String> answerMap;

  public NumberGuessGame() {
    correctAnswer = AnswerGenerator.generate();
    counter = new Counter(MAX_INPUT_TIMES);
    answerMap = new LinkedHashMap<>();
  }

  @SneakyThrows
  public String inputAnswer(String userInput) {
    InputValidator.validate(userInput);
    counter.count();
    int[] answerNumbers = InputTranslator.translateInput(userInput);
    int correctNumber = 0;
    int positionWrongNumber = 0;
    for (int index = 0; index < answerNumbers.length; index++) {
      if (answerNumbers[index] == (correctAnswer[index])) {
        correctNumber++;
      } else if (Arrays.asList(correctAnswer).contains(answerNumbers[index])) {
        positionWrongNumber++;
      }
    }

    answerMap.put(Arrays.toString(answerNumbers),
        String.format("%dA%dB", correctNumber, positionWrongNumber));
    StringBuffer answerStr = new StringBuffer();
    answerMap.forEach((key, value) -> answerStr.append(String.format("%s, %s\n", key, value)));
    return answerStr.toString();
  }
}
