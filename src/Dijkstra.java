import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Dijkstra {
    static PApplet parent;
    static MAP map;
    static boolean isVisited[][];
    static int distance[][];
   static ArrayList<Integer> TimeLapsDrawingArrX=new ArrayList<Integer>();
    static  ArrayList<Integer> TimeLapsDrawingArrY=new ArrayList<Integer>();
static ArrayList<Integer> EntryX = new ArrayList<Integer>();
    static ArrayList<Integer> EntryY = new ArrayList<Integer>();

    public Dijkstra(PApplet parent, MAP map) {
        this.parent = parent;
        this.map = map;
    }

    public static void SolveDijkstra(String[][] MAP, int row, int column, int StartX, int StartY) {
        distance = new int[row][column];
        isVisited = new boolean[row][column];


        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                isVisited[j][i] = false;
                distance[j][i] = Integer.MAX_VALUE;
            }
        }


        distance[StartX][StartY] = 0;
        for (int i = 0; i < row * column; i++) {
            int[] u = minVertex(distance, isVisited);
            if (u[0] != -1) {
                int minindexX = u[0];
                int minindexY = u[1];
                isVisited[minindexX][minindexY] = true;


            EntryX.add(minindexX);
            EntryY. add(minindexY);

                //SAĞ KONTROL
                if (minindexX != row - 1)
                    if (distance[minindexX + 1][minindexY] > distance[minindexX][minindexY] + 1 && !isVisited[minindexX+1][minindexY]) {

                        if (!MAP[minindexX][minindexY].equals("BLOCK") && !MAP[minindexX + 1][minindexY].equals("BLOCK"))
                            distance[minindexX+1][minindexY] = distance[minindexX][minindexY] + 1;


                    }

//SOL KONTROL

                if (minindexX != 0)
                    if (distance[minindexX-1][minindexY] > distance[minindexX][minindexY] + 1 && !isVisited[minindexX-1][minindexY]) {


                        if (!MAP[minindexX][minindexY].equals("BLOCK") && !MAP[minindexX - 1][minindexY].equals("BLOCK"))
                            distance[minindexX-1][minindexY] = distance[minindexX][minindexY] + 1;
                    }


//YUKARI KONTROL

                if (minindexY != 0) {
                    if (distance[minindexX][minindexY-1] > distance[minindexX][minindexY] + 1 && !isVisited[minindexX][minindexY- 1]) {
                        {
                            if (!MAP[minindexX][minindexY].equals("BLOCK") && !MAP[minindexX][minindexY - 1].equals("BLOCK")) {
                                distance[minindexX][minindexY-1] = distance[minindexX][minindexY] + 1;
                            }
                        }
                    }
                }

//AŞŞAĞI KONTROL

                if (minindexY != column - 1)
                    if (distance[minindexX][minindexY+1] > distance[minindexX][minindexY] + 1 && !isVisited[minindexX][minindexY+1]) {
                        if (!MAP[minindexX][minindexY + 1].equals("BLOCK") && !MAP[minindexX][minindexY].equals("BLOCK")) {

                            distance[minindexX][minindexY+1] = distance[minindexX][minindexY] + 1;
                        }

                    }
            }


        }





    }


    private static int[] minVertex (int [][] dist, boolean [][] v) {
        //StartValue
        int x = Integer.MAX_VALUE;
        int yy = -1;
        int xx=-1;
         return findNextVertexminDistanceAndNotVisited(dist,v,xx,yy,x);
    }

    public static int[]findNextVertexminDistanceAndNotVisited(int [][] dist, boolean [][] v,int xx,int yy,int x){
    for (int i=0; i<dist.length; i++) {
            for (int j=0; j<dist[0].length; j++) {
                if (!v[i][j] && dist[i][j] < x) {
                    yy = i;
                    xx=j;
                    x = dist[i][j];
                }
            }
        }
return createArrayForMinVertexRETURN(xx,yy);
    }
public static int [] createArrayForMinVertexRETURN(int xx,int yy){
    int dizi[]=new int[2];
    dizi[0]=yy;
    dizi[1]=xx;
    return dizi;
}

public ArrayList<Integer> FinalPathFinder (int row,int column,int finalX,int finalY){

    ArrayList<Integer> Path=new ArrayList<Integer>();

    int mesafe = distance[finalX][finalY];

    for (int k = 0; k < mesafe; k++) {
        int MIN = Integer.MAX_VALUE;

        int l1 = Integer.MAX_VALUE, l2 = Integer.MAX_VALUE, l3 = Integer.MAX_VALUE, l4 = Integer.MAX_VALUE;
        if (finalX!= row-1) {
            l1 = distance[finalX + 1][finalY];
            if (l1 < MIN)
                MIN = l1;
        }
        if (finalX!= 0) {
            l2 = distance[finalX - 1][finalY];

            if (l2 < MIN)
                MIN = l2;

        }

        if (finalY != column-1) {
            l3 = distance[finalX][finalY+1];
            if (l3 < MIN)
                MIN = l3;
        }
        if (finalY != 0) {
            l4 = distance[finalX][finalY - 1];
            if (l4 < MIN)
                MIN = l4;
        }

        int sayacz = 0;
int minx=0;
int miny =0;
        if (finalX != row-1)
            if (distance[finalX + 1][finalY] == MIN && sayacz == 0) {
                minx = finalX +1 ;
                miny = finalY ;

                Path.add(minx);
                Path.add(miny);
                sayacz = 1;

            }
        if (finalX != 0)
            if (distance[finalX - 1][finalY] == MIN && sayacz == 0) {
                minx = finalX-1;
                miny = finalY;
                sayacz = 1;
                Path.add(minx);
                Path.add(miny);
            }
        if (finalY != column-1)
            if (distance[finalX][finalY + 1] == MIN && sayacz == 0) {
                minx = finalX;
                miny = finalY+1;
                sayacz = 1;
                Path.add(minx);
                Path.add(miny);
            }
        if (finalY != 0)
            if (distance[finalX][finalY-1] == MIN && sayacz == 0) {

                minx = finalX;
                miny = finalY-  1;
                sayacz = 1;
                Path.add(minx);
                Path.add(miny);
            }


        finalX=minx;
            finalY=miny;

    }


        return Path;
}








}