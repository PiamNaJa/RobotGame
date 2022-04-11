package main;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.awt.Color;
public class Bullet implements Serializable
{
    Client c;
    int dx, dy, x, y, width, height, speed, xx, yy;
    String direction;
    public Bullet(Client c, int x, int y, String direction)
    {
        this.c = c;
        this.x = x;
        this.y = y;
        this.height = this.width = this.speed = c.tileSize;
        this.direction = direction;
        dx = dy = 0;
    }
    public void tick()
    {
        if(this.direction.equals("up"))
        {
            dx = 0;
            dy = -speed;
        }
        if(this.direction.equals("down"))
        {
            dx = 0;
            dy = speed;
        }
        if(this.direction.equals("left"))
        {
            dy = 0;
            dx = -speed;
        }
        if(this.direction.equals("right"))
        {
            dy = 0;
            dx = speed;
        }
        this.x += dx;
        this.y += dy;
    }
    public void draw(Graphics2D g)
	{
        xx = this.x -  c.x[c.pid] + c.Xscreen;
        yy = this.y - c.y[c.pid] + c.Yscreen;
        g.setColor(Color.MAGENTA);
		g.fillRect(xx+13, yy+13, this.width/4, this.height/4);
	}
}