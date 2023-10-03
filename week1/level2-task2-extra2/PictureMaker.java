import java.awt.Color;
public class PictureMaker
{
    private TurtleWorld world;
    private Turtle fred;
    
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
 
    public void drawInitials() 
    {
        world.dropIn(fred);
        
        fred.penUp();
        fred.left(90);
        fred.forward(100);
        fred.left(90);
        
        fred.penDown();
        
        fred.setColor(Color.red);
        fred.forward(50);
        fred.left(180);
        fred.forward(100);
        fred.right(120);
        fred.forward(100);
        fred.right(120);
        fred.forward(100);
        fred.right(120);
        fred.forward(100);
        
        fred.setColor(Color.blue);
        fred.right(90);
        fred.forward(100);
        fred.right(90);
        fred.forward(100);
        fred.right(90);
        fred.forward(100);
        fred.right(90);
        fred.forward(100);
        
        fred.setColor(Color.green);
        fred.right(72);
        fred.forward(100);
        fred.right(72);
        fred.forward(100);
        fred.right(72);
        fred.forward(100);
        fred.right(72);
        fred.forward(100);
        fred.right(72);
        fred.forward(100);
        
        fred.setColor(Color.yellow);
        fred.right(60);
        fred.forward(100);
        fred.right(60);
        fred.forward(100);
        fred.right(60);
        fred.forward(100);
        fred.right(60);
        fred.forward(100);
        fred.right(60);
        fred.forward(100);
        fred.right(60);
        fred.forward(100);
        
        world.removeTurtle(fred);
        
    }
    
}

