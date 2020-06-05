package com.example.trenlop_nam_3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class MyView extends View {
    Paint mPaint = new Paint();
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
            mPaint.setAntiAlias(true);

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.rgb(0,0,0));
            mPaint.setStrokeWidth(5);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      
        canvas.drawLine(100,100,405,100,mPaint);
//        canvas.drawLine(105,105,105,405,mPaint);
//        canvas.drawLine(405,405,100,405,mPaint);
//        canvas.drawLine(400,100,400,400,mPaint);

            //hình (chữ nhật,vuông) left,top,right,bottom
            //canvas.drawRect(100,100,400,600,mPaint);


            //hình tròn
//        canvas.drawCircle(400,400,100,mPaint);


            //hình elip
//        canvas.drawOval(200,200,530,450,mPaint);

            //tam giác
            Point point1 = new Point(350,350);
            Point point2 = new Point(200,500);
            Point point3 = new Point(700,500);

            Path path = new Path();
            path.moveTo(point1.x,point1.y);
            path.lineTo(point2.x,point2.y);
            path.lineTo(point3.x,point3.y);
            path.lineTo(point1.x,point1.y);

            path.close();

            canvas.drawPath(path,mPaint);
    }
        //Draw component in here

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public MyView(Context context,AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
//---------------------------------------------


//    public class ExampView extends View {
//        Paint mPaint, otherPaint, outerPaint, mTextPaint;
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//
//            //vẽ 1 đoạn theo tọa độ x start,y start,x end, y end
////        canvas.drawLine(100,100,405,100,mPaint);
////        canvas.drawLine(105,105,105,405,mPaint);
////        canvas.drawLine(405,405,100,405,mPaint);
////        canvas.drawLine(400,100,400,400,mPaint);
//
//            //hình (chữ nhật,vuông) left,top,right,bottom
//            //canvas.drawRect(100,100,400,600,mPaint);
//
//
//            //hình tròn
////        canvas.drawCircle(400,400,100,mPaint);
//
//
//            //hình elip
////        canvas.drawOval(200,200,530,450,mPaint);
//
//            //tam giác
//            Point point1 = new Point(350,350);
//            Point point2 = new Point(200,500);
//            Point point3 = new Point(700,500);
//
//            Path path = new Path();
//            path.moveTo(point1.x,point1.y);
//            path.lineTo(point2.x,point2.y);
//            path.lineTo(point3.x,point3.y);
//            path.lineTo(point1.x,point1.y);
//
//            path.close();
//
//            canvas.drawPath(path,mPaint);
//
//
//        }
//
//        public ExampView(Context context) {
//            super(context);
//            mPaint = new Paint();
//            mPaint.setAntiAlias(true);
//
//            mPaint.setStyle(Paint.Style.STROKE);
//            mPaint.setColor(Color.rgb(0,0,0));
//            mPaint.setStrokeWidth(5);
//        }
//
//        public ExampView(Context context, AttributeSet attrs) {
//            super(context, attrs);
//        }
//
//        public ExampView(Context context, AttributeSet attrs, int defStyleAttr) {
//            super(context, attrs, defStyleAttr);
//        }
//
//        public ExampView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//            super(context, attrs, defStyleAttr, defStyleRes);
//        }
//    }
//------------------------------------------
//    Paint mPaint, otherPaint, outerPaint, mTextPaint;
//    RectF mRectF;
//    int mPadding;
//
//    float arcLeft, arcTop, arcRight, arcBottom;
//
//    Path mPath;


//    public MyView(Context context) {
//        super(context);

//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
//
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStrokeWidth(5);
//
//
//        mTextPaint = new Paint(Paint.LINEAR_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
//        mTextPaint.setColor(Color.BLACK);
//        mTextPaint.setTextSize(pxFromDp(context, 24));
//
//        otherPaint = new Paint();
//
//        outerPaint = new Paint();
//        outerPaint.setStyle(Paint.Style.FILL);
//        outerPaint.setColor(Color.YELLOW);
//
//        mPadding = 100;
//
//
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//
//        ((Activity) getContext()).getWindowManager()
//                .getDefaultDisplay()
//                .getMetrics(displayMetrics);
//
//
//        int screenWidth = displayMetrics.widthPixels;
//        int screenHeight = displayMetrics.heightPixels;
//
//        arcLeft = pxFromDp(context, 20);
//        arcTop = pxFromDp(context, 20);
//        arcRight = pxFromDp(context, 100);
//        arcBottom = pxFromDp(context, 100);
//
//
//        Point p1 = new Point((int) pxFromDp(context, 80) + (screenWidth / 2), (int) pxFromDp(context, 40));
//        Point p2 = new Point((int) pxFromDp(context, 40) + (screenWidth / 2), (int) pxFromDp(context, 80));
//        Point p3 = new Point((int) pxFromDp(context, 120) + (screenWidth / 2), (int) pxFromDp(context, 80));
//
//        mPath = new Path();
//        mPath.moveTo(p1.x, p1.y);
//        mPath.lineTo(p2.x, p2.y);
//        mPath.lineTo(p3.x, p3.y);
//        mPath.close();
//
//        mRectF = new RectF(screenWidth / 4, screenHeight / 3, screenWidth / 6, screenHeight / 2);
//
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        canvas.drawRoundRect(mRectF, 10, 10, otherPaint);
//        canvas.clipRect(mRectF, Region.Op.DIFFERENCE);
//        canvas.drawPaint(outerPaint);
//
//        canvas.drawLine(250, 250, 400, 400, mPaint);
//        canvas.drawRect(mPadding, mPadding, getWidth() - mPadding, getHeight() - mPadding, mPaint);
//        canvas.drawArc(arcLeft, arcTop, arcRight, arcBottom, 75, 45, true, mPaint);
//
//
//        otherPaint.setColor(Color.GREEN);
//        otherPaint.setStyle(Paint.Style.FILL);
//
//        canvas.drawRect(
//                getLeft() + (getRight() - getLeft()) / 3,
//                getTop() + (getBottom() - getTop()) / 3,
//                getRight() - (getRight() - getLeft()) / 3,
//                getBottom() - (getBottom() - getTop()) / 3, otherPaint);
//
//
//        canvas.drawPath(mPath, mPaint);
//        otherPaint.setColor(Color.BLACK);
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, arcLeft, otherPaint);
//
//        canvas.drawText("Canvas basics", (float) (getWidth() * 0.3), (float) (getHeight() * 0.8), mTextPaint);
//
//    }
//
//
//    public static float pxFromDp(final Context context, final float dp) {
//        return dp * context.getResources().getDisplayMetrics().density;
//   }

}