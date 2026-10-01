import java.util.*;

class TemperatureMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        double[] temp = new double[n];

        double sum = 0;
        double max;
        double min;

        System.out.println("Enter temperatures:");

        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextDouble();
            sum += temp[i];
        }

        max = temp[0];
        min = temp[0];

        for (int i = 1; i < n; i++) {
            if (temp[i] > max)
                max = temp[i];

            if (temp[i] < min)
                min = temp[i];
        }

        double average = sum / n;

        System.out.println("Average Temperature: " + average);
        System.out.println("Highest Temperature: " + max);
        System.out.println("Lowest Temperature: " + min);

        sc.close();
    }
}