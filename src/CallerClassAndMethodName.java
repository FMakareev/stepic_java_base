public class CallerClassAndMethodName {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        Thread current = Thread.currentThread();
        StackTraceElement[] methods = current.getStackTrace();
        //в этом случае в массиве использовать 3е значение:
        if (methods.length > 3) return methods[3].getClassName() + "#" + methods[3].getMethodName();

        return null;
    }
}
