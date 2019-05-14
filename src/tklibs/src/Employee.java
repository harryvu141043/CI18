import game.Vector2D;

import java.util.ArrayList;

public class Employee extends Human {
    public static void main(String[] args) {
        ArrayList<Vector2D> vectors=new ArrayList<> ();
        try {
            doSomething ( 1 );
            doSomething ( 0 );
            doSomething ( -1 );
        }catch (Exception ex){
            System.out.println (ex.getMessage ());
        }finally {
            System.out.println ("final");
        }
        System.out.println ("continue");
//        try {
//            dosomething ();
//        }catch (Exception ex){
////            System.out.println (ex.getMessage ());
//            ex.printStackTrace ();
        }
//        System.out.println ("continue..");
        //.add(),.remove(),.size(),.get()
//        vectors.add ( new Vector2D ( 1,1 ) );
//        vectors.add ( new Vector2D ( 3.4,2 ) );
//        vectors.add ( new Vector2D ( 2,1 ) );
//        vectors.add ( new Vector2D ( 3,5 ) );
//        vectors.add ( new Vector2D ( 5,10 ) );
//        double maxTotal=0;
//        int indexmax=0;
//
//        for(int i=0;i<vectors.size ();i++){
//            Vector2D vector=vectors.get ( i );
//            System.out.println (vector.x+" "+vector.y);
//            if(vector.x+vector.y>maxTotal){
//                maxTotal=vector.x+vector.y;
//                indexmax=i;
//            }
//        }
//        System.out.println (vectors.get (indexmax).x+vectors.get ( indexmax ).y);
//        for (Vector2D vector:vectors){
//            System.out.println (vector);
//            }
//        }
        public static void doSomething(int input) throws Exception{
            if(input>0){
                System.out.println ("okay");
            }
            else {
                if(input==0){
                    throw new Exception ( "not okay" );
                }
                else {
                    System.out.println ("okay");
                }
            }
        }
    }

