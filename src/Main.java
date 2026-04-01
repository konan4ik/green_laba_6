import Classes.Banana;
import Classes.HpCounter;
import Classes.Spider;
import Components.AiComponent;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Main extends World
{
    public Main()
    {
        super(600, 400, 1);

        var hpCounter = new HpCounter();
        addObject(hpCounter, 30, 20);
        var banana = new Banana(hpCounter);
        addObject(banana, 500,100);

        for (int i = 0; i < 2; i++)
        {
            int x = 50 + Greenfoot.getRandomNumber(500);
            int y = 50 + Greenfoot.getRandomNumber(300);
            var spider = new Spider();
            addObject(spider, x,y);
            spider.getComponent(AiComponent.class).SetTarget(banana);
        }
    }
}