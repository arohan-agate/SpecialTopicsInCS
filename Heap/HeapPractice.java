// isConsecutive
public boolean isConsecutive(PriorityQueue<Integer> pq) {
    if (pq.isEmpty())
	return true;

    Queue<Integer> aux = new LinkedList<Integer>();
    boolean isConsecutive = true;
    while (!pq.isEmpty()) {
	int element = pq.remove();
	if (isConsecutive && !pq.isEmpty() && element != pq.peek() - 1) {
	    isConsecutive = false;
	}
	aux.add(element);
    }
    while(!aux.isEmpty())
	pq.add(aux.remove());
    return isConsecutive;
}

// removeDuplicates
public void removeDuplicates(PriorityQueue<Integer> pq) {
    Queue<Integer> aux = new LinkedList<Integer>();
    int old = Integer.MAX_VALUE;
    while(!pq.isEmpty()) {
	int element = pq.remove();
	if (element != old) {
	    aux.add(element);
	}
	old = element;
    }
    while(!aux.isEmpty())
	pq.add(aux.remove());
    
}

// stutter
public void stutter(PriorityQueue<Integer> pq) {
    Queue<Integer> aux = new LinkedList<Integer>();
    while(!pq.isEmpty()) 
	aux.add(pq.remove());

    while(!aux.isEmpty()) {
	int element = aux.remove();
	pq.add(element);
	pq.add(element);
    }
}

// fillGaps
public void fillGaps(PriorityQueue<Integer> pq){
    if(pq == null){
        return;
    }
    PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
    int curr = pq.poll();
    while(pq.size() > 0){
        int next = pq.poll();
        
        for(int i = 0; i <= next - curr; i++){
            temp.offer(curr + i);
        }
        curr = next;
    }
     while(temp.size() > 0){
        pq.offer(temp.poll());
    }
    
}
