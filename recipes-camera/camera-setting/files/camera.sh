#!/bin/bash

echo -e  "\n"
echo " Start camera setting"

rpm -ivh --nodeps aiqb-1.0.0-2720.a4ef266.x86_64
rpm -ivh --nodeps libiaaiq-1.0.0-2720.df05787.x86_64
rpm -ivh --nodeps libiacss-1.0.0-2720.ae8628e.x86_64
rpm -ivh --nodeps libcamhal-1.0.0-2720.d122692c.x86_64
rpm -ivh --nodeps icamerasrc-1.0.0-2720.4847058.x86_64
rpm -ivh --nodeps ipu4fw-1.0.0-2720.88ddf58.DSS.signed.x86_64
rpm -ivh --nodeps --force iotg_camera-1.0.0-2558.x86_64



echo " End camera setting ,Board will reset after 15 seconds"
echo -e  "\n"
sleep 15
reboot

echo "Done!!"

