# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.19

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\games\LAB29

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\games\LAB29\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/LAB29.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/LAB29.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/LAB29.dir/flags.make

CMakeFiles/LAB29.dir/main.cpp.obj: CMakeFiles/LAB29.dir/flags.make
CMakeFiles/LAB29.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\games\LAB29\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/LAB29.dir/main.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\LAB29.dir\main.cpp.obj -c C:\games\LAB29\main.cpp

CMakeFiles/LAB29.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/LAB29.dir/main.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\games\LAB29\main.cpp > CMakeFiles\LAB29.dir\main.cpp.i

CMakeFiles/LAB29.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/LAB29.dir/main.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\games\LAB29\main.cpp -o CMakeFiles\LAB29.dir\main.cpp.s

CMakeFiles/LAB29.dir/Lab3_STL.cpp.obj: CMakeFiles/LAB29.dir/flags.make
CMakeFiles/LAB29.dir/Lab3_STL.cpp.obj: ../Lab3_STL.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\games\LAB29\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/LAB29.dir/Lab3_STL.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\LAB29.dir\Lab3_STL.cpp.obj -c C:\games\LAB29\Lab3_STL.cpp

CMakeFiles/LAB29.dir/Lab3_STL.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/LAB29.dir/Lab3_STL.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\games\LAB29\Lab3_STL.cpp > CMakeFiles\LAB29.dir\Lab3_STL.cpp.i

CMakeFiles/LAB29.dir/Lab3_STL.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/LAB29.dir/Lab3_STL.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\games\LAB29\Lab3_STL.cpp -o CMakeFiles\LAB29.dir\Lab3_STL.cpp.s

# Object files for target LAB29
LAB29_OBJECTS = \
"CMakeFiles/LAB29.dir/main.cpp.obj" \
"CMakeFiles/LAB29.dir/Lab3_STL.cpp.obj"

# External object files for target LAB29
LAB29_EXTERNAL_OBJECTS =

LAB29.exe: CMakeFiles/LAB29.dir/main.cpp.obj
LAB29.exe: CMakeFiles/LAB29.dir/Lab3_STL.cpp.obj
LAB29.exe: CMakeFiles/LAB29.dir/build.make
LAB29.exe: CMakeFiles/LAB29.dir/linklibs.rsp
LAB29.exe: CMakeFiles/LAB29.dir/objects1.rsp
LAB29.exe: CMakeFiles/LAB29.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\games\LAB29\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable LAB29.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\LAB29.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/LAB29.dir/build: LAB29.exe

.PHONY : CMakeFiles/LAB29.dir/build

CMakeFiles/LAB29.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\LAB29.dir\cmake_clean.cmake
.PHONY : CMakeFiles/LAB29.dir/clean

CMakeFiles/LAB29.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\games\LAB29 C:\games\LAB29 C:\games\LAB29\cmake-build-debug C:\games\LAB29\cmake-build-debug C:\games\LAB29\cmake-build-debug\CMakeFiles\LAB29.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/LAB29.dir/depend

