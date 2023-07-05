cmake_minimum_required(VERSION 3.0.0)
project(javaLib VERSION 1.0.0 LANGUAGES C CXX)

# Jni header
if(NOT DEFINED ENV{JAVA_HOME})
    message(FATAL_ERROR "please set JAVA_HOME")
endif()
include_directories("$ENV{JAVA_HOME}/include" "$ENV{JAVA_HOME}/include/win32")
include_directories("../include" "./include" ".")

add_library(javaLib SHARED javaLib.cpp)

set(LIBRARY_OUTPUT_PATH ${PROJECT_BINARY_DIR}/../lib)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
