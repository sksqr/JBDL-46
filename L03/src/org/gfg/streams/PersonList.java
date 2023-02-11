package org.gfg.streams;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class PersonList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Person> list;

    public PersonList(List<Person> list) {
        this.list = list;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "list=" + list +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        for(Person p:list){
            String data = p.getName()+","+p.getAge()+"\n";
            out.write(data.getBytes());
        }
    }

    private void readObject(ObjectInputStream in)   throws IOException, ClassNotFoundException{

    }
}
