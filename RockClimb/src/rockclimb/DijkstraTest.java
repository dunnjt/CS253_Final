/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockclimb;

import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.ArrayList;
/**
 *
 * @author johndunn
 */
public class DijkstraTest {

   //private static final Graph.Edge[] GRAPH = new Graph.Edge[19900];
   private static ArrayList <Graph.Edge> GRAPH = new ArrayList<Graph.Edge>(); 
   private static String START;
   private static String END;
   private static Graph g;
 
   public static void buildEdges(ArrayList<Points> points) {
       int arrayCounter = 0;
       Sort.selectionSort(points);

       START = points.get(0).toString();
       END = points.get(199).toString();
       
       System.out.println(START + " " +END);
       for(int j=0; j<199; j++) {
           System.out.println(points.get(j).toString());
            for(int i=j; i<199; i++) {
                int d = (int)Math.sqrt((points.get(i+1).getX()-points.get(j).getX())*(points.get(i+1).getX()-points.get(j).getX()) + 
                        (points.get(i+1).getY()-points.get(j).getY())*(points.get(i+1).getY()-points.get(j).getY()));
                if ((j==0 && i==0) || (j==198 && i==198) || d<1000) {
                    System.out.println("d: " + d);
//                    GRAPH[arrayCounter] = new Graph.Edge(points.get(j).toString(), points.get(i+1).toString(), 
//                            (int)Math.sqrt((points.get(i+1).getX()-points.get(j).getX())*(points.get(i+1).getX()-points.get(j).getX()) + 
//                            (points.get(i+1).getY()-points.get(j).getY())*(points.get(i+1).getY()-points.get(j).getY())));
                      GRAPH.add(new Graph.Edge(points.get(j).toString(), points.get(i+1).toString(), d));
                      arrayCounter++;
                }
   
                
                

                
            }
       }
       
       System.out.println(arrayCounter);
       g = new Graph(GRAPH);
       g.dijkstra(START);
       g.printPath(END);
       //printPath();
   }
   
   public static void printPath() {
       g.printAllPaths();
   }


//    public static void main(String[] args) {
//    
//        ArrayList<Integer> listX= new ArrayList<Integer>();
//        ArrayList<Integer> listY= new ArrayList<Integer>();
//        ArrayList<Points> pointTest = new ArrayList<Points>();
//        
//        for (int i=0; i<10; i++)
//            listX.add(i);
//        for (int j=10; j>0; j--)
//            listY.add(j);
//        for (int i=0; i<10; i++) 
//            pointTest.add(new Points(listX.get(i), listY.get(i)));
//
//        buildEdges(pointTest);
//        printPath();
//    }
}
