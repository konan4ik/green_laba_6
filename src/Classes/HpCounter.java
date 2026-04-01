package Classes;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class HpCounter extends Actor
{
    public HpCounter()
    {
        setImage(new GreenfootImage("hp: ", 24, Color.BLACK, new Color(255,255,255)));
    }

    public void Update(int hp)
    {
        setImage(new GreenfootImage("hp: " + hp, 24, Color.BLACK, new Color(255,255,255)));
    }
}
