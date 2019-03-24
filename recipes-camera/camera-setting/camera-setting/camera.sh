#!/bin/bash

echo -e  "\n"
echo " Start camera setting"

rpm -ivh --nodeps aiqb-1.0.0-2516.a4ef266.x86_64.rpm
rpm -ivh --nodeps libiaaiq-1.0.0-2516.5d67e6c.x86_64.rpm
rpm -ivh --nodeps libiacss-1.0.0-2516.ae8628e.x86_64.rpm
rpm -ivh --nodeps libcamhal-1.0.0-2516.0a50c401.x86_64.rpm
rpm -ivh --nodeps icamerasrc-1.0.0-2516.326d3e0.x86_64.rpm
rpm -ivh --nodeps --force libcamhal-1.0.0-2516.0a50c401.x86_64.rpm
rpm -ivh --nodeps --force icamerasrc-1.0.0-2516.326d3e0.x86_64.rpm
rpm -ivh --nodeps ipu4fw-1.0.0-2516.1878832.DSS.signed.x86_64.rpm
rpm -ivh --nodeps --force iotg_camera-1.0.0-2558.x86_64.rpm



echo " End camera setting ,Board will reset after 10seconds"
echo -e  "\n"
sleep 10
reboot

echo "Done!!"

