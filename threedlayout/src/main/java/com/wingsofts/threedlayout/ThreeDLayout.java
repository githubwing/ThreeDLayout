package com.wingsofts.threedlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * A 3D Layout
 * When you use it warp other view,it can became a 3D view
 * Enable the touch mode or start Animate
 *
 *
 *
 *
 *
 *
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　 　　　　ｗｗｗ
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　 　　　　ｗｗｗ　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　ｗ
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　ｗｗｗｗ
 * 　　　　　ｗｗ　　　ｗｗ　　　ｗｗｗ　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　　ｗ　　ｗｗｗ　　　　　　　　　　　　　　　　　　ｗｗｗｗｗｗｗ
 * 　　　　　ｗｗ　　　ｗｗ　　　ｗｗｗ　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗｗｗｗｗｗｗ　　　　　　　　　　　　　　ｗｗｗｗｗｗｗ
 * 　　　　　ｗｗ　　　ｗｗｗ　　ｗｗ　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗｗｗ　ｗｗｗ　　　　　　　　　　　　　ｗｗｗｗｗｗｗｗ
 * 　　　　　ｗｗｗ　ｗｗｗｗ　ｗｗｗ　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　ｗｗ　　　　ｗｗｗ
 * 　　　　　　ｗｗ　ｗｗｗｗ　ｗｗｗ　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　ｗｗｗｗ　ｗｗｗ
 * 　　　　　　ｗｗ　ｗｗｗｗ　ｗｗ　　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　　ｗｗｗｗｗｗｗ
 * 　　　　　　ｗｗｗｗｗｗｗｗｗｗ　　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　ｗｗｗｗｗｗ
 * 　　　　　　ｗｗｗｗ　　ｗｗｗｗ　　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　ｗｗｗｗｗｗ
 * 　　　　　　　ｗｗｗ　　ｗｗｗ　　　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　　ｗｗｗｗｗｗｗｗ
 * 　　　　　　　ｗｗｗ　　ｗｗｗ　　　　　　　　　　　　　　　　　ｗｗ　　　　　　　　　　　　　　　　ｗｗｗ　　　　ｗｗ　　　　　　　　　　　　　ｗｗｗ　ｗｗｗｗｗｗ
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　ｗ　　　　　　ｗ　　　　　　　　　　　　　ｗｗ　　　　　ｗｗｗ
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　ｗｗｗｗｗｗｗｗｗｗ
 * 　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　ｗｗｗｗｗｗｗｗｗ
 *
 * Created by wing on 10/14/16.
 */

public class ThreeDLayout extends ViewGroup {
  private Camera mCamera;
  private Matrix mMatrix;

  //this viewgroup's center
  private int mCenterX;
  private int mCenterY;

  //rotateDegree
  private float mCanvasRotateY;
  private float mCanvasRotateX;

  private float mCanvasMaxRotateDegree = 50;

  //the touch mode
  public static int MODE_X = 0;
  public static int MODE_Y = 1;
  public static int MODE_BOTH_X_Y = 2;
  private int mMode = MODE_BOTH_X_Y;


  private float mDensity;
  private float[] mValues = new float[9];

  //the flag of touch
  private boolean isCanTouch = false;

  //the degree of animation
  private float mDegreeY = 0;
  private float mDegreeX = 0;

  //the flag of animate
  private boolean isPlaying = false;

  //the degree of longer animate
  private int mLoopAnimateY = 0;

  public ThreeDLayout(Context context) {
    this(context, null);
  }

  public ThreeDLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ThreeDLayout(Context context, AttributeSet attrs, int defStyleAttr) {

    super(context, attrs, defStyleAttr);

    //set a default background to make sure onDraw() dispatch
    if (getBackground() == null) {
      setBackgroundColor(Color.parseColor("#ffffff"));
    }

    DisplayMetrics dm = new DisplayMetrics();
    dm = getResources().getDisplayMetrics();

    mDensity = dm.density;
    mCamera = new Camera();
    mMatrix = new Matrix();
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    if (getChildCount() != 1) {
      throw new IllegalStateException("ThreeDLayout can only have one child");
    }
    View child = getChildAt(0);
    measureChild(child, widthMeasureSpec, heightMeasureSpec);

    //only one child view,so give the same size
    setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
  }

  @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {

    View child = getChildAt(0);
    child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mCenterX = w / 2;
    mCenterY = h / 2;
  }

