#!/bin/bash

LINHAS=$(wc -l dados-cell.txt | awk '{print $1}')
PASSO=100
FIGURAS=$[LINHAS / PASSO]


seq 0 $[$FIGURAS - 1] | while read i; do 
   awk -v tam=$PASSO -v i=$i '{
      if( NR < i*tam ) 
         print $0
         #print (i*tam)" a "((i+1)*tam - 1) 
      }' dados-cell.txt > /tmp/dados-cell_${i}.txt
      sh gnuplot-heatmaps.sh "/tmp/dados-cell_${i}.txt" "/tmp/gif_${i}.png"
done
#if( NR > ((i+1)*tam - 1) )

convert -loop 0 -delay 200 /tmp/gif_*.png ./cache/heatmap.gif 