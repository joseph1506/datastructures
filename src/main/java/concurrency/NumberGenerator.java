package concurrency;

/**
 * Created with IntelliJ IDEA.
 * User: angel
 * Date: 10/11/15
 * Time: 7:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class NumberGenerator implements Runnable{

    private int limit;
    private Printer printer;
    private boolean isOddGenerator;

    public NumberGenerator(int limit,Printer printer,boolean isOddGenerator){
        this.limit=limit;
        this.printer=printer;
        this.isOddGenerator=isOddGenerator;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            int number= isOddGenerator==true? 1:2;
            while(number<=limit){
                if(isOddGenerator){
                    printer.generateOddNumbers(number);
                }else{
                    printer.generateEvenNumbers(number);
                }
                number+=2;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static  void main(String args[]){
        Printer printer= new Printer();
        //Thread t1= new Thread(new NumberGenerator(50, printer, true));
        Thread t2= new Thread(new NumberGenerator(50, printer, false));
        t2.start();
        //t1.start();


    }

}


class Printer {
    private volatile boolean isOdd=true;

    public synchronized void generateOddNumbers(int number) throws InterruptedException {
        // TODO Auto-generated method stub
        if(isOdd==false){
            wait();
        }
        System.out.println("Odd :"+number);
        isOdd=false;
        notify();
    }

    public synchronized void generateEvenNumbers(int number) throws InterruptedException {
        // TODO Auto-generated method stub
        if(isOdd==true){
            wait();
        }
        System.out.println("Even :"+number);
        isOdd=true;
        notify();
    }

}
