public class counter{

    int count=0;
    
    synchronized void producer(){
        if (count < 2 ){
        count++;
        System.out.println("produced count="+count);
        }
        
    }

    synchronized void consumer(){
        if ( count > 0){
        count--;
        System.out.println("consumed count="+count);
        }
        
    }
    
    
    public static void main(String args[]){
        counter c = new counter();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                c.producer();
                c.producer();
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                c.consumer();
            }
        });

        t2.start();

            }
}

