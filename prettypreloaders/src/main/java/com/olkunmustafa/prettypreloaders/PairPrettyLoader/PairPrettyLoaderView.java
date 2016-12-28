package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.olkunmustafa.prettypreloaders.BasePrettyLoaderView;
import com.olkunmustafa.prettypreloaders.R;
import com.olkunmustafa.prettypreloaders.utils.DensityUtils;

/**
 * Created by olkunmustafa on 28/12/2016.
 */

public class PairPrettyLoaderView extends BasePrettyLoaderView {

    private static final int DEFAULT_RADIUS_DP = 6;
    private static final int DEFAULT_STROKE_DP = 0;

    private int radiusPx;
    private int strokePx;

    private PairPrettyLoaderCal mPairPrettyLoaderCal;

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

        initSizeAttribute( typedArray );

        typedArray.recycle();

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
}
