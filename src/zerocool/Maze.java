package zerocool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Maze {
    private int[][] pixels;
    Maze(String filename) throws IOException
    {
        loadMaze(filename);
        //printMaze();



       // Node startNode = new Node(pixels);


    }
//    private Node createNode(int[][] pixels)
//    {

//
//        return startNode;
//    }

//
//    public boolean exploreNode(Node currnode)
//    {
//        if(currnode.adjLeft!=null)
//            exploreNode(currnode.adjLeft);
//        if(currnode.adjRight!=null)
//            exploreNode(currnode.adjRight);
//        if(currnode.adjBottom!=null)
//            exploreNode(currnode.adjBottom);
//        if(currnode.adjTop!=null)
//            exploreNode(currnode.adjTop);
//
//
//        if(currnode.getCoordX()==currnode.getEndCoordX()&&currnode.getCoordY()==currnode.getEndCoordY())
//            if(currnode.getCoordX()!=0&&currnode.getCoordY()!=0)
//                System.out.println("Path found");
//        return true;
//
//    }
    private  void loadMaze(String filename) throws IOException
    {
        BufferedImage image = ImageIO.read(new File("resource/"+filename));
        pixels = new int[image.getWidth()][];

        for (int x = 0; x < image.getWidth(); x++)
        {
            pixels[x] = new int[image.getHeight()];
            for (int y = 0; y < image.getHeight(); y++)
            {
                pixels[x][y] = (byte) (image.getRGB(y, x) == 0xFFFFFFFF ? 1 : 0);
            }
        }
    }
    public void printMaze()
    {
        for(int x=0;x<pixels.length;x++){

            for(int y=0;y<pixels[x].length;y++){

                System.out.print(pixels[x][y]+" ");
                if(y==pixels[x].length-1)
                    System.out.println();
            }

        }
    }
}
