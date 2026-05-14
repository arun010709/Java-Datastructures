package interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Immutable {
    private final String name;
    private final Map<String,String> dept;

    public Immutable(String name,Map<String,String> dept){
        this.name=name;
        if(dept!=null){
            this.dept =new HashMap<>(dept);
        }else {
            this.dept =new HashMap<>();
        }

        //for a map with custom obj like String,Department create deepcody of dept
        /*Map<String, Department> deepCopy = new HashMap<>();

        // DEEP COPY: Create brand new Department objects
        for (Map.Entry<String, Department> entry : depts.entrySet()) {
            deepCopy.put(entry.getKey(), new Department(entry.getValue().getRank()));
        }

        this.depts = deepCopy;*/
    }

    public String getName(){
        return name;
    }

    public Map<String,String> getDept(){
        return Collections.unmodifiableMap(dept);
    }

    public static void main(String args[]){
        Map<String,String> hm = new HashMap<>();
        hm.put("IT","TechOps");
        Immutable immutable = new Immutable("Arun",hm);
        System.out.println(immutable.getDept().get("IT"));
        hm.put("IT","DevOps");
        /*Map<String,String> hm1=immutable.getDept();
        hm1.put("IT","DevOps");*/
        //immutable.getDept().put("IT","DevOps");
        System.out.println(immutable.getDept().get("IT"));
        //System.out.println(immutable.getDept().put("IT","DevOps"));
    }
}
