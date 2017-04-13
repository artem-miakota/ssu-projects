#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main()
{
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
        
    printf("Amount of numbers: %7.3d\nSum: %7.3d\nAverage value: %7.3f\nMax value: %7.3d\nDifference between max and average values: %7.3f\nEnter name for report file or leave blank for omitting this step: ", amount, sum, av, array[amount-1], diff);
    string fname;
    getline(cin, fname, '\n');
    if(fname == "") {
        return 0;
    } else {
        ofstream myfile;
        myfile.open (fname + ".txt");
        myfile << "Elements amount: " << amount << "\n"
        << "Sum: " << sum << "\n"
        << "Average value: " << av << "\n"
        << "Max value: " << array[amount-1] << "\n"
        << "Difference between max and average values: " << diff << "\n"
        << "Array elements: " << "\n[";
        for (int i = 0; i < amount-1; i++) {
            if (i % 10 == 0 && i != 0) myfile << "\n";
            myfile << array[i] << "  ";
        }
        myfile << array[amount-1] << "]\n";
        myfile.close();
        return 1;
    }   
}
