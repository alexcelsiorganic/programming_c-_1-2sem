
#ifndef STRINGSET_SET_H
#define STRINGSET_SET_H
#pragma once
#define _CRT_SECURE_NO_WARNINGS


#include <iostream>
#include <cstring>
#include <fstream>
#include <string>
using namespace std;

class SetException {
public:
    SetException(string error) : m_error(error) {}
    const char* getError() {
        return m_error.c_str();
    }
private:
    string m_error;
};

class Set {
public:
    Set();
    Set(char* a);
    Set(string a);
    Set(const Set& a);
    ~Set();
    Set& Adds(char symbol);
    Set& Rems(char symbol);
    Set& operator=(const Set& a);
    friend bool Belongs(const Set& a, char symbol);
    friend Set operator&(const Set& a, const Set& b);
    friend Set operator^(const Set& a, const Set& b);
    friend Set operator|(const Set& a, const Set& b);
    friend bool operator==(const Set& a, const Set& b);
    friend bool operator>(const Set& a, const Set& b);
    friend bool operator<(const Set& a, const Set& b);
    friend ostream& operator<<(ostream& output, const Set& b);

private:
    char* set;
    int size;
};


#endif //STRINGSET_SET_H
