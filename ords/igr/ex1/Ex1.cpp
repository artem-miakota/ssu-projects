#include <cstdlib>
#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main(int argc, char** argv) {
int amount = 0;
    for (int i = 1; i <= 10000; i++) {
        if (i % 7 == 0 && i % 2 != 0) amount++;
    }
    
    int array[amount], j = 0, sum = 0;
    for (int i = 1; i <= 10000; i++) {
        if (i % 7 == 0 && i % 2 != 0) {
            array[j] = i;
            j++;
            sum += i;
        }
    }
    
    float av = sum / amount, diff = array[amount-1] - av;
        
    printf("Кількість чисел: %7.3d\nСума: %7.3d\nСереднє значення: %7.3f\nНайбільше значення: %7.3d\nРізниця між найбільшим і середнім значеннями: %7.3f\nВведіть назву звіту: ", amount, sum, av, array[amount-1], diff);
    string fname;
    getline(cin, fname, '\n');
    if(fname == "") {
        return 0;
    } else {
        ofstream myfile;
        myfile.open (fname + ".txt");
        myfile << "Кількість чисел: " << amount
        << "\nСума: " << sum
        << "\nСереднє значення: " << av
        << "\nНайбільше значення: " << array[amount-1]
        << "\nРізниця між найбільшим і середнім значеннями: " << diff
        << "\nЕлементи масиву: [\n";
        for (int i = 0; i < amount-1; i++) {
            if (array[i] < 10) myfile << "   ";
            else if (array[i] < 100) myfile << "  ";
            else if (array[i] < 1000) myfile << " ";
            myfile << array[i];
            
            if ((i + 1) % 10 == 0)
                myfile << "\n";
            else
                myfile << "  ";
        }
        myfile << array[amount-1] << "]\n";
        myfile.close();
        return 1;
    }   
}

