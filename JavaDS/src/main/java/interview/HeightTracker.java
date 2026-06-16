package interview;

/*identify
the tallest
person present
at a
specific time.
{1,1,"bob1",5.1},
{3,2,"bob2",5.3},
{4,3,"bob3",5.0},
{5,4,"bob4",5.5}*/


import java.util.Map;
import java.util.TreeMap;

public class HeightTracker {
    static class Person{
        int id;
        String name;
        double height;

        Person(int id, String name, double height) {
            this.id = id;
            this.name = name;
            this.height = height;
        }
    }

    private TreeMap<Integer,Person> timePersonMap = new TreeMap<>();
    private Person currentTallestPerson=null;

    public void addPerson(int id, String name, double height, int temperature){
        if(currentTallestPerson==null || height > currentTallestPerson.height){
            currentTallestPerson = new Person(id,name,height);
        }
        //Add a new person only if his/her height is greater than current tallest person
        //else store the available tallest person again for that instant
        timePersonMap.put(temperature,currentTallestPerson);
    }

    public String getTallestAtTime(int temperature){
        var entry = timePersonMap.floorEntry(temperature);

        return entry!=null?entry.getValue().name:"Not Found";
    }
    public static void main(String args[]){

        HeightTracker ht = new HeightTracker();
        ht.addPerson(1,"bob1",5.1,1);
        ht.addPerson(2,"bob2",5.3,3);
        ht.addPerson(3,"bob3",5.0,4);
        ht.addPerson(4,"bob4",5.7,5);

        // Queries
        System.out.println("Tallest at t=2: " + ht.getTallestAtTime(2));
        System.out.println("Tallest at t=4: " + ht.getTallestAtTime(4));
        System.out.println("Tallest at t=6: " + ht.getTallestAtTime(6));

    }
}
