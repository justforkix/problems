package com.problems.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
	
    class Data<S,T> {
        private S value;
        private Node<T> node;
        
        Data(S value, Node<T> node) {
            this.value = value;
            this.node = node;
        }
        
        public S getValue() {
            return this.value;
        }
        
        public void setValue(S value) {
            this.value = value;
        }
        
        public Node<T> getNode() {
            return this.node;
        }
        
        public void setNode(Node<T> node) {
        	this.node = node;
        }
        
        @Override
        public String toString() {
        	return "Data<" + value.toString() + "," + node.toString() + ">";
        }
    }


    class Node<T> {
        T key;
        Node<T> prev;
        Node<T> next;
        
        Node(T key, Node<T> prev, Node<T> next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
        
        public T getKey() {
            return this.key;
        }
        
        public void setKey(T key) {
            this.key = key;
        }
        
        public Node<T> getPrev() {
            return this.prev;
        }
        
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
        
        public Node<T> getNext() {
            return this.next;
        }
        
        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        @Override
        public String toString() {
        	String myprev = "";
        	String mynext = "";
        	if (prev == null) {
        		myprev = "null";
        	} else {
        		myprev = prev.getKey().toString();
        	}
        	
        	if (next == null) {
        		mynext = "null";
        	} else {
        		mynext = next.getKey().toString();
        	}
        	
        	return "Node(" + key.toString() + "," + myprev + "," + mynext + ")";
        }
    }
    
    class MyList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;
        
        public Node<T> getHead() {
            return this.head;
        }
        
        public Node<T> getTail() {
            return this.tail;
        }
        
        public void setHead(Node<T> node) {
            this.head = node;
        }
        
        public void setTail(Node<T> node) {
            this.tail = node;
        } 
        
        public boolean isEmpty() {
            if (head == null) {
                return true;
            } else {
                return false;
            }
        }
        
        public int size() {
        	return this.size;
        }
        
        public synchronized void add(Node<T> node) {
            if (this.isEmpty()) {
                this.setHead(node);
                this.setTail(node);
                node.setPrev(null);
                node.setNext(null);
            } else {
                Node<T> tail = this.getTail();
                tail.setNext(node);
                node.setPrev(tail);
                this.setTail(node);
                node.setNext(null);
            }
            this.size = this.size + 1;
        }
        
        public synchronized void remove(Node<T> node) {
            if (this.isEmpty()) {
                throw new IllegalStateException();
            }
        
            if (node == this.getHead()) {
                this.setHead(node.getNext());
                if (node.getNext() != null) {
                node.getNext().setPrev(null);
                }
                node.setNext(null);
            } else if (node == this.getTail()) {
                this.setTail(node.getPrev());
                if (node.getPrev() != null) {
                node.getPrev().setNext(null);
                }
                node.setPrev(null);
            } else {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
                node.setNext(null);
                node.setPrev(null);
            }
            
            this.size = this.size - 1;
    
        }
        
        @Override
        public String toString() {
        	StringBuilder sb = new StringBuilder();
        	sb.append("{{List: (");
        	Node<T> node = this.getHead(); 
        	while(node != null) {
        		sb.append(node.toString() + ",");
        		node = node.getNext();
        	}
        	sb.append("}}");
        	return sb.toString();
        }
        
    }
    
    private Map<Integer, Data<Integer,Integer>> dict = new HashMap<Integer, Data<Integer,Integer>>();
    private MyList<Integer> list = new MyList<Integer>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int size() {
    	return list.size();
    }
    
    @Override
    public String toString() {
    	return "{[Map:" + dict.toString() + "]" + "[List:" + list.toString() + "]}";
    	
    }
    
    public int getLRUKey() {
    	Node<Integer> node = list.getHead();
    	return  node.getKey();
    }
    
    public int getMRUKey() {
    	Node<Integer> node = list.getTail();
    	return  node.getKey();
    }
    
    public synchronized int get(int key) {
        if (dict.containsKey(key)) {
            Data<Integer,Integer> data = dict.get(key);
            updateNode(data.getNode());
            return data.getValue();
        } else {
            return -1;
        }
        
    }
    
    public synchronized void set(int key, int value) {
        if (dict.containsKey(key)) {
            Data<Integer,Integer> data = dict.get(key);
            updateNode(data.getNode());
            data.setValue(value);    
        } else {
            if (list.size() == capacity) {
            	Node<Integer> LRUNode = list.getHead();
                list.remove(LRUNode);
                dict.remove(LRUNode.getKey());  
            } 
            addItem(key, value);
        }
    }
    
    private void updateNode(Node<Integer> node) {
        list.remove(node);
        list.add(node);
    }
    
    private void addItem(int key, int value) {
        Node<Integer> node = new Node<Integer>(key, null, null);
        list.add(node);
        Data<Integer,Integer> data = new Data<Integer,Integer>(value, node);
        dict.put(key, data);
    }


}
