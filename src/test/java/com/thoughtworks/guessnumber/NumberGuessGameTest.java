package com.thoughtworks.guessnumber;

import org.junit.Test;

public class NumberGuessGameTest {

  @Test
  public void should_receive_user_input() {
    NumberGuessGame numberGuessGame = new NumberGuessGame();
    numberGuessGame.inputAnswer("1 2 3 4");
  }

  @Test(expected = TooManyInputsError.class)
  public void should_throw_exception_when_user_give_over_than_6_times_input() {
    NumberGuessGame numberGuessGame = new NumberGuessGame();
    numberGuessGame.inputAnswer("1 2 3 4");
    numberGuessGame.inputAnswer("1 2 3 4");
    numberGuessGame.inputAnswer("1 2 3 4");
    numberGuessGame.inputAnswer("1 2 3 4");
    numberGuessGame.inputAnswer("1 2 3 4");
    numberGuessGame.inputAnswer("1 2 3 4");
    numberGuessGame.inputAnswer("1 2 3 4");
  }

  @Test(expected = IllegalAnswerError.class)
  public void should_throw_exception_when_user_given_same_number_in_input() {
    NumberGuessGame numberGuessGame = new NumberGuessGame();
    numberGuessGame.inputAnswer("1 1 3 4");
  }

  @Test(expected = IllegalAnswerError.class)
  public void should_throw_exception_when_user_input_illegal_answer() {
    NumberGuessGame numberGuessGame = new NumberGuessGame();
    numberGuessGame.inputAnswer("11 3 4");
  }
}
