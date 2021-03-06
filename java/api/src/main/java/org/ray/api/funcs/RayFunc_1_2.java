package org.ray.api.funcs;

import org.apache.commons.lang3.SerializationUtils;
import org.ray.api.internal.RayFunc;
import org.ray.api.returns.MultipleReturns2;

@FunctionalInterface
public interface RayFunc_1_2<T0, R0, R1> extends RayFunc {

  MultipleReturns2<R0, R1> apply(T0 t0) throws Throwable;

  static <T0, R0, R1> MultipleReturns2<R0, R1> execute(Object[] args) throws Throwable {
    String name = (String) args[args.length - 2];
    assert (name.equals(RayFunc_1_2.class.getName()));
    byte[] funcBytes = (byte[]) args[args.length - 1];
    RayFunc_1_2<T0, R0, R1> f = SerializationUtils.deserialize(funcBytes);
    return f.apply((T0) args[0]);
  }

}
