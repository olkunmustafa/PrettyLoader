package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.animation.Animation;

import com.olkunmustafa.prettypreloaders.BasePrettyLoaderView;
import com.olkunmustafa.prettypreloaders.R;
import com.olkunmustafa.prettypreloaders.utils.DensityUtils;

public class PairPrettyLoaderView extends BasePrettyLoaderView {

    private static final int DEFAULT_RADIUS_DP = 20;
    private static final int DEFAULT_STROKE_DP = 0;

    private int radiusPx;
    private int strokePx;

    private int circleColorOne;
    private int circleColorTwo;

    private Paint mCirclePaintOne = new Paint();
    private Paint mCirclePaintTwo = new Paint();

    private float circleOnePosition;
    private float circleTwoPosition;

    private PairPrettyLoaderCal mPairPrettyLoaderCal;
    private PPLAnimation pplAnimation;

    public PairPrettyLoaderView( Context context ) {
        this( context, null, 0 );
    }

    public PairPrettyLoaderView( Context context, AttributeSet attrs ) {
        this( context, attrs, 0 );
    }

    public PairPrettyLoaderView( Context context, AttributeSet attrs, int defStyleAttr ) {
        super( context, attrs, defStyleAttr );

        init( context, attrs );
    }

    public PairPrettyLoaderView( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes ) {
        super( context, attrs, defStyleAttr, defStyleRes );
    }

    /**
     * Inıtiliaze method for Pair Pretty Loader
     *
     * @param attrs Defined attributes set
     * @since 0.1.0
     */
    private void init( Context context, AttributeSet attrs ) {

        this.mPairPrettyLoaderCal = new PairPrettyLoaderCal();

        TypedArray typedArray =
                context.obtainStyledAttributes( attrs, R.styleable.PairPrettyLoaderView );

        this.initPaint();
        this.initSizeAttribute( typedArray );
        this.initColorAttribute( context, typedArray );

        typedArray.recycle();

    }

    /**
     * @since 0.1.0
     */
    private void initPaint() {

        this.mCirclePaintOne.setStyle( Paint.Style.FILL );
        this.mCirclePaintOne.setAntiAlias( true );

        this.mCirclePaintTwo.setStyle( Paint.Style.FILL );
        this.mCirclePaintTwo.setAntiAlias( true );

    }

    /**
     * Inıtiliaze method for Pair Pretty Loader
     *
     * @param typedArray Array to use defined size
     * @since 0.1.0
     */
    private void initSizeAttribute( @NonNull TypedArray typedArray ) {

        this.radiusPx = ( int ) typedArray.getDimension( R.styleable.PairPrettyLoaderView_ppl_radius, DensityUtils.dpToPx( DEFAULT_RADIUS_DP ) );
        this.strokePx = ( int ) typedArray.getDimension( R.styleable.PairPrettyLoaderView_ppl_strokeWidth, DensityUtils.dpToPx( DEFAULT_STROKE_DP ) );

        this.mPairPrettyLoaderCal.setAnimationPart( 1 );
        this.circleOnePosition = this.mPairPrettyLoaderCal.pplCircleStartPosition( radiusPx, radiusPx * 3 );
        this.circleTwoPosition = radiusPx * 3;

        this.pplAnimation = new PPLAnimation( this, circleOnePosition, circleTwoPosition, 1000 );
        this.pplAnimation.setRepeatCount( Animation.INFINITE );

//        this.startAnimation( pplAnimation );

    }

    /**
     * Initilize method for getting the provided colors
     *
     * @param context    Context to access Android component
     * @param typedArray Provided attributes
     * @since 0.1.0
     */
    private void initColorAttribute( Context context, TypedArray typedArray ) {

        this.circleColorOne = typedArray.getColor( R.styleable.PairPrettyLoaderView_ppl_circleColorOne, ContextCompat.getColor( context, R.color.defaultRed ) );
        this.circleColorTwo = typedArray.getColor( R.styleable.PairPrettyLoaderView_ppl_circleColorTwo, ContextCompat.getColor( context, R.color.defaultBlue ) );

        this.mCirclePaintOne.setColor( this.circleColorOne );
        this.mCirclePaintTwo.setColor( this.circleColorTwo );

    }

    @Override
    protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
        int widthMode = MeasureSpec.getMode( widthMeasureSpec );
        int widthSize = MeasureSpec.getSize( widthMeasureSpec );

        int heightMode = MeasureSpec.getMode( heightMeasureSpec );
        int heightSize = MeasureSpec.getSize( heightMeasureSpec );

        int desiredHeight = this.mPairPrettyLoaderCal.pplDesiredHeight( radiusPx, strokePx );
        int desiredWidth = this.mPairPrettyLoaderCal.pplDesiredWidth( radiusPx, strokePx );

        int width;
        int height;

        // Define width START //
        if ( widthMode == MeasureSpec.EXACTLY ) {
            width = widthSize;

        } else if ( widthMode == MeasureSpec.AT_MOST ) {
            width = Math.min( desiredWidth, widthSize );

        } else {
            width = desiredWidth;
        }
        // Define width END //

        if ( heightMode == MeasureSpec.EXACTLY ) {
            height = heightSize;

        } else if ( heightMode == MeasureSpec.AT_MOST ) {
            height = Math.min( desiredHeight, heightSize );

        } else {
            height = desiredHeight;
        }

        if ( width < 0 ) {
            width = 0;
        }

        if ( height < 0 ) {
            height = 0;
        }

        setMeasuredDimension( width, height );
    }

    @Override
    protected void onDraw( Canvas canvas ) {
        super.onDraw( canvas );

        canvas.drawCircle( this.circleOnePosition, radiusPx, radiusPx, mCirclePaintOne );
        canvas.drawCircle( this.circleTwoPosition, radiusPx, radiusPx, mCirclePaintTwo );

    }

    /**
     * Sets the position of CircleOne
     *
     * @param position Position value
     * @since 0.1.0
     */
    public void setCircleOnePosition( float position ) {

        this.circleOnePosition = position;
        invalidate();
    }

    /**
     * Sets the position of CircleOne
     *
     * @since 0.1.0
     */
    public void setCircleAlpha( int alpha ) {

        mCirclePaintOne.setAlpha( alpha );
        invalidate();
    }

    /**
     * Sets the position of CircleOne
     *
     * @param position Position value
     * @since 0.1.0
     */
    public void setCircleTwoPosition( float position ) {

        this.circleTwoPosition = position;
        invalidate();
    }

    /**
     * Sets the position of CircleOne
     *
     * @since 0.1.0
     */
    public void setCircleTwoAlpha( int alpha ) {

        this.mCirclePaintTwo.setAlpha( alpha );
        invalidate();
    }

    public void setColorOne( int circleColorOne ) {
        this.circleColorOne = circleColorOne;
        this.mCirclePaintOne.setColor( circleColorOne );

        invalidate();
    }

    public void setColorTwo( int circleColorTwo ) {
        this.circleColorTwo = circleColorTwo;
        this.mCirclePaintTwo.setColor( circleColorTwo );

        invalidate();
    }
}
