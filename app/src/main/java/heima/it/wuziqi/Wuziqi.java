package heima.it.wuziqi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 张琦 on 2016/4/27.
 */
public class Wuziqi extends View{
    private int mPanelWidth;
    private float mLineHeight;
    private int maxLine = 10;
    private Paint mPaint = new Paint();
    public Wuziqi(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        setBackgroundColor(0x44ff0000);
    }

    private void initView() {
        /*
        初始化画笔
         */
        mPaint.setColor(0x88000000);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = Math.min(widthSize,heightSize);

        if (widthMode == MeasureSpec.UNSPECIFIED){
            width = heightSize;
        }else if(heightMode == MeasureSpec.UNSPECIFIED){
            width = widthSize;
        }
        Log.d("TAG","onMeasure");
        setMeasuredDimension(width,width);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mPanelWidth = w;
        mLineHeight = mPanelWidth*1.0f / maxLine;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBoard(canvas);
    }

    private void drawBoard(Canvas canvas) {

        int w = mPanelWidth;
        float lineHeight = mLineHeight;

        for (int i = 0;i<maxLine;i++){
            int startX = (int) lineHeight / 2;
            int endX =  (int) (w - lineHeight/2);

            int y = (int) ((0.5 + i) * lineHeight);

            canvas.drawLine(startX,y,endX,y,mPaint);
            canvas.drawLine(y,startX,y,endX,mPaint);
        }
    }


}/
