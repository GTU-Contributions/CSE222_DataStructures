package com.mycompany.hw7_mehmed_mustafa_131044084;

/**
 * Chain Hash Table Class
 * @author Mehmed Mustafa 131044084
 */
public class MehmeDChainHash<K, V>{
    
    /**
     * Inner class
     * @param <K>
     * @param <V> 
     */
    private static class LinkedEntry<K, V>{
        private final K key;
        private V value;
        private LinkedEntry next;

        LinkedEntry(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public void setValue(V value){
            this.value = value;
        }
        public V getValue(){
            return value;
        }
        public K getKey(){
            return key;
        }  
        public void setNext(LinkedEntry next){
            this.next = next;
        }
        public LinkedEntry getNext(){
            return next;
        }
    }
    
    //Data Fields
    /* Initial table size */
    private final static int INITIAL_SIZE = 502;
    /* Hash table holder */
    private final LinkedEntry[] table;
    
    //Constructor
    /**
     * Default Constructor
     */
    public MehmeDChainHash(){
        table = new LinkedEntry[INITIAL_SIZE];
        for(int i=0; i<INITIAL_SIZE; ++i)
            table[i] = null;
    }
    
    /**
     * Get the value for the given key
     * @param key The key
     * @return The value for the given key
     */
    public V get(K key){
        int hash = (key.hashCode() % INITIAL_SIZE);
        
        if(hash < 0)
            hash *= -1;
        
        if(table[hash] != null)
        {
            LinkedEntry entry = table[hash];
            while(entry != null && entry.getKey() != key)
                entry = entry.getNext();

            if(entry != null)
                return (V)entry.getValue();
        }
        
        return null;
    }
    
    /**
     * Put the value with the given key
     * @param key The key
     * @param value The value
     */
    public void put(K key, V value) {
        int hash = (key.hashCode() % INITIAL_SIZE);
        
        if(hash < 0)
            hash *= -1;
        
        if (table[hash] == null)
            table[hash] = new LinkedEntry(key, value);
        else
        {
            LinkedEntry entry = table[hash];
            while(entry.getNext() != null && entry.getKey() != key)
                entry = entry.getNext();

            if(entry.getKey() == key)
                entry.setValue(value);
            else
                entry.setNext(new LinkedEntry(key, value));
        }
    }
    
    /**
     * Removes the key entry
     * @param key The key
     */
    public void remove(K key){
        int hash = (key.hashCode() % INITIAL_SIZE);
        
        if(hash < 0)
            hash *= -1;
        
        if(table[hash] != null)
        {
            LinkedEntry prevEntry = null;
            LinkedEntry entry = table[hash];
            while(entry.getNext() != null && entry.getKey() != key){
                prevEntry = entry;
                entry = entry.getNext();
            }
            if(entry.getKey() == key)
            {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
            }
        }
    }
      
}
