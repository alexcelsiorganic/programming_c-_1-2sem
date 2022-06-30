#include <iostream>

using namespace std;

void Merge(int arr[], int mid1, int mid2) {
    if (mid1  = )



}




void CHeap(int arr[], int n, int i) {

    int root = i;

    int l = 2 * root + 1;
    int r = 2 * root + 2;

    if (l < n && arr[l] > arr[root]) {
        root = l;
    }

    if (r < n && arr[r] > arr[root]) {
        root = r;
    }

    if (root != i) {
        swap(arr[i], arr[root]);
        CHeap(arr, n, root);
    }
}

void HeapSort(int arr[], int n) {

    for (int i = n/2 - 1; i >= 0; i--) {
        CHeap(arr, n, i);
    }
    for (int i  = n - 1; i  >= 0; i--) {
        swap(arr[0], arr[i]);
        CHeap(arr, i , 0);
    }
}


int main() {

    int arr[10] = {1, 5, 6, 7, 2, 3 ,4, 0, 1};
    HeapSort(arr, 10);
    for (int i = 0; i < 10; i++) {
        cout << arr[i] << " ";
    }

}




