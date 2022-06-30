#ifndef STRING_STRING_H
#define STRING_STRING_H
#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;
class String {
public:
    class String_Iterator;
    String();
    String(const char* str);
    String(const String& a);
    ~String();
    int length();
    char& operator[](const int index);
    String& operator=(const String& a);
    friend String operator+(const String& a, const String& b);
    friend String& operator+=(String& a, const String& b);
    friend bool operator==(const String& a, const String& b);
    friend int compare_str(void const* a, void const* b);
    friend int Find_Word(const String& s, const String& word);
    friend bool Palindrom(const String& s);
    String& erase(const String& b);
    //String& insert(int place, const String& b);
    String& replace(int place, int num_of_chars, const String& b);
    friend String& DelWord(String& s, const String& word);
    friend String& Insert_Word(String& s, const String& s1,const String& s2);
    friend String& Swap_2_word(String& s, const String& s1, const String& s2);
    friend String& Replace_word(String& s, const String& s1, const String& s2);
    friend String& QSort(String& s);
    friend ostream& operator<<(ostream& output, const String& a);
    friend istream& operator>>(istream& input, String& a);
    String_Iterator begin() {
        return string;
    }
    String_Iterator end() {
        return string + size;
    }
    class String_Iterator {
        char* cur;
    public:
        String_Iterator(char* first) : cur(first) {}
        char& operator+(int n) {
            return *(cur + n);
        }
        char& operator-(int n) {
            return *(cur - n);
        }

        char& operator++(int) {
            return *cur++;
        }

        char& operator--(int) {
            return *cur--;
        }

        char& operator++() {
            return *++cur;
        }

        char& operator--() {
            return *--cur;
        }

        bool operator!=(const String_Iterator& it) {
            return (cur != it.cur);
        }
        bool operator==(const String_Iterator& it) {
            return (cur == it.cur);
        }
    } ;
private:
    int size;
    char* string;
};
#endif STRING_STRING_H
