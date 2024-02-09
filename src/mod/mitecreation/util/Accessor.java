package mod.mitecreation.util;

import java.lang.reflect.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Accessor {
    private static final Logger logger = LogManager.getLogger("Accessor");

    private Accessor() {
        try{
            throw new Throwable("你怎么回事，为什么要创建Accessor的实例？");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static <T,Y> T modify(@Nonnull Field field, @Nonnull T value ,@Nonnull Y instance) {
        try {
            if(Modifier.isFinal(field.getModifiers())){
                Field modifiers = Field.class.getDeclaredField("modifiers");
                modifiers.setAccessible(true);
                modifiers.setInt(field, field.getModifiers() & -17);
            }
            field.setAccessible(true);
            field.set(instance, value);
            return (T) field.get(value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Accessor：找不到" + field.getName(),e);
        } catch (IllegalAccessException | ClassCastException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Accessor：输入的值" + value + "无效", e);
        }
    }

    public static <T> T modifyStatic(@Nonnull Field field, @Nonnull T value) {
        try {
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & -17);
            field.setAccessible(true);
            field.set(null, value);
            return (T) field.get(value);
        } catch (NoSuchFieldException | IllegalAccessException | ClassCastException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Accessor：输入的值" + value + "无效", e);
        }
    }

    public static <T,Y> Y access(@Nonnull Field field, @Nonnull T instance) throws TargetIsStaticException {
        if(!Modifier.isStatic(field.getModifiers())){
            try {
                field.setAccessible(true);
                return (Y) field.get(instance);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Accessor：你最好不是乱输的" + instance, e);
            } catch (SecurityException | ClassCastException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }else {
            throw new TargetIsStaticException("Accessor：成员" + field.getName() + "是非静态的，不能以静态形式访问！");
        }
    }

    public static <T> T accessStatic(@Nonnull Field field) throws TargetIsNotStaticException {
        if(Modifier.isStatic(field.getModifiers())){
            try {
                field.setAccessible(true);
                return (T) field.get(null);
            } catch (IllegalArgumentException | SecurityException | ClassCastException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }else {
            throw new TargetIsNotStaticException("Accessor：成员" + field.getName() + "不是静态的！");
        }
    }

    public static <T> T createInstance(@Nonnull Class<T> clazz, @Nullable Object... args) {
        try {
            Class[] parameterTypes = new Class[args.length];
            int i = 0;
            Object[] var4 = args;
            int var5 = args.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Object object = var4[var6];
                parameterTypes[i] = object.getClass();
                ++i;
            }

            Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(args);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Accessor：你要不检查检查你传入的参数？或者使用另一个createInstant()？", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T createInstance(@Nonnull Class<T> clazz, @Nonnull Class[] types, @Nonnull Object[] args) {
        try {
            if (types.length != args.length) {
                throw new IllegalArgumentException("Accessor：参数类型数量和参数数量不一致！");
            } else {
                Constructor<T> constructor = clazz.getDeclaredConstructor(types);
                constructor.setAccessible(true);
                return constructor.newInstance(args);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Accessor：你要不检查检查你传入的参数类型？", e);
        } catch (InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Accessor：快去告诉锈铁锭他Accessor有问题", e);
        }
    }

    public static <T, Y> Y invoke(@Nonnull Method method, @Nonnull T instance, @Nullable Object... args) throws TargetIsStaticException {
        if(!Modifier.isStatic(method.getModifiers()) || instance == null){
            try {
                method.setAccessible(true);
                return (Y) method.invoke(instance, args);
            } catch (InvocationTargetException | IllegalAccessException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }else {
            throw new TargetIsStaticException("Accessor：不能以静态方式访问非静态方法" + method.getName());
        }
    }

    public static <T> T invokeStatic(@Nonnull Method method,@Nullable Object... args) throws TargetIsNotStaticException {
        if(Modifier.isStatic(method.getModifiers())){
            try {
                method.setAccessible(true);
                return (T) method.invoke(null, args);
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e) {
                throw new RuntimeException("Accessor：需要实例！", e);
            }
        }else {
            throw new TargetIsNotStaticException("Accessor：方法" + method.getName() + "不是静态的！");
        }
    }

    public static <T> Class<T> accessClass(@Nonnull String className) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(className);
            return clazz;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Accessor：要不再考虑清楚？", e);
        }
    }

    public static <T, Y> Class<Y> accessInnerClass(@Nonnull Class<T> outerClass, @Nonnull String innerClassName) {
        try {
            Class<Y> innerClass = (Class<Y>) Class.forName(outerClass.getName() + "$" + innerClassName);
            return innerClass;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
