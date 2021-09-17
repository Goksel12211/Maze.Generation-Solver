import processing.core.PApplet;
import java.util.Vector;

 class Button {
    PApplet parent;
    private static int StarterX, StarterY, width, height,diff; //encapsulation
    static String buttonChoose=" ";




public  Button(PApplet parent,int StarterX,int StarterY,int width,int height,int diff){
    this.StarterX=StarterX;
    this.StarterY=StarterY;
    this.width=width;
    this.height=height;
    this.diff=diff;
    this.parent=parent; }

public  void ButtonDrawer(){
    parent.fill(255, 87, 51);
  parent.rect(StarterX,StarterY,width,height);
    parent.fill(0);

    parent.text("Start",StarterX+width/3,StarterY+height/3+10);

    parent.fill(144, 12, 63);
    parent.rect(StarterX-diff,StarterY,width,height);
    parent.fill(0);
    parent.text("Finish",StarterX+width/3-diff,StarterY+height/3+10);



    parent.fill(90, 24, 154);
    parent.rect(StarterX-diff*2/3,StarterY+diff*2/3,width+diff/3,height);
    parent.fill(255);
    parent.text("Generate Maze",StarterX+width/3-diff*2/3,StarterY+height+10+diff/3);
    parent.fill(255);


    parent.fill(88, 24, 69 );
    parent.rect(StarterX-diff*2/3,StarterY+diff*4/3,width+diff/3,height*2);
    parent.fill(255);
    parent.text("Blocks",StarterX-20,StarterY+height*10/3+10);



}
String   whichButtonPressed(){

    if( StarterX<parent.mouseX &&StarterX+width>parent.mouseX  && parent.mousePressed && parent.mouseY>StarterY && parent.mouseY<StarterY+height){
        buttonChoose="START";
    }
    else if( StarterX-diff<parent.mouseX &&StarterX+width-diff>parent.mouseX  && parent.mousePressed && parent.mouseY>StarterY && parent.mouseY<StarterY+height){
        buttonChoose="FINISH";
    }
    else if(parent.mouseX>StarterX-diff*2/3 &&parent.mouseX<StarterX-diff*2/3 + width + diff/3 && parent.mousePressed && parent.mouseY>StarterY+diff*4/3 && parent.mouseY< (StarterY+diff*4/3)+height*2){
        buttonChoose="BLOCK";
    }
    else if(parent.mouseX>StarterX-diff*2/3 && parent.mouseX<StarterX-diff*2/3 + width+diff/3 && parent.mousePressed &&StarterY+diff*2/3<parent.mouseY && parent.mouseY<StarterY+height+diff*2/3) {
        buttonChoose = "GENERATE";
    }

    return buttonChoose;
}


     public PApplet getParent() {
         return parent;
     }

     public void setParent(PApplet parent) {
         this.parent = parent;
     }

     public static int getStarterX() {
         return StarterX;
     }

     public static void setStarterX(int starterX) {
         StarterX = starterX;
     }

     public static int getStarterY() {
         return StarterY;
     }

     public static void setStarterY(int starterY) {
         StarterY = starterY;
     }

     public static int getWidth() {
         return width;
     }

     public static void setWidth(int width) {
         Button.width = width;
     }

     public static int getHeight() {
         return height;
     }

     public static void setHeight(int height) {
         Button.height = height;
     }

     public static int getDiff() {
         return diff;
     }

     public static void setDiff(int diff) {
         Button.diff = diff;
     }

     public String getButtonChoose() {
         return buttonChoose;
     }

     public void setButtonChoose(String buttonChoose) {
         this.buttonChoose = buttonChoose;
     }
 }
