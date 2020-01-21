package com.thoughtworks.guessnumber;

import java.util.Arrays;
import lombok.SneakyThrows;

public class NumberGuessGame {

  private Integer[] correctAnswer;
  private Counter counter;
  private final int MAX_INPUT_TIMES = 6;

  public NumberGuessGame() {
    correctAnswer = AnswerGenerator.generate();
    counter = new Counter(MAX_INPUT_TIMES);
  }

  @SneakyThrows
  public String inputAnswer(String userInput) {
    counter.count();
    InputValidator.validate(userInput);
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

    return String.format("%dA%dB", correctNumber, positionWrongNumber);
  }
}
