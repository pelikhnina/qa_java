package com.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assertions.assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        Assertions.assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).eatMeat();
    }
}
