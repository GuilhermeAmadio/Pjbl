abstract public class Collision {
    public boolean TestCollision(int x1, int y1, int x2, int y2, int h2) {
        if (x1 == x2 && y1 + 30 >= y2 - h2 && y1 - 30 <= y2 + h2) {
            return true;
        }

        return false;
    }
}
