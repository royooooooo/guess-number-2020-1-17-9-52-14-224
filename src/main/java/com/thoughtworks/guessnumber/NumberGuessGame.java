package com.thoughtworks.guessnumber;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
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
  public void inputAnswer(String userInput) {
    inputTimes++;
    if (inputTimes > MAX_INPUT_TIMES) {
      throw new TooManyInputsError();
    }

    String[] answerSre = userInput.split(" ");
    List<Integer> answerNumbers;
    try {
      answerNumbers = Arrays.stream(answerSre).map(Integer::valueOf).distinct()
          .collect(toList());
    } catch (Exception e) {
      throw new IllegalAnswerError();
    }
    if (answerNumbers.size() != 4) {
      throw new IllegalAnswerError();
    }
  }
}
