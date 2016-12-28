package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.*;

/**
 * Created by olkunmustafa on 28/12/2016.
 */
@RunWith( JUnitParamsRunner.class )
public class PairPrettyLoaderCalTest {

    private PairPrettyLoaderCal mPairPrettyLoaderCal;

    @Before
    public void setUp() throws Exception {
        this.mPairPrettyLoaderCal = new PairPrettyLoaderCal();

    }

    @Test
    @Parameters( { "10, 5, 25", "30, 10, 70", "5, 0, 10" } )
    public void pplDesiredHeightTest( int radius, int stroke, int expected ) throws Exception {

        int actual = this.mPairPrettyLoaderCal.pplDesiredHeight( radius, stroke );
        assertEquals( expected, actual );

    }

    @Test
    @Parameters( { "10, 1, 84", "5, 2, 48" } )
    public void pplDesiredWidthTest( int radius, int stroke, int expected ) throws Exception {

        int actual = this.mPairPrettyLoaderCal.pplDesiredWidth( radius, stroke );
        assertEquals( expected, actual );

    }
}