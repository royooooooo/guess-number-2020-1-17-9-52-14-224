package com.thoughtworks.guessnumber;

import java.util.Arrays;
import lombok.SneakyThrows;

public class NumberGuessGame {

  private int inputTimes;
  private static int MAX_INPUT_TIMES = 6;
  private Integer[] correctAnswer;

  public NumberGuessGame() {
    inputTimes = 0;
    correctAnswer = AnswerGenerator.generate();
  }

  @SneakyThrows
  public String inputAnswer(String userInput) {
    inputTimes++;
    if (inputTimes > MAX_INPUT_TIMES) {
      throw new TooManyInputsError();
    }

    String[] answerStr = userInput.split(" ");
    int[] answerNumbers;
    try {
      answerNumbers = Arrays.stream(answerStr).mapToInt(Integer::parseInt).distinct().toArray();
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalAnswerError();
    }
    if (answerNumbers.length != 4) {
      throw new IllegalAnswerError();
    }

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
