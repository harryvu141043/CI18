package game.enemy;

import game.GameObject;

public class EnemySummoner extends GameObject {
    public EnemySummoner(){ }
    int count=0;



    @Override
    public void run() {
        super.run ();
        count++;
        if(count>80){
            Enemy enemy=GameObject.recycle ( Enemy.class );
            count=0;
        }
        System.out.println (GameObject.objects.size ());
    }

}
