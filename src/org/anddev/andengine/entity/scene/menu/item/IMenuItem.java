package org.anddev.andengine.entity.scene.menu.item;

import org.anddev.andengine.entity.shape.IShape;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 13:27:16 - 07.07.2010
 */
public interface IMenuItem extends IShape {
    // ===========================================================
    // Final Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    public int getID();
    public abstract void onSelected();
    public abstract void onUnselected();
}