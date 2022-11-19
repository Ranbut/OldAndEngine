package org.anddev.andengine.opengl.vertex;

import org.anddev.andengine.opengl.buffer.BufferObject;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 12:16:18 - 09.03.2010
 */
public abstract class VertexBuffer extends BufferObject {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public VertexBuffer(final int pCapacity, final int pDrawType, final boolean pManaged) {
        super(pCapacity, pDrawType, pManaged);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

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