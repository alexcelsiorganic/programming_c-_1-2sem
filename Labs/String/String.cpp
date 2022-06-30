#include <iostream>
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
        string = new char[size];
        for (int i = 0; i < size; i++) {
            string[i] = a.string[i];
        }
    }
    return *this;
}
String operator+(const String& a, const String& b) {
    String sum;
    sum.size = a.size + b.size;
    delete[] sum.string;
    sum.string = new char[sum.size];
    for (int i = 0; i < a.size; i++) {
        sum[i] = a.string[i];
    }
    for (int i = 0; i < b.size; i++) {
        sum[a.size + i] = b.string[i];
    }
    return sum;
}
String& operator+=(String& a, const String& b) {
    int new_size = a.size + b.size;
    String temp(a);
    delete[] a.string;
    a.size = new_size;
    a.string = new char[new_size];
    for (int i = 0; i < a.size; i++) {
        a.string[i] = temp.string[i];
    }
    for (int i = a.size; i < new_size; i++) {
        a.string[i] = b.string[i];
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
int Find_Word(const String& s, const String& word) {
    int n;
    try {
        if (s.size < word.size) {
            throw - 1;
        }
    }
    catch (int a) {
        cerr << "String size can't be less than word size";
    }
    int count = 0;
    for (int i = 0; i < s.size; i++) {
        if (s.string[i] == word.string[count]) {
            count++;
        }
        if (count == word.size && s.string[i] != word.size) {
            return i - count;
        }
    }
    return 0;
}
bool Palindrom(const String& s) {
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
String& String::erase(const String& word) {
    int a = Find_Word(*this ,word);
    String str;
    for (int i = 0; i < a; i++) {
        str[i] = string[i];
    }
    a += strlen(word.string);
    for (int i = a; i < size; i++) {
        str[i] = string[i];
    }
    *this = str;
    return *this;
}
/*String& String::insert(int place, const String& word) {
	int a = Find_Word(*this, word);
	String str("");
	try {
		if (a > size) {
			throw -199;
		}
	}
	catch (int a) {
	cerr << "Error";
	}
	str
		str += word;
	this->string = str.string;
	return *this;
}
*/
String& String::replace(int place, int num_of_chars, const String& word) {
    if (num_of_chars > word.size)
        *this += word;
    erase(word);
    char* tchar_er = new char[num_of_chars];
    char* tchar_ins = new char[num_of_chars];
    for (int i = place; i < place + num_of_chars; i++) {
        tchar_er[i] = string[i];
    }
    String temp_er(tchar_er);
    erase(temp_er);
    for (int i = 0; i < num_of_chars; i++) {
        tchar_ins[i] = word.string[i];
    }
    String temp_ins(tchar_ins);
    insert(place, temp_ins);
    delete[] tchar_er;
    delete[] tchar_ins;
    return *this;
}
String& DelWord(String& s, const String& word) {
    int n = Find_Word(s, word);
    s.erase(word);
    return s;
}
String& Insert_Word(String& s, const String& s1, const String& s2) {
    int n = Find_Word(s, s1);
    n += s1.size;
    char sp[2] = " ";
    String space(sp);
    s.insert(n, s2);
    s.insert(n, sp);
    return s;
}
String& Swap_2_word(String& s, const String& s1, const  String& s2)
{
    int n = Find_Word(s, s1);
    s.replace(n, s.size , s2);
    n = Find_Word(s, s2);
    s.replace(n, s1.size, s1);
    return s;
}
String& Replace_word(String& s, const String& s1, const String& s2) {
    int n = Find_Word(s, s1);
    s.replace(n, s2.size, s2);
    return s;
}

String& QSort(String & s) {
    qsort(s.string, s.size, sizeof(s[0]), compare_str);
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