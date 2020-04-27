#include <jni.h>
#include "Main.h"

JNIEXPORT jobject JNICALL Java_Main_constructNatively(JNIEnv *env, jclass cls) {
    jclass simpleCls = env->FindClass("Simple");
    if (env->ExceptionOccurred() || !simpleCls) {
        fprintf(stderr, "Could not load class 'Simple'\n");
        return NULL;
    }

    jmethodID init = env->GetMethodID(simpleCls, "<init>", "(ZCBIJDFS)V");
    if (env->ExceptionOccurred() || !init) {
        fprintf(stderr, "Could not load method 'Simple.<init>'\n");
        return NULL;
    }

    jobject simple = env->NewObject(simpleCls, init, JNI_TRUE, 'a', 23, 40199921,
        1234567890LL, 0.303148390148931, 1.0f, 1241);
    if (env->ExceptionOccurred() || !simple) {
        fprintf(stderr, "Could not create instance of 'Simple'\n");
        return NULL;
    }

    return simple;
}

