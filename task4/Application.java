class Consumer implements Runnable{
    private Container container;
    public Consumer(Container c){
        this.container = c;
    }
    public void run(){
        for(int i=0;i<100;i++)
        this.container.additem();
    }
}
class Producer implements Runnable{
    private Container container;
    public Producer(Container c){
        this.container = c;
    }
    public void run(){
        for(int i=0;i<100;i++)
            System.out.println(container.getitem());
    }
}
public class Application {
    public static void main(String[]args){
        Container c= new Container();
        new Thread(new Producer(c)).start();
        new Thread(new Consumer(c)).start();
    }
}
