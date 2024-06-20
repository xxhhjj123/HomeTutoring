package com.example.hometutoring;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class MarqueeView extends View {
    private String text;
    private Paint paint;
    private float textWidth;
    private float textX;
    private float viewWidth;
    private ValueAnimator animator;

    public MarqueeView(Context context) {
        super(context);
        init();
    }

    public MarqueeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MarqueeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        text = "This is a marquee";
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        textWidth = paint.measureText(text);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        textX = viewWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text, textX, getHeight() / 2, paint);
    }

    public void startMarquee() {
        animator= ValueAnimator.ofFloat(viewWidth, -textWidth);
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(animation -> {
            textX = (float) animation.getAnimatedValue();
            invalidate();
        });
        animator.start();
    }

    public void stopMarquee() {
// 停止动画
        if (animator!=null) animator.cancel();
    }
}
