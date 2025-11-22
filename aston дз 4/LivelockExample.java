public class LiveLockExample {
    private static boolean isThread1Turn = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (isThread1Turn) {
                    System.out.println("Thread 1 is working");
                    isThread1Turn = false;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (!isThread1Turn) {
                    System.out.println("Thread 2 is working");
                    isThread1Turn = true;
                }
            }
        });

        t1.start();
        t2.start();
    }
}