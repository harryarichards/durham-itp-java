import java.awt.Color;

public class PictureMaker
{
    private TurtleWorld world;
    private Turtle fred;
    private java.awt.Color[] colorArray = {
        Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green,Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow
    };
    
   
    
    public PictureMaker()
    {
        world = new TurtleWorld(500, 500, "Picture Maker");
        fred = new Turtle();
    }
    
    public void display() {
        world.display();
    }
    
    public void erase() {
        world.removeTraces();
        world.removeTurtles();
    }

    
    public void changeColor(Color colourString)
    {
        
        fred.setColor(colourString);
    }
    
    public void drawShape(int numberOfSides, int sideLength) {
        world.dropIn(fred);
        
        fred.penUp();
        fred.left(180);
        fred.forward(50);
        fred.right(90);
        fred.forward(225);
        fred.right(90);
        fred.penDown();
        
        for (int i = 1; i < numberOfSides; i++) {
        fred.forward(sideLength);
        fred.right(360/numberOfSides);
    }
        fred.forward(sideLength);
        world.removeTurtle(fred);
    }
    
    public void drawHexagon() {
        world.dropIn(fred);
        
        fred.penUp();
        fred.left(90);
        fred.forward(200);
        fred.right(90);
        fred.penDown();
        
        for (int i = 1; i < 6; i++) {
        fred.forward(100);
        fred.right(60);
    }
        fred.forward(100);
        world.removeTurtle(fred);
    }
    
    public void drawPentagon() {
        world.dropIn(fred);
        fred.penUp();
        fred.left(90);
        fred.forward(200);
        fred.right(90);
        fred.penDown();
        
        for (int i = 1; i < 5; i++) {
        fred.forward(100);
        fred.right(72);
    }
        fred.forward(100);
        world.removeTurtle(fred);
    }
        
    
}

