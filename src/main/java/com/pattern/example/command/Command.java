package com.pattern.example.command;

import com.pattern.example.character.Commander;
import com.pattern.example.target.Target;

public interface Command {

  void execute(Commander commander, Target target);

  void undo();

  void redo();

  @Override
  String toString();

}
