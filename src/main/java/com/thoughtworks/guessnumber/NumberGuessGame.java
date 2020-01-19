package com.thoughtworks.guessnumber;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;

public class NumberGuessGame {

  private int inputTimes;
  private static int MAX_INPUT_TIMES = 6;

  public NumberGuessGame() {
    inputTimes = 0;
  }

  @SneakyThrows
  public void inputAnswer(String userInput) {
    inputTimes++;
    if (inputTimes > MAX_INPUT_TIMES) {
      throw new TooManyInputsError();
    }

    String[] answerSre = userInput.split(" ");
    List<Integer> answerNumbers = Arrays.stream(answerSre).map(Integer::valueOf).distinct()
        .collect(toList());
    if (answerNumbers.size() < 4) {
      throw new SameNumberInAnswerError();
    }
  }
}
