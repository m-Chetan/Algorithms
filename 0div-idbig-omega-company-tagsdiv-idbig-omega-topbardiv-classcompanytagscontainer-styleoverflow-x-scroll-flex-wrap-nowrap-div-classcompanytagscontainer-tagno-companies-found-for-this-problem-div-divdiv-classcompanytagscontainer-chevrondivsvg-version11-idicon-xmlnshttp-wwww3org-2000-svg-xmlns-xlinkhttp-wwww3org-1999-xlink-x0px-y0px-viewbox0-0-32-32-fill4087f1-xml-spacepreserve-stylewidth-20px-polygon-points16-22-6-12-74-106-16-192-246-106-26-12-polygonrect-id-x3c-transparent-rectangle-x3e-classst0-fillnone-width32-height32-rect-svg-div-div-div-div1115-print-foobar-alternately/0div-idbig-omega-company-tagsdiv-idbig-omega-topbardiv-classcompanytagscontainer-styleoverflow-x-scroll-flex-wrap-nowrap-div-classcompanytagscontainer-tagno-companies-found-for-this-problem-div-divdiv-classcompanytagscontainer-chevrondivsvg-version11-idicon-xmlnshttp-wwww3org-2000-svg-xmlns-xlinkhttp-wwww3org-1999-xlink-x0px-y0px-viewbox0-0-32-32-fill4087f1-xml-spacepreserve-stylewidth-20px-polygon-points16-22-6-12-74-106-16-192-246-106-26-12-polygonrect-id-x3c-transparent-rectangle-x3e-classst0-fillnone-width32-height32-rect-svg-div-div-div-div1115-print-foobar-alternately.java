class FooBar {
    private int n;
    private boolean lock = false;
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	while(lock==true) this.wait();
        	printFoo.run();
            lock=true;
            this.notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(lock==false) this.wait();
        	printBar.run();
            lock =false;
            this.notify();
        }
    }
}