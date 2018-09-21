package com.pattern.example;

import com.pattern.example.character.Dragon;
import com.pattern.example.character.Tidus;
import com.pattern.example.characteristic.Effect;
import com.pattern.example.command.HasteSpell;
import com.pattern.example.command.SlowSpell;
import com.pattern.example.command.Attack;

public class App {

  public static void main(String[] args) {
    Tidus tidus = new Tidus(100, Effect.HASTE);
    Dragon dragon = new Dragon(100, Effect.NORMAL);

    dragon.printStatus();


    tidus.use(new Attack(), dragon);
    dragon.printStatus();

    tidus.use(new SlowSpell(), dragon);
    dragon.printStatus();

    tidus.use(new HasteSpell(), tidus);
    dragon.printStatus();

    tidus.use(new Attack(), dragon);
    dragon.printStatus();
    dragon.use(new Attack(), tidus);
    tidus.printStatus();

    tidus.undo();
    dragon.printStatus();

    dragon.undo();
    tidus.printStatus();

  }
}
