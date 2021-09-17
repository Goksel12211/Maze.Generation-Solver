import processing.core.PApplet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class MAP {
    private int xAmount = 0;
    private int yAmount = 0;
    int StarterX, StarterY, AmountX, AmountY, perWitdh, perHeight = 0;
    PApplet parent;
  static  String[][] MAP ;

    public int getxAmount() {
        return xAmount;
    }

    public void setxAmount(int xAmount) {
        this.xAmount = xAmount;
    }

    public int getyAmount() {
        return yAmount;
    }

    public void setyAmount(int yAmount) {
        this.yAmount = yAmount;
    }

    public int getStarterX() {
        return StarterX;
    }

    public void setStarterX(int starterX) {
        StarterX = starterX;
    }

    public int getStarterY() {
        return StarterY;
    }

    public void setStarterY(int starterY) {
        StarterY = starterY;
    }

    public int getAmountX() {
        return AmountX;
    }

    public void setAmountX(int amountX) {
        AmountX = amountX;
    }

    public int getAmountY() {
        return AmountY;
    }

    public void setAmountY(int amountY) {
        AmountY = amountY;
    }

    public int getPerWitdh() {
        return perWitdh;
    }

    public void setPerWitdh(int perWitdh) {
        this.perWitdh = perWitdh;
    }

    public int getPerHeight() {
        return perHeight;
    }

    public void setPerHeight(int perHeight) {
        this.perHeight = perHeight;
    }

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    public MAP(PApplet parent, int StarterX, int StarterY, int AmountX, int AmountY, int perWitdh, int perHeight) {
        this.StarterX = StarterX;
        this.StarterY = StarterY;
        this.AmountX = AmountX;
        this.AmountY = AmountY;
        this.perWitdh = perWitdh;
        this.perHeight = perHeight;
        this.parent = parent;

        MAP=new String[AmountX][AmountY];
        for(int i=0;i<AmountX;i++){
            for(int j=0;j<AmountY;j++)
            {
                MAP[i][j]="EMPTY";
            }
        }


    }


    public void colorChangesForMaze(String [][] MAP,int i,int j){
        if(MAP[i][j]=="EMPTY")
            parent.fill(255, 195, 0);
        else if(MAP[i][j]=="START") {
            parent.fill(255, 87, 51);
        }
        else if(MAP[i][j]=="FINISH") {
            parent.fill(144, 12, 63);
        }
        else if(MAP[i][j]=="BLOCK") {
            parent.fill(88, 24, 69);
        }
    }
    public void drawMaze() {
        for (int i = 0; i < AmountX; i++) {
            for (int j = 0; j < AmountY; j++) {
                colorChangesForMaze(MAP,i,j);
                parent.rect(StarterX + perWitdh * i, StarterY + perHeight * j, perWitdh, perHeight);
            }

        }
    }

    public Vector<Integer> ListenInput() {
        Vector<Integer> SelectedKoordinat = new Vector<Integer>();

        for (int i = 0; i < AmountX; i++) {
            for (int j = 0; j < AmountY; j++) {
                if (parent.mouseX > StarterX + perWitdh * i && parent.mouseX < perWitdh + StarterX + perWitdh * i && parent.mouseY > StarterY + perHeight * j && parent.mouseY < perHeight + StarterY + perHeight * j && parent.mousePressed) {
                    SelectedKoordinat.insertElementAt(j, 0);
                    SelectedKoordinat.insertElementAt(i, 0);
                    parent.mousePressed=false;
                }
            }
        }
        return SelectedKoordinat;
    }


    public void MapChangeForOneElement(int x, int y , String value){

        if(MAP[x][y]=="EMPTY")
            MAP[x][y]=value ;
        else
            MAP[x][y]="EMPTY" ;

    }


    public String[][] getMAP() {
        return MAP;
    }

    public void setMAP(String[][] MAP) {
        this.MAP = MAP;
    }
}