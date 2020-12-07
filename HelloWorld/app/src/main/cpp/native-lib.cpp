//
// Created by Edward on 07/12/2020.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jboolean JNICALL
Java_id_ac_ui_cs_mobileprogramming_edwardpga_helloworld_MainActivity_checkColorInt(
        JNIEnv *env,
        jobject,
        jint currentColorInt,
        jint standardColorInt) {
    return (currentColorInt == standardColorInt);
}