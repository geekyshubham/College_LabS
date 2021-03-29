import java.util.List;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class arrayListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        // adding elements to the list

        list.add("My");
        list.add("Name");
        list.add("Is");
        list.add("adding name...");

        // remove and add at specific index using get/set methods
        list.remove("adding name...");
        list.add(3, "hubham");
        list.set(3, "S" + list.get(3));

        // size of the list
        System.out.printf("Size of list:%d\nList Content: ", list.size());

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // clone list
        // ArrayList<String> backupList =list.clone();
        // backupList.clone(list);

        // clear list
        list.clear();
        System.out.println("\nIs list empty:" + (list.isEmpty() ? "yes" : "no"));

        // add other collection

        List<String> temp = new ArrayList<String>();
        temp.add("ele2");
        temp.add("ele4");
        temp.add("ele1");
        temp.add("ele3");

        list.addAll(temp);

        // sort list
        Collections.sort(list);

        System.out.print("Elements in Sorted List: ");
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println(" [Total " + list.size() + " elements]");

        try {
            // Serialization

            FileOutputStream fos = new FileOutputStream("file");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);

            
            fos.close();
            oos.close();
            

            // Deserialization
            FileInputStream fis = new FileInputStream("file");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList flist = (ArrayList) ois.readObject();
            System.out.println("File O/P:" + flist);
            fis.close();
            ois.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        finally {

        }
    }
}