package ir.net;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jefferson on 7/28/2017.
 */

public class Programchi extends View {

    private int circleCol, labelCol;
    private String circleText;
    private Paint circlePaint;

    public Programchi(Context context, AttributeSet attrs){
        super(context, attrs);

        circlePaint = new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.Programchi, 0, 0);

        try {
            circleText = a.getString(R.styleable.Programchi_circleLabel);
            circleCol = a.getInteger(R.styleable.Programchi_circleColor, 0);
            labelCol = a.getInteger(R.styleable.Programchi_labelColor, 0);
        } finally {
            a.recycle();
        }
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);



    }
    @Override
    protected void onDraw(Canvas canvas) {
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);
    }
    public int getCircleColor(){
        return circleCol;
    }

    public int getLabelColor(){
        return labelCol;
    }

    public String getLabelText(){
        return circleText;
    }
    public void setCircleColor(int newColor){
        circleCol=newColor;
        invalidate();
        requestLayout();
    }
    public void setLabelColor(int newColor){
        labelCol=newColor;
        invalidate();
        requestLayout();
    }
    public void setLabelText(String newLabel){
        circleText=newLabel;
        invalidate();
        requestLayout();
    }
}
