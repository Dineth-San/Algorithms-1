
import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> lines;

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("Argument cannot be null");

        for (Point p : points) {
            if (p == null) throw new IllegalArgumentException("Point cannot be null");
        }

        Point[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints);
        for (int i = 0; i < sortedPoints.length - 1; i++) {
            if (sortedPoints[i].compareTo(sortedPoints[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicate points detected");
            }
        }

        lines = new ArrayList<>();
        findCollinearSegments(sortedPoints);
    }

    private void findCollinearSegments(Point[] points) {
        int n = points.length;

        for (Point p : points) {
            Point[] sortedBySlope = points.clone();
            Arrays.sort(sortedBySlope, p.slopeOrder());

            int count = 1;
            Point start = null;
            double prevSlope = Double.NEGATIVE_INFINITY;

            for (int j = 1; j < n; j++) {
                double slope = p.slopeTo(sortedBySlope[j]);
                if (slope == prevSlope) {
                    count++;
                    if (count == 2) start = sortedBySlope[j - 1];
                    if (count >= 3 && j == n - 1) {
                        addSegment(p, start, sortedBySlope[j]);
                    }
                } else {
                    if (count >= 3) {
                        addSegment(p, start, sortedBySlope[j - 1]);
                    }
                    count = 1;
                    prevSlope = slope;
                }
            }
        }
    }

    private void addSegment(Point p, Point start, Point end) {
        if (p.compareTo(start) < 0) {
            lines.add(new LineSegment(p, end));
        }
    }

    public int numberOfSegments() {
        return lines.size();
    }

    public LineSegment[] segments() {
        return lines.toArray(new LineSegment[0]);
    }
}
