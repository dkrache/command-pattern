package com.pattern.example.character;

import com.pattern.example.characteristic.Effect;

public class Dragon extends Commander {

  public Dragon(Integer hitPoint, Effect effect) {
    super(hitPoint, effect, new Stat(50,26));
  }

  @Override
  public String toString() {
    return "Dragon";
  }
}
