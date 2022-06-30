#ifndef STRINGSET_STRING_H
#define STRINGSET_STRING_H

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class StringException {
public:
    StringException(std::string error) : m_error(error) {}
    const char* getError() {
        return m_error.c_str();
    }
private:
    std::string m_error;
};

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
    friend string StrToS(String& a);
    friend String operator+(const String& a, const String& b);
    friend String& operator+=(String& a, const String& b);
    friend bool operator==(const String& a, const String& b);
    friend int compare_str(void const* a, void const* b);
    friend int Find_Word(const String& s, const String& word);
    friend int Find_Word_pos(int position, const String& s, const String& word);
    friend bool Palindrom(const String& s);
    friend String& MakePalindrom(String& s);
    String String_to_Digit();
    String& erase(const String& b);
    String& erase_pos(int position, const String& b);
    String& insert(int place, const String& b);
    String& replace(int place, int num_of_chars, const String& b);
    friend String reverse(String& a);
    friend String& Insert_Word(String& s, const String& s1, const String& s2);
    friend String& Swap_2_word(String& s, const String& s1, const String& s2);
    friend String& Replace_word(String& s, const String& s1, const String& s2);
    friend String& Sort(String& s);
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
    };
private:
    int size;
    char* string;
};

#endif //STRINGSET_STRING_H
