/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.data;

import java.util.ArrayList;
import java.util.List;

import com.example.textrecoapp.characters.Character;

public class CharacterGenerator {

  private List<Character> characters;

  public CharacterGenerator() {
    init();
  }

  private void init() {
    characters = new ArrayList<Character>();

    Character character = new Character("Komita", "The Ilinden Uprising", "komita");
    characters.add(character);

    character = new Character("Partizan", "World wars", "partizan");
    characters.add(character);

    character = new Character("Ancient warrior", "Ancient Greek and Persian wars", "falanga_man");
    characters.add(character);
  }

  public List<Character> getCharacters() {
    return characters;
  }
}
