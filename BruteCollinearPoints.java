
import java.util.ArrayList;

public class BruteCollinearPoints {
    private int numberOfSegments = 0;
    private ArrayList<LineSegment> lines;

    public BruteCollinearPoints(Point[] points){
        if (points == null){
            throw new IllegalArgumentException("no arguments");
        }

        lines = new ArrayList<>();
        for (int i = 0; i < points.length-3; i++){
            for (int j = i+1; j < points.length-2; j++){
                for (int k = j+1; k < points.length-1; k++){
                    if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])) {
                        for (int a = k + 1; a < points.length; a++) {
                            if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[a])){
                                numberOfSegments++;

                                Point min = points[i];
                                Point max = points[i];

                                if (min.compareTo(points[j]) == 1) min = points[j];
                                if (min.compareTo(points[k]) == 1) min = points[k];
                                if (min.compareTo(points[a]) == 1) min = points[a];

                                if (max.compareTo(points[j]) == -1) max = points[j];
                                if (max.compareTo(points[k]) == -1) max = points[k];
                                if (max.compareTo(points[a]) == -1) max = points[a];

                                lines.add(new LineSegment(min, max));
                            }
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments(){
        return numberOfSegments;
    }

    public LineSegment[] segments(){
        return lines.toArray(new LineSegment[0]);
    }
}
