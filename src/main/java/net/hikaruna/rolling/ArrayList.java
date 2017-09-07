package net.hikaruna.rolling;

import javax.annotation.Nonnull;

public class ArrayList<E> extends java.util.ArrayList<E> {

    private static final long serialVersionUID = 1054066276178532545L;

    public void each(@Nonnull final VoidFunc<E> func) {
        for(final E i : this) {
            func.call(i);
        }
    }
}
