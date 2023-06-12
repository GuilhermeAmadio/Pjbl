import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Spawner extends Collision {
    private Random random = new Random();
    private ArrayList<DescentObject> objects = new ArrayList<>();
    private ArrayList<EnemyCar> enemyCars = new ArrayList<>();
    private boolean canSpawnEnemy = true, canSpawnGuardrail = true, canSpawnLine = true;
    private long currentTime, cdEnemy, cdEnemyMax = 1700;
    private long cdGuardrail, cdGuardrailMax = 2000;
    private long cdLine, cdLineMax = 2000;

    public Spawner() {
        objects.add(new StreetSigns(211, 211, 211, 80, 490, 25, 100));
        objects.add(new StreetSigns(211, 211, 211, 320, 490, 25, 100));

        objects.add(new StreetSigns(211, 211, 211, 80, 310, 25, 100));
        objects.add(new StreetSigns(211, 211, 211, 320, 310, 25, 100));

        objects.add(new StreetSigns(211, 211, 211, 80, 90, 25, 100));
        objects.add(new StreetSigns(211, 211, 211, 320, 90, 25, 100));

        objects.add(new StreetSigns(255, 255, 0, 200, 490, 15, 100));

        objects.add(new StreetSigns(255, 255, 0, 200, 310, 15, 100));

        objects.add(new StreetSigns(255, 255, 0, 200, 90, 15, 100));
    }

    public void Draw(Graphics2D g2d) {
        for (DescentObject object : objects) {
            if (object.remove == false) {
                object.Draw(g2d);
            }
        }

        for (EnemyCar enemyCar : enemyCars) {
            if (enemyCar.remove == false) {
                enemyCar.Draw(g2d);
            }
        }

        SpawnEnemy();
        SpawnGuardrail();
        SpawnLine();
    }

    void SpawnEnemy() {
        CheckCanSpawnEnemy();

        if (canSpawnEnemy) {
            canSpawnEnemy = false;

            cdEnemy = System.currentTimeMillis();

            int n = random.nextInt(0, 2);
            switch (n) {
                case 0: enemyCars.add(new EnemyCar(255, 0, 0, 50)); break;
                case 1: enemyCars.add(new EnemyCar(255, 0, 0, -50)); break;
            }
        }
    }

    void CheckCanSpawnEnemy() {
        currentTime = System.currentTimeMillis();
        if (currentTime - cdEnemy >= cdEnemyMax) {
            canSpawnEnemy = true;
        }
    }

    void SpawnGuardrail() {
        CheckCanGuardrail();

        if (canSpawnGuardrail) {
            canSpawnGuardrail = false;

            cdGuardrail = System.currentTimeMillis();

            objects.add(new StreetSigns(211, 211, 211, 80, -100, 25, 100));
            objects.add(new StreetSigns(211, 211, 211, 320, -100, 25, 100));
        }
    }

    void CheckCanGuardrail() {
        currentTime = System.currentTimeMillis();
        if (currentTime - cdGuardrail >= cdGuardrailMax) {
            canSpawnGuardrail = true;
        }
    }

    void SpawnLine() {
        CheckCanLine();

        if (canSpawnLine) {
            canSpawnLine = false;

            cdLine = System.currentTimeMillis();

            objects.add(new StreetSigns(255, 255, 0, 200, -100, 15, 100));
        }
    }

    void CheckCanLine() {
        currentTime = System.currentTimeMillis();
        if (currentTime - cdLine >= cdLineMax) {
            canSpawnLine = true;
        }
    }

    public boolean TestColl(int cX, int cY, int cW, int cH) {
        for (EnemyCar enemyCar : enemyCars) {
            if (enemyCar.remove == false && enemyCar.canCollide == true) {
                if (TestCollision(cX, cY, enemyCar.x + enemyCar.offset, enemyCar.y, enemyCar.h)) {
                    enemyCar.canCollide = false;
                    return true;
                }
            }
        }

        return false;
    }
}
