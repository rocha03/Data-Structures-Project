import datastructs.Classes.list.LinkedList;
import datastructs.Exceptions.ElementNotFoundException;
import datastructs.Exceptions.EmptyCollectionException;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<String>();

        a.add("111");
        a.add("222");
        a.add("333");
        a.display();
        try {
            a.remove(3);
        } catch (EmptyCollectionException | ElementNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        a.display();
    }
}
