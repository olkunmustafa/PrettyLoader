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

    public static final double ANIMATION_PART = 0.2;

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
        return totalCircleWidth * 3;

    }

    /**
     * @param t Duration for each ball animation
     * @return Desired total duration for whole animation
     * @since 0.1.0
     */
    float pplDesiredDuration( float t ) {
        return ( float ) ( ( t * 2 ) - ( ANIMATION_PART * t ) );

    }

    float pplCircleFinalPosition( float start, float end, float interpolatedTime ) {
        return ( start + ( ( end - start ) * pplDesiredDuration( interpolatedTime ) ) );

    }

    public float pplCircleLife( float i ) {
        return i / pplDesiredDuration( i );
    }

    public double round( double value, int places ) {
        if ( places < 0 ) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal( value );
        bd = bd.setScale( places, RoundingMode.HALF_UP );
        return bd.doubleValue();
    }
}
