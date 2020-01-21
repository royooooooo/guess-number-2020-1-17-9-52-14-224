package com.thoughtworks.guessnumber;

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
