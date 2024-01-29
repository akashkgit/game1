package edu.binghamton.cs.csterdroids;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class boulder {
    float x, y, dx, dy, diameter;
    float width, height;


    int color;
    boolean alive = false;
    float health;

    public void update() {
        x += dx;
        y += dy;
        boolean hit =false;
        if (x < 0 || x > width) {
            dx = -dx;
            hit = true;
        }
        if (y < 0 || y > height) {
            dy = -dy; hit = true;
        }

        if (hit){

            if(0 < Color.green(color)){
                  color=Color.argb(Color.alpha(color), Color.red(color),Color.green(color)-50,Color.blue(color));
            }
            else {
                int initRed=Color.red(color) ;
                System.out.println("Rd "+initRed);
                if ( 250 <= initRed ) {

                alive= false;
                return;
                }
                if(0 == initRed) initRed = 50;
            color=Color.argb(Color.alpha(color) -50, Color.red(color)+50,Color.green(color),Color.blue(color));
            }

        }
    }

    public void draw(Canvas canvas, Paint paint) {
        Paint p = new Paint();
        p.setColor(color);
//        System.out.println(" drawing in color "+ color);
        canvas.drawCircle(x, y, diameter, p);
    }

}
