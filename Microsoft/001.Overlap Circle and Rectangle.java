class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int deltaX=shortestDistanceToSegment(x1,x2,xCenter);
        int deltaY=shortestDistanceToSegment(y1,y2,yCenter);
        return deltaX*deltaX+deltaY*deltaY<=radius*radius;
        
    }
    private int shortestDistanceToSegment(int segmentStart, int segmentEnd, int center)
    {
        if(segmentStart<=center && center<=segmentEnd){
            return 0;
        }
        if(center<segmentStart){
            return segmentStart-center;
        }
        return center-segmentEnd;
    }
}