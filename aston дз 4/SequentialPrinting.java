public class SequentialPrinting {
    private static boolean printOne = true;

    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!printOne) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("1");
                    printOne = false;
                    lock.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (printOne) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("2");
                    printOne = true;
                    lock.notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
    }
}