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
CMAKE_SOURCE_DIR = C:\games\WINAPI

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\games\WINAPI\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/WINAPI.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/WINAPI.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/WINAPI.dir/flags.make

CMakeFiles/WINAPI.dir/main.cpp.obj: CMakeFiles/WINAPI.dir/flags.make
CMakeFiles/WINAPI.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\games\WINAPI\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/WINAPI.dir/main.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\WINAPI.dir\main.cpp.obj -c C:\games\WINAPI\main.cpp

CMakeFiles/WINAPI.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/WINAPI.dir/main.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\games\WINAPI\main.cpp > CMakeFiles\WINAPI.dir\main.cpp.i

CMakeFiles/WINAPI.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/WINAPI.dir/main.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\games\WINAPI\main.cpp -o CMakeFiles\WINAPI.dir\main.cpp.s

# Object files for target WINAPI
WINAPI_OBJECTS = \
"CMakeFiles/WINAPI.dir/main.cpp.obj"

# External object files for target WINAPI
WINAPI_EXTERNAL_OBJECTS =

WINAPI.exe: CMakeFiles/WINAPI.dir/main.cpp.obj
WINAPI.exe: CMakeFiles/WINAPI.dir/build.make
WINAPI.exe: CMakeFiles/WINAPI.dir/linklibs.rsp
WINAPI.exe: CMakeFiles/WINAPI.dir/objects1.rsp
WINAPI.exe: CMakeFiles/WINAPI.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\games\WINAPI\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable WINAPI.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\WINAPI.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/WINAPI.dir/build: WINAPI.exe

.PHONY : CMakeFiles/WINAPI.dir/build

CMakeFiles/WINAPI.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\WINAPI.dir\cmake_clean.cmake
.PHONY : CMakeFiles/WINAPI.dir/clean

CMakeFiles/WINAPI.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\games\WINAPI C:\games\WINAPI C:\games\WINAPI\cmake-build-debug C:\games\WINAPI\cmake-build-debug C:\games\WINAPI\cmake-build-debug\CMakeFiles\WINAPI.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/WINAPI.dir/depend

