package zerocool;


public class Node
{
    int[][]pixels;
    Node(int[][]pixels)
    {
        this.pixels=pixels;
    }

    private int coordX;
    private int coordY;

    private int endcoordX;
    private int endcoordY;


    Node adjLeft=null;
    Node adjRight=null;
    Node adjTop=null;
    Node adjBottom=null;


    public int getCoordX(){return coordX;}
    public int getCoordY(){return coordY;}

    public int getEndCoordX(){return endcoordX;}
    public int getEndCoordY(){return endcoordY;}

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
