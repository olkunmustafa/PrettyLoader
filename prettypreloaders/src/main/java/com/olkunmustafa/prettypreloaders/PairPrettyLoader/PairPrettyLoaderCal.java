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
        return radiusPx * 6;

    }

    /**
     * @param t Duration for each ball animation
     * @return Desired total duration for whole animation.
     * @since 0.1.0
     */
    float pplDesiredDuration( float t ) {
        return ( t * 2 ) - ( t / 2 );

    }

    float pplCircleOneStartPosition( float radius ) {
        float end = ( radius * 3 );
        return ( end - radius );

    }

    float pplCircleTwoStartPosition( float radius ) {
        return radius * 3;

    }

    /**
     * @param radius Radius of circle
     * @param time   Time
     * @return The current position of the circle in accurate time.
     * @since 0.1.0
     */
    float pplCircleFirstPartCurrentPosition( float radius, float time ) {

        float start = radius * 2;
        float end = radius * 3;

        return ( ( start + ( ( end - radius ) * time ) ) );
    }


    /**
     * @param radius Radius of circle
     * @param time   Time
     * @return The current position of the circle in accurate time.
     * @since 0.1.0
     */
    float pplCircleSecondPartCurrentPosition( float radius, float time ) {

        float start = radius;
        float end = radius * 3;

        return ( float ) (start + ( ( end - radius ) * ( time - 0.5 ) ));
    }

    /**
     * @param radius Radius of circle
     * @param time   Time
     * @return The current position of the circle in accurate time.
     * @since 0.1.0
     */
    float pplCircleThirdPartCurrentPosition( float radius, float time ) {

        float start = radius * 3;
        float end = radius * 5;

        return ( float ) (start + ( ( end - start ) * time ));
    }

}
