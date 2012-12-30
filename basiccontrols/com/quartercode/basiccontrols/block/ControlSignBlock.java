
package com.quartercode.basiccontrols.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Minecart;
import com.quartercode.basiccontrols.BasicControlsPlugin;
import com.quartercode.minecartrevolution.block.ControlBlock;
import com.quartercode.minecartrevolution.block.ControlBlockInfo;
import com.quartercode.minecartrevolution.get.Lang;

public class ControlSignBlock extends ControlBlock {

    private final BasicControlsPlugin basicControlsPlugin;

    public ControlSignBlock(final BasicControlsPlugin basicControlsPlugin) {

        this.basicControlsPlugin = basicControlsPlugin;
    }

    @Override
    public ControlBlockInfo getInfo() {

        return new ControlBlockInfo(Lang.getValue("basiccontrols.blocks.controlsign.name"), Lang.getValue("basiccontrols.blocks.controlsign.description"), "controlsign.place", "controlsign.destroy", Material.STONE.getId());
    }

    @Override
    public void execute(final Minecart minecart, final Location blockLocation, final int blockId, final Block block) {

        if (hasSontrolSign(blockLocation)) {
            for (final Sign sign : getControlSigns(blockLocation)) {
                basicControlsPlugin.getControlSignExecutor().executeControlSign(sign.getLocation(), minecart);
            }
        }
    }

}
