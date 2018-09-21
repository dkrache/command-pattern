package com.pattern.example.command;

import com.pattern.example.character.Commander;
import com.pattern.example.characteristic.Effect;
import com.pattern.example.target.Target;

public class SlowSpell implements Command {

  private Effect oldEffect;
  private Target target;

  @Override
  public void execute(Commander commander, Target target) {
    oldEffect = target.getEffect();
    target.setEffect(Effect.SLOW);
    this.target = target;
  }

  @Override
  public void undo() {
    if (oldEffect != null && target != null) {
      Effect temp = target.getEffect();
      target.setEffect(oldEffect);
      oldEffect = temp;
    }
  }

  @Override
  public void redo() {
    undo();
  }

  @Override
  public String toString() {
    return "slow spell";
  }
}
