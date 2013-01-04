
package com.quartercode.basicexpression.util;

import com.quartercode.minecartrevolution.plugin.MinecartRevolutionPlugin;
import com.quartercode.minecartrevolution.plugin.PluginConfig;

public class BasicExpressionConfig extends PluginConfig {

    private static final String ANNOUNCE                   = "announce";
    public static final String  ANNOUNCE_ALLOW_COLOR_CODES = ANNOUNCE + ".allowColorCodes";

    private static final String COLLECT                    = "collect";
    public static final String  COLLECT_MAX_RADIUS         = COLLECT + ".maxRadius";

    private static final String GRAB                       = "grab";
    public static final String  GRAB_MAX_RADIUS            = GRAB + ".maxRadius";

    private static final String SPEED                      = "speed";
    public static final String  SPEED_MAX_SPEED            = SPEED + ".maxSpeed";

    public BasicExpressionConfig(final MinecartRevolutionPlugin minecartRevolutionPlugin) {

        super(minecartRevolutionPlugin);
    }

    @Override
    public void setDefaults() {

        addDefault(ANNOUNCE_ALLOW_COLOR_CODES, true);
        addDefault(COLLECT_MAX_RADIUS, 20);
        addDefault(GRAB_MAX_RADIUS, 20);
        addDefault(SPEED_MAX_SPEED, 100);
    }

}
