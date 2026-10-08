import java.util.*;

class EventReservation {

    static class Event {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of reservations: ");
        int n = sc.nextInt();

        Event[] events = new Event[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter start time: ");
            int start = sc.nextInt();

            System.out.print("Enter end time: ");
            int end = sc.nextInt();

            events[i] = new Event(start, end);
        }

        boolean overlap = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (events[i].start < events[j].end &&
                    events[j].start < events[i].end) {

                    overlap = true;

                    System.out.println(
                        "Reservation " + (i + 1) +
                        " overlaps with Reservation " + (j + 1)
                    );
                }
            }
        }

        if (!overlap)
            System.out.println("All reservations are valid.");

        sc.close();
    }
}
