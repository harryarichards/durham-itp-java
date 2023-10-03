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
    private Circle apple1;
    private Circle apple2;
    private Circle apple3;
    private Circle apple4;
    private Circle apple5;
    private Circle apple6;
    
    private Circle star1;
    private Circle star2;
    private Circle star3;
    private Circle star4;    
    private Circle star5;  
    private Circle star6;
    private Circle star7;
    private Circle star8;
    private Circle star9;    
    private Circle star10;
    private Circle star11;
    private Circle star12;
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
    public void day(int xSize, int ySize)
    {
        sky = new Square();
        sky.changeSize(2000, 1000);
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
        wall.changeSize(xSize, ySize);
        wall.makeVisible();
                       
        window = new Square();
        window.changeColor("black");
        window.changeSize(xSize/4, ySize/4);
        window.moveHorizontal(-50);
        window.moveVertical(120);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeColor("darkgrey");
        roof.changeSize(60, (xSize + (xSize)/5));
        roof.moveHorizontal(-10);   
        roof.moveVertical(85);
        roof.makeVisible();
        
        
        if (ySize < 100){
            wall.moveVertical(100 - ySize);
            roof.moveVertical(100 - ySize);
            window.moveVertical(100 - ySize);
        }
        
        if (xSize < 100){
            wall.moveHorizontal(100 - xSize);
            roof.moveHorizontal((100 - xSize)/2);
            window.moveHorizontal(100 - xSize);
        }
        
        if (ySize > 100){
            wall.moveVertical(-(ySize - 100));
            roof.moveVertical(-(ySize - 100));
            window.moveVertical(-(ySize - 100));
        }
        
        if (xSize > 100){
            roof.moveHorizontal((xSize - 100)/2);
            window.moveHorizontal(xSize - 100);
        }
        
        ground = new Square();
        ground.changeColor("grassgreen");
        ground.moveVertical(200);
        ground.moveHorizontal(-60);
        ground.changeSize(1500, 300);
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
        
        apple1 = new Circle();
        apple1.changeSize(10);
        apple1.moveVertical(75);
        apple1.moveHorizontal(220);
        apple1.changeColor("red");
        apple1.makeVisible();
        
        apple2 = new Circle();
        apple2.changeSize(11);
        apple2.moveVertical(95);
        apple2.moveHorizontal(240);
        apple2.changeColor("red");
        apple2.makeVisible();
        
        apple3 = new Circle();
        apple3.changeSize(10);
        apple3.moveVertical(110);
        apple3.moveHorizontal(260);
        apple3.changeColor("red");
        apple3.makeVisible();
        
        apple4 = new Circle();
        apple4.changeSize(10);
        apple4.moveVertical(130);
        apple4.moveHorizontal(230);
        apple4.changeColor("red");
        apple4.makeVisible();
        
        apple5 = new Circle();
        apple5.changeSize(10);
        apple5.moveVertical(60);
        apple5.moveHorizontal(270);
        apple5.changeColor("red");
        apple5.makeVisible();
        
        apple6 = new Circle();
        apple6.changeSize(10);
        apple6.moveVertical(150);
        apple6.moveHorizontal(270);
        apple6.changeColor("red");
        apple6.makeVisible();
    }
    
    public void regrowApple1() {
        apple1.makeInvisible();
        apple1.slowMoveVertical(-140);
        apple1.changeSize(0);
        apple1.makeVisible();
        for (int i = 0; i < 11; i++) {
            apple1.changeSize(i);
        }
    }
    
    public void regrowApple2() {
        apple2.makeInvisible();
        apple2.slowMoveVertical(-140);
        apple2.changeSize(0);
        apple2.makeVisible();
        for (int i = 0; i < 12; i++) {
            apple2.changeSize(i);
        }
    }
    
    public void regrowApple3() {
        apple3.makeInvisible();
        apple3.slowMoveVertical(-110);
        apple3.changeSize(0);
        apple3.makeVisible();
        for (int i = 0; i < 11; i++) {
            apple3.changeSize(i);
        }
        }
    
    
    public void regrowApple4() {
        apple4.makeInvisible();
        apple4.slowMoveVertical(-90);
        apple4.changeSize(0);
        apple4.makeVisible();
        for (int i = 0; i < 11; i++) {
            apple4.changeSize(i);
        }
    }
    
    public void regrowApple5() {
        apple5.makeInvisible();
        apple5.slowMoveVertical(-170);
        apple5.changeSize(0);
        apple5.makeVisible();
        for (int i = 0; i < 11; i++) {
            apple5.changeSize(i);
        }
    }
    
    public void regrowApple6() {
        apple6.makeInvisible();
        apple6.slowMoveVertical(-80);
        apple6.changeSize(0);
        apple6.makeVisible();
        for (int i = 0; i < 11; i++) {
            apple6.changeSize(i);
        }
    }
    
    public void dropapple1(){
        apple1.slowMoveVertical(140);
    }
    
    public void dropapple2(){
        apple2.slowMoveVertical(140);
    }
    
    public void dropapple3(){
        apple3.slowMoveVertical(110);
    }
    
    public void dropapple4(){
        apple4.slowMoveVertical(90);
    }
    
    public void dropapple5(){
        apple5.slowMoveVertical(170);
    }
    
    public void dropapple6(){
        apple6.slowMoveVertical(80);
    }
    
    public void sunset(){
        sky.makeVisible();
        sun.makeVisible();
        wall.makeVisible();
        window.makeVisible();
        roof.makeVisible();
        ground.makeVisible();
        trunk.makeVisible();
        leaves.makeVisible(); 
        apple1.makeVisible();
        apple2.makeVisible();
        apple3.makeVisible();
        apple4.makeVisible();
        apple5.makeVisible();
        apple6.makeVisible();
        
        for (int i = 1; i < 51; i++) {
            sun.slowMoveHorizontal(3);
            sun.slowMoveVertical(4);
            
            if (i == 10) {
                sky.changeColor("yellow");
                sun.changeColor("orangered");
                wall.makeVisible();
                window.makeVisible();
                roof.makeVisible();
                ground.makeVisible();
                trunk.makeVisible();
                leaves.makeVisible();
                apple1.makeVisible();
                apple2.makeVisible();       
                apple3.makeVisible();
                apple4.makeVisible();  
                apple5.makeVisible();
                apple6.makeVisible();
            }
            
            if (i == 30) {
                sky.changeColor("orangered");
                sun.changeColor("sunset");
                wall.makeVisible();
                window.makeVisible();
                roof.makeVisible();
                ground.makeVisible();
                trunk.makeVisible();
                leaves.makeVisible();
                apple1.makeVisible();
                apple2.makeVisible();       
                apple3.makeVisible();
                apple4.makeVisible();  
                apple5.makeVisible();
                apple6.makeVisible();
            }
            
            if (i == 30) {
                sun.changeColor("sunsetred");
                wall.makeVisible();
                window.makeVisible();
                roof.makeVisible();
                ground.makeVisible();
                trunk.makeVisible();
                leaves.makeVisible(); 
                apple1.makeVisible();
                apple2.makeVisible();       
                apple3.makeVisible();
                apple4.makeVisible();  
                apple5.makeVisible();
                apple6.makeVisible();
            }
        }
        
               
        for (int i = 1; i < 40; i++) {
                sun.slowMoveHorizontal(3);
                sun.slowMoveVertical(4);
        }
        
        dropapple1();
        dropapple2();
        dropapple3();
        dropapple4();
        dropapple5();
        dropapple6();
        
        night();
    }
    
    public void sunrise(int xSize,int ySize) {
        star1.makeInvisible();
        star2.makeInvisible();
        star3.makeInvisible();
        star4.makeInvisible();
        star5.makeInvisible();
        star6.makeInvisible();
        star7.makeInvisible();
        star8.makeInvisible();
        star9.makeInvisible();
        star10.makeInvisible();
        star11.makeInvisible();
        star12.makeInvisible();
        
        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(260);
        sun.moveVertical(210);
        sun.changeSize(150);
        sun.makeVisible();
        
        
        sky.changeColor("blue");
        wall.makeVisible();
        window.makeVisible();
        roof.makeVisible();
        ground.changeColor("darkgreen");
        trunk.makeVisible();
        leaves.changeColor("darkgreen");
        
        apple1.changeColor("dullred");
        apple2.changeColor("dullred");    
        apple3.changeColor("dullred");
        apple4.changeColor("dullred");
        apple5.changeColor("dullred");    
        apple6.changeColor("dullred");
        
        
        
        for (int i = 1; i < 80; i++) {
                                sun.slowMoveHorizontal(-4);
                sun.slowMoveVertical(-4);     
                if (i == 20) {
                    sky.changeColor("steelblue");        
                    wall.makeVisible();
                    window.makeVisible();
                    roof.makeVisible();
                    ground.changeColor("darkgreen");
                    trunk.makeVisible();
                    leaves.changeColor("darkgreen");
                    apple1.changeColor("dullred");
                    apple2.changeColor("dullred");    
                    apple3.changeColor("dullred");
                    apple4.changeColor("dullred");
                    apple5.changeColor("dullred");    
                    apple6.changeColor("dullred");
                    
                }
                if (i == 40) {
                    sky.changeColor("dodgerblue");        
                    wall.makeVisible();
                    window.makeVisible();
                    roof.makeVisible();
                    ground.changeColor("darkgreen");
                    trunk.makeVisible();
                    leaves.changeColor("grassgreen");
                    
                    regrowApple1();
                    apple1.changeColor("red");
                    regrowApple2();
                    apple2.changeColor("red");    
                    regrowApple3();
                    apple3.changeColor("red");
                    regrowApple4();
                    apple4.changeColor("red");
                    regrowApple5();
                    apple5.changeColor("red");
                    regrowApple6();
                    apple6.changeColor("red");
                     
                }
                if (i == 60) {
                    sky.changeColor("skyblue");        
                    wall.makeVisible();
                    window.makeVisible();
                    roof.makeVisible();
                    ground.changeColor("darkgreen");
                    trunk.makeVisible();
                    leaves.changeColor("grassgreen");
                    apple1.changeColor("red");
                    apple2.changeColor("red");    
                    apple3.changeColor("red");
                    apple4.changeColor("red");
                    apple5.changeColor("red");    
                    apple6.changeColor("red");                  
                }                             
                if (i == 79) {
                    day(xSize, ySize);
                }
                    
                
        }
    }
    
    public void night(){
        sky.changeColor("blue");
        moon = new Circle();
        moon.changeColor("white");
        moon.moveHorizontal(0);
        moon.moveVertical(-40);
        moon.changeSize(100);
        moon.makeVisible();
        
        wall.makeVisible();
        window.makeVisible();
        roof.makeVisible();
        
        ground.changeColor("darkgreen");
        ground.makeVisible();
 
        
        trunk.makeVisible();
        leaves.changeColor("darkgreen");
        leaves.makeVisible();
        
        apple1.changeColor("dullred");
        apple2.changeColor("dullred");    
        apple3.changeColor("dullred");
        apple4.changeColor("dullred");
        apple5.changeColor("dullred");    
        apple6.changeColor("dullred");
        
        for (int i = 1; i < 100; i++) {
           moon.slowMoveHorizontal(3);
           moon.slowMoveVertical(-1);
           if (i == 99) {
            sky.changeColor("black");
            wall.makeVisible();
            window.makeVisible();
            roof.makeVisible();
            ground.makeVisible();
            trunk.makeVisible();
            leaves.makeVisible();
            
            apple1.makeVisible();
            apple2.makeVisible();   
            apple3.makeVisible();
            apple4.makeVisible();
            apple5.makeVisible();    
            apple6.makeVisible();
            
            star1 = new Circle();
            star1.changeColor("white");
            star1.changeSize(2);
            star1.moveHorizontal(180);
            star1.moveVertical(0);
            star1.makeVisible();
            
            star2 = new Circle();
            star2.changeColor("white");
            star2.changeSize(3);
            star2.moveHorizontal(230);
            star2.moveVertical(-20);
            star2.makeVisible();
            
            star3 = new Circle();
            star3.changeColor("white");
            star3.changeSize(3);
            star3.moveHorizontal(120);
            star3.moveVertical(-30);
            star3.makeVisible();
            
            star4 = new Circle();
            star4.changeColor("white");
            star4.changeSize(4);
            star4.moveHorizontal(80);
            star4.moveVertical(0);
            star4.makeVisible();
            
            star5 = new Circle();
            star5.changeColor("white");
            star5.changeSize(3);
            star5.moveHorizontal(0);
            star5.moveVertical(-50);
            star5.makeVisible();
            
            star6 = new Circle();
            star6.changeColor("white");
            star6.changeSize(2);
            star6.moveHorizontal(-5);
            star6.moveVertical(10);
            star6.makeVisible();
            
            star7 = new Circle();
            star7.changeColor("white");
            star7.changeSize(3);
            star7.moveHorizontal(250);
            star7.moveVertical(20);
            star7.makeVisible();
            
            star8 = new Circle();
            star8.changeColor("white");
            star8.changeSize(3);
            star8.moveHorizontal(260);
            star8.moveVertical(-50);
            star8.makeVisible();
            
            star9 = new Circle();
            star9.changeColor("white");
            star9.changeSize(4);
            star9.moveHorizontal(180);
            star9.moveVertical(-40);
            star9.makeVisible();
            
            star10 = new Circle();
            star10.changeColor("white");
            star10.changeSize(3);
            star10.moveHorizontal(40);
            star10.moveVertical(20);
            star10.makeVisible();
            
            star11 = new Circle();
            star11.changeColor("white");
            star11.changeSize(3);
            star11.moveHorizontal(50);
            star11.moveVertical(-35);
            star11.makeVisible();
            
            star12 = new Circle();
            star12.changeColor("white");
            star12.changeSize(3);
            star12.moveHorizontal(150);
            star12.moveVertical(40);
            star12.makeVisible();
            }
        }
        
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
