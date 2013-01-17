
package com.quartercode.basicexpression;

import com.quartercode.basicexpression.command.AnnounceCommand;
import com.quartercode.basicexpression.command.ChestCommand;
import com.quartercode.basicexpression.command.ClearCommand;
import com.quartercode.basicexpression.command.CollectCommand;
import com.quartercode.basicexpression.command.CommandCommand;
import com.quartercode.basicexpression.command.EffectCommand;
import com.quartercode.basicexpression.command.EjectCommand;
import com.quartercode.basicexpression.command.FileCommand;
import com.quartercode.basicexpression.command.FurnaceCommand;
import com.quartercode.basicexpression.command.GrabCommand;
import com.quartercode.basicexpression.command.HealthCommand;
import com.quartercode.basicexpression.command.HoldCommand;
import com.quartercode.basicexpression.command.IntersectionCommand;
import com.quartercode.basicexpression.command.KillCommand;
import com.quartercode.basicexpression.command.LockCommand;
import com.quartercode.basicexpression.command.ReverseCommand;
import com.quartercode.basicexpression.command.SensorCommand;
import com.quartercode.basicexpression.command.SpeedCommand;
import com.quartercode.basicexpression.command.TimeCommand;
import com.quartercode.basicexpression.command.VerticalCommand;
import com.quartercode.basicexpression.command.WeatherCommand;
import com.quartercode.basicexpression.constant.HealthConstant;
import com.quartercode.basicexpression.constant.PlayerConstant;
import com.quartercode.basicexpression.constant.SpeedConstant;
import com.quartercode.basicexpression.constant.TimeConstant;
import com.quartercode.basicexpression.constant.XConstant;
import com.quartercode.basicexpression.constant.YConstant;
import com.quartercode.basicexpression.constant.ZConstant;
import com.quartercode.basicexpression.util.BasicExpressionConfig;
import com.quartercode.minecartrevolution.plugin.JavaMinecartRevolutionPlugin;
import com.quartercode.minecartrevolution.plugin.PluginInfo;
import com.quartercode.qcutil.version.Version;

public class BasicExpressionPlugin extends JavaMinecartRevolutionPlugin {

    public BasicExpressionPlugin() {

        super();
    }

    @Override
    public PluginInfo getInfo() {

        return new PluginInfo("BasicExpression", new Version("1.0"));
    }

    @Override
    public void onEnable() {

        config = new BasicExpressionConfig(this);
        config.setDefaults();
        config.save();

        addExpressionCommand(new AnnounceCommand(this));
        addExpressionCommand(new ChestCommand());
        addExpressionCommand(new ClearCommand());
        addExpressionCommand(new CollectCommand(this));
        addExpressionCommand(new CommandCommand());
        addExpressionCommand(new EffectCommand());
        addExpressionCommand(new EjectCommand());
        addExpressionCommand(new FileCommand(getExpressionExecutor()));
        addExpressionCommand(new FurnaceCommand());
        addExpressionCommand(new GrabCommand(this));
        addExpressionCommand(new HealthCommand());
        addExpressionCommand(new HoldCommand(getMinecartRevolution()));
        addExpressionCommand(new IntersectionCommand(this));
        addExpressionCommand(new KillCommand(getMinecartRevolution()));
        addExpressionCommand(new LockCommand(getMinecartRevolution()));
        addExpressionCommand(new ReverseCommand());
        addExpressionCommand(new SensorCommand(this));
        addExpressionCommand(new SpeedCommand(this));
        addExpressionCommand(new TimeCommand());
        addExpressionCommand(new VerticalCommand());
        addExpressionCommand(new WeatherCommand());

        addExpressionConstant(new HealthConstant());
        addExpressionConstant(new PlayerConstant());
        addExpressionConstant(new SpeedConstant());
        addExpressionConstant(new TimeConstant());
        addExpressionConstant(new XConstant());
        addExpressionConstant(new YConstant());
        addExpressionConstant(new ZConstant());
    }

}
