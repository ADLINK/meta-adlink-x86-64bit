#!/bin/bash -e

./setup_aic3107.sh

echo "SSP0 test"
sleep 2

aplay -Dplughw:0,0 -d10 2ch_48sine.wav

#arecord -Dhw:0,1 -r48000 -c2 -d10 -fS16_LE ticodec.wav

#Playaback then record concurrently
#note: need to route HPLOUT and HPROUT signal back to LINE1LP and LINE1RP
#aplay -Dhw:0,0 -d10 2ch_48sine.wav | arecord -Dhw:0,1 -r48000 -c2 -d10 -fS16_LE ticodec.wav


#This command records then playback the recorded input
#arecord -Dhw:0,1 -r48000 -c2 -fS16_LE | aplay -Dhw:0,0 &

#scp ticodec.wav ilab@10.88.227.30:~/Leaf_Hill_Workspace/
#rm *.wav -f

echo "Done!!"
