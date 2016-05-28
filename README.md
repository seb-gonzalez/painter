# Project Title

Application that allows you to draw lines and rectangles over a canvas

## Getting Started

For a successful set up in your local machine you just have to download this
repository into your machine, then you should import this project as an 'Existing Maven Project'.

```
git init
git remote add origin https://github.com/sebachili/Paint.git
git pull -u origin master
```

## DOCUMENTATION:

The project is integrated by two main packages:
* Main package:
  - Application class
  - Canvas class
  - Drawable interface
  - Line class
  - Rectangle class
  - Filler class
  
* Graph package:
  - Point class [this class will represent the vertex within a graph]
  - Arista class
  - Graph class
  - DFS class [Depth-first search]
  
 
In order to find out how to fill a canvas given a point I have used the DFS algorithm to
go though every vertex within the graph that represents the current canvas and the visited
points on it will be the ones in which I could draw the color we want.

## Running the App

```
enter command: 
C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
enter command: 
L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
enter command: 
L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
enter command: 
R 16 1 20 3
----------------------
|               xxxxx|
|xxxxxx         x   x|
|     x         xxxxx|
|     x              |
----------------------
enter command: 
B 10 3 o
----------------------
|oooooooooooooooxxxxx|
|xxxxxxooooooooox   x|
|     xoooooooooxxxxx|
|     xoooooooooooooo|
----------------------
enter command: 
Q
```
