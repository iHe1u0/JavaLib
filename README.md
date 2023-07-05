# JavaLib

A sample project for Java and C++.

## Getting Started

- run `javac -h ./include/ ./src/App.java -d ./bin/` to generate Jni header.
- run cmake.
- run Java program.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `include`: the folder for JNI header files.
- `cpp`: the folder for C or C++ sources.

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.
