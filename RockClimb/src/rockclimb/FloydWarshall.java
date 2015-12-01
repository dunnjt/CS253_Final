/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockclimb;

/**
 *
 * @author johndunn
 */

import java.util.ArrayList;

public class FloydWarshall {

    private int distancematrix[][];
    private int numberofvertices;
    public static final int INFINITY = 999;
 
    public FloydWarshall(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }
 
    public void floydwarshall(int adjacencymatrix[][])
    {
        for (int source = 0; source < numberofvertices; source++)
        {
            for (int destination = 0; destination < numberofvertices; destination++)
            {
                distancematrix[source][destination] = adjacencymatrix[source][destination];
            }
        }
 
        for (int intermediate = 0; intermediate < numberofvertices; intermediate++)
        {
            for (int source = 0; source < numberofvertices; source++)
            {
                for (int destination = 0; destination < numberofvertices; destination++)
                {
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                         < distancematrix[source][destination])
                        distancematrix[source][destination] = distancematrix[source][intermediate] 
                            + distancematrix[intermediate][destination];
                }
            }
        }
 
        for (int source = 1; source <= numberofvertices; source++)
            System.out.print("\t" + source);
 
        System.out.println();
        for (int source = 1; source <= numberofvertices; source++)
        {
            System.out.print(source + "\t");
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                System.out.print(distancematrix[source][destination] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void buildMatrix(ArrayList<Points> points) {
        int adjacency_matrix[][];
        int numberofvertices;
        int d;

        numberofvertices = points.size();
        //System.out.println(points.size());
        
        Sort.selectionSort(points);
 
        adjacency_matrix = new int[points.size()][points.size()];
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int source = 0; source < numberofvertices; source++)
        {
            for (int destination = 0; destination < numberofvertices; destination++)
            {
                d = (int)Math.sqrt((points.get(destination).getX()-points.get(source).getX())*(points.get(destination).getX()-points.get(source).getX()) + 
                        (points.get(destination).getY()-points.get(source).getY())*(points.get(destination).getY()-points.get(source).getY()));
                if (d<50) {
                    adjacency_matrix[source][destination] = d;
                }
                else {
                    adjacency_matrix[source][destination] = 0;
                }
                
                if (source == destination)
                {
                    adjacency_matrix[source][destination] = 0;
                    continue;
                }
                if (adjacency_matrix[source][destination] == 0)
                {
                    adjacency_matrix[source][destination] = INFINITY;
                }
            }
        }
 
        System.out.println("The Transitive Closure of the Graph");
        FloydWarshall floydwarshall = new FloydWarshall(numberofvertices);
        floydwarshall.floydwarshall(adjacency_matrix);
    }
    
//        public static void main(String[] args) {
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
//        buildMatrix(pointTest);
//        //printPath();
//    }
}
