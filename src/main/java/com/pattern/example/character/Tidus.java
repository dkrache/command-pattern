package com.pattern.example.character;

import com.pattern.example.characteristic.Effect;
import com.pattern.example.command.Command;
import com.pattern.example.target.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

public class Tidus extends Commander {

  private static final Logger LOGGER = LoggerFactory.getLogger(Commander.class);

  public Tidus(Integer hitPoint, Effect effect) {
    super(hitPoint, effect, new Stat(45,30));
  }

  @Override
  public String toString(){
    return "tidus";
  }
}
