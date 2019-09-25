#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

//https://www.codingame.com/training/easy/power-of-thor-episode-1
using namespace std;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
int main()
{
    int lightX; // the X position of the light of power
    int lightY; // the Y position of the light of power
    int initialTX; // Thor's starting X position
    int initialTY; // Thor's starting Y position
    //bool something = false;
    cin >> lightX >> lightY >> initialTX >> initialTY; cin.ignore();

    // game loop
    while (1) {
        int remainingTurns; // The remaining amount of turns Thor can move. Do not remove this line.
        cin >> remainingTurns; cin.ignore();

        // Write an action using cout. DON'T FORGET THE "<< endl"
        // To debug: cerr << "Debug messages..." << endl;
        string somethingX = "";
        string somethingY = "";
    
    if(initialTX != lightX)
    {
        if(initialTX > lightX)
        {
            //cout << "W" <<endl;
            somethingX = "W";
            initialTX --;
           
        }
        else if(initialTX < lightX )//&& initialTX !=39
        {
            //cout << "E" <<endl;
            somethingX = "E";
            initialTX ++;
        }
    }
    
    if(initialTY != lightY)
    {
        if(initialTY < lightY )//&& (initialTY +1) != 18 
        {
            //cout << "S" << endl;
            somethingY = "S";
            initialTY ++;
            
            
        }
        else if(initialTY > lightY )//&& (initialTY -1) != 0 
        {
            //cout << "N" <<endl;
            somethingY = "N";
            initialTY --;           
        }
    }
    cout << somethingY << somethingX <<endl;
    /* if(initialTX > lightX && initialTY > lightY)
        {
            cout << "NW" << endl;
            initialTX --;
            initialTY --; 
        }
        if(initialTY < lightY && initialTX < lightX)
        {
            cout << "SE" << endl;
            initialTX ++;
            initialTY ++;
        }
        if(initialTY < lightY && initialTX >lightX)
        {
            cout << "SW" << endl;
            initialTX --;
             initialTY ++;
            
        }
        if(initialTY > lightY && initialTX < lightX)
        {
            cout << "NE" << endl;
            initialTX ++;
            initialTY ++;
        }*/
        // A single line providing the move to be made: N NE E SE S SW W or NW
        //cout << "SE" << endl;
    
    }
}