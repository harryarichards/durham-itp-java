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
        fred.forward(200);
        fred.left(90);
        fred.forward(200);
        fred.left(180);
        
        fred.penDown();
        fred.forward(350);
        fred.left(180);
        fred.forward(175);
        fred.left(90);
        fred.forward(175);
        fred.right(90);
        fred.forward(175);
        fred.right(180);
        fred.forward(350);
        fred.right(180);
        fred.forward(175);
        fred.penUp();
        
        fred.left(90);
        fred.forward(50);
        
        fred.penDown();
        fred.right(90);
        fred.forward(175);
        fred.right(180);
        fred.forward(350);
        fred.right(90);
        fred.forward(175);
        fred.right(90);
        fred.forward(175);
        fred.right(90);
        fred.forward(175);
        fred.left(135);
        fred.forward(247);
        
        world.removeTurtle(fred);
    }
    
}

