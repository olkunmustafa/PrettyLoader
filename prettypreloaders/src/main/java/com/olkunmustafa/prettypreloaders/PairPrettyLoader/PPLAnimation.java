package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class PPLAnimation extends Animation {

    private PairPrettyLoaderView mPPLView;
    private float startPosition;
    private float endPosition;
    private int oneBallDuration;
    private PairPrettyLoaderCal mPairPrettyLoaderCal;

    private float circleLife;

    PPLAnimation( PairPrettyLoaderView mPPLView, float startPosition, float endPosition, int oneBallDuration ) {
        this.mPPLView = mPPLView;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.oneBallDuration = oneBallDuration;

        init();
    }

    private void init() {
        this.mPairPrettyLoaderCal = new PairPrettyLoaderCal();

        this.setDuration( ( long ) this.mPairPrettyLoaderCal.pplDesiredDuration( this.oneBallDuration ) );
        this.circleLife = this.mPairPrettyLoaderCal.pplCircleLife( this.oneBallDuration );

    }

    @Override
    protected void applyTransformation( float interpolatedTime, Transformation transformation ) {

        if ( interpolatedTime <= this.circleLife ) {
            this.circleOneAnimation( interpolatedTime );
        }

//        if ( interpolatedTime >= ( 1 - this.circleLife ) ) {
//            this.circleTwoAnimation( interpolatedTime - ( 1 - this.circleLife ) );
//        }

    }

    private void circleOneAnimation( float t ) {

        float finalPosition = this.mPairPrettyLoaderCal.pplCircleCurrentPosition( this.startPosition, this.endPosition, t );
        int finalAlpha = ( int ) ( 255 - ( ( this.mPairPrettyLoaderCal.pplDesiredDuration( t ) ) * 255 ) );

        if ( finalAlpha == 0 )
            finalPosition = this.startPosition;

        if ( finalPosition == this.startPosition )
            finalAlpha = 255;

        this.mPPLView.setCircleOnePosition( finalPosition );
        this.mPPLView.setCircleAlpha( finalAlpha );

    }

//    private void circleTwoAnimation( float t ) {
//
//        float secondStart = this.endPosition;
//
//        float finalPosition = this.mPairPrettyLoaderCal.pplCircleCurrentPosition( secondStart, secondStart * 2, t );
//        int finalAlpha = ( int ) ( 255 - ( ( this.mPairPrettyLoaderCal.pplDesiredDuration( t ) ) * 255 ) );
//
//        if ( finalAlpha == 0 )
//            finalPosition = secondStart;
//
//        if ( finalPosition == secondStart )
//            finalAlpha = 255;
//
//        this.mPPLView.setCircleTwoPosition( finalPosition );
//        this.mPPLView.setCircleTwoAlpha( finalAlpha );
//
//    }

}
