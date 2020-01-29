package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.exception.IllegalAnswerError;
import lombok.SneakyThrows;

public class InputValidator {

  @SneakyThrows
  public static void validate(String userInput) {
    int[] answerNumbers;
    try {
      answerNumbers = InputTranslator.translateInput(userInput);
    } catch (Exception e) {
      throw new IllegalAnswerError();
    }
    if (answerNumbers.length != 4) {
      throw new IllegalAnswerError();
    }
  }
}
