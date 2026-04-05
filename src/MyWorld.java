import Classes.*;
import greenfoot.World;

public class MyWorld extends World
{
    private final GameHandler gameHandler;
    private final Ui ui;

    public MyWorld()
    {
        super(750, 450, 1);

        var banana = new Banana();

        addObject(banana, 500,100);

        gameHandler = new GameHandler(banana, this);
        gameHandler.start();
        ui = new Ui(banana, gameHandler);
        ui.start();
    }

    public void act() {
        gameHandler.update();
    }
}