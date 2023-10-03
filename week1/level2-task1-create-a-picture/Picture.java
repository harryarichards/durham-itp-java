/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Square ground;
    private Square trunk;
    private Circle leaves;
    private Square sky;
    private Circle moon;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void day()
    {
        sky = new Square();
        sky.changeSize(1000, 1000);
        sky.changeColor("skyblue");
        sky.moveHorizontal(-250);
        sky.moveVertical(-250);
        sky.makeVisible();
        
        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(-50);
        sun.moveVertical(-100);
        sun.changeSize(150);
        sun.makeVisible();
        
        wall = new Square();
        wall.changeColor("grey");
        wall.moveHorizontal(-70);
        wall.moveVertical(100);
        wall.changeSize(100, 100);
        wall.makeVisible();
        
        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(-50);;
        window.moveVertical(120);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeColor("darkgrey");
        roof.changeSize(50, 140);
        roof.moveHorizontal(-10);
        roof.moveVertical(90);
        roof.makeVisible();
        
        ground = new Square();
        ground.changeColor("grassgreen");
        ground.moveVertical(200);
        ground.moveHorizontal(-60);
        ground.changeSize(300, 300);
        ground.makeVisible();
 
        trunk = new Square();
        trunk.changeSize(50, 150);
        trunk.moveVertical(100);
        trunk.moveHorizontal(200);
        trunk.changeColor("brown");
        trunk.makeVisible();
        
        leaves = new Circle();
        leaves.changeSize(120);
        leaves.moveVertical(50);
        leaves.moveHorizontal(200);
        leaves.changeColor("darkgreen");
        leaves.makeVisible();
    }
    
    public void sunset(){
        sky = new Square();
        sky.changeSize(1000, 1000);
        sky.changeColor("sunset");
        sky.moveHorizontal(-250);
        sky.moveVertical(-250);
        sky.makeVisible();
        
        sun = new Circle();
        sun.changeColor("red");
        sun.moveHorizontal(50);
        sun.moveVertical(100);
        sun.changeSize(200);
        sun.makeVisible();
        
        wall = new Square();
        wall.changeColor("grey");
        wall.moveHorizontal(-70);
        wall.moveVertical(100);
        wall.changeSize(100, 100);
        wall.makeVisible();
        
        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(-50);
        window.moveVertical(120);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeColor("darkgrey");
        roof.changeSize(50, 140);
        roof.moveHorizontal(-10);
        roof.moveVertical(90);
        roof.makeVisible();
        
        ground = new Square();
        ground.changeColor("grassgreen");
        ground.moveVertical(200);
        ground.moveHorizontal(-60);
        ground.changeSize(300, 300);
        ground.makeVisible();
 
        trunk = new Square();
        trunk.changeSize(50, 150);
        trunk.moveVertical(100);
        trunk.moveHorizontal(200);
        trunk.changeColor("brown");
        trunk.makeVisible();
        
        leaves = new Circle();
        leaves.changeSize(120);
        leaves.moveVertical(50);
        leaves.moveHorizontal(200);
        leaves.changeColor("darkgreen");
        leaves.makeVisible();
    }
    
    public void night(){
        sky = new Square();
        sky.changeSize(1000, 1000);
        sky.changeColor("blue");
        sky.moveHorizontal(-250);
        sky.moveVertical(-250);
        sky.makeVisible();
        
        moon = new Circle();
        moon.changeColor("white");
        moon.moveHorizontal(0);
        moon.moveVertical(-40);
        moon.changeSize(100);
        moon.makeVisible();
        
        wall = new Square();
        wall.changeColor("grey");
        wall.moveHorizontal(-70);
        wall.moveVertical(100);
        wall.changeSize(100, 100);
        wall.makeVisible();
        
        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(-50);
        window.moveVertical(120);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeColor("darkgrey");
        roof.changeSize(50, 140);
        roof.moveHorizontal(-10);
        roof.moveVertical(90);
        roof.makeVisible();
        
        ground = new Square();
        ground.changeColor("darkgreen");
        ground.moveVertical(200);
        ground.moveHorizontal(-60);
        ground.changeSize(300, 300);
        ground.makeVisible();
 
        trunk = new Square();
        trunk.changeSize(50, 150);
        trunk.moveVertical(100);
        trunk.moveHorizontal(200);
        trunk.changeColor("brown");
        trunk.makeVisible();
        
        leaves = new Circle();
        leaves.changeSize(120);
        leaves.moveVertical(50);
        leaves.moveHorizontal(200);
        leaves.changeColor("darkgreen");
        leaves.makeVisible();
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        if(wall != null)   // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        if(wall != null)   // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
        
    }
}
