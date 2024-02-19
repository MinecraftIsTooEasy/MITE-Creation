package mod.mitecreation.item.materil;

import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.EnumQuality;
import sun.reflect.ConstructorAccessor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumEquipmentMaterials {
    private static ConstructorAccessor constructorAccessor;
    private static int ordinary = EnumEquipmentMaterial.values().length;
    static {
        try {
            Constructor<?> CTOR = EnumEquipmentMaterial.silver.getClass().getDeclaredConstructors()[0];
            Method acquireConstructorAccessor;
            acquireConstructorAccessor = Constructor.class.getDeclaredMethod("acquireConstructorAccessor");
            acquireConstructorAccessor.setAccessible(true);
            acquireConstructorAccessor.invoke(CTOR);
            Field field = Constructor.class.getDeclaredField("constructorAccessor");
            field.setAccessible(true);
            constructorAccessor = (ConstructorAccessor) field.get(CTOR);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public static final EnumEquipmentMaterial tungsten = newEnumEquipmentMaterial(32.0F,60, EnumQuality.masterwork,"tungsten");
    public static final EnumEquipmentMaterial stone = newEnumEquipmentMaterial(2.0F,0, EnumQuality.poor,"stone");

    private static final EnumEquipmentMaterial newEnumEquipmentMaterial(float durability, int enchantability, EnumQuality max_quality, String name){
        try {
            return (EnumEquipmentMaterial) constructorAccessor.newInstance(new Object[]{name,ordinary++,durability,enchantability,max_quality,name});
        } catch (InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
