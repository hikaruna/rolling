package net.hikaruna.rolling;

import javax.annotation.Nonnull;
import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public class ArrayList<E> extends java.util.ArrayList<E> {

    private static final long serialVersionUID = 1054066276178532545L;

    public ArrayList(@Nonnull final Collection<? extends E> c) {
        super(c);
    }

    public void each(@Nonnull final VoidFunction<E> function) {
        for (final E i : this) {
            function.call(i);
        }
    }
}
