package com.example.grayapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class GrayImageView extends AppCompatImageView {

    private Paint mPaint = new Paint();

    public GrayImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.saveLayer(null,mPaint,Canvas.ALL_SAVE_FLAG);
        super.draw(canvas);
        canvas.restore();
    }
}
