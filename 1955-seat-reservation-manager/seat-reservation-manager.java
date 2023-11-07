class SeatManager {
    private PriorityQueue<Integer> seats; 
    public SeatManager(int n) {
        seats = new PriorityQueue<>();
     
        for (int i = 1; i <= n; i++) {
            seats.offer(i);
        }
    }
    public int reserve() {
            int reservedSeat = seats.poll(); 
            return reservedSeat; 
    }

    public void unreserve(int seatNumber) {
        seats.offer(seatNumber);
    }
}