package Lists;

import java.lang.RuntimeException;
public class MyHashMap {

    private MyHashMap[] array;
    private int hashvalue;
    private int capacity;

    public void put(MyHashMap s){
        for(int k = 0; k < array.length; k++) {
            if(array[k] == null) {
                array[k] = s;
                return;
            } else if(array[k].equals(s) || array[k] != null) {
                throw new RuntimeException("error");
            }
        }

    }

    public void remove(MyHashMap s){

        for(MyHashMap m : array) {
            if(m == s) {
                throw new RuntimeException("error");
            }
        }
    }
    
    public boolean contains(MyHashMap s){
        for(MyHashMap i : array) {
            if(i == s) {
                return true;
            }
        }
        return false;
    }
    
    public int getNumberMyHashMapWithHashvalue(int h){
        int n = 0;

        h = hashvalue;
        array = new MyHashMap[capacity];

        for(int j = 0; j < array.length; j++) {
            if(array[j].equals(h)) {
                n++;
            }
        }
        return n;
    }
    
    public void size(){
        MyHashMap[] newtable = array;
        array = new MyHashMap[array.length*2];

        for(int n=0; n < array.length; n++) {
            if(array[n] != null) {
                newtable = new MyHashMap[array.length*2];
            }
        }

    }

    public MyHashMap[] getArray(){
        return array;
    }

    public void setArray(MyHashMap[] array){
        this.array = array;
    }

    public int hashFunction(MyHashMap s){
        int hashvalue = Math.abs(s.hashCode()) % array.length;
        return hashvalue;
    }

    public MyHashMap(int capacity){
        array = new MyHashMap[capacity];
    }

}
