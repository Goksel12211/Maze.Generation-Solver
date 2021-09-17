import java.util.ArrayList;
import java.util.Random;

public class Generator {

public String[][] setBlockAllMazeExpectStartNode(String[][] MAP,int row,int column,int startx,int starty){
    for (int i = 0; i < column; i++) {
        for (int j = 0; j < row; j++) {
            MAP[i][j] ="BLOCK";
        }
    }
    MAP[startx][starty] ="EMPTY";
    return MAP;
}



    public boolean UpCheck(String[][] MAP,Node node,int row,int column){

        if(node.getY()<row-2) {
            if (MAP[node.getX()][node.getY() + 2].equals("BLOCK")) {
                    return true;
            }
        }return false;
}


    public boolean DownCheck(String[][] MAP,Node node,int row,int column){

        if(node.getY()>0) {
            if (MAP[node.getX()][node.getY() - 2].equals("BLOCK")) {
                return true;
            }
        }return false;
    }



    public boolean RightCheck(String[][] MAP,Node node,int row,int column){

        if(node.getX()<column-2) {
            if (MAP[node.getX()+2][node.getY() ].equals("BLOCK")) {
                return true;
            }
        }return false;
    }


    public boolean LeftCheck(String[][] MAP,Node node,int row,int column){

        if(node.getX()>0) {
            if (MAP[node.getX()-2][node.getY() ].equals("BLOCK")) {
                return true;
            }
        }return false;
    }


    public void addAvaiablePathToRandomList(String[][] MAP, Node node, int row, int column,ArrayList<Integer> randomlistesi){
        randomlistesi.clear();
        if(LeftCheck(MAP,node,row,column))
            randomlistesi.add(0);
        if(DownCheck(MAP,node,row,column))
            randomlistesi.add(1);
        if(UpCheck(MAP,node,row,column))
            randomlistesi.add(2);
        if(RightCheck(MAP,node,row,column))
            randomlistesi.add(3);
    }


    public int SelectRandomDirection(ArrayList<Integer> randomlistesi){

        int randomsayi = 0;
        Random rnd = new Random();
        if (randomlistesi.size() >0) {
            randomsayi = rnd.nextInt(randomlistesi.size());
            randomsayi = randomlistesi.get(randomsayi);

        }
return randomsayi;
    }


    public String[][] MoveTheNode(String[][] MAP, Node node, int row, int column) {
        ArrayList<Integer> randomlistesi=new ArrayList<Integer>();
        if (isRoadAvaiable(MAP, node, row, column)) {
            addAvaiablePathToRandomList(MAP,node,row,column,randomlistesi);

          int  currentDirection=SelectRandomDirection(randomlistesi);

            if (node.getX() != 0 && currentDirection == 0) {
                if (MAP[node.getX() - 2][node.getY()].equals("BLOCK")) {
                    MAP[node.getX() - 1][node.getY()] = "EMPTY";
                    MAP[node.getX() - 2][node.getY()] = "EMPTY";
                    node.setX(node.getX() - 2);
                    node.addX(node.getX());
                    node.addY(node.getY());
                  MoveTheNode(MAP, node, row, column);

                }
            }



                if (node.getY() != 0 && currentDirection == 1) {
                    if (MAP[node.getX()][node.getY() - 2].equals("BLOCK")) {
                        MAP[node.getX()][node.getY() - 1] = "EMPTY";
                        MAP[node.getX()][node.getY() - 2] = "EMPTY";
                        node.setY(node.getY() - 2);
                        node.addX(node.getX());
                        node.addY(node.getY());
                      MoveTheNode(MAP, node, row, column);


                    }
                }






                if (node.getY() < row - 2 && currentDirection == 2) {
                    if (MAP[node.getX()][node.getY() + 2].equals("BLOCK")) {
                        MAP[node.getX()][node.getY() + 1] = "EMPTY";
                        MAP[node.getX()][node.getY() + 2] = "EMPTY";
                        node.setY(node.getY() + 2);
                        node.addX(node.getX());
                        node.addY(node.getY());
                     MoveTheNode(MAP, node, row, column);


                    }
                }



                if (node.getX() < column - 2 && currentDirection == 3) {
                    if (MAP[node.getX() + 2][node.getY()].equals("BLOCK")) {
                        MAP[node.getX() + 1][node.getY()] = "EMPTY";
                        MAP[node.getX() + 2][node.getY()] = "EMPTY";
                        node.setX(node.getX() + 2);
                        node.addX(node.getX());
                        node.addY(node.getY());

                      MoveTheNode(MAP, node, row, column);

                    }

                }


        } else {
            if (node.getEntrysX().size() > 2) {
                node.removeEntryLastItem();
                node.setX(node.getEntrysX().get(node.getEntrysX().size() - 1));
                node.setY(node.getEntrysY().get(node.getEntrysY().size() - 1));
                MoveTheNode(MAP, node, row, column);

            }

        }
            return MAP;
}










    public boolean isRoadAvaiable(String[][] MAP,Node node,int row,int column){

        int hepsimi=0;


        if(node.getY()<row-2) {
            if (MAP[node.getX()][node.getY() + 2].equals("BLOCK")) {

                hepsimi++;
            }
        }
        if(node.getX()<column-2) {
            if (MAP[node.getX()+2][node.getY() ].equals("BLOCK")) {
                hepsimi++;
            }
        }

        if(node.getY()>0){
            if (MAP[node.getX()][node.getY() -2 ].equals("BLOCK")) {
                hepsimi++;
            }
        }
        if(node.getX()>0) {
            if (MAP[node.getX() -2 ][node.getY()  ].equals("BLOCK")) {
                hepsimi++;
            }
        }

        if(hepsimi>0)
            return true;
        else
            return false;
    }

}
