#!/bin/bash

INTERFACE=$(iw dev | grep 'Interface' | awk '{print $2}' )

sudo iwlist $INTERFACE scanning | grep -E "(Cell)|(Channel)|(Frequency)|(Quality)|(ESSID)"