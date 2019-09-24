/*
 * SimpleLinkedList.java
 */
package circularlinkedlist;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

/**
 * A circular, doubly-linked list class.
 * @author Nasser Najib
 * @version 1.0
 * Test Environment: JDK 1.7.0_03 on Windows 7, i3 CPU<br>
 * @param <E> the data type
 */
public class SimpleLinkedList<E>  extends AbstractList<E>
    implements List<E>, Cloneable, Serializable, Iterable<E>
{
    public static final int ITEM_NOT_FOUND = -1;
    /**
     * Inner class Node
     * @param <E> the data type
     */
    protected class Node<E>
    {
        protected E element;
        protected Node<E> next;
        protected Node<E> previous;

        /**
         * constructor
         * @param element the data element
         */
        protected Node(E element)
        {
            this.element = element;
            next = null;
            previous = null;
        }

        /**
         * accessor for element
         * @return the element
         */
        protected E getElement()
        {
            return element;
        }
        /**
         * constructor
         * @param element the data element
         * @param next reference to the next Node
         */
        protected Node(E element, Node<E> next)
        {
            this.element = element;
            this.next = next;
            //this.previous = previous;
        }
  
        /**
         * Return the data as a string
         * @return the data as a string
         */
        @Override
        public String toString()
        {
            return "->" + element.toString();
        }
        
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Class            SimpleLinkedList_ListIterator
     * File             SimpleLinkedList.java
     * Description      A list iterator. Methods are circular.
     * @author          Nasser Najib
     * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
     * Date             5/6/2018
     * @version         1.0
     * @see             List Iterator
     * History Log:     5/6/2018 - Written
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    protected class SimpleLinkedList_ListIterator 
            implements ListIterator<E>{
        protected Node<E> current;
        protected int index = -1;
        
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      SimpleLinkedListIterator_ListIterator
         * @author          Nasser Najib
         * Description      Default constructor.
         *
         * Input            None.
         * Output           Creates a ListIterator.
         *
         * History Log:     5/6/2018 - Written
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        protected SimpleLinkedList_ListIterator(){
            current = (Node<E>) head;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      SimpleLinkedList_ListIterator
         * @author          Nasser Najib
         * Description      Constructor, iterates to a specified index.
         *
         * Input            Integer representing an index to iterate to.
         * @param           index - The index of the list to iterate to.
         * Output           Creates a list iterator and starts at a specified
         *              index.
         *
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        protected SimpleLinkedList_ListIterator(int index){
            if(index < 0)
                index = length + (index % length);
            if (index > length)
                index = index % length;
            if (index == length || index == -1)
                previous();
            int midpoint = 0;
            if(length % 2 == 0)
                midpoint = (length/2) + 1;
            else
                midpoint = length/2;
            if(index > midpoint)
                for(int i = 0; i < length - (index + 1); i++)
                    previous();
            if(index <= midpoint)
                for(int i = 0; i < index; i++)
                    next();
            for(int i = 0; i < index; i++)
                next();
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      next
         * @author          Nasser Najib
         * Description      Iterates to the next element in the list.
         *              If the there is no next element (end of the list), then
         *              it will return the first element (head).
         *
         * Input            None.
         * Output           Returns the next element in the list.
         *
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public E next(){
            if(current == null){
                throw new NoSuchElementException();
            }
            E theElement = current.element;
            if(current.next == null){
                current = (Node<E>) head;
                index = -1;
            }
            else
                current = current.next;
            index++;
            return theElement;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      previous
         * @author          Nasser Najib
         * Description      Iterates to the previous element in the list.
         *              If there is no previous element (reached the head), then
         *              it will return the last element (tail).
         *
         * Input        None.
         * Output       Returns the next element in the list.
         *
         * @throws NoSuchElementException if not currently positioned at a node.
         * 
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public E previous(){
            if(current == null)
                throw new NoSuchElementException();
            E theElement = current.element;
            if(current.previous == null){
                current = (Node<E>) getTail();
                index = length;
            }
            else
                current = current.previous;
            index--;
            return theElement;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      hasNext
         * @author          Nasser Najib
         * Description      Returns true if the list contains elements (because 
         *              this is a circular list), false if it's empty.
         *
         * Input        None.
         * Output       True if the list contains objects; False otherwise.
         * @return      boolean value.
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public boolean hasNext(){
            return head != null;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      nextIndex
         * @author          Nasser Najib
         * Description      Returns the next index (int).
         *
         * Input            None.
         * Output
         * @return          integer value representing the next index location.
         *
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public int nextIndex(){
            if(index == length)
                return 0;
            return index + 1;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      previousIndex
         * @author          Nasser Najib
         * Description      Returns the previous index (int)
         *
         * Input            None.
         * Output
         * @return          integer value repreesenting the previous index location.
         *
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public int previousIndex(){
            if(index == 0)
                return length - 1;
            return index - 1;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      hasPrevious
         * @author          Nasser Najib
         * Description      Returns True if the list contains elements (because
         *              this is a circular list); false otherwise.
         *
         * Input        None.
         * Output
         * @return      boolean value.
         *
         * History Log:     05/6/2018
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public boolean hasPrevious(){
            return head != null;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      add
         * @author          Nasser Najib
         * Description      adds an object into the list at the current index.
         *
         * Input            The object to be added.
         * @param           obj
         * Output           None.
         *
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public void add(E obj){
            SimpleLinkedList.this.add(obj);
            index = length -1;
            current = current.next;
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      remove
         * @author          Nasser Najib
         * Description      removes the object in the current index.
         *
         * Input            None.
         * Output           None.
         *
         * History Log:     05/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public void remove(){
            if(index == -1)
                throw new IllegalStateException();
            SimpleLinkedList.this.remove(index);
            index = -1;
            
        }
        /**<pre>
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method Name      set
         * @author          Nasser Najib
         * Description      replaces the element of the object in the current index
         *                  to the object that's given.
         *
         * Input            The new object to replace the previous.
         * @param           obj - The object to be replaced with.
         * Output           None.
         *
         * History Log:     5/6/2018 - Written.
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *</pre>
         */
        @Override
        public void set(E obj){
            current.element = obj;
        }
    
    }
   
    /**
     * Inner class SimpleLinkedListIterator
     * This is an iterator
     */
    protected class SimpleLinkedListIterator<E> implements Iterator<E>
    {
        protected Node<E> next; 
        protected int index = -1;
        
        protected SimpleLinkedListIterator()
        {
            next = (Node<E>)head;
        }
        
        /** 
        *  Returns the element this Iterator object was (before this call) 
        *  positioned at, and advances this Iterator object.
        *                    
        *  @return - the element this Iterator object was positioned at.
        *
        *  @throws NoSuchElementException if this Iterator object was
        *    not positioned at an element before this call.
        */                            
        @Override
        public E next()
        {
            if(next == null){
                throw new NoSuchElementException();
            }
            E theElement = next.element;
            if(next.next == null){
                next = (Node<E>) head;
                index = -1;
            }
            else
                next = next.next;
            index++;
            return theElement;
        }

       /**
        *  Determines if this Iterator object is positioned at an element
        *   in this Collection.
        *  @return true - if this Iterator object is positioned at an element; 
        *    otherwise, false.                        
        */                   
        @Override
        public boolean hasNext() 
        {       
            if(index < 0)
                return false;
            if(index >= length - 1)
                return false;
            return true;
        }
        
        /**
        * Removes from the underlying collection the last element returned by
        *   this iterator (optional operation). This method can be called only
        *   once per call to next(). The behavior of an iterator is
        *   unspecified if the underlying collection is modified while the
        *   iteration is in progress in any way other than by calling this
        *   method.
        * 
        * @throws IllegalStateException - if next() had not been called before
        *   this call to remove(), or if there had been an intervening call 
        *   to remove() between the most recent call to next() and this call.                
        */
        @Override
        public void remove() throws UnsupportedOperationException
        { 
            if(index == -1)
                throw new IllegalStateException();
            SimpleLinkedList.this.remove(index);
            index = -1;
        }
    }
    
    /**
     * default constructor -- creates an empty list
     */
    public SimpleLinkedList()
    { }
    /**
     * Appends the specified element to the end of this list.
     * @param e element to be appended to this list
     * @return true (as specified by Collection.add(E))
     * @throws ClassCastException if the class of the specified element
     *   prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *   list does not permit null element
     * @throws IllegalArgumentException if some property of this element
     *   prevents it from being added to this list   
     */
    @Override
    public boolean add(E e) throws ClassCastException,
            NullPointerException,
            IllegalArgumentException
    {
        if(e == null)
            throw new NullPointerException();
        if(head == null)
        {
            head = new Node<>(e);
        }
        else
        {
            Node<E> tail = getTail();
            tail.next = new Node(e);
            tail.next.previous = tail; //bruh.
        }
        length++;
        return true;
    }
    
    /**
     * Inserts the specified element at the specified position in this list.
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws ClassCastException if the class of the specified element
     *   prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *   list does not permit null element
     * @throws IllegalArgumentException if some property of this element
     *   prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index less than 0 || index greater than size())
     */
    @Override
    public void add(int index, E element) throws
            ClassCastException,
            NullPointerException,
            IllegalArgumentException,
            IndexOutOfBoundsException
    { 
        if(element == null)
            throw new NullPointerException();
        if(index < 0 || index > length)
            throw new IndexOutOfBoundsException();
        if(index == 0)
        {
            Node<E> temp = head;
            head = new Node<>(element, temp);
            if(length > 1)
                head.next.previous = head;
        }
        else
        {
            Node<E> nodeAtPrevious = getNodeAt(index - 1);
            if(nodeAtPrevious == null)
                throw new IndexOutOfBoundsException();
            nodeAtPrevious.next = new Node<>(element, 
                    nodeAtPrevious.next);
            nodeAtPrevious.next.previous = nodeAtPrevious;
            
        }
        length++;
    }

    /**
     * Appends all of the elements in the specified collection to the end
     * of this list, in the order they are returned by the specified
     * collection's iterator (optional operation)
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of the specified
     *   collection prevents it from being added to this list
     * @throws NullPointerException if the specified collection contains one
     *   or more null elements and this list does not permit null elements,
     *   or if the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     *   specified collection prevents it from being added to this list
     */
    @Override
    public boolean addAll(Collection<? extends E> c) throws
            ClassCastException,
            NullPointerException,
            IllegalArgumentException
    {
        if(c.isEmpty())
            return false;
        Object[] add = new Object[c.size()];
        add = c.toArray(add);
        for(int i = 0; i < add.length; i++){
            if (add[i] == null)
                throw new NullPointerException();
            add((E)add[i]); //I regret naming my array and the method both add. Still wont change it tho.
        }
        return true;
    }
    
     /**
     * Inserts all of the elements in the specified collection into this list
     * at the specified position (optional operation).
     * @param c collection containing elements to be added to this list
     * @param index index at which to insert the first element from the
     *   specified collection
     * @return true if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of the specified
     *   collection prevents it from being added to this list
     * @throws NullPointerException if the specified collection contains one
     *   or more null elements and this list does not permit null elements,
     *   or if the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     *   specified collection prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index less than 0 || index greater than size())
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c)
            throws UnsupportedOperationException,
            ClassCastException, NullPointerException,
            IllegalArgumentException,
            IndexOutOfBoundsException
    {
        if(index < 0 || index > length)
            throw new IndexOutOfBoundsException();
        if(c.isEmpty())
            return false;
        Object[] add = new Object[c.size()];
        add = c.toArray(add);
        for(int i = 0; i < add.length; i++){
            if (add[i] == null)
                throw new NullPointerException();
            add(index, (E)add[i]); //I regret naming my array and the method both add. Still wont change it tho.
            index++;
        }
        return true;
    }

    /**
     * Removes all of the elements from this list.
     * @throws UnsupportedOperationException if the clear operation is not
     *   supported by this list
     */
    @Override
    public void clear()
    {
        //This should get rid of all references. Even just setting head to null
        //Would work but would take longer for garbage collection. This is faster.
        Node<E> temp = head;
        for(int i = 0; i < length; i++){
            remove(i);
        }
        head = null;
        length = 0;
    }
    /**
     * Returns a shallow copy of this LinkedList.
     * @return a shallow copy of this list.
     * @throws CloneNotSupportedException if not supported
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
       
    }

    /**
     * Returns true if this list contains the specified element.
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element.
     */
    @Override
    public boolean contains(Object o)
    {
        for(Node<E> current = head; current != null; current = current.next)
            if(o == null)
            {
                if(current.element == null)
                    return true;
            }
            else
                if(current.element.equals(o))
                    return true;
        return false;
    }
    
    /**
     * Returns true if this list contains all of the elements
     * of the specified collection.
     * @param c collection containing elements whose presence in this list are
     *   to be tested
     * @return return true if this list contains all of the specified elements
     * @throws ClassCastException if the types of one or more elements in the
     *   specified collection are incompatible with this list (optional)
     * @throws NullPointerException if the specified collection contains one
     *   or more null elements and this list does not permit null elements
     *   (optional), or if the specified collection is null
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {
        if(c.isEmpty())
            return false;
        Object[] compare = new Object[c.size()];
        compare = c.toArray(compare);
        for(int i = 0; i < compare.length; i++){
            if(compare[i] == null)
                throw new NullPointerException();
            if(!contains(compare[i]))
                return false;
        }
        return true;
    }
    
    /**
     * Compares the specified object with this list for equality.
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof SimpleLinkedList))
            return false;
        SimpleLinkedList temp = (SimpleLinkedList) o;
        Iterator it = temp.iterator();
        if(temp.length != length)
            return false;
        for(int i = 0; i < length; i++){
        }
            
        return true;
    }
  
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException
    {
         Node<E> node = getNodeAt(index);
         return node.getElement();     
    }
 
    /**
     * Returns the hash code value for this list.
     * @return the hash code value for this list
     */
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + this.length;
        return hash;  
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * n this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *   this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element is
     *   incompatible with this list (optional)
     * @throws NullPointerException if the specified element is null and this
     *   list does not permit null elements (optional)
     */
    @Override
    public int indexOf(Object o) throws ClassCastException,
        NullPointerException
    {
        int count = 0;
        if(o == null)
        {
            for(Node<E> current = head; current != null;
                    current = current.next)
            {
                if(current.getElement() == null)
                    return count;
                count++;
            }   
        }else
        {
            E searchElement = (E)o;
            for(Node<E> current = head; current != null;
                    current = current.next)
            {
                if(searchElement.equals(current.getElement()))
                    return count;
                count++;
            }
        }
        return ITEM_NOT_FOUND;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty()
    {
        if(length == 0)
            return true;
        return false;
    }
    
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator()
    {
        //return null;
         return new SimpleLinkedListIterator<>();     
    }
    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *   this list, or -1 if this list does not contain the element
     * @throws ClassCastException - if the type of the specified element is
     *   incompatible with this list (optional)
     * @throws NullPointerException - if the specified element is null and
     *   this list does not permit null elements (optional)
     */
    @Override
    public int lastIndexOf(Object o) throws ClassCastException,
        NullPointerException
    { 
        int lastIndex = ITEM_NOT_FOUND;
        try
        {
             lastIndex = lastIndexOf((E)o, head, 0);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.err.println(e);
        }
        return lastIndex;
    }

    /**
     * Returns the index of the last occurrence of the specified element --
     *   recursive
     * @param searchElement element to search for
     * @param node reference to current node
     * @param index the current index
     * @return the index of the last occurrence of the specified element in
     *   this list, or -1 if this list does not contain the element
     * @throws IndexOutOfBoundsException if
     *   (index less than 0 || index greater than or equal to length)
     */
    protected int lastIndexOf(E searchElement, Node<E> node, int index)
            throws IndexOutOfBoundsException
    { 
         if(index < 0 || index >= length)
            throw new IndexOutOfBoundsException();
         int FoundIndex = ITEM_NOT_FOUND;
         if(node == null)
            return FoundIndex;
         if(node.next != null)
             FoundIndex = lastIndexOf(searchElement, node.next, index + 1);
         if(searchElement == null)
         {
            if(node.getElement() == null)
                if(FoundIndex == ITEM_NOT_FOUND)
                    FoundIndex = index;    
         }
         if(searchElement.equals(node.getElement()))
             if(FoundIndex == ITEM_NOT_FOUND)
                 FoundIndex = index;
         return FoundIndex;
    }

    /**
     * Returns a list iterator over the elements in this list
     *   (in proper sequence).
     * @return a list iterator over the elements in this list
     *   (in proper sequence)
     */
    @Override
    public ListIterator<E> listIterator()
    {
        return new SimpleLinkedList_ListIterator();    
    }
    
    /**
     * Returns a list-iterator of the elements in this list
     * (in proper sequence), starting at the specified position in the list.
     * @param index index of the first element to be returned from the list
     *   iterator (by a call to next)
     * @return a list iterator over the elements in this list
     *   (in proper sequence), starting at the specified position in the list

     */
    @Override
    public ListIterator<E> listIterator(int index)
    {
         return new SimpleLinkedList_ListIterator(index);
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index index of the first element to be returned from the list
     *   iterator (by a call to next)
     * @return a list iterator over the elements in this list
     *   (in proper sequence), starting at the specified position in the list
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException
    {
        if(index < 0)
            index = length + (index % length);
        if (index > length)
            index = index % length;
        if(index == 0)
        {
            Node<E> temp = head;
            head = head.next;
            //head.next.previous = head;
            length--;
            return temp.getElement();
        }
        Node<E> nodeBefore = getNodeAt(index - 1);
        if(nodeBefore == null)
            throw new IndexOutOfBoundsException();
        Node<E> temp = nodeBefore.next;
        nodeBefore.next = temp.next;
        nodeBefore.previous = temp.previous;
        length--;
        return temp.getElement();      
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     * @throws ClassCastException - if the type of the specified element is
     *   incompatible with this list (optional)
     * @throws NullPointerException - if the specified element is null and
     *   this list does not permit null elements (optional)
     * @throws UnsupportedOperationException - if the remove operation is
     *   not supported by this list
     */
    @Override
    public boolean remove(Object o) throws ClassCastException,
        NullPointerException, UnsupportedOperationException
    {
        //throw new UnsupportedOperationException();  
        if(o == null)
            throw new NullPointerException();
        if(contains(0)){
            remove(indexOf(o));
            return true;
            
        }
        return false;
    }

    /**
     * Removes from this list all of its elements that are contained
     * in the specified collection (optional operation).
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     * @throws UnsupportedOperationException if the removeAll operation is not
     *   supported by this list
     * @throws ClassCastException if the class of an element of this list is
     *   incompatible with the specified collection (optional) 
     * @throws NullPointerException if this list contains a null element and
     *   the specified collection does not permit null elements (optional),
     *   or if the specified collection is null
     */
    @Override
    public boolean removeAll(Collection<?> c)
            throws UnsupportedOperationException
    {
       throw new UnsupportedOperationException();
    }

    
    /**
     * Retains only the elements in this list that are contained
     * in the specified collection (optional operation).
     * @param c collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     * @throws UnsupportedOperationException if the retainAll operation is not
     *   supported by this list
     * @throws ClassCastException if the class of an element of this list is
     *   incompatible with the specified collection (optional)
     * @throws  NullPointerException if this list contains a null element and
     *   the specified collection does not permit null elements (optional),
     *   or if the specified collection is null
     */
    @Override
    public boolean retainAll(Collection<?> c)
            throws UnsupportedOperationException, ClassCastException,
            NullPointerException
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the set operation is not
     *   supported by this list
     * @throws ClassCastException if the class of the specified element
     *   prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and
     *   this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *   element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *   (index less than 0 || index greater than or equal to size()) 
     */
    @Override
    public E set(int index, E element) throws UnsupportedOperationException,
        ClassCastException, NullPointerException, IllegalArgumentException,
        IndexOutOfBoundsException
    {
        if(element == null)
            throw new NullPointerException();
        Node<E> temp = getNodeAt(index);
        E ret = temp.element;
        temp.element = element;
        return ret;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size()
    {
       return length;       
    }
    
    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *   (fromIndex less than 0 || toIndex greater than size ||
     *     fromIndex greater than toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex)
            throws IndexOutOfBoundsException
    {
        if(fromIndex < 0 || toIndex > length || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        List<E> ret = new ArrayList();
        for(int i = fromIndex; i < toIndex; i++)
            ret.add(get(fromIndex + i));
        return ret;
    }
    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     * @return an array containing all of the elements in this list
     *   in proper sequence
     */
    @Override
    public Object[] toArray()
    {
        Object[] arr = new Object[length];
        for(int i = 0; i < length; i++)
            arr[i] = get(i);
        return arr;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     * @param a the array into which the elements of this list are to be
     *   stored, if it is big enough; otherwise, a new array of the same
     *   runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     */
    @Override
    public <T> T[] toArray(T[] a)
    {
        if(a.length < length)
            a = (T[])Array.newInstance(this.getClass().getComponentType(), length);
        for(int i = 0; i < length; i++){
            a[i] = (T) get(i);
        }
        return a;     
    }
    /**
    * Return the data as a string
    * @return the data as a string
    */
    @Override
    public String toString()
    {
        String string = "";
        for(Node<E> current = head; current != null; current = current.next)
            string += current.toString();
        return string;
    }
    
    /**
     * Returns a reference to the last Node
     * @return a reference to the last Node
     */
    protected Node<E> getTail()
    {
        Node<E> tail = head;
        for(int i = 1; i < length; i++)
            tail = tail.next;
        return tail;
    }
       
    /**
     * Returns a reference to the last Node
     * @param index location in list
     * @return a reference to the last Node
     */
    protected Node<E> getNodeAt(int index) throws IndexOutOfBoundsException
    {
        if(index < 0){
            index = length + (index % length);
        }
        if(index > length){
            index = index % length;
        }
        Node<E> node = head;
        Node<E> tail = getTail();
        int midpoint = 0;
        if(length % 2 == 0)
            midpoint = (length/2) + 1;
        else
            midpoint = length/2;
        if(index > midpoint){
            for(int i = 0; i < length - (index + 1); i++)
                tail = tail.previous;
            return tail;
            }
        if(index <= midpoint){
            for(int i = 0; i < index; i++)
                node = node.next;
            return node;
        }
        return node;
    }
   
    protected int length = 0;
    protected Node<E> head;
}
