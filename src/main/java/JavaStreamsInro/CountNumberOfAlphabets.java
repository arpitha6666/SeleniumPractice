package JavaStreamsInro;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountNumberOfAlphabets {
    @Test
    public void arrayTest(){
        List<String> namesList = new ArrayList<>();
        namesList.add("Arpitha");
        namesList.add("Aravinda");
        namesList.add("Ahana");
        namesList.add("Sreemathi");
        namesList.add("John");
        int count =0;
        for(String it : namesList){
            if(it.startsWith("A")){
                count++;

            }
        }
        System.out.println(count);
    }
    @Test
    public void  streamArrayTest(){
        List<String> namesList = new ArrayList<>();
        namesList.add("Arpitha");
        namesList.add("Aravinda");
        namesList.add("Ahana");
        namesList.add("Sreemathi");
        namesList.add("John");
        Long count =namesList.stream().filter(it->it.startsWith("A")).count();
        System.out.println(count);
        namesList.stream().filter(s->s.length()>4).forEach(System.out::println);
        namesList.stream().filter(s->s.length()>4).limit(2).forEach(System.out::println);
    }

    @Test
    public void  mapStreamTest(){
        Stream.of("Alekya","John","Brayan","Rama")
                .filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase())
                .forEach(System.out::println);
    }
    @Test
    public void  mapStreamUpperCaseTest(){
        Stream.of("Alekya","John","Brayan","Rama")
                .map(s->s.toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void  mapStreamUpperCaseAndSortedTest(){
        Stream.of("Alekya","John","Brayan","Rama")
                .map(s->s.toUpperCase())
                .sorted()
                .forEach(System.out::println);
    }

    //merging two lists
    @Test
    public void  mergeTwoListTest(){
        List<String> namesList1 = new ArrayList<>();
        namesList1.add("Arpitha");
        namesList1.add("Aravinda");
        namesList1.add("Ahana");
        namesList1.add("Sreemathi");
        namesList1.add("John");
        Stream<String> namesList2 =Stream.of("Alekya","Mathew","Brayan","Rama");

        Stream<String> output =Stream.concat(namesList1.stream(),namesList2);
        //output.sorted().forEach(System.out::println);
        Assert.assertTrue(output.anyMatch(s->s.equalsIgnoreCase("Rama")));



    }

    @Test
    public void streamCollect(){
        List<String> namesList3 =Stream.of("Alekya","Mathew","Brayan","Rama")
                .filter(s->s.endsWith("a"))
                .map(a->a.toUpperCase()).collect(Collectors.toList());
        namesList3.stream().forEach(System.out::println);
    }

    @Test
    public void assignment(){
        List<Integer> intList = Arrays.asList(3,2,2,7,5,1,9);
               //print unique numebers and sor the array
        intList.stream().distinct().sorted().forEach(System.out::println);
    }

}
