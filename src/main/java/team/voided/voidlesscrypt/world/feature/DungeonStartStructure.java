package team.voided.voidlesscrypt.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Optional;

public class DungeonStartStructure extends Structure {
    public static final Codec<DungeonStartStructure> CODEC = createCodec(DungeonStartStructure::new);

    public DungeonStartStructure(Config config) {
        super(config);
    }

    @Override
    public Optional<StructurePosition> getStructurePosition(Context context) {
        return Optional.empty();
    }

    @Override
    public StructureType<?> getType() {
        return null;
    }
}
