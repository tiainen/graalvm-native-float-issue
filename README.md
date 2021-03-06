# graalvm-native-float-issue
Sample to demonstrate issue with passing floats from JNI to Java with GraalVM native-image on the Windows platform.

Steps to reproduce after cloning this repository (run inside a `x64 Native Tools Command Prompt`):

`JAVA_HOME` should point to JDK 11 or later.
`GRAALVM_HOME` should point to GraalVM 20.2-dev.

    C:> "%JAVA_HOME%\bin\javac.exe" -d build\classes -h build\jni --release 11 Main.java Simple.java
    C:> cl /Ibuild\jni /I"%JAVA_HOME%\include" /I"%JAVA_HOME%\include\win32" /LD simple_generator.cpp
    C:> "%GRAALVM_HOME%\bin\native-image.cmd" -classpath build\classes -H:JNIConfigurationFiles=jniconfig.json Main
    C:> "%JAVA_HOME%\bin\java.exe" -classpath build\classes Main
    C:> main.exe

### Output for `java.exe` is:

    Simple from JVM: Simple:
            aBoolean=true
            aChar=a
            aByte=23
            anInt=40199921
            aLong=1234567890
            aDouble=0.303148390148931
            aFloat=1.0
            aShort=1241
    Simple from JNI: Simple:
            aBoolean=true
            aChar=a
            aByte=23
            anInt=40199921
            aLong=1234567890
            aDouble=0.303148390148931
            aFloat=1.0
            aShort=1241

### Output for `main.exe` is:

    Simple from JVM: Simple:
            aBoolean=true
            aChar=a
            aByte=23
            anInt=40199921
            aLong=1234567890
            aDouble=0.303148390148931
            aFloat=1.0
            aShort=1241
    Simple from JNI: Simple:
            aBoolean=true
            aChar=a
            aByte=23
            anInt=40199921
            aLong=1234567890
            aDouble=0.303148390148931
            aFloat=0.0
            aShort=1241

Notice that the value for `aFloat`, from the Simple instance generated by JNI, is __0.0f__ instead of the expected __1.0f__.
