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

        Node startNode = new Node(pixels);
        for (int x=0;x<pixels.length;x++)
        {
            if(pixels[0][x]==1)
            {
                startNode.coordX=x;
                startNode.isStartNode=true;
                break;
            }
        }
        int y=pixels[0].length-1;
        for(int x=0;x<pixels.length;x++)
        {
            if(pixels[y][x]==1)
            {
                startNode.endcoordX=x;
                startNode.endcoordY=y;
            }
        }
        startNode.constructAdj();
        startNode.isStartNode=true;
        startNode.inited=true;

//        System.out.println("coordX ="+start.coordX);
//        System.out.println("coordY ="+start.coordY);
//
//        System.out.println("endcordx ="+start.endcoordX);
//        System.out.println("endcordy ="+start.endcoordY);

        Node.exploreNode(startNode);


    }
//    private Node createNode(int[][] pixels)
//    {

//
//        return startNode;
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
