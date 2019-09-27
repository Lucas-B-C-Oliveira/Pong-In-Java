import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 1.3;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();
	}
	
	public void update() {
		collisionWithScreen();
		checkScore();
		collision();
		move();
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	private void move() {
		x += dx * speed;
		y += dy * speed;
	}
	
	private void collisionWithScreen() {
		if(x + (dx * speed) + width >= Game.WIDTH) {
			dx *= -1;
		}
		else if(x + (dx * speed) < 0) {
			dx *= -1;
		}
		
	}
	
	private void collision() {
		Rectangle bounds = new Rectangle( (int)(x + (dx * speed)), (int)(y + (dy * speed)), width, height );
		Rectangle boundsPlayer = new Rectangle( Game.player.x, Game.player.y, Game.player.width, Game.player.height );
		Rectangle boundsEnemy = new Rectangle( (int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height );
		
		if(bounds.intersects(boundsPlayer)) {
			dy *= -1;
		}
		else if (bounds.intersects(boundsEnemy)) {
			dy *= -1;
		}
	}

	
	private void checkScore() {
		if(y >= Game.WIDTH) {
			//Ponto do Inimigo
		}
		else if(y < 0) {
			//Ponto do Jogador
		}
	}
	
	

}
