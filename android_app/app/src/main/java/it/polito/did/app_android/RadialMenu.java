/*
package it.polito.did.app_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class RadialMenu extends View {

    private float mShadowRadius;
    private float angle = 90;
    private Paint mRadial;
    private Path path1;
    private int mShadowColor;
    private Paint mRadialMenuPaint;
    private boolean isMenuVisible;
    private float mStartAngle;
    private RectF mMenuRect;
    private List<Object> mMenuItems;

    public RadialMenu(Context ctx) {
        this(ctx, null, 0);
    }

    public RadialMenu(Context ctx, AttributeSet attrs) {
        this(ctx, attrs, 0);
    }

    public RadialMenu(Context ctx, AttributeSet attrs, int theme) {
        super(ctx, attrs, theme);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRadialMenuPaint.setShadowLayer(mShadowRadius, 0.0f, 0.0f, mShadowColor);
        //Draw the menu if the menu is to be displayed.
        if(isMenuVisible) {
            canvas.drawArc(mMenuRect, mStartAngle, 180, true, mRadialMenuPaint);
            //See if there is any item in the collection
            if(mMenuItems.size() > 0) {
                float mStart = mStartAngle;
                //Get the sweep angles based on the number of menu items
                float mSweep = 180/mMenuItems.size();
                for(SemiCircularRadialMenuItem item : mMenuItems.values()) {
                    mRadialMenuPaint.setColor(item.getBackgroundColor());
                    item.setMenuPath(mMenuCenterButtonRect, mMenuRect, mStart, mSweep, mRadius, mViewAnchorPoints);
                    canvas.drawPath(item.getMenuPath(), mRadialMenuPaint);
                    if(isShowMenuText) {
                        mRadialMenuPaint.setShadowLayer(mShadowRadius, 0.0f, 0.0f, Color.TRANSPARENT);
                        mRadialMenuPaint.setColor(item.getTextColor());
                        canvas.drawTextOnPath(item.getText(), item.getMenuPath(), 5, textSize, mRadialMenuPaint);
                        mRadialMenuPaint.setShadowLayer(mShadowRadius, 0.0f, 0.0f, mShadowColor);
                    }
                    item.getIcon().draw(canvas);
                    mStart += mSweep;
                }
                mRadialMenuPaint.setStyle(Paint.Style.FILL);
            }
        }
        //Draw the center menu toggle piece
        mRadialMenuPaint.setColor(centerRadialColor);
        canvas.drawArc(mMenuCenterButtonRect, mStartAngle, 180, true, mRadialMenuPaint);
        mRadialMenuPaint.setShadowLayer(mShadowRadius, 0.0f, 0.0f, Color.TRANSPARENT);
        //Draw the center text
        drawCenterText(canvas, mRadialMenuPaint);

    }


}
*/
