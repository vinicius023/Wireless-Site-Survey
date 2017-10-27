#!/bin/bash

PLANTA="$@"
OUT_DIR=./cache

convert -resize 1000x600\! "$PLANTA" ${OUT_DIR}/ambiente.png 

FILENAME=$(basename ${PLANTA})
composite -gravity center ${OUT_DIR}/heatmap.png ${OUT_DIR}/ambiente.png  "${OUT_DIR}/${FILENAME}_overlay.png" 