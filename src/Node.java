import java.util.ArrayList;

public class Node {
    static public int x=0;
    static public int y=0;
    static private ArrayList<Integer> EntrysX=new ArrayList<Integer>();
    private static  ArrayList<Integer> EntrysY=new ArrayList<Integer>();

    public void addX(int x) {
        EntrysX.add(x);
    }

    public void addY(int y) {
        EntrysY.add(y);
    }



    public static void removeEntryLastItem(){
        EntrysX.remove(EntrysX.size()-1);
        EntrysY.remove(EntrysY.size()-1);

    }

    public static ArrayList<Integer> getEntrysX() {
        return EntrysX;
    }


    public static void setEntrysX(ArrayList<Integer> entrysX) {
        EntrysX = entrysX;
    }

    public static ArrayList<Integer> getEntrysY() {
        return EntrysY;
    }

    public static void setEntrysY(ArrayList<Integer> entrysY) {
        EntrysY = entrysY;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Node.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Node.y = y;
    }
}
