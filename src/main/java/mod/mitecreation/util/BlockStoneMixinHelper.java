package mod.mitecreation.util;

import net.minecraft.BlockSubtypes;

public class BlockStoneMixinHelper {

    public static BlockSubtypes subtypesInitializer() {
        BlockSubtypes subtypes = new BlockSubtypes(new String[]{"stone", "deepslate"});
        return subtypes;
    }
}
