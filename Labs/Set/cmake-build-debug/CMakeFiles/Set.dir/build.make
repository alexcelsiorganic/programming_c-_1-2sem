# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

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

# Suppress display of executed commands.
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
CMAKE_SOURCE_DIR = C:\games\Set

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\games\Set\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Set.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Set.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Set.dir/flags.make

CMakeFiles/Set.dir/main.cpp.obj: CMakeFiles/Set.dir/flags.make
CMakeFiles/Set.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\games\Set\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Set.dir/main.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Set.dir\main.cpp.obj -c C:\games\Set\main.cpp

CMakeFiles/Set.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Set.dir/main.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\games\Set\main.cpp > CMakeFiles\Set.dir\main.cpp.i

CMakeFiles/Set.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Set.dir/main.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\games\Set\main.cpp -o CMakeFiles\Set.dir\main.cpp.s

CMakeFiles/Set.dir/Set.cpp.obj: CMakeFiles/Set.dir/flags.make
CMakeFiles/Set.dir/Set.cpp.obj: ../Set.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\games\Set\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/Set.dir/Set.cpp.obj"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Set.dir\Set.cpp.obj -c C:\games\Set\Set.cpp

CMakeFiles/Set.dir/Set.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Set.dir/Set.cpp.i"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\games\Set\Set.cpp > CMakeFiles\Set.dir\Set.cpp.i

CMakeFiles/Set.dir/Set.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Set.dir/Set.cpp.s"
	C:\PROGRA~2\MINGW-~1\I686-8~1.0-P\mingw32\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\games\Set\Set.cpp -o CMakeFiles\Set.dir\Set.cpp.s

# Object files for target Set
Set_OBJECTS = \
"CMakeFiles/Set.dir/main.cpp.obj" \
"CMakeFiles/Set.dir/Set.cpp.obj"

# External object files for target Set
Set_EXTERNAL_OBJECTS =

Set.exe: CMakeFiles/Set.dir/main.cpp.obj
Set.exe: CMakeFiles/Set.dir/Set.cpp.obj
Set.exe: CMakeFiles/Set.dir/build.make
Set.exe: CMakeFiles/Set.dir/linklibs.rsp
Set.exe: CMakeFiles/Set.dir/objects1.rsp
Set.exe: CMakeFiles/Set.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\games\Set\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable Set.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Set.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Set.dir/build: Set.exe

.PHONY : CMakeFiles/Set.dir/build

CMakeFiles/Set.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Set.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Set.dir/clean

CMakeFiles/Set.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\games\Set C:\games\Set C:\games\Set\cmake-build-debug C:\games\Set\cmake-build-debug C:\games\Set\cmake-build-debug\CMakeFiles\Set.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Set.dir/depend

