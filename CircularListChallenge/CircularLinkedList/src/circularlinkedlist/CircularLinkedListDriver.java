/*
 * CircularLinkedListDriver.java
 */
package circularlinkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Nasser Najib
 */
public class CircularLinkedListDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try
        {
            int index = SimpleLinkedList.ITEM_NOT_FOUND;
            List<String> aList =  new SimpleLinkedList<>();
            aList.add(0, "this");
            System.out.println(aList);
            aList.add(1, "is");
            System.out.println(aList);
            aList.add(2, "a");
            System.out.println(aList);
            aList.add(3, "test");
            System.out.println(aList);
            aList.add(2, "not");
            aList.add(4, "not");
            System.out.println(aList);
            index = aList.indexOf("not");
            if(index > SimpleLinkedList.ITEM_NOT_FOUND)
                System.out.println("first \"not\" is at " + index);
            else
                System.out.println("item not found");              
            index = aList.lastIndexOf("not");
            if(index > SimpleLinkedList.ITEM_NOT_FOUND)
                System.out.println("last \"not\" is at " + index);
            else
                System.out.println("item not found");          
            index = aList.indexOf("note");
            if(index > SimpleLinkedList.ITEM_NOT_FOUND)
                System.out.println("first \"note\" is at " + index);
            else
                System.out.println("item not found"); 
            
            System.out.println("removing element 4: " + aList.remove(4));        
            System.out.println(aList);
            for(String s: aList)
                System.out.print("(" + s + ") ");
            System.out.println("\nRemoving element -1: " + aList.get(-1));
            aList.remove(-1);
            System.out.println(aList);
            System.out.println("Clearing list");
            aList.clear();
            if(aList.isEmpty())
                System.out.println("List was cleared");
            else
                System.out.println("Problem");
            List<String> bList = new ArrayList();
            aList.add("First");
            aList.add("Second");
            System.out.println("Here's my new list:");
            System.out.println(aList);
            bList.add("Third");
            bList.add("Fourth");
            System.out.println("Here's a new list");
            System.out.println(bList);
            System.out.println("Adding new list to first list");
            aList.addAll(bList);
            System.out.println(aList);
            if(aList.containsAll(bList))
                System.out.println("It worked!");
            else
                System.out.println("problem");
            System.out.println("Now I'll iterate through them, but in reverse!");
            ListIterator li = aList.listIterator();
            for(int i = 0; i < aList.size(); i++)
                System.out.println(li.previous());
            System.out.println("Now I'll make a shallow copy!");
            List<String> cList = new SimpleLinkedList();
            cList = aList;
            if(cList == aList)
                System.out.println("Shallow!");
            else
                System.out.println("Problem");
            System.out.println("Now I'll make an identical copy!");
            cList = new SimpleLinkedList();
            cList.addAll(aList);
            System.out.println(cList);
            if(aList.equals(cList))
                System.out.println("It Worked!");
            else
                System.out.println("Problem");
            bList.clear();
            aList.clear();
            System.out.println("Now I'll use the list iterator to set the last "
                    + "value to \"Last\"");
            li = cList.listIterator();
            li.previous();
            li.set("Last");
            System.out.println(cList);
            if(cList.contains("Last"))
                System.out.println("It Worked!");
            else
                System.out.println("Problem");
            System.out.println("Now I'll use the list iterator to add an object");
            li.add("SIKE!");
            System.out.println(cList);
            System.out.println("I'll remove that");
            li.remove();
            if(!cList.contains("SIKE!"))
                System.out.println("It worked!");
            else
                System.out.println("Problem");
            System.out.println(cList);
            System.out.println("Now lets make an array out of our list");
            String[] arr = new String[cList.size()];
            arr = cList.toArray(arr);
            for(int i = 0; i < arr.length;i++)
                System.out.print(arr[i] + " ");
            boolean contains = true;
            for(int i = 0; i < arr.length; i++)
                if(!cList.contains(arr[i]))
                    contains = !contains;
            if(contains)
                System.out.println("It worked");
            else
                System.out.println("problem");
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
