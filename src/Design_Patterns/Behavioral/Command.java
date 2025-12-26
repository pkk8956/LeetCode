package Design_Patterns.Behavioral;

// Command interface
interface CommandInterface {
    void execute();
}

// Concrete command for turning a device on
class TurnOnCommand implements CommandInterface {
    private Runnable deviceAction;

    public TurnOnCommand(Runnable deviceAction) {
        this.deviceAction = deviceAction;
    }

    @Override
    public void execute() {
        deviceAction.run();
    }
}

// Concrete command for turning a device off
class TurnOffCommand implements CommandInterface {
    private Runnable deviceAction;

    public TurnOffCommand(Runnable deviceAction) {
        this.deviceAction = deviceAction;
    }

    @Override
    public void execute() {
        deviceAction.run();
    }
}

// Concrete command for adjusting the volume of a stereo
class AdjustVolumeCommand implements CommandInterface {
    private Runnable stereoAction;

    public AdjustVolumeCommand(Runnable stereoAction) {
        this.stereoAction = stereoAction;
    }

    @Override
    public void execute() {
        stereoAction.run();
    }
}

// Concrete command for changing the channel of a TV
class ChangeChannelCommand implements CommandInterface {
    private Runnable tvAction;

    public ChangeChannelCommand(Runnable tvAction) {
        this.tvAction = tvAction;
    }

    @Override
    public void execute() {
        tvAction.run();
    }
}

// Receiver interface
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete receiver for a TV
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is now off");
    }

    public void changeChannel() {
        System.out.println("Channel changed");
    }
}

// Concrete receiver for a stereo
class Stereo implements Device {
    @Override
    public void turnOn() {
        System.out.println("Stereo is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is now off");
    }

    public void adjustVolume() {
        System.out.println("Volume adjusted");
    }
}

// Invoker
class RemoteControl {
    private CommandInterface command;

    public void setCommand(CommandInterface command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

// Example usage
public class Command {
    public static void main(String[] args) {
        // Create devices
        TV tv = new TV();
        Stereo stereo = new Stereo();

        // Create command objects
        CommandInterface turnOnTvCommand = new TurnOnCommand(tv::turnOn);
        CommandInterface turnOffTvCommand = new TurnOffCommand(tv::turnOff);
        CommandInterface adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo::adjustVolume);
        CommandInterface changeChannelTvCommand = new ChangeChannelCommand(tv::changeChannel);

        // Create remote control
        RemoteControl remote = new RemoteControl();

        // Set and execute commands
        remote.setCommand(turnOnTvCommand);
        remote.pressButton();  // Outputs: TV is now on

        remote.setCommand(adjustVolumeStereoCommand);
        remote.pressButton();  // Outputs: Volume adjusted

        remote.setCommand(changeChannelTvCommand);
        remote.pressButton();  // Outputs: Channel changed

        remote.setCommand(turnOffTvCommand);
        remote.pressButton();  // Outputs: TV is now off
    }
}