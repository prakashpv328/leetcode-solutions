class LFUCache {
    int capacity;
    int minfreq;
    int curr_capacity;

    HashMap<Integer,Node> cache;
    HashMap<Integer,DLL> freqList;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.freqList=new HashMap<>();
        this.curr_capacity=0;
        this.minfreq=0;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            update(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;

        if(cache.containsKey(key)){
            cache.get(key).val=value;
            update(cache.get(key));
            return;
        }
        else{
            curr_capacity++;
            if(curr_capacity>capacity){
                DLL dll=freqList.get(minfreq);
                cache.remove(dll.tail.prev.key);
                dll.delete(dll.tail.prev);
                curr_capacity--;
            }
            minfreq=1;
            Node node=new Node(key,value);
            DLL newdll=freqList.getOrDefault(1,new DLL());
            newdll.add(node);
            freqList.put(1,newdll);
            cache.put(key,node);
        }

    }

    void update(Node node){
        int f=node.freq;
        DLL dll=freqList.get(f);
        if(dll!=null)dll.delete(node);

        if(f==minfreq && dll.size==0){
            minfreq++;
        }

        node.freq++;

        DLL newdll=freqList.getOrDefault(f+1,new DLL());
        newdll.add(node);
        freqList.put(f+1,newdll);
    }
}

class Node{
    int val;
    int key;
    int freq;
    Node next=null;
    Node prev=null;
    Node(int key,int val){
        this.freq=1;
        this.key=key;
        this.val=val;
    }
}

class DLL{
    int size=0;
    Node head;
    Node tail;
    DLL(){
        this.size=0;
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    void add(Node newNode){
        Node nextNode=head.next;
        head.next=newNode;
        newNode.next=nextNode;
        newNode.prev=head;
        nextNode.prev=newNode;
        size++;
    }

    void delete(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        size--;
    }

}
