package tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private int elementIndex;
    
    public CircularListImpl(){
        this.list = new ArrayList<>();
        this.elementIndex = 0;
    }

    public CircularListImpl(List<Integer> list){
        this.list = new ArrayList<>(list);
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(this.isEmpty()) {
            return Optional.empty();
        }
        if(this.list.listIterator().hasNext()) {
            return Optional.of(this.list.listIterator().next()); 
        } 
        return Optional.of(this.list.listIterator(0).next());
        /*if(elementIndex == this.size()) {
            elementIndex = 0;
        }
        return this.isEmpty() ?
            Optional.empty() :    
            Optional.of(this.list.get(elementIndex++));*/
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()) {
            return Optional.empty();
        } 
        return Optional.of(this.list.listIterator().previous()); 
        /*this.elementIndex--;
        if(elementIndex == -1) {
            elementIndex = this.size() - 1;
        }
        return this.isEmpty() ?
            Optional.empty() :    
            Optional.of(this.list.get(elementIndex));*/
    }

    @Override
    public void reset() {
        this.list.listIterator(0);
    }
}
