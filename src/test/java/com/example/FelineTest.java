package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        Assertions.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assertions.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int expectedKittens = 1;

        int actualKittens = feline.getKittens();

        Assertions.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        int expectedKittens = 5;

        int actualKittens = feline.getKittens(5);

        Assertions.assertEquals(expectedKittens, actualKittens);
    }
}