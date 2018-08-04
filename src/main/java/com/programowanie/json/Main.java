package com.programowanie.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programowanie.json.model.Item;
import com.programowanie.json.model.Order;
import com.programowanie.json.model.Person;
import com.programowanie.json.model.PersonFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public Main() throws IOException{

    }

    public static void main(String[] args) throws IOException{
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));

        ObjectMapper mapper = new ObjectMapper();
        File filename = new File("person.json");
        filename.createNewFile();
        mapper.writeValue(filename, personList);


        Person[] readorders = mapper.readValue(new File("person.json"), Person[].class);

        ObservableList<PersonFX> personListFX = FXCollections.observableArrayList();

        for(Person p:  readorders){
            System.out.println(p.getName());
            personListFX.add(new PersonFX(p.getName(), p.getLastName()));
        }


//        Item item = new Item("mleko", "2", "TESCO");
//        Item item1 = new Item("baton", "2", "TESCO");
//        Item item2 = new Item("gruszki", "2", "TESCO");
//
//        List<Item> itemList = Arrays.asList(item, item1, item2);
//
//        Order order = new Order(itemList, 1);
//
//        ObjectMapper mapper = new ObjectMapper();
//        File filename = new File("order.json");
//        filename.createNewFile();
//        mapper.writeValue(filename, order);
//
//        Order readorders =
//                mapper.readValue(new File("order.json"),
//                        Order.class);
//
//        for(Item items: readorders.getItemList()){
//            System.out.println(items.getName());
//        }
    }
}
