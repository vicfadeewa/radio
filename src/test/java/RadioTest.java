import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldCreateDefaultRadio() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
        assertEquals(9, radio.getMaxStation());
    }

    @Test
    void shouldCreateCustomRadio() {
        Radio radio = new Radio(15);
        assertEquals(15, radio.getStationCount());
        assertEquals(14, radio.getMaxStation());
    }

    @Test
    void shouldHandleInvalidStationCount() {
        Radio radio = new Radio(-5);
        assertEquals(10, radio.getStationCount()); // Проверка fallback
    }

    @Test
    void shouldSwitchStations() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(3);

        radio.next();
        assertEquals(4, radio.getCurrentStation());

        radio.next();
        assertEquals(0, radio.getCurrentStation()); // Переход через максимум

        radio.prev();
        assertEquals(4, radio.getCurrentStation()); // Переход через минимум
    }

    @Test
    void shouldControlVolume() {
        Radio radio = new Radio();

        for (int i = 0; i < 150; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());

        for (int i = 0; i < 150; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldIgnoreInvalidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation());
    }
}
