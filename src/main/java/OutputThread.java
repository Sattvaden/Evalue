

public class OutputThread extends Thread {

    private static final int DELAY = 60000;

    private Packages packages;

    OutputThread(Packages packages) {

        this.packages = packages;
    }

    @Override
    public void run() {
        while (true) {
            packages.print();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
