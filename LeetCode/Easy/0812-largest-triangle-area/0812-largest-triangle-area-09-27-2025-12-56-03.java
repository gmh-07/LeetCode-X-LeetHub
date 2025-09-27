class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    double x1 = points[i][0];
                    double y1 = points[i][1];
                    double x2 = points[j][0];
                    double y2 = points[j][1];
                    double x3 = points[k][0];
                    double y3 = points[k][1];
                    double side1 = findSide(x1,y1,x2,y2);
                    double side2 = findSide(x1,y1,x3,y3);
                    double side3 = findSide(x3,y3,x2,y2);
                    double area =  area(side1,side2,side3);
                    max = Math.max(max,area);
                }
            }
        }
        return max;
    }
    private double area(double a,double b,double c){
        double s = 0.5 * (a+b+c);
        double areaSquare = s*(s-a)*(s-b)*(s-c);
        if(areaSquare <= 0) return 0.0;
        return Math.sqrt(areaSquare);
    }
    private double findSide(double x1,double y1,double x2,double y2){
        return Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
    }
}