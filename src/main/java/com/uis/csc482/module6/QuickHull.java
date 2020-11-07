package com.uis.csc482.module6;

import java.util.ArrayList;
import java.util.List;

public class QuickHull {

    public static void main(String args[]) {

        ReadPoints readPoints = new ReadPoints();

        List<Points> points = readPoints.processFile();

        List<Points> convexHull = new ArrayList<>();

        int minPoint = -1;
        int maxPoint = -1;
        int minimumX = Integer.MAX_VALUE;
        int maximumX = Integer.MIN_VALUE;

        for (int i = 0; i < points.size(); i++) {

            if (points.get(i).getX() < minimumX) {

                minimumX = points.get(i).getX();
                minPoint = i;
            }

            if (points.get(i).getX() > maximumX) {
                maximumX = points.get(i).getX();
                maxPoint = i;
            }

        }

        //-- Getting minimum and maximum points
        Points A = points.get(minPoint);
        Points B = points.get(maxPoint);

        //-- Adding the minimum and maximum points to the list
        convexHull.add(A);
        convexHull.add(B);

        //-- Removing the minimum and maximum point since they are already added to list
        points.remove(A);
        points.remove(B);

        List<Points> leftSideSet = new ArrayList<>();
        List<Points> rightSideSet = new ArrayList<>();

        //-- Finding the point on left or right side of AB
        for (int i = 0; i < points.size(); i++) {
            Points P = points.get(i);
            if (pointLocation(A, B, P) == -1)
                leftSideSet.add(P);
            else if (pointLocation(A, B, P) == 1)
                rightSideSet.add(P);
        }

        findHull(A, B, rightSideSet, convexHull);
        findHull(B, A, leftSideSet, convexHull);

        convexHull.forEach(obj -> System.out.println(obj.x + "," + obj.y));
    }

    /**
     * This method determines what side the point is on
     *
     * @param A - first point
     * @param B - second point
     * @param P - point whose location needs to be determined
     * @return the result
     */
    public static int pointLocation(Points A, Points B, Points P) {
        int pointLocation = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
        if (pointLocation > 0)
            return 1;
        else if (pointLocation == 0)
            return 0;
        else
            return -1;
    }

    /**
     * This method finds the farthest point from points A and B and build the quick hull
     *
     * @param A          - The first point
     * @param B          - The second point
     * @param set        - The list of points in set either right side or left side of the line
     * @param convexHull - The list of points that make quick hull
     */
    public static void findHull(Points A, Points B, List<Points> set, List<Points> convexHull) {

        int insertPosition = convexHull.indexOf(B);
        if (set.size() == 0) {
            return;
        }
        if (set.size() == 1) {
            Points p = set.get(0);
            set.remove(p);
            convexHull.add(insertPosition, p);
            return;
        }

        int dist = Integer.MIN_VALUE;
        int farthestPoint = -1;

        //-- Finding the farthest point from A B
        for (int i = 0; i < set.size(); i++) {

            Points p = set.get(i);
            int distance = location(A, B, p);

            if (distance > dist) {
                dist = distance;
                farthestPoint = i;
            }
        }

        Points P = set.get(farthestPoint);
        set.remove(farthestPoint);
        convexHull.add(insertPosition, P);

        //-- Finding points on the left of AP
        List<Points> leftSetAP = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            Points M = set.get(i);
            if (pointLocation(A, P, M) == 1 && !checkPointInsideTriangle(A, B, P, M)) {
                leftSetAP.add(M);
            }
        }

        //-- Finding points on the left of PB
        List<Points> leftSetPB = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {
            Points M = set.get(i);
            if (pointLocation(P, B, M) == 1 && !checkPointInsideTriangle(A, B, P, M)) {
                leftSetPB.add(M);
            }
        }
        findHull(A, P, leftSetAP, convexHull);
        findHull(P, B, leftSetPB, convexHull);

    }

    /**
     * This method finds the location of point from AB
     *
     * @param A - first point
     * @param B - second point
     * @param C - The point whose location is required wrt AB
     * @return - The result of location
     */
    public static int location(Points A, Points B, Points C) {
        return (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
    }

    /**
     * This method finds the location of a point wrt to triangle formed by 3 points
     *
     * @param A - First point
     * @param B - Second point
     * @param C - Third point
     * @param P - The point whose location is required wrt triangle formed by A B C
     * @return - The result whether the point is inside or outside the triangle
     */
    public static boolean checkPointInsideTriangle(Points A, Points B, Points C, Points P) {

        int pXA = (P.x - A.x) * (B.y - A.y) - (P.y - A.y) * (B.x - A.x);
        int pXB = (P.x - B.x) * (C.y - B.y) - (P.y - B.y) * (C.x - B.x);
        int pXC = (P.x - C.x) * (A.y - C.y) - (P.y - C.y) * (A.x - C.x);

        return (pXA > 0 && pXB > 0 && pXC > 0) || (pXA < 0 && pXB < 0 && pXC < 0);
    }
}
