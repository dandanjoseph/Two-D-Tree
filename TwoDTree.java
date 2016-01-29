/**
 * This project implements a 2dTree
 * It is similar to a binary search but takes into consideration of each point and makes moves upon them
 * 
 * 
 */



package twodtreetest;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Program that creates a Two D Tree
 * Assignment 3
 * @author Joseph
 */
public class TwoDTree {

    TwoDTreeNodeY root = null;
    TwoDTreeNodeY left;
    TwoDTreeNodeY right;
    Point data;
    ArrayList<Point> answer1 = new ArrayList<Point>();
    
    /**
     *
     */
    public TwoDTree(){}

    /**
     *
     * @param p
     */
    public void insert(Point p) {
        if (root == null) {
            root = new TwoDTree.TwoDTreeNodeY(p);
        } else {
            root.insert(p);
        }
    }

    /**
     *
     * @param p
     */
    public TwoDTree(ArrayList<Point> p) {
        //Add the Nodes.
        for (Point point : p) {
            this.insert(point);
        }
    }

    /**
     *
     * @param p1
     * @param p2
     * @return
     */
    public ArrayList<Point> searchRange(Point p1, Point p2) {
        ArrayList<Point> answer = new ArrayList<Point>();
        int MaxX = Math.max(p1.x, p2.x);
        int MinX = Math.min(p1.x, p2.x);
        int MaxY = Math.max(p1.y, p2.y);
        int MinY = Math.min(p1.y, p2.y);
        
        if (root == null){
        return answer;
        }
        else
        return root.searchRange(MinX, MaxX, MinY, MaxY);
    }

    /**
     *
     * @param p
     * @return
     */
    public boolean search(Point p) {
        if (root == null) {
            return false;
        } else {
            return root.search(p);
        }
    }

    private interface TwoDTreeNode {

        public void insert(Point p);

        public boolean search(Point p);

        public ArrayList<Point> searchRange(int a, int b, int c, int d);
 

    }

    private class TwoDTreeNodeX implements TwoDTreeNode {
            TwoDTreeNode left;
            TwoDTreeNode right;
            Point data;
        public TwoDTreeNodeX(Point p) {
           data = p;
        }

        public void insert(Point p) {
            if (p.getY() <= data.getY()) {   // note that data is an instance variable in our node
                if (left == null) {
                    left = new TwoDTreeNodeY(p);
                } else {
                    left.insert(p);
                }
            } else {   // note that data is an instance variable in our node
                if (right == null) {
                    right = new TwoDTreeNodeY(p);
                } else {
                    right.insert(p);
                }
            }
        }

        @Override
        public boolean search(Point p) {
            if ((p.getX() == data.getX()) && (p.getY() == data.getY())) {
                return true;
            } else {
                if (p.getX() <= data.getX()) {

                    if (left == null) {
                        return false;
                    } else {
                        return left.search(p);
                    }

                } else {
                    if (right == null) {
                        return false;

                    } else {
                        return right.search(p);
                    }
                }
            }
        }

        @Override
        public ArrayList<Point> searchRange(int MinX,int MaxX, int MinY, int MaxY) {
            ArrayList<Point> anwser = new ArrayList<Point>();
            Point axis = new Point();
            for (int i = MinX; i < MaxX; i++){
                for(int j = MinY; j < MaxY; j++){
                axis.x = i;
                axis.y = j;
                anwser.add(axis);
                }
            }
            System.out.println(anwser);
            return anwser;
        }
    }

    private class TwoDTreeNodeY implements TwoDTreeNode {

        TwoDTreeNode left;
        TwoDTreeNode right;
        Point data;

        public TwoDTreeNodeY(Point p) {
            data = p;
        }

        public void insert(Point p) {
            if (p.getY() <= data.getY()) {   // note that data is an instance variable in our node
                if (left == null) {
                    left = new TwoDTreeNodeX(p);
                } else {
                    left.insert(p);
                }
            } else {   // note that data is an instance variable in our node
                if (right == null) {
                    right = new TwoDTreeNodeX(p);
                } else {
                    right.insert(p);
                }
            }
        }

        @Override
        public boolean search(Point p) {
            if ((p.getX() == data.getX()) && (p.getY() == data.getY())) {
                return true;
            } else {
                if (p.getY() <= data.getY()) {

                    if (left == null) {
                        return false;
                    } else {
                        return left.search(p);
                    }

                } else {
                    if (right == null) {
                        return false;

                    } else {
                        return right.search(p);
                    }
                }
            }
        }

        public ArrayList<Point> searchRange(int MinX,int MaxX, int MinY, int MaxY) {
            ArrayList<Point> anwser = new ArrayList<Point>();
               
            Point axis = new Point();
            for (int i = MinX; i < MaxX; i++){
                for(int j = MinY; j < MaxY; j++){
                axis.x = i;
                axis.y = j;
                anwser.add(axis);
                }
            }
            System.out.println(anwser);
            return anwser;
        

    }
    }

 
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(3,3));
        points.add(new Point(4,5));
        points.add(new Point(5,6));

        TwoDTree tree = new TwoDTree();
        tree.insert(new Point(2,2));
        tree.insert(new Point(1,1));
        tree.insert(new Point(1,2));
        System.out.println(tree.search(new Point(2,2)));
        System.out.println(tree.search(new Point(1,0)));
        System.out.println(tree.search(new Point(1,1)));
        System.out.println(tree.searchRange(new Point(0,0), new Point (5,5)));
        
        System.out.println(tree);
   // System.out.println(tree.search(new Point(1,10)));
    }

    }


