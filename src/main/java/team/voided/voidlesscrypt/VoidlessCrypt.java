package team.voided.voidlesscrypt;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import team.voided.voidlesscrypt.world.feature.DungeonStartStructure;
import team.voided.voidlesscrypt.world.generator.DungeonGenerator;

public class VoidlessCrypt implements ModInitializer {
    public static final String MOD_ID = "voidless_crypt";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final StructurePieceType DUNGEON_START_PIECE_TYPE = DungeonGenerator.DungeonStartPiece::new;
    private static final Structure DUNGEON_START_STRUCTURE = new DungeonStartStructure(new Structure.Config(RegistryEntryList.of(), ImmutableMap.of(), GenerationStep.Feature.SURFACE_STRUCTURES, StructureTerrainAdaptation.BEARD_THIN));

    @Override
    public void onInitialize() {
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(MOD_ID, "dss"), DUNGEON_START_PIECE_TYPE);
        Registry.register(Registry.STRUCTURE_TYPE, new Identifier(MOD_ID, "dsss"), (StructureType<DungeonStartStructure>) () -> DungeonStartStructure.CODEC);
        LOGGER.info("Initialized");
    }
}
