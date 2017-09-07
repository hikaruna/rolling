package net.hikaruna.rolling;

import javax.annotation.Nonnull;

public interface VoidFunc<Arg> {
    void call(Arg arg);
}
