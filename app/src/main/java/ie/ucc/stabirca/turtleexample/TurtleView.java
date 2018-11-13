package ie.ucc.stabirca.turtleexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TurtleView extends View {
    private Context c;
    private int order,type;
    private float length;

    public TurtleView(Context c, int order, int type, float length) {
        super(c);
        this.c = c;
        this.order = order;
        this.type = type;
        this.length = length;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //setup drawing
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(3);
        Turtle t = new Turtle(canvas,p);
        t.moveTo(getWidth()/2,getHeight()/2,-Math.PI/2);
        //draw based on type
        switch(this.type){
            case 0: //binary tree
                tree(order,length,t);
                break;
            case 1:
                tree4(order,length,t);
                break;
            case 2:
                flake(order,length,t);
                break;
            case 3:
                gasket(order,length,t);
                break;

        }
    }

    protected void tree(int order, float length, Turtle t){
        if(order == 0 || length < 2){
            return;
        }
        t.forward(length);
        t.left(Math.PI/4);
        tree(order-1,length/2,t);
        t.right(Math.PI/2);
        tree(order-1,length/2,t);
        t.left(Math.PI/4);
        t.backward(length);
    }

    protected void tree4(int order, float length, Turtle t){
        if(order == 0 || length < 2){
            return;
        }
        t.forward(length);
        t.left(Math.PI/2);

        tree4(order-1,length/2,t);
        t.right(Math.PI/3);
        tree4(order-1,length/2,t);
        t.right(Math.PI/3);
        tree4(order-1,length/2,t);
        t.right(Math.PI/3);
        tree4(order-1,length/2,t);

        t.left(Math.PI/2);
        t.backward(length);
    }

    protected void koch(int order, float length,Turtle t){
        if(order == 0 || length <2){
            t.forward(length);
            return;
        }
        koch(order-1,length/3,t);
        t.left(Math.PI/3);
        koch(order-1,length/3,t);
        t.right(2*Math.PI/3);
        koch(order-1,length/3,t);
        t.left(Math.PI/3);
        koch(order-1,length/3,t);
    }

    private void flake(int order,float length, Turtle t){
        for(int i=0; i<3; i++){
            koch(order,length,t);
            t.left(2*Math.PI/3);
        }
    }

    protected void gasket(int order, float length, Turtle t){
        if(order == 0 || length <2){
            for(int i=0; i<3; i++){
                t.forward(length);
                t.left(2*Math.PI/3);
            }
            return;
        }
        for(int i=0; i<3; i++){
            gasket(order-1,length/2,t);
            t.forward(length);
            t.left(2*Math.PI/3);
        }
    }
}
