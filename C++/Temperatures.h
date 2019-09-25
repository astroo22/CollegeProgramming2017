#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
//https://www.codingame.com/ide/puzzle/temperatures
using namespace std;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
int main()
{
    int n; // the number of temperatures to analyse
    cin >> n; cin.ignore();
    int out = 5526;

    //string temps; // the n temperatures expressed as integers ranging from -273 to 5526
    //getline(cin, temps);
     vector<int> temps;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    temps.push_back(t);
  }
	
  if(n == 0)
  {
    out = 0;
  }
  else
  {
    for(int i=0; i<temps.size(); i++) 
    {
          int t = temps[i];
          if(abs(t) < abs(out))
          {
    	    out = t;
          }
          else if((abs(t) == abs(out)) && (t == -out))
          {
    	    out = abs(out);
          }            
          if(out == 0)
          {
    	    break;
          }
    }
  }
	
  cout << out << endl;

    // Write an action using cout. DON'T FORGET THE "<< endl"
    // To debug: cerr << "Debug messages..." << endl;

   // cout << "result" << endl;
}