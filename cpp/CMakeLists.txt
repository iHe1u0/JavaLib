cmake_minimum_required(VERSION 3.0.0)
project(javaLib VERSION 0.1.0 LANGUAGES C CXX)

# 查找Java可执行程序并设置JAVA_EXECUTABLE变量
find_program(JAVA_EXECUTABLE java)

if(JAVA_EXECUTABLE)
    # 执行java -XshowSettings:properties命令获取JAVA_HOME路径
    execute_process(
        COMMAND "${JAVA_EXECUTABLE}" -XshowSettings:properties
        OUTPUT_VARIABLE java_settings
        ERROR_QUIET
        RESULT_VARIABLE result
    )
    
    if(result EQUAL 0)
        # 解析输出以获取JAVA_HOME路径
        string(REGEX MATCH "java.home[ ]+=[^\n]+" java_home_line "${java_settings}")
        
        if(java_home_line)
            string(REGEX REPLACE "java.home[ ]+=" "" JAVA_HOME ${java_home_line})
            message("JAVA_HOME: ${JAVA_HOME}")
        else()
            message("无法解析JAVA_HOME")
        endif()
    else()
        message("无法执行java命令")
    endif()
else()
    message("无法找到Java可执行程序")
endif()

include_directories("C:/Java/jdk-11.0.2/include")
include_directories("C:/Java/jdk-11.0.2/include/win32")

add_library(javaLib SHARED javaLib.cpp)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
