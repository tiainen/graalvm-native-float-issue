# graalvm-native-float-issue
Sample to demonstrate issue with passing floats from JNI to Java with GraalVM native-image on the Windows platform.

Steps to reproduce after cloning this repository (run inside a `x64 Native Tools Command Prompt`):

    C:> "%JAVA_HOME%\bin\javac" -d build\classes -h build\jni --release 11 Main.java Simple.java
    C:> cl /Ibuild\jni /I"%JAVA_HOME%\include" /I"%JAVA_HOME%\include\win32" /LD simple_generator.cpp
    C:> "%GRAALVM_HOME%\bin\native-image.cmd" -classpath build\classes -H:JNIConfigurationFiles=jniconfig.json Main
    C:> main.exe

`JAVA_HOME` should point to JDK 11 or later.
`GRAALVM_HOME` should point to GraalVM 20.2-dev.
