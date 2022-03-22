package ru.netology.geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GeoServiceImplTest {
    @ParameterizedTest

    @MethodSource(value = "locationMethod")
    void byIp(Location location, String ip) {
        assertEquals(location, new GeoServiceImpl().byIp(ip));
    }

    static Stream<Arguments> locationMethod() {
        return Stream.of(
                arguments(null, "101.3.100.100"), //случайный ip вне США,России и localhost
                arguments(new Location(null, null, null, 0), "127.0.0.1"),
                arguments(new Location("Moscow", Country.RUSSIA, "Lenina", 15), "172.0.32.11"),
                arguments(new Location("New York", Country.USA, " 10th Avenue", 32), "96.44.183.149"),
                arguments(new Location("Moscow", Country.RUSSIA, null, 0), "172.0.32.111"),
                arguments(new Location("New York", Country.USA, null, 0), "96.44.183.49"));
    }
}
