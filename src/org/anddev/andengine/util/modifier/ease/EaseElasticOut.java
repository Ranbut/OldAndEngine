package org.anddev.andengine.util.modifier.ease;

import org.anddev.andengine.util.constants.MathConstants;

import android.util.FloatMath;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseElasticOut implements IEaseFunction, MathConstants {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private static EaseElasticOut INSTANCE;

    // ===========================================================
    // Constructors
    // ===========================================================

    private EaseElasticOut() {

    }

    public static EaseElasticOut getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EaseElasticOut();
        }
        return INSTANCE;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public float getPercentage(final float pSecondsElapsed, final float pDuration) {
        return EaseElasticOut.getValue(pSecondsElapsed, pDuration, pSecondsElapsed / pDuration);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public static float getValue(final float pSecondsElapsed, final float pDuration, final float pPercentageDone) {
        if(pSecondsElapsed == 0) {
            return 0;
        }
        if(pSecondsElapsed == pDuration) {
            return 1;
        }

        final float p = pDuration * 0.3f;
        final float s = p / 4;

        return (float) (1 + (float)Math.pow(2, -10 * pPercentageDone) * Math.sin((pPercentageDone * pDuration - s) * PI_TWICE / p));
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}