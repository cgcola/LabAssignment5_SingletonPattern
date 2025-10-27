public class CentralizedQueueSystem {
    private static volatile CentralizedQueueSystem instance;
    private int currentNumber;
    private CentralizedQueueSystem() {
        currentNumber = 0;
    }

    public static CentralizedQueueSystem getInstance() {
        if (instance == null) {
            synchronized (CentralizedQueueSystem.class) {
                if (instance == null) {
                    instance = new CentralizedQueueSystem();
                }
            }
        }
        return instance;
    }

    //to get the next queue number
    public synchronized int getNextNumber() {
        return ++currentNumber;
    }

    //to get the current number (for monitoring)
    public synchronized int getCurrentNumber() {
        return currentNumber;
    }

    //reset the queue to a given starting number
    public synchronized void resetQueue(int newStart){
        currentNumber = newStart;
        System.out.println("[SYSTEM NOTICE] Queue reset to " + newStart);
    }
}
