package Classes;

import Components.HealthComponent;
import Components.TargetComponent;
import greenfoot.Greenfoot;
import greenfoot.World;
import util.Event;
import util.Vector2;

public class GameHandler {

    private final Entity player;
    private final World world;
    private int currentFrame;

    private int killCount;
    public Event<Integer> onKill = new Event<>();

    public GameHandler(Entity player, World world) {
        this.player = player;
        this.world = world;
    }

    public Vector2 getPositionAtEdge(){
        var num = Greenfoot.getRandomNumber(3);
        int x = 0;
        int y = 0;
        switch (num) {
            case 0:
                x = 30;
                y = 30 + Greenfoot.getRandomNumber(world.getHeight()-30);
                break;
            case 1:
                x = world.getWidth()-30;
                y = 30 + Greenfoot.getRandomNumber(world.getHeight()-30);
                break;
            case 2:
                x = 30 + Greenfoot.getRandomNumber(world.getWidth()-30);
                y = world.getHeight()-30;
        }
        return new Vector2(x, y);
    }

    public void update() {
        currentFrame++;
        if (currentFrame % 80 == 0) {
            var spider = new Spider();
            var pos = getPositionAtEdge();
            world.addObject(spider, (int)pos.getX(), (int)pos.getY());
            spider.getComponent(HealthComponent.class).onDeath.addListener(emptyArg -> {
                killCount++;
                onKill.invoke(killCount);
            });
            spider.getComponent(TargetComponent.class).setTarget(player);
        }
    }

    public void start() {
        var playerHealthComponent = player.getComponent(HealthComponent.class);
        playerHealthComponent.onDeath.addListener(emptyArg -> Greenfoot.stop());
    }
}
