class ZeroEvenOdd {
    private int n;
    private int lock = 0;
    private boolean flag = false;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            while(lock==2 || lock==1) this.wait(); 
            printNumber.accept(0);
            if(flag==false){
                lock=1;
                flag=true;
            }
            else{
                lock=2;
                flag=false;
            }
            
            this.notifyAll();
        }
        
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            while(lock==0 || lock==1) this.wait(); 
            printNumber.accept(i);
            lock=0;
            this.notifyAll();
        }
        
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            while(lock==0 || lock==2) this.wait();
            printNumber.accept(i);
            lock=0;
            this.notifyAll();
        }
        
    }
}