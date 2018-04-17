/*Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.*/


class Solution {
    public boolean judgeCircle(String moves) {
        int i=0;
        int position[]=new int [2];
        while(i<moves.length()){
            if(moves.charAt(i)=='U'){
                position[0]-=1;
            }else if(moves.charAt(i)=='D'){
                position[0]+=1;
            }else if(moves.charAt(i)=='L'){
                position[1]-=1;
            }else if(moves.charAt(i)=='R'){
                position[1]+=1;
            }
            i++;
        }
        
        if(position[0]==0 && position[1]==0){
            return true;
        }
        
        return false;
    }
}
