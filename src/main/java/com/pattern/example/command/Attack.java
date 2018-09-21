package com.pattern.example.command;

import com.pattern.example.character.Commander;
import com.pattern.example.target.Target;

import java.util.Random;

public class Attack implements Command {

  private static Random random = new Random();
  private Commander commander;
  private Integer oldHitPoint;
  private Integer damage = 10;
  private Target target;

  @Override
  public void execute(Commander commander, Target target) {
    oldHitPoint = target.getHitPoint();
    int effectiveAttack = random.nextInt(commander.getStat().getAttack());
    int effectDefense = random.nextInt(target.getStat().getDefense());
    target.setHitPoint(target.getHitPoint() - 10 - Math.max(1,damage+(effectiveAttack-effectDefense)));
    this.target = target;
  }

  @Override
  public void undo() {
    if (oldHitPoint != null && target != null) {
      Integer tempHitPoint = target.getHitPoint();
      target.setHitPoint(oldHitPoint);
      oldHitPoint = tempHitPoint;
    }
  }

  @Override
  public void redo() {
    undo();
  }

  @Override
  public String toString() {
    return "attack";
  }
}
