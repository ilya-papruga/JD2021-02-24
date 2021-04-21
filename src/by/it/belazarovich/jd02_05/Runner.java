package by.it.belazarovich.jd02_05;

public class Runner {
    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getInstanceLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new OneThread("th" + i).start();
        }
    }
}


