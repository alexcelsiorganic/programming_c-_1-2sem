#ifndef LAB29_LAB3_STL_H
#define LAB29_LAB3_STL_H
/*
 * Выполняем задания 1 семестра лаб3  по массивам и  лаб4  по матрицам с использованием стандартного класса-шаблона <vector>.
Создаем свой класс с методом решения задачи и пишем в классе вызов  готовых стандартных функции выполняющих:
1.	добавление (в конец, середину по индексу),
2.	удаление элементов,
3.	изменение элементов;
4.	сортировку (использовать алгоритм);
5.	частичной сортировки (использовать алгоритм);
6.	бинарного поиска в отсортированном векторе (использовать алгоритм);
7.	сравнение (поиск вектора в векторе),
8.	копирование (во второй вектор);
9.	объединение  векторов (использовать алгоритм);
10.	вычисления суммы элементов (использовать алгоритм);
11.	. вычисления произведения элементов (использовать алгоритм);
12.	использовать итераторы
13.	использовать итераторы вывода (ostream_iterator).

 */
#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <numeric>

using namespace std;

void PushBack(vector<int>& a, int num); //добавление в конец

void Push(vector<int>& a, int num, int index);//вставка в позицию

void Erase(vector<int>& a, int num);//удаление элемента


void Change(vector<int> &a, int old_value, int new_value);//изменение значения элемента

void Dupl(vector<int>& a);//удаление дублей


void Sort(vector<int> &a);//сортировка


void SortRange(vector<int>& a,  int startSort , int endSort);// частичная сортировка

void BinarySearch(vector<int>& a, int find_value);//бинарный поиск


void SearchV1InV2(vector<int>& b);//поиск 1 вхождения 1 вектора во 2

void CopyV1ToV2(vector<int>& a1, vector<int>& a2);//копирование 1 вектора во 2

void UniqueVectors(vector<int>& a1, vector<int>& a2);//объединение векторов


int SumOfElements(vector<int>& a);//сумма элементов

void UsingOfIterators(vector<int>& a);//испольование итераторов

void PrintVector(vector<int>& a);//использование ostream_iterator



#endif //LAB29_LAB3_STL_H
