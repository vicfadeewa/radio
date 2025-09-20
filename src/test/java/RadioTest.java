import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());

        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());

        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation());

        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        for(int i = 0; i < 100; i++) radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // Новый тест для проверки работы с нестандартным количеством станций
    @Test
    void shouldHandleCustomStationCount() {
        Radio radio = new Radio(15);

        radio.setCurrentStation(14);
        radio.next();
        assertEquals(0, radio.getCurrentStation());

        radio.prev();
        assertEquals(14, radio.getCurrentStation());
    }

    // Тест для проверки граничных случаев при нестандартном количестве станций
    @Test
    void shouldHandleBoundaryCases() {
        Radio radio = new Radio(5); // 5 станций: 0-4

        // Переключение с последней станции на первую
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(0, radio.getCurrentStation());

        // Переключение с первой станции на последнюю
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    // Тест для проверки некорректных значений в конструкторе
    @Test
    void shouldThrowExceptionForInvalidStationCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Radio(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Radio(-5);
        });
    }
}
