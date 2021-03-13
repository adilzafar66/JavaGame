package tiles;

public class TileDir {

    public static Tiles[] tiles = new Tiles[256];
    public static Tiles dirtTile = new DirtTile(6);
    public static Tiles skyTile = new SkyTile(5);
    public static Tiles cloudTile3 = new CloudTile3(9);
    public static Tiles cloudTile2 = new CloudTile2(8);
    public static Tiles cloudTile = new CloudTile(4);
    public static Tiles grassMidTile = new GrassMidTile(3);
    public static Tiles grassTile = new GrassTile(2);
    public static Tiles gravelTile = new GravelTile(1);
    public static Tiles emptyTile = new EmptyTile(0);

}
