package singleton;

public class MySingletonClass {

    private static MySingletonClass mySingletonClass= new MySingletonClass();

    private MySingletonClass() {}

    public static MySingletonClass getMySingletonClass(){
        return mySingletonClass;
    }
}
