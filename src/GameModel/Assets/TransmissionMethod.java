package GameModel.Assets;

import java.util.ArrayList;

public class TransmissionMethod
{
    private String name;
    private int capacity;
    private static ArrayList<TransmissionMethod> transmissionMethodArrayList = new ArrayList<>();

    public TransmissionMethod(String name, int capacity)
    {
        this.name = name;
        this.capacity = capacity;
    }

    public int GetCapacity()
    {
        return capacity;
    }

    public String GetName()
    {
        return name;
    }
    public static ArrayList<TransmissionMethod> GetTransPaths()
    {
        return transmissionMethodArrayList;
    }

    @Override
    public String toString()
    {
        return "Transmission Method: " + name +
                ", Viruses per second: " + capacity;
    }
}
