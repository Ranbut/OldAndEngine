package org.anddev.andengine.util.modifier.ease;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 17:13:17 - 26.07.2010
 */
public interface IEaseFunction {
    // ===========================================================
    // Final Fields
    // ===========================================================

    public static final IEaseFunction DEFAULT = EaseLinear.getInstance();

    // ===========================================================
    // Methods
    // ===========================================================

    public float getPercentage(final float pSecondsElapsed, final float pDuration);
}