
package com.quartercode.minecartrevolution.sign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Minecart;
import com.quartercode.minecartrevolution.MinecartRevolution;

public class ControlSignExecutor {

    private static final int[][]     controlSignOffsets = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 }, { 0, -2, 0 }, { 0, 2, 0 }, { 0, 3, 0 } };

    private final MinecartRevolution minecartRevolution;
    private List<ControlSign>        controlSigns;

    public ControlSignExecutor(final MinecartRevolution minecartRevolution) {

        this.minecartRevolution = minecartRevolution;
        controlSigns = new ArrayList<ControlSign>();
    }

    public List<ControlSign> getControlSigns() {

        return Collections.unmodifiableList(controlSigns);
    }

    public ControlSign getControlBlock(final Class<? extends ControlSign> c) {

        for (final ControlSign controlSign : controlSigns) {
            if (controlSign.getClass().equals(c)) {
                return controlSign;
            }
        }

        return null;
    }

    public void setControlSigns(final List<ControlSign> controlSigns) {

        this.controlSigns = controlSigns;
    }

    public void addControlSign(final ControlSign controlSign) {

        controlSign.setMinecartRevolution(minecartRevolution);
        controlSigns.add(controlSign);
        controlSign.enable();
    }

    public List<Sign> getSigns(final Minecart minecart) {

        final List<Sign> signs = new ArrayList<Sign>();
        final Location location = minecart.getLocation();

        for (final int[] offsets : controlSignOffsets) {
            final Location signLocation = location.clone();
            signLocation.add(offsets[0], offsets[1], offsets[2]);

            if (signLocation.getBlock().getType() == Material.SIGN || signLocation.getBlock().getType() == Material.SIGN_POST) {
                signs.add((Sign) signLocation.getBlock().getState());
            }
        }

        return signs;
    }

    public void execute(final Minecart minecart) {

        for (final Sign sign : getSigns(minecart)) {
            executeControlSign(sign, minecart);
        }
    }

    public void executeControlSign(final Sign sign, final Minecart minecart) {

        if (sign.getBlock().isBlockIndirectlyPowered()) {
            return;
        }

        for (final ControlSign controlSign : controlSigns) {
            final ControlSignInfo controlSignInfo = controlSign.getInfo();

            for (final String label : controlSignInfo.getLabels()) {
                if (ControlSignInfo.getFormattedLabel(label).equalsIgnoreCase(sign.getLine(0))) {
                    controlSign.execute(minecart, sign.getLine(0), sign);
                }
            }
        }
    }

}
