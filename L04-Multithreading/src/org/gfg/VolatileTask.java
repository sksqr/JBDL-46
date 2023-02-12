package org.gfg;

public class VolatileTask implements Runnable{
    private static volatile int val=0;
    private String type;

    public VolatileTask( String type) {
        ;
        this.type = type;
    }


    @Override
    public void run() {
        if(type.equals("S")){
            while (val<10000){
                val++;
                System.out.println("updated val : "+val);
//                try {
////                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
        else{
            while (val!=10000){
                System.out.println("Read val:"+val);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
}
