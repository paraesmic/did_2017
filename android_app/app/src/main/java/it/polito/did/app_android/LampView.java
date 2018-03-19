package it.polito.did.app_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Luca on 16/03/2018.
 */

public class LampView extends View {
   private Paint paint1;
   private Path path1;
    public LampView(Context ctx, AttributeSet attrs, int theme){
        super(ctx,attrs,theme);
        paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setStrokeWidth(3.0f);
        paint1.setStyle(Paint.Style.STROKE);
        path1= new Path();
    }

    public LampView(Context ctx, AttributeSet attrs){
        this(ctx,attrs,0);
    }

    public float angle = 90;

    public void setAngle(float angle){
        if(angle>=0 && angle<=180)
        this.angle = angle;
        else invalidate();
    }
    public float getAngle(){
        return this.angle;
    }

    @Override
    protected void onDraw(Canvas canvas){
        float w = canvas.getWidth();
        float h = canvas.getHeight();
        float l = Math.min(w,h)*0.8f;
        double rad = Math.toRadians(angle);
        path1.rewind();
        path1.moveTo((float) (w/2-l/3+l/4*Math.cos(Math.PI-rad)), (float) (h/2+l/4*Math.sin(Math.PI-rad)));

    }
}
