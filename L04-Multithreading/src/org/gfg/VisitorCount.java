package org.gfg;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCount implements Runnable{
//    private AtomicInteger vistor;

    private  int visitor;
    public VisitorCount() {
//        this.vistor = new AtomicInteger();
        visitor =0;
    }
    public int getVistor() {
       // return vistor.intValue();
        return visitor;
    }

    @Override
    public void run() {
        incrementVisitor();
    }

    private synchronized void  incrementVisitor(){
        visitor++;
    }
}
