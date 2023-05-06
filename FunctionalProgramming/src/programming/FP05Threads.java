package programming;

public class FP05Threads {


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                for(int i=0;i<1000;i++)
                {
                    System.out.println(Thread.currentThread().getId()+ " :"+i);
                }
                
            }
            
        };

        Runnable runnable2 = ()-> { for(int i=0;i<1000;i++)
            {
                System.out.println(Thread.currentThread().getId()+ " :"+i);
            } };

        Thread t1 = new Thread(runnable2);
        t1.start();

        
        Thread t2 = new Thread(runnable2);
        t2.start();

        
        Thread t3 = new Thread(runnable2);
        t3.start();
       
    }
    
}
