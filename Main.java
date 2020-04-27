public class Main {

    static {
        System.loadLibrary("simple_generator");
    }

    private static native Simple constructNatively();

    public static void main(String[] args) {
        Simple simpleFromJvm = new Simple(true, 'a', (byte) 23, 40199921, 1234567890L, 0.303148390148931, 1.0f, (short) 1241);
        Simple simpleFromJni = constructNatively();
        System.out.println("Simple from JVM: " + simpleFromJvm);
        System.out.println("Simple from JNI: " + simpleFromJni);
    }
}

