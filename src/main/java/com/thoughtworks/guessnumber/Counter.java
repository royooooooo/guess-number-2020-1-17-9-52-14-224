package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.exception.TooManyInputsError;
import lombok.SneakyThrows;

public class Counter {

  private int maxInputTimes;
  private int count;

  public Counter(int maxInputTimes) {
    this.maxInputTimes = maxInputTimes;
    count = 0;
  }

  @SneakyThrows
  public void count() {
    count++;
    if (count > maxInputTimes) {
      throw new TooManyInputsError();
    }
  }
}
