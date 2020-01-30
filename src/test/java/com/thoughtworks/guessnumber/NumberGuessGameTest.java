package com.thoughtworks.guessnumber;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.thoughtworks.guessnumber.exception.IllegalAnswerError;
import com.thoughtworks.guessnumber.exception.TooManyInputsError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AnswerGenerator.class})
public class NumberGuessGameTest {

  @Before
  public void setUp() {
    PowerMockito.mockStatic(AnswerGenerator.class);
    when(AnswerGenerator.generate()).thenReturn(new Integer[]{1, 2, 3, 4});
  }

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

  @Test
  public void should_return_previous_answer_when_user_input_repeatedly() {
    NumberGuessGame numberGuessGame = new NumberGuessGame();

    assertEquals(numberGuessGame.inputAnswer("1 5 6 7"), "[1, 5, 6, 7], 1A0B\n");
    assertEquals(numberGuessGame.inputAnswer("2 4 7 8"),
        "[1, 5, 6, 7], 1A0B\n[2, 4, 7, 8], 0A2B\n");
    assertEquals(numberGuessGame.inputAnswer("0 3 2 4"),
        "[1, 5, 6, 7], 1A0B\n[2, 4, 7, 8], 0A2B\n[0, 3, 2, 4], 1A2B\n");
  }
}
