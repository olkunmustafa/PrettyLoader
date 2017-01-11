package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by olkunmustafa on 05/01/2017.
 */

public class PPLAnimation extends Animation {

    private PairPrettyLoaderView mPPLView;
    private float startPosition;
    private float endPosition;
    private int oneBallDuration;
    private PairPrettyLoaderCal mPairPrettyLoaderCal;

    public PPLAnimation( PairPrettyLoaderView mPPLView, float startPosition, float endPosition, int oneBallDuration ) {
        this.mPPLView = mPPLView;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.oneBallDuration = oneBallDuration;

        init();
    }

    private void init() {
        this.mPairPrettyLoaderCal = new PairPrettyLoaderCal();

        this.setDuration( ( long ) this.mPairPrettyLoaderCal.pplDesiredDuration( this.oneBallDuration ) );
    }

    @Override
    protected void applyTransformation( float interpolatedTime, Transformation transformation ) {

        if ( interpolatedTime <= this.mPairPrettyLoaderCal.pplCircleLife( this.oneBallDuration ) ) {

            float finalPosition = this.mPairPrettyLoaderCal.pplCircleFinalPosition( this.startPosition, this.endPosition, interpolatedTime );
            int finalAlpha = ( int ) ( 255 - ( ( this.mPairPrettyLoaderCal.pplDesiredDuration( interpolatedTime ) ) * 255 ) );

            if ( finalAlpha == 0 )
                finalPosition = this.startPosition;

            if ( finalPosition == this.startPosition )
                finalAlpha = 255;

            this.mPPLView.setCircleOnePosition( finalPosition );
            this.mPPLView.setCircleAlpha( finalAlpha );

        }


    }

}
