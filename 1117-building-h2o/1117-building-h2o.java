class H2O {
    
    private int count=0;
    
    public H2O() {
        
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while(count==2) this.wait();
        releaseHydrogen.run();
        count++;
        this.notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(count<2) this.wait();
		releaseOxygen.run();
        count=0;
        this.notifyAll();
    }
}