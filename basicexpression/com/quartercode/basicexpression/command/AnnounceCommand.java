
package com.quartercode.basicexpression.command;

import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import com.quartercode.minecartrevolution.util.expression.ExpressionCommand;
import com.quartercode.minecartrevolution.util.expression.ExpressionCommandInfo;

public class AnnounceCommand implements ExpressionCommand {

    public AnnounceCommand() {

    }

    @Override
    public ExpressionCommandInfo getInfo() {

        return new ExpressionCommandInfo("a", "announce");
    }

    @Override
    public boolean canExecute(final Minecart minecart) {

        return minecart.getPassenger() != null && minecart.getPassenger() instanceof Player;
    }

    @Override
    public void execute(final Minecart minecart, final Object parameter) {

        if (parameter != null) {
            ((Player) minecart.getPassenger()).sendMessage(String.valueOf(parameter).replaceAll("&", "�"));
        }
    }

}
