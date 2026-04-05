package Classes;

import Components.HealthComponent;
import Components.PlayerFiringComponent;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class Ui {
    private final Entity player;
    private final GameHandler gameHandler;
    public final Counter killCounter = new Counter();
    public final Counter hpCounter = new Counter();
    public final Counter reloadCounter = new Counter();

    public Ui(Entity player, GameHandler gameHandler) {
        this.player = player;
        this.gameHandler = gameHandler;
    }

    public void start() {
        var playerHealthComponent = player.getComponent(HealthComponent.class);
        playerHealthComponent.onHpChange.addListener(this::updateHp);
        var hp = playerHealthComponent.getHealth();

        var playerFiringComponent = player.getComponent(PlayerFiringComponent.class);
        playerFiringComponent.onReload.addListener(this::updateReload);

        gameHandler.onKill.addListener(this::updateKills);

        killCounter.setImage(new GreenfootImage("kills: " + "0", 24, Color.BLACK, new Color(255,255,255)));
        var killCounterWidth = killCounter.getImage().getWidth();
        hpCounter.setImage(new GreenfootImage("hp: " + hp, 24, Color.BLACK, new Color(255,255,255)));
        var hpCounterWidth = hpCounter.getImage().getWidth();
        reloadCounter.setImage(new GreenfootImage("beforeNextShot: " + "0", 24, Color.BLACK, new Color(255,255,255)));
        var reloadCounterWidth = reloadCounter.getImage().getWidth();

        var indent = 60;
        var freeSpace = player.getWorld().getWidth() - indent*2;
        var countersWidth = hpCounterWidth + reloadCounterWidth + killCounterWidth;
        var distance = (freeSpace - countersWidth)/2;

        var x1 = indent + hpCounterWidth/2;
        var x2 = x1 + hpCounterWidth/2 + distance + reloadCounterWidth/2;
        var x3 = x2 + reloadCounterWidth/2 + distance + killCounterWidth/2;
        player.getWorld().addObject(hpCounter, x1, 30);
        player.getWorld().addObject(reloadCounter, x2, 30);
        player.getWorld().addObject(killCounter, x3, 30);
    }

    public void updateKills(int kills) {
        killCounter.setImage(new GreenfootImage("kills: " + kills, 24, Color.BLACK, new Color(255,255,255)));
    }

    public void updateHp(int hp) {
        hpCounter.setImage(new GreenfootImage("hp: " + hp, 24, Color.BLACK, new Color(255,255,255)));
    }

    public void updateReload(int beforeNextShot) {
        reloadCounter.setImage(new GreenfootImage("beforeNextShot: " + beforeNextShot, 24, Color.BLACK, new Color(255,255,255)));
    }


}

