#!/bin/bash

if [ ! -z $1 ]; then
	IN="$1"
else
	IN="./dados-cell.txt"
fi

if [ ! -z $2 ]; then
	OUT="$2"
else
	OUT="./cache/heatmap.png"
fi

echo "IN: $IN"
echo "OUT: $OUT"

echo '
set terminal pngcairo transparent size 1366, 819  

set view map 
set pm3d at b map 

set dgrid3d 1000, 600,2 
set xrange [0:1000]
set yrange [0:600] 

set palette defined (0 0 0 0.5, 1 0 0 1, 2 0 0.5 1, 3 0 1 1, 4 0.5 1 0.5, 5 1 1 0, 6 1 0.5 0, 7 1 0 0, 8 0.5 0 0)
set pm3d interpolate 0,0
set style fill transparent solid 0.5 noborder

set output "'$OUT'" 
splot "'$IN'" u 1:2:4  

#set output "'$OUT'" 
#splot "'$IN'" u 1:2:3 

exit' | gnuplot -