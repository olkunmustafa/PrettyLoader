package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by olkunmustafa on 28/12/2016.
 * <p>
 * This is helper calculate class.
 * Uses to calculate the desired width and height.
 */
class PairPrettyLoaderCal {

    public double animationPart;

    /**
     * @param radiusPx Radius dimension for each circle
     * @param strokePx Stroke dimension for each circle
     * @return The desired height dimension for {@link PairPrettyLoaderView}
     * @since 0.1.0
     */
    int pplDesiredHeight( int radiusPx, int strokePx ) {

        int circleDiameterPx = radiusPx * 2;
        return circleDiameterPx + strokePx;

    }

    /**
     * @param radiusPx Radius dimension for each circle
     * @param strokePx Stroke dimension for each circle
     * @return Desired total width dimension for {@link PairPrettyLoaderView}
     * @since 0.1.0
     */
    int pplDesiredWidth( int radiusPx, int strokePx ) {

        int circleDiameterPx = radiusPx * 2;
        int totalCircleWidth = ( circleDiameterPx + strokePx );
        return totalCircleWidth * 4;

    }

    /**
     * @param t Duration for each ball animation
     * @return Desired total duration for whole animation.
     * @since 0.1.0
     */
    float pplDesiredDuration( float t ) {
        return ( float ) ( ( t * 2 ) - ( this.getAnimationPart() * t ) );

    }

    float pplCircleCurrentPosition( float start, float end, float interpolatedTime ) {
        return ( start + ( ( end - start ) * pplDesiredDuration( interpolatedTime ) ) );

    }

    float pplCircleLife( float i ) {
        return i / pplDesiredDuration( i );

    }

    float pplCircleStartPosition( float start, float end ) {
        return ( float ) ( end - ( ( end - start ) * this.getAnimationPart() ) );
    }

    double round( double value, int places ) {
        if ( places < 0 ) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal( value );
        bd = bd.setScale( places, RoundingMode.HALF_UP );
        return bd.doubleValue();
    }

    double getAnimationPart() {
        if ( this.animationPart == 0 )
            return this.animationPart = 0.3;

        return this.animationPart;
    }

    void setAnimationPart( double animationPart ) {
        this.animationPart = animationPart;
    }
}
