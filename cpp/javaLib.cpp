#include <iostream>
#include <jni.h>
#include "App.h"

void say_hello()
{
    std::cout << "Hello, from javaLib!\n";
}

JNIEXPORT void JNICALL Java_App_sayHello(JNIEnv *, jclass)
{
    say_hello();
}