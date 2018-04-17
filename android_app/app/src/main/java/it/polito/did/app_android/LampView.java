package it.polito.did.app_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


public class LampView extends View {

    private Paint paint;
    private float angle=90;
    private Paint paint1;
    private Path path1;


    public LampView(Context ctx) {
        this(ctx, null, 0);
    }

    public LampView(Context ctx, AttributeSet attrs) {
        this(ctx, attrs, 0);
    }

    public LampView(Context ctx, AttributeSet attrs, int theme) {
        super(ctx, attrs, theme);

    }

    public void setAngle(float angle) {
        if (angle>=0 && angle<=180 && angle!=this.angle) {
            this.angle = angle;
            invalidate();
        }
    }

    public float getAngle() {
        return this.angle;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint1.setColor(0xffff0000);
        paint1.setStrokeWidth(3.0f);
        paint1.setStyle(Paint.Style.STROKE);
        path1 = new Path();
        float w = canvas.getWidth();
        float h = canvas.getHeight();
        float l = Math.min(w,h)*0.8f;
        double rad = Math.toRadians(angle);
        path1.rewind();
        path1.moveTo((float) (w/2-l/3+l/4*Math.cos(Math.PI-rad)), (float) (h/2+l/4*Math.sin(Math.PI-rad)));
        path1.lineTo(w/2-l/3,h/2);
        path1.lineTo(w/2-l/3,h/2-l/4);
        path1.lineTo(w/2+l/3,h/2-l/4);
        path1.lineTo(w/2+l/3,h/2);
        canvas.drawPath(path1,paint1);
    }
}
