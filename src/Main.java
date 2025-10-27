import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CentralizedQueueSystem queue = CentralizedQueueSystem.getInstance();
        Scanner sc = new Scanner(System.in);

        Integer desk1Num = null;
        Integer desk2Num = null;
        Integer desk3Num = null;

        System.out.println("=== Pag-Ibig Centralized Queuing System ===");

        boolean running = true;
        while(running){
            System.out.println("\n--- MENU ---");
            System.out.println("1. Serve Next Number at Desk 1");
            System.out.println("2. Serve Next Number at Desk 2");
            System.out.println("3. Serve Next Number at Desk 3");
            System.out.println("4. View Current Numbers");
            System.out.println("5. Reset Queue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    desk1Num = queue.getNextNumber();
                    break;
                case 2:
                    desk2Num = queue.getNextNumber();
                    break;
                case 3:
                    desk3Num = queue.getNextNumber();
                    break;
                case 4:
                    // just display numbers
                    break;
                case 5:
                    System.out.print("Enter New Current Number: ");
                    int newStart = sc.nextInt();
                    queue.resetQueue(newStart);
                    desk1Num = desk2Num = desk3Num = null;
                    break;
                case 6:
                    System.out.println("Exiting System...");
                    running = false;
                    continue;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            // Display current state
            System.out.println("\nCurrent Number: " + queue.getCurrentNumber());
            System.out.println("Desk 1: " + (desk1Num != null ? desk1Num : "-"));
            System.out.println("Desk 2: " + (desk2Num != null ? desk2Num : "-"));
            System.out.println("Desk 3: " + (desk3Num != null ? desk3Num : "-"));
        }

        sc.close();
    }
}
