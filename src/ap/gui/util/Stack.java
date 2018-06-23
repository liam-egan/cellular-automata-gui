package ap.gui.util;

import java.util.*;

public class Stack<E> {
    protected List<E> items;

    public Stack() {
        this(new ArrayList<E>());
    }

    public Stack(Stack<E> s) {
        this(s.getItems());
    }

    public Stack(List<E> items) {
        this.items = items;
    }

    public void push(E e) {
        this.items.add(e);
    }

    public E pop() {
        if (this.isEmpty()) {
            return null;
        }

        return this.items.remove(this.items.size() - 1);
    }

    public E peek() {    
        if (this.isEmpty()) {
            return null;
        }

        return this.items.get(this.items.size() - 1);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public int size() {
        return this.items.size();
    }

    public void clear() {
        this.items.clear();
    }

    public List<E> getItems() {
        return this.items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    public String toString() {
        String result = "";
        
        for (E e : this.items) {
            result += e + "\n";
        }

        return result;
    }
}
