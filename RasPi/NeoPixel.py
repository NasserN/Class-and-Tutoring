#include all neccessary packages to get LEDs to work with Raspberry Pi
import time
import board
import neopixel
from random import randrange

#Initialise a strips variable, provide the GPIO Data Pin
#utilised and the amount of LED Nodes on strip and brightness (0 to 1 value)
pixels1 = neopixel.NeoPixel(board.D18, 8, brightness=1)

#Also create an arbitary count variable
x=0

#Focusing on a particular strip, this will traverse the strip, changing each LED to a random color.
while x<=7:
    pixels1[x] = (randrange(256), randrange(256), randrange(256))
    x = x+1
x = 0
time.sleep(2)

#changes all the LEDs to putple
pixels1.fill((200, 0, 100))


#LED Node 8 to blue
pixels1[7] = (0, 20, 255)

#Sleep for three seconds, You should now have all LEDs showing light with the first node
#Showing a different colour
time.sleep(4)

#Little Light slider script, it will produce a nice loading bar effect all the way up
#and then all the way back
#This was created using a While Loop taking advantage of that arbitary variable to determine
#which LED Node we will taget/index with a different colour

#Below will loop until variabe x has value 35
while x<=7:
    
    pixels1[x] = (255, 0, 0)
    #Add 1 to the counter
    x=x+1
    #Add a small time pause which will translate to 'smoothly' changing colour
    time.sleep(0.05)
    print(x)
i = 0;
while i < 9:
    if(i%2 == 0):
        pixels1.fill((255,255,255))
    else:
        pixels1.fill((0,0,0))
    time.sleep(.1)
    i = i+1
x=7
#below section is the same process as above loop just in reverse
while x>-1:
    pixels1[x] = (255, 0, 200)
    x=x-1
    time.sleep(0.05)

#Add a brief time delay to appreciate what has happened    
time.sleep(4)

#Complete the script by returning all the LED to off
pixels1.fill((0, 0, 0))

