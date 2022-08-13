package team.voided.voidlesscrypt.world.generator;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import team.voided.voidlesscrypt.VoidlessCrypt;

import java.util.Map;

public class DungeonGenerator {
    public static final Identifier STRUCTURE_START = new Identifier(VoidlessCrypt.MOD_ID, "structures/start.nbt");
    public static final Map<Identifier, BlockPos> OFFSETS_FROM_TOP = ImmutableMap.of(STRUCTURE_START, BlockPos.ORIGIN);

    public static void addPieces(StructureTemplateManager manager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder holder, Random random) {
        holder.addPiece(new DungeonStartPiece(manager, STRUCTURE_START, pos, rotation, 0));
    }

    public static class DungeonStartPiece extends SimpleStructurePiece {
        public DungeonStartPiece(StructureTemplateManager manager, Identifier id, BlockPos pos, BlockRotation rotation, int yOffset) {
            super(VoidlessCrypt.DUNGEON_START_PIECE_TYPE, 0, manager, id, id.toString(), createPlacementData(rotation, id), getPosOffset(id, pos, yOffset));
        }

        public DungeonStartPiece(StructureContext context, NbtCompound nbt) {
            super(VoidlessCrypt.DUNGEON_START_PIECE_TYPE, nbt, context.structureTemplateManager(), identifier -> createPlacementData(BlockRotation.valueOf(nbt.getString("Rot")), identifier));
        }

        private static StructurePlacementData createPlacementData(BlockRotation rotation, Identifier id) {
            return new StructurePlacementData().setRotation(rotation).setMirror(BlockMirror.NONE).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        }

        private static BlockPos getPosOffset(Identifier id, BlockPos pos, int yOffset) {
            return pos.add(OFFSETS_FROM_TOP.get(id)).down(yOffset);
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {

        }
    }
}
