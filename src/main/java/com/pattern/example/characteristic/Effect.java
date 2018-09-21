package com.pattern.example.characteristic;

public enum Effect {

  SLOW("slow"), NORMAL("normal"), HASTE("haste");

  private String title;

  Effect(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}
