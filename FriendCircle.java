class Solution {
    public int findCircleNum(int[][] M) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int table[] = new int[M.length];
        int count=0;
        for(int curr=0;curr<M.length;curr++){
            if(table[curr]!=0) continue;
            count++;
            queue.offer(curr);
            table[curr]=count;
            
            while(!queue.isEmpty()){
                int point = queue.poll();
                for(int i=0;i<M.length;i++){
                    if(table[i]==0 && M[point][i]==1){
                        table[i]=count;
                        queue.offer(i);
                    }
                }
            }
        }
        return count;
        
    }
}
