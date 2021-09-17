import processing.core.PApplet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class Main extends PApplet {

    public static void main(String[] args) {

        PApplet.main("Main", args);

    }
    MAP map=new MAP(this,10,10,60,60,14,14);
    Button button =new Button(this,1400,30,100,60,120);
    Dijkstra dijkstra=new Dijkstra(this,map);
    Time time = new Time();

    Generator generator=new Generator();
    int tempForGenerate=0;
    public void settings() {
        fullScreen();
    }

    public void setup() {
        time.start();
    }
Node node=new Node();
    public void draw() {

        InputProcess();
        DrawProcess();
      dijkstraDrawer();
    }





    public void dijkstraDrawer(){
        if(isFirstNodeSelected() && isFinishNodeSelected()) {
            dijkstra.SolveDijkstra(map.getMAP(), map.getAmountX(), map.AmountY, FirstNodeFinder().get(0), FirstNodeFinder().get(1));

            for(int i=0;i<dijkstra.EntryX.size();i++){
                if(time.saniye>1 ) {


                    dijkstra.TimeLapsDrawingArrX.add(dijkstra.EntryX.get(0));
                    dijkstra.TimeLapsDrawingArrY.add(dijkstra.EntryY.get(0));
                    if( dijkstra.EntryX.get(0)==FinishNodeFinder().get(0) &&dijkstra.EntryY.get(0)==FinishNodeFinder().get(1) )
                        break;
                    dijkstra.EntryX.remove(0);
                    dijkstra.EntryY.remove(0);


                    time.saniye=0;
                }
            }

            for(int i=0;i<dijkstra.TimeLapsDrawingArrX.size();i++) {

                if(i==dijkstra.TimeLapsDrawingArrX.size()-1)
                    fill(199, 0, 57);
                else
                    fill(255, 87, 51);

                rect(map.StarterX + map.perWitdh * dijkstra.TimeLapsDrawingArrX.get(i), map.StarterY + map.perHeight * dijkstra.TimeLapsDrawingArrY.get(i), map.perWitdh, map.perHeight);

                if(dijkstra.TimeLapsDrawingArrX.get(i)== FinishNodeFinder().get(0) && dijkstra.TimeLapsDrawingArrY.get(i)==FinishNodeFinder().get(1)){
                    if(isFirstNodeSelected() && isFinishNodeSelected()) {
                        dijkstra.SolveDijkstra(map.getMAP(), map.getAmountX(), map.AmountY, FirstNodeFinder().get(0), FirstNodeFinder().get(1));
                        ArrayList<Integer> PATH = dijkstra.FinalPathFinder(map.AmountX, map.AmountY, FinishNodeFinder().get(0), FinishNodeFinder().get(1));

                        for (int j = 0; j < PATH.size(); j++) {
                            rect(map.StarterX + map.perWitdh * PATH.get(j), map.StarterY + map.perHeight * PATH.get(j + 1), map.perWitdh, map.perHeight);
                            j++;
                        }

                    }
            }


            }



        }

    }


    boolean isFirstNodeSelected(){
        if(FirstNodeFinder().get(0)!=-1)
    return true;
        else return false   ;
    }

    boolean isFinishNodeSelected(){
        if(FinishNodeFinder().get(0)!=-1)
            return true;
        else return false   ;
    }



    Vector<Integer>  FinishNodeFinder(){
        String[][] MAP =map.getMAP();

        Vector<Integer> FirstXY=new Vector<Integer>(2);
        FirstXY.insertElementAt(-1,0);
        FirstXY.insertElementAt(-1,0);
        for(int i=0;i<map.getAmountX();i++){
            for (int j=0;j<map.getAmountY();j++){
                if (MAP[i][j].equals("FINISH")){
                    FirstXY.removeElementAt(0);
                    FirstXY.removeElementAt(0);

                    FirstXY.insertElementAt(j,0);
                    FirstXY.insertElementAt(i,0);
                    return FirstXY;
                }


            }
        }

        return FirstXY;

    }



    Vector<Integer>  FirstNodeFinder(){
          String[][] MAP =map.getMAP();

        Vector<Integer> FirstXY=new Vector<Integer>(2);
        FirstXY.insertElementAt(-1,0);
        FirstXY.insertElementAt(-1,0);
        for(int i=0;i<map.getAmountX();i++){
            for (int j=0;j<map.getAmountY();j++){
                if (MAP[i][j].equals("START")){
                    FirstXY.removeElementAt(0);
                    FirstXY.removeElementAt(0);

                    FirstXY.insertElementAt(j,0);
                    FirstXY.insertElementAt(i,0);
                    return FirstXY;
                }


            }
        }

return FirstXY;

    }


    public void InputProcess()
    {
        Vector<Integer >inputXY;
        if(  !button.whichButtonPressed().equals(" ")){

            cursor(CROSS);

            inputXY=map.ListenInput();
            if(inputXY.size()!=0){
                map.MapChangeForOneElement(inputXY.get(0),inputXY.get(1),button.whichButtonPressed());


                if(!button.getButtonChoose().equals("BLOCK"))
                button.setButtonChoose(" ");
                cursor(ARROW);

            }


            if(button.whichButtonPressed().equals("GENERATE")){

                if(tempForGenerate==0) {
                    map.setMAP(generator.setBlockAllMazeExpectStartNode(map.getMAP(), map.AmountY, map.AmountX, 0, 0));
                    map.setMAP(generator.MoveTheNode(map.getMAP(),node,map.AmountX,map.AmountY));
                    tempForGenerate=1;
                }
            }


        }





    }



    public void DrawProcess(){
        background(218, 247, 166);
        fill(255, 195, 0);
        map.drawMaze();
        button.ButtonDrawer();

    }


}
