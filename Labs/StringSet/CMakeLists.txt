cmake_minimum_required(VERSION 3.19)
project(StringSet)

set(CMAKE_CXX_STANDARD 14)

add_executable(StringSet main.cpp Set.h String.h Set.cpp String.cpp)