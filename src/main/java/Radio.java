public class Radio {
    private int currentStation;
    private final int maxStation;
    private int currentVolume;

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this.maxStation = 9; // 10 станций: 0-9
    }

    // Конструктор с настройкой количества станций
    public Radio(int stationCount) {
        if (stationCount < 1) {
            throw new IllegalArgumentException("Количество станций должно быть положительным");
        }
        this.maxStation = stationCount - 1;
    }

    public void next() {
        currentStation = (currentStation == maxStation) ? 0 : currentStation + 1;
    }

    public void prev() {
        currentStation = (currentStation == 0) ? maxStation : currentStation - 1;
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= 0 && newStation <= maxStation) {
            currentStation = newStation;
        }
    }

    // Методы для громкости остаются без изменений
    public void increaseVolume() {
        if (currentVolume < 100) currentVolume++;
    }

    public void decreaseVolume() {
        if (currentVolume > 0) currentVolume--;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}