  @Override protected void onDraw(Canvas canvas) {
    mMatrix.reset();
    mCamera.save();
    if (mMode == MODE_Y || mMode == MODE_BOTH_X_Y) {
      mCamera.rotateX(mCanvasRotateX);
    }
    if (mMode == MODE_X || mMode == MODE_BOTH_X_Y) {
      mCamera.rotateY(mCanvasRotateY);
    }

    mCamera.rotateY(mDegreeY);
    mCamera.rotateX(mDegreeX);

    if (isPlaying) {
      mCamera.rotateY(mLoopAnimateY++);
      Log.e("wing", mLoopAnimateY + "");
      if (mLoopAnimateY == 360) {
        mLoopAnimateY = 0;
      }
      invalidate();
    }
    mCamera.getMatrix(mMatrix);

    // fix the Camera bug,

    mMatrix.getValues(mValues);
    mValues[6] = mValues[6] / mDensity;
    mValues[7] = mValues[7] / mDensity;
    mMatrix.setValues(mValues);
    mCamera.restore();
    mMatrix.preTranslate(-mCenterX, -mCenterY);
    mMatrix.postTranslate(mCenterX, mCenterY);

    canvas.concat(mMatrix);

    super.onDraw(canvas);
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent ev) {

    if (isCanTouch) {
      return true;
    } else {
      return super.onInterceptTouchEvent(ev);
    }
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    if (isCanTouch) {
      float x = event.getX();
      float y = event.getY();
      int action = event.getAction();
      switch (action) {
        case MotionEvent.ACTION_MOVE: {
          rotateCanvasWhenMove(x, y);
          invalidate();

          return true;
        }
        case MotionEvent.ACTION_UP: {
          mDegreeY = 0;
          rotateCanvasWhenMove(mCenterX, mCenterY);
          invalidate();

          return true;
        }
      }
      return true;
    } else {
      return super.onTouchEvent(event);
    }
  }

  /**
   * get the value to rotate
   */
  private void rotateCanvasWhenMove(float x, float y) {
    float dx = x - mCenterX;
    float dy = y - mCenterY;

    float percentX = dx / mCenterX;
    float percentY = dy / mCenterY;

    if (percentX > 1f) {
      percentX = 1f;
    } else if (percentX < -1f) {
      percentX = -1f;
    }
    if (percentY > 1f) {
      percentY = 1f;
    } else if (percentY < -1f) {
      percentY = -1f;
    }
    mCanvasRotateY = mCanvasMaxRotateDegree * percentX;
    mCanvasRotateX = -(mCanvasMaxRotateDegree * percentY);
  }

  public void setTouchable(boolean canTouch) {
    isCanTouch = canTouch;
  }

  public void setTouchMode(int mode) {
    mMode = mode;
    isCanTouch = true;
  }

  /**
   * set the max rotate degree
   */
  public void setMaxRotateDegree(int degree) {
    mCanvasMaxRotateDegree = degree;
  }

  /**
   * start horizontal turn animate
   */
  public void startHorizontalAnimate(long duration) {
    final ValueAnimator animator = ValueAnimator.ofFloat(-180f, 0f);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        mDegreeY = (float) animation.getAnimatedValue();
        invalidate();
      }
    });
    animator.addListener(new Animator.AnimatorListener() {
      @Override public void onAnimationStart(Animator animation) {

      }

      @Override public void onAnimationEnd(Animator animation) {
        mDegreeY = 0;
        animator.removeAllUpdateListeners();
      }

      @Override public void onAnimationCancel(Animator animation) {

      }

      @Override public void onAnimationRepeat(Animator animation) {

      }
    });

    animator.setDuration(duration);
    animator.start();
  }

  /**
   * start horizontal turn animate delayed
   */
  public void startHorizontalAnimateDelayed(final long delayed, final long duration) {

    new Thread(new Runnable() {
      @Override public void run() {
        try {
          Thread.sleep(delayed);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        post(new Runnable() {
          @Override public void run() {
            startHorizontalAnimate(duration);
          }
        });
      }
    }).start();
  }

  /**
   * start vertical turn animate
   */
  public void startVerticalAnimate(long duration) {
    final ValueAnimator animator = ValueAnimator.ofFloat(-180f, 0f);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        mDegreeX = (float) animation.getAnimatedValue();
        invalidate();
      }
    });
    animator.addListener(new Animator.AnimatorListener() {
      @Override public void onAnimationStart(Animator animation) {

      }

      @Override public void onAnimationEnd(Animator animation) {
        mDegreeX = 0;
        animator.removeAllUpdateListeners();
      }

      @Override public void onAnimationCancel(Animator animation) {

      }

      @Override public void onAnimationRepeat(Animator animation) {

      }
    });

    animator.setDuration(duration);
    animator.start();
  }

  /**
   * start vertical turn animate delayed
   */
  public void startVerticalAnimateDelayed(final long delayed, final long duration) {

    new Thread(new Runnable() {
      @Override public void run() {
        try {
          Thread.sleep(delayed);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        post(new Runnable() {
          @Override public void run() {
            startVerticalAnimate(duration);
          }
        });
      }
    }).start();
  }

  /**
   * start loop animate
   */
  public void startHorizontalAnimate() {
    isPlaying = true;
    invalidate();
  }

  /**
   * stop the loop animate
   */
  public void stopAnimate() {
    isPlaying = false;
    mLoopAnimateY = 0;
    invalidate();
  }
}
