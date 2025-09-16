public class Radio {
    private int currentStation;
    private int currentVolume;

    public void next() {
        this.currentStation = (this.currentStation == 9) ? 0 : this.currentStation + 1;
    }

    public void prev() {
        this.currentStation = (this.currentStation == 0) ? 9 : this.currentStation - 1;
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= 0) {
            if (newStation <= 9) {
                this.currentStation = newStation;
            }
        }
    }

    public void increaseVolume() {
        if (this.currentVolume < 100) {
            this.currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (this.currentVolume > 0) {
            this.currentVolume--;
        }
    }

    public int getCurrentStation() {
        return this.currentStation;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }
}
