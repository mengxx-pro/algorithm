package leetcode706;


/**
 * @program: algorithm
 * @description:
 *
 * @author: mengxiangxing
 * @create: 2021-07-18 15:01
 **/
class MyHashMap {

  Node[] nodes =new Node[1000009];

  class Node{
    private int key;
    private Node(int key){
      this.key=key;
    }
  }

  /** Initialize your data structure here. */
  public MyHashMap() {

  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    nodes[key]=new Node(value);
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    return nodes[key]==null?-1:nodes[key].key;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    nodes[key]=null;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */