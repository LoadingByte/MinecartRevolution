
package com.quartercode.basicexpression.command;

import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import com.quartercode.minecartrevolution.util.expression.ExpressionCommand;
import com.quartercode.minecartrevolution.util.expression.ExpressionCommandInfo;

public class VerticalCommand implements ExpressionCommand {

    public VerticalCommand() {

    }

    @Override
    public ExpressionCommandInfo getInfo() {

        return new ExpressionCommandInfo("v", "vert", "vertical");
    }

    @Override
    public boolean canExecute(Minecart minecart) {

        return true;
    }

    @Override
    public void execute(Minecart minecart, Object parameter) {

        if (parameter != null && parameter instanceof Double) {
            Location location = minecart.getLocation();
            location.add(0, (Double) parameter, 0);
            minecart.teleport(location);
        }
    }

}