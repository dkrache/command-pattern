package com.pattern.example.character;

import com.pattern.example.characteristic.Effect;
import com.pattern.example.command.Command;
import com.pattern.example.target.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

public abstract class Commander extends Target {

  private static final Logger LOGGER = LoggerFactory.getLogger(Commander.class);

  private Deque<Command> undoStack = new LinkedList<>();
  private Deque<Command> redoStack = new LinkedList<>();

  public Commander(Integer hitPoint, Effect effect, Stat stat) {
    setHitPoint(hitPoint);
    setEffect(effect);
    setStat(stat);
  }

  public void use(Command command, Target target) {
    LOGGER.info("{} casts {} at {}", this, command, target);
    Integer HPbefore = target.getHitPoint();
    command.execute(this, target);
    Integer HPAfter  = target.getHitPoint();
    if(HPAfter>HPbefore){
      LOGGER.info("{} recover {} HP", target, HPAfter-HPbefore);
    }else if (HPAfter<HPbefore) {
      LOGGER.info("{} takes {} damage", target, HPbefore-HPAfter);
    }
    undoStack.offerLast(command);
  }

  public void undo() {
    if (!undoStack.isEmpty()) {
      Command previousSpell = undoStack.pollLast();
      redoStack.offerLast(previousSpell);
      LOGGER.info("{} undoes {}", this, previousSpell);
      previousSpell.undo();
    }
  }

  public void redo() {
    if (!redoStack.isEmpty()) {
      Command previousSpell = redoStack.pollLast();
      undoStack.offerLast(previousSpell);
      LOGGER.info("{} redoes {}", this, previousSpell);
      previousSpell.redo();
    }
  }

  @Override
  public abstract String toString();
}
