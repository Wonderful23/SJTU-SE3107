import java.util.ArrayList;
public class Container{
    private static int count = 0;
    private ArrayList<Item> arraylist;
    private long TimeOut = 3000;
    private int counter = 10;
    public Container(){
        this.arraylist = new ArrayList<Item>();
    }
    public synchronized void removeItem(){
        Long now = System.currentTimeMillis();
        for(int i=0;i<this.arraylist.size();i++){
            Item tempitem = this.arraylist.get(i);
            if(now - tempitem.time>3000)
            {
                this.arraylist.remove(i);
            }
        }
    }
    public String getitem(){
        removeItem();
        int size = this.arraylist.size();
        if(size == 0){
            return "Empty!";
        }
        else if(size>=10){
            Item tempitem = this.arraylist.get(size-1);
            this.arraylist.remove(size-1);
            return "Item:"+tempitem.contain;
        }
        else if(size>0&& size<10){
            Item tempitem = this.arraylist.get(0);
            this.arraylist.remove(0);
            return "Item"+tempitem.contain;
        }
        else{
            return "Empty!";
        }
    }
    public synchronized void additem(){
        Item item  = new Item();
        this.arraylist.add(item);
        return ;
    }
}
class Item{
    private static int counting = 0;
    public int contain;
    public long time;
    public Item(){
        this.counting++;
        this.time = System.currentTimeMillis();
        this.contain = this.counting;
    }

}