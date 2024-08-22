public class Seat {
    private int seatId;
    private int row;
    private SeatCategory seatCategory;
    private int price;

    public Seat() {
    }

    // Parameterized constructor
    public Seat(int seatId, int row, SeatCategory seatCategory, int price) {
        this.seatId = seatId;
        this.row = row;
        this.seatCategory = seatCategory;
        this.price = price;
    }

    // Getter and setter for seatId
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    // Getter and setter for row
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    // Getter and setter for seatCategory
    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    // Getter and setter for price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", seatCategory=" + seatCategory +
                ", price=" + price +
                '}';
    }
}
