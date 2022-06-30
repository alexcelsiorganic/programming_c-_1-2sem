#include <iostream>
#include <algorithm>
#include <sstream>
#include "String.h"
using namespace std;

String::String() : size(0) {
    string = new char[size];

}
String::String(const char* str) : size(strlen(str)) {
    string = new char[size + 1];
    for (int i = 0; i < size; i++) {
        string[i] = str[i];
    }
    string[size] = '\0';
}
String::String(const String& a) : size(a.size) {
    string = new char[size + 1];
    for (int i = 0; i < size; i++) {
        string[i] = a.string[i];
    }
    string[size] = '\0';
}
String::~String() {
    delete[] string;
}
int String::length() {
    return size;
}
char& String::operator[](const int index) {
    return string[index];
}
String& String::operator=(const String& a) {
    if (this != &a) {
        delete[] string;
        size = a.size;
        string = new char[size + 1];
        for (int i = 0; i < size; i++) {
            string[i] = a.string[i];
        }
        string[size] = '\0';
    }
    return *this;
}
String operator+(const String& a, const String& b) {
    String sum;
    sum.size = a.size + b.size;
    delete[] sum.string;
    sum.string = new char[sum.size + 1];
    for (int i = 0; i < a.size; i++) {
        sum[i] = a.string[i];
    }
    for (int i = 0; i < b.size; i++) {
        sum[a.size + i] = b.string[i];
    }
    sum[sum.size] = '\0';
    return sum;
}
String& operator+=(String& a, const String& b) {
    int new_size = a.size + b.size;
    String temp(a);
    delete[] a.string;
    a.size = new_size;
    a.string = new char[a.size];
    for (int i = 0; i < temp.size; i++) {
        a.string[i] = temp.string[i];
    }
    for (int i = 0; i < b.size; i++) {
        a.string[temp.size + i] = b.string[i];
    }
    return a;
}
bool operator==(const String& a, const String& b) {
    return (a.string == b.string);
}
int compare_str(void const* a, void const* b) {
    char const* aa = (char const*)a;
    char const* bb = (char const*)b;
    if (*aa == *bb) {
        return 0;
    }
    else if (*aa > *bb) {
        return 1;
    }
    else {
        return -1;
    }
}
int Find_Word(const String& s, const String& word) {//искать слово в строке
    int n;
    try {
        if (s.size < word.size) {
            throw StringException("String size can't be less than word size");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
    int count = 0;
    for (int i = 0; i < s.size; i++) {
        if (s.string[i] == word.string[count]) {
            count++;
        }
        if (count == word.size && s.string[i] != word.size) {
            return i - count + 1;
        }
    }
    return -1;
}
int Find_Word_pos(int position, const String& s, const String& word) { //искать слово, начиная с position
    int n;
    try {
        if (s.size < word.size) {
            throw StringException("String size can't be less than word size");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
    int count = 0;
    for (int i = position; i < s.size; i++) {
        if (s.string[i] == word.string[count]) {
            count++;
        }
        if (count == word.size && s.string[i] != word.size) {
            return i - count + 1;
        }
    }
    return -1;
}
bool Palindrom(const String& s) {//проверка, является ли палиндромом
    cout << boolalpha;
    String s1 = s;
    for (int i = 0; i < s1.size; i++) {
        s1[i] = s1[s1.size - i];
    }
    if (s1 == s) {
        return true;
    }
    else {
        return false;
    }
}
String& String::erase(const String& word) { //удаление слова из строки
    try {
        if (word.size > size) {
            throw StringException("ERROR! A word size can't be more than string size");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
    int pos = Find_Word(*this ,word);
    try {
        if (pos == -1) {
            throw StringException("This word not found");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
    int new_size =  size - strlen(word.string);
    char* str_er = new char[new_size + 1];
    for (int i = 0; i < pos; i++) {
        str_er[i] = string[i];
    }
    int pos1 = pos;
    pos += strlen(word.string);
    for (int i = 0; i < size - pos; i++) {
        str_er[pos1 + i] = string[pos + i];
    }
    str_er[size - strlen(word.string)] = '\0';
    String str(str_er);
    *this = str;
    return *this;
}
String& String::erase_pos(int position, const String& word) { //удаление слова из строки, начиная с определенного символа
    try {
        if (word.size > size) {
            throw StringException("ERROR! A word size can't be more than string size");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
    int pos = Find_Word_pos(position, *this ,word);
    try {
        if (pos == -1) {
            throw StringException("This word not found");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
        int new_size = size - strlen(word.string);
        char *str_er = new char[new_size + 1];
        for (int i = 0; i < pos; i++) {
            str_er[i] = string[i];
        }
        int pos1 = pos;
        pos += strlen(word.string);
        for (int i = 0; i < size - pos; i++) {
            str_er[pos1 + i] = string[pos + i];
        }
        str_er[size - strlen(word.string)] = '\0';
        String str(str_er);
        delete[] str_er;
        *this = str;
        return *this;
}
String& String::insert(int place, const String& word) {//вставка слова в позицию place
    try {
        if (place > size) {
            throw StringException("ERROR! A place can't be more than size");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
	char* start = new char[place + 1];
	for (int i = 0; i < place; i++) {
	    start[i] = string[i];
	}
    start[place] = '\0';
	String start_string(start);
    char* finish = new char[size - place + 1];
    for (int i = place; i < size; i++) {
        finish[i - place] = string[i];
    }
    finish[size - place] = '\0';
    String finish_string(finish);
    start_string += word;
    start_string += finish_string;
    *this = start_string;
	delete[] start;
	delete[] finish;
	return *this;
}
String& String::replace(int place, int num_of_chars, const String& word) { //заменить num_of_chars символов строки на num_of_chars word
    char *tchar_er = new char[num_of_chars + 1];
    char *tchar_ins = new char[num_of_chars + 1];
    for (int i = 0; i < num_of_chars; i++) {
        tchar_er[i] = string[place + i];
    }
    tchar_er[num_of_chars] = '\0';
    String temp_er(tchar_er);
    erase(temp_er);
    for (int i = 0; i < num_of_chars; i++) {
        tchar_ins[i] = word.string[i];
    }
    tchar_ins[num_of_chars] = '\0';
    String temp_ins(tchar_ins);
    insert(place, temp_ins);
    delete[] tchar_er;
    delete[] tchar_ins;
    return *this;
}
String& Insert_Word(String& s, const String& s1, const String& s2) { //вставить одно слово после другого
    int n = Find_Word(s, s1);
    try {
        if (n == -1) {
            throw StringException("This word not found");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
        n += s1.size;
        char sp[2] = " ";
        String space(sp);
        s.insert(n, s2);
        s.insert(n, sp);
    return s;
}
String& Replace_word(String& s, const String& s1, const String& s2) { //замена 1 слова на другое
    int n1 = Find_Word(s, s1);
    try {
        if (n1 == -1) {
            throw StringException("This word not found");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
        if (s1.size != s2.size) {
            s.erase(s1);
            s.insert(n1, s2);
        } else {
            s.replace(n1, s2.size, s2);
        }
        return s;
}

String& Swap_2_word(String& s, const String& s1, const  String& s2) { // перестановка 2 слов
    Replace_word(s, s1, s2);
    int n2 = Find_Word_pos(s2.size, s, s2);
    try {
        if (n2 == -1) {
            throw StringException("This word not found");
        }
    }
    catch (StringException& exception) {
        cerr << "An set exception occurred (" << exception.getError() << ")\n";
        exit(1);
    }
       s.erase_pos(s2.size, s2);
        s.insert(n2, s1);
    return s;
}
String String::String_to_Digit() {
    String temp;
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (isdigit(string[i])) {
            while (isdigit(string[i]) && i < size) {
                count++;
                i++;
            }
        }
    }
    char *numbr = new char[count + 1];
    count = 0;
    for (int i = 0; i < size; i++) {
        if (isdigit(string[i])) {
            while (isdigit(string[i]) && i < size) {
                numbr[count] = string[i];
                count++;
                i++;
            }
        }
    }
    numbr[count]  = '\0';
    String number(numbr);
    return number;
}
String& Sort(String & s) {
    string temp = static_cast<string>(s.string);
    int count = 0; // колво пробелов
    for(int i = 0; i < temp.length(); i++) {
        if(temp[i] == ' ') {
            count++;
        }
    }
    string words[count + 1];
    count = 0;
    int word_begin = 0;
    int word_end = 0;
    for (int i = 0; i < temp.length(); i++) {
        if(temp[i] == ' ' || i == temp.length() - 1) {
            word_end = i;
            for(int j = word_begin; j < word_end; j++) {
                words[count] += temp[j];
                if (j == word_end - 1 && i == temp.length() - 1) {
                    words[count] += temp[j + 1];
                }
            }
            count++;
            word_begin = word_end +1;
        }
    }
    string tmp = " ";
    for(int i = 0 ;i < count; i++) {
        for (int j = i; j < count; j++) {
            if (words[i] > words[j]) {
                tmp = words[i];
                words[i] = words[j];
                words[j] = tmp;
            }
        }
    }
    temp = "";
    for(int i = 0; i < count; i++) {
        temp += words[i]+ " ";
    }
    String a(temp.c_str());
    s = a;
    return s;
}
ostream& operator<<(ostream& output, const String& a) {
    for (int i = 0; i < a.size; i++) {
        output << a.string[i];
    }
    output << endl;
    return output;
}
istream& operator>>(istream& input, String& a) {
    for (int i = 0; i < a.size; i++) {
        input >> a.string[i];
    }
    return input;
}