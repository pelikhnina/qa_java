package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvSource({ "Самец, true", "Самка, false" })
    public void testDoesHaveMane(String sex, boolean expectedMane) throws Exception {
        lion = new Lion(sex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    void testInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("InvalidSex", new Feline()));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 1})
    public void testGetKittens(int expectedKittens) throws Exception {
        when(feline.getKittens()).thenReturn(expectedKittens);
        lion = new Lion("Самка", feline);
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
        verify(feline).getKittens();
    }



    @ParameterizedTest
    @CsvSource({ "Травоядное, Трава, Различные растения", "Хищник, Животные, Птицы, Рыба" })
    public void testGetFood(String food1, String food2) throws Exception {
        when(feline.getFood(anyString())).thenReturn(List.of(food1, food2));
        lion = new Lion("Самец", feline);
        List<String> actualFood = lion.getFood();
        assertEquals(List.of(food1, food2), actualFood);
        verify(feline).getFood(anyString());
    }

}
