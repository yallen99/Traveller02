package core.game_engine;
import java.util.ArrayList;
import processing.core.PApplet;

public class ObjectManager {
    public PApplet parent;
    public ObjectManager(PApplet p){
        this.parent = p; }

        public ArrayList objects = new ArrayList(0);

        public void AddObjectToList(){
        objects.add(1);
        }

    public void SubtractLastObject(){
        objects.remove(1);
    }

    public void ClearAll(){
            objects.clear();
    }
}
