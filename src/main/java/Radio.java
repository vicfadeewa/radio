public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int stationCount;
    private final int maxStation;

    public Radio() {
        this.stationCount = 10;
        this.maxStation = 9;
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            stationCount = 10; // Значение по умолчанию при невалидном вводе
        }
        this.stationCount = stationCount;
        this.maxStation = stationCount - 1;
    }

    // переключение на следующую станцию
    public void next() {
        if (currentStation == maxStation) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // переключение на предыдущую станцию
    public void prev() {
        if (currentStation == 0) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }

    // установка станции
    public void setCurrentStation(int newStation) {
        if (newStation >= 0 && newStation <= maxStation) {
            currentStation = newStation;
        }
    }

    // увеличение громкости
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // уменьшение громкости
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getStationCount() {
        return stationCount;
    }

    public int getMaxStation() {
        return maxStation;
    }
}
