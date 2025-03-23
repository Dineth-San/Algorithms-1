import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point>{
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(){
        StdDraw.point(x, y);
    }

    public void drawTo(Point that){
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that){
        if (this.y < that.y){
            return -1;
        }
        else if (this.y > that.y){
            return 1;
        }
        else{
            if (this.x < that.x){
                return -1;
            }
            else if (this.x > that.x){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    public double slopeTo(Point that){
        double d_y = that.y - this.y;
        double d_x = that.x - this.x;
        if (d_x == 0 && d_y == 0){
            return Double.NEGATIVE_INFINITY;
        }
        if(d_y ==  0){
            return +0.0;
        }
        if (d_x == 0){
            return Double.POSITIVE_INFINITY;
        }

        return d_y/d_x;
    }

    public Comparator<Point> slopeOrder(){
        return new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                double slope1 = slopeTo(p1);
                double slope2 = slopeTo(p2);

                if (slope1 < slope2){
                    return -1;
                }
                else if (slope1 > slope2){
                    return 1;
                }
                else{
                    return 0;
                }
            }

        };
    }
}
