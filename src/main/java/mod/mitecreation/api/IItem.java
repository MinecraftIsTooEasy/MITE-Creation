package mod.mitecreation.api;

public interface IItem {
    default int getCookTime(int heat_level) {
        return 0;
    }
}
