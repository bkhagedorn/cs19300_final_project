public class SplatCheck {
    public static void main(String[] args) {
        int input = 0;
        while (true) {
            IO.println("1) Display data");
            IO.println("2) Add data");
            IO.println("3) Edit data");
            IO.println("4) Exit");

            try {
                input = Integer.parseInt(IO.readln("Enter your choice: "));
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Please enter a number.");
            }

            if (input == 1) {
                IO.println("todo");
            } else if (input == 2) {
                IO.println("todo");
            } else if (input == 3) {
                IO.println("todo");
            } else if (input == 4) {
                IO.println("todo");
                break;
            }
        }
    }
}