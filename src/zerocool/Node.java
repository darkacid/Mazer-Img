package zerocool;


public class Node
{
    int[][]pixels;
    Node(int[][]pixels)
    {
        this.pixels=pixels;


    }
    Node()
    {

    }

    boolean explored=false;
    boolean isStartNode=false;
    boolean isEndNode=false;
    boolean inited=false;



    int coordX;
    int coordY;

    int endcoordX;
    int endcoordY;


    Node adjLeft=null;
    Node adjRight=null;
    Node adjTop=null;
    Node adjBottom=null;



    public static boolean exploreNode(Node currnode)
    {
        if(currnode.adjLeft!=null)
            exploreNode(currnode.adjLeft);
        if(currnode.adjRight!=null)
            exploreNode(currnode.adjRight);
        if(currnode.adjBottom!=null)
            exploreNode(currnode.adjBottom);
        if(currnode.adjTop!=null)
            exploreNode(currnode.adjTop);





        if(currnode.coordX==currnode.endcoordX&&currnode.coordY==currnode.endcoordY)
            if(currnode.coordX!=0&&currnode.coordY!=0)
            System.out.println("Path found");
        return true;
    }
    public void constructAdj()
    {
        //adjLeft
        if(coordX!=0)
        if(pixels[coordY][coordX-1]==1)
        {
            adjLeft=new Node(pixels);
            adjLeft.coordX = coordX - 1;
            adjLeft.coordY = coordY;

            adjLeft.endcoordX=endcoordX;
            adjLeft.endcoordY=endcoordY;
        }

        //adjRight
        if(coordX!=pixels.length-1)
        if(pixels[coordY][coordX+1]==1)
        {
            adjRight=new Node(pixels);
            adjRight.coordX = coordX + 1;
            adjRight.coordY = coordY;

            adjRight.endcoordX=endcoordX;
            adjRight.endcoordY=endcoordY;
        }

        //adjTop
        if(coordY!=0)
        if(pixels[coordY-1][coordX]==1)
        {
            adjTop=new Node(pixels);
            adjTop.coordX = coordX;
            adjTop.coordY = coordY-1;

            adjTop.endcoordX=endcoordX;
            adjTop.endcoordY=endcoordY;
        }

        //adjBottom
        if (coordY!=pixels[0].length-1)
        if(pixels[coordY+1][coordX]==1)
        {
            adjBottom=new Node(pixels);
            adjBottom.coordX = coordX;
            adjBottom.coordY = coordY+1;

            adjBottom.endcoordX=endcoordX;
            adjBottom.endcoordY=endcoordY;
        }
    }
    public int showAdjCount()
    {
        int count=0;
        if(adjLeft!=null)
            count++;

        if(adjRight!=null)
            count++;

        if(adjTop!=null)
            count++;

        if(adjBottom!=null)
            count++;
        return count;
    }
}
