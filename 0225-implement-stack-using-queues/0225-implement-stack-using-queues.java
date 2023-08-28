class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        if(q.size() == 0) return -1;
        int size = q.size();
        for(int i=1;i<size;i++) q.add(q.remove());
        return q.remove();
    }
    
    public int top() {
        if(q.size() == 0) return -1;
        int size = q.size();
        for(int i=1;i<size;i++) q.add(q.remove());
        int top = q.remove();
        q.add(top);
        
        return top;
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */