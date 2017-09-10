package singleton;

/**
 * Created by shumishra on 6/12/17.
 */
public class TestSingleton {
    public static void main(String[] args) {
        MySingletonClass mySingletonClass1 = MySingletonClass.getMySingletonClass();
        MySingletonClass mySingletonClass2 = MySingletonClass.getMySingletonClass();
        if(mySingletonClass1 == mySingletonClass2) {
            System.out.println("both are equal : " + mySingletonClass1.toString() + "   " + mySingletonClass2.toString());
        }
    }
}
