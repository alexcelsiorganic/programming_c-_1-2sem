cmake_minimum_required(VERSION 3.17)
project(DOP_2_6)

set(CMAKE_CXX_STANDARD 20)

add_executable(DOP_2_6 main.cpp Moon.cpp Moon.h Planet.cpp Planet.h Star.cpp Star.h Galaxy.cpp Galaxy.h)