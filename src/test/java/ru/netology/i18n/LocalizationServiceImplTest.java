package ru.netology.i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {
    @ParameterizedTest

    @CsvSource
            (value = {"Добро пожаловать, RUSSIA",
            "Welcome, GERMANY",
            "Welcome, USA",
            "Welcome, BRAZIL",
    })
    void locate(String greetings, Country country) {
        assertEquals(greetings, new LocalizationServiceImpl().locale(country));
    }
}
