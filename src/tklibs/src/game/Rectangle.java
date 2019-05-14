package game;

public class Rectangle {
    public Vector2D position;
    public int width;
    public int height;

    public Rectangle() {
        this(new Vector2D (0, 0), 1, 1);
    }

    public Rectangle(double x, double y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * @param other: the rectangle need to check intersects with this rectangle
     * @return
     */

    public boolean intersects(Rectangle other) {
//        left=x
//        top=y
//        right=x+width
//         bottom=y+height
        return this.right ()>=other.left () &&
                this.left ()<=other.right ()&&
                this.bottom ()>=other.top ()&&
                this.top()<=other.bottom ();
//        TODO: 1. remove default return statement and fill logic check intersects 'this' and 'other'
        //return false;
//        game.Rectangle rec = new game.Rectangle(position,width,height);


//        game.Rectangle rec=new game.Rectangle(this.position,this.width,this.height);
//        if ((rec.position.x <= other.position.x && other.position.x <= rec.width + rec.position.x)
//                &&
//                (rec.position.y <= other.position.y && other.position.y <= rec.position.y + rec.height)
//        ) {
//            System.out.println(rec.width);
//
//            System.out.println(rec.position.x);
//            System.out.println(other.position.x);
//            return true;
//        } else {
//            return false;
//
//        }

}
    double top(){
        return this.position.y;
    }
    double bottom(){
        return this.top ()+this.height;
    }
    double left(){
        return this.position.x;
    }
    double right(){
        return this.left ()+this.width;
    }

    public static void main(String[] args) {
        // TODO: 2. Run this file to test the result
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(3, 3, 5, 5);
        Rectangle rect3 = new Rectangle(6, 6, 5, 5);

        System.out.println(rect1.intersects(rect2) + " - " + true);
        System.out.println(rect2.intersects(rect3) + " - " + true);
        System.out.println(rect1.intersects(rect3) + " - " + false);
        // the result must be:
        // true - true
        // true - true
        // false - false
    }
}
