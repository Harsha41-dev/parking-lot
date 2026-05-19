public class ParkingBill {
    private Ticket ticket;
    private int amount;

    public ParkingBill(Ticket ticket, int amount) {
        this.ticket = ticket;
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getAmount() {
        return amount;
    }
}
