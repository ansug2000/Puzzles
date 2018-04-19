/*Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(n==0)return tasks.length;
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
    
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(26, Collections.reverseOrder());
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
           //System.out.println(entry.getKey()+":"+entry.getValue());
            pq.add(entry.getValue());
        }
        int max=0, count=0;
         while(!pq.isEmpty()){
             int i=0;
             List<Integer> temp = new ArrayList<Integer>();
             while(i<=n){
                 
                 if(!pq.isEmpty()){
                     if(pq.peek() >1)
                     temp.add(pq.poll()-1);
                     else
                        pq.poll();
                 }max++;
                 if (pq.isEmpty() && temp.size() == 0)
                    break;
                 i++;
            }
             for(int l:temp){
             pq.add(l);
             }
         }
        return max;    
    }
}
