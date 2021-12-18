package GameModel.Assets;

import java.util.ArrayList;

public class Connections
{
    private boolean OpenClose;
    private Country a;
    private Country b;
    private TransmissionMethod path;
    private static ArrayList<Connections> connectionsList= new ArrayList<>();

    public Connections(Country a, Country b, TransmissionMethod path)
    {
        this.a = a;
        this.b = b;
        this.path = path;
        Open();
        connectionsList.add(this);
    }
    public void Open()
    {
        OpenClose = true;
    }
    public void Close()
    {
        OpenClose = false;
    }

    public boolean GetOpenClose()
    {
        return OpenClose;
    }

    public static ArrayList<Connections> GetConnectionsList()
    {
        return connectionsList;
    }

    public TransmissionMethod GetPath()
    {
        return path;
    }
    public String GetPathName() { return path.GetName();}

    public Country GetCountryA()
    {
        return a;
    }

    public Country GetCountryB()
    {
        return b;
    }
}
