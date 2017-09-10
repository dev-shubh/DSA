package singleton;

/**
 * Created by shumishra on 6/12/17.
 */
public class MySingletonClass {
    private static MySingletonClass mySingletonClass= new MySingletonClass();

    private MySingletonClass() {}

    public static MySingletonClass getMySingletonClass(){
        return mySingletonClass;
    }

}
