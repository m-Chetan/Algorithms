class Foo {
    int lock=0;
    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        lock++;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(lock!=1) this.wait();
        printSecond.run();
        lock++;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(lock!=2) this.wait();
        printThird.run();
    }
}