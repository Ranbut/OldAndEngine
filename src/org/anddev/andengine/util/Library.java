package org.anddev.andengine.util;

import android.util.SparseArray;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:51:29 - 20.08.2010
 * @param <T>
 */
public class Library<T> {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    protected final SparseArray<T> mItems;

    // ===========================================================
    // Constructors
    // ===========================================================

    public Library() {
        this.mItems = new SparseArray<T>();
    }

    public Library(final int pInitialCapacity) {
        this.mItems = new SparseArray<T>(pInitialCapacity);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void put(final int pID, final T pItem) {
        final T existingItem = this.mItems.get(pID);
        if(existingItem == null) {
            this.mItems.put(pID, pItem);
        } else {
            throw new IllegalArgumentException("ID: '" + pID + "' is already associated with item: '" + existingItem.toString() + "'.");
        }
    }

    public void remove(final int pID) {
        this.mItems.remove(pID);
    }

    public T get(final int pID) {
        return this.mItems.get(pID);
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}