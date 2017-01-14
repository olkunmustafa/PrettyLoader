package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

class PPLAnimation extends Animation {

    private PairPrettyLoaderView mPPLView;
    private float mRadius;

    private int oneBallDuration = 1000;
    private PairPrettyLoaderCal mPairPrettyLoaderCal;

    PPLAnimation( PairPrettyLoaderView mPPLView, float radius ) {
        this.mPPLView = mPPLView;
        this.mRadius = radius;

        init();
    }

    private void init() {

        this.mPairPrettyLoaderCal = new PairPrettyLoaderCal();
        this.setInterpolator( new LinearInterpolator() );
        this.setDuration( this.oneBallDuration );

    }

    @Override
    protected void applyTransformation( float interpolatedTime, Transformation transformation ) {

        this.circleOneAnimation( interpolatedTime );
        this.circleTwoAnimation( interpolatedTime );

    }

    private void circleOneAnimation( float t ) {
        float currentPosition = 0;
        int currentAlpha = 0;

        if ( t <= 0.5 ) {
            currentPosition = this.mPairPrettyLoaderCal.pplCircleFirstPartCurrentPosition( this.mRadius, t );
            currentAlpha = this.mPairPrettyLoaderCal.pplCircleFirstPartAlpha( t );
        }

        if ( t >= 0.5 ) {
            currentPosition = this.mPairPrettyLoaderCal.pplCircleSecondPartCurrentPosition( this.mRadius, t );
            currentAlpha = this.mPairPrettyLoaderCal.pplCircleSecondPartAlpha( t );
        }

        this.mPPLView.setCircleOnePosition( currentPosition );
        this.mPPLView.setCircleAlpha( currentAlpha );

    }

    private void circleTwoAnimation( float t ) {

        float currentPosition = this.mPairPrettyLoaderCal.pplCircleThirdPartCurrentPosition( this.mRadius, t );
        int currentAlpha = this.mPairPrettyLoaderCal.pplCircleThirdPartAlpha( t );

        this.mPPLView.setCircleTwoPosition( currentPosition );
        this.mPPLView.setCircleTwoAlpha( currentAlpha );

    }

}
