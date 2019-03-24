#!/bin/bash
echo -e "\n"
echo "########## Start USB OTG Setting ###########"

# Get a list of hard drives
hdnamelist=""
tmplist=""
hdname=""
isFound="N"

echo "\n Select the option to configure USB OTG as Host or Device ####\n"
echo "\n Host   :   1 "
echo "\n Device :   2 "
read usbrole

if [ "${usbrole}" == "2" ]; then
echo "<<<<<<<<< Scan Hard Drives Start >>>>>>>>>>"
tmplist=`mount | awk '{print $1}'`
for device in $tmplist; do
    case $device in
    	/dev/mmcblk*)
			device=${device#\/dev/}
			hdnamelist="$hdnamelist $device"
			echo "*)${device}"
            ;;
		/dev/sd*)
			device=${device#\/dev/}
			hdnamelist="$hdnamelist $device"
			echo "*)${device}"
    esac	    
done

if [ -z "${hdnamelist}" ]; then
	echo "[Error] Can't scan any hard drive in your system,and please insert a hard drive and retry again!!!"
	echo -e "\n"
	exit 5
else
	echo -e "\n"
	while [ "$isFound" != "Y" ]
	do
		echo -n "Please enter the hard drive name which you want to show on Host Side:"
		read hdname
		echo "Your input hard drive: ${hdname}"
		
		for hdItem in $hdnamelist; do
			if [ "$hdname" == "$hdItem" ]; then
				isFound="Y"
				break
			fi
		done

		if [ "$isFound" != "Y" ]; then
			echo "Your input is not a vaild hard drive name,and please input again !!!"
			echo -e "\n"
		else
			echo "Hard drive Found !!!"
			echo -e "\n"
			break
		fi
	done
fi

echo "<<<<<<<<< Scan Hard Drives End >>>>>>>>>>"
fi




mod_drcfg_source="intel_xhci_usb_role_switch"

mod_drcfg_targetlist=`lsmod | grep -i intel_xhci_usb_role_switch | awk '{print $1}'`
mod_drcfg_target=""

#Filter other module which selected to list due to containing keyword:portmux_intel_drcfg
for modname in $mod_drcfg_targetlist; do
    case $modname in
    	intel_xhci_usb_role_switch*)
			mod_drcfg_target="$modname"
            ;;
    esac	    
done


if [ "$mod_drcfg_source" == "$mod_drcfg_target" ]; then
	echo "intel_xhci_usb_role_switch, unload intel_xhci_usb_role_switch"
	modprobe -r intel_xhci_usb_role_switch
fi

mod_drcfg_targetlist=`lsmod | grep -i intel_xhci_usb_role_switch | awk '{print $1}'`
mod_drcfg_target=""

#Filter other module which selected to list due to containing keyword:portmux_intel_drcfg
for modname in $mod_drcfg_targetlist; do
    case $modname in
    	portmux_intel_drcfg*)
			mod_drcfg_target="$modname"
            ;;
    esac	    
done


if [ -z "$mod_drcfg_target" ]; then 
	modprobe intel_xhci_usb_role_switch default_role=${usbrole}
	
	mod_drcfg_targetlist=`lsmod | grep -i intel_xhci_usb_role_switch | awk '{print $1}'`
	mod_drcfg_target=""
	
	#Filter other module which selected to list due to containing keyword:portmux_intel_drcfg
	for modname in $mod_drcfg_targetlist; do
	    case $modname in
	    	intel_xhci_usb_role_switch*)
				mod_drcfg_target="$modname"
	            ;;
	    esac	    
	done
	
	if [ "$mod_drcfg_source" == "$mod_drcfg_target" ]; then
		echo "Load intel_xhci_usb_role_switch Successfully !!!"
	else
		echo "[Error] Load intel_xhci_usb_role_switch Fail !!!"
		echo -e "\n"
		exit 1
	fi
else
	echo "[Error] Can't unload intel_xhci_usb_role_switch !!!"
	echo -e "\n"
	exit 2	
fi

if [ "${usbrole}" == "2" ]; then
mod_gmass_source="g_mass_storage"

mod_gmass_targetlist=`lsmod | grep -i g_mass_storage | awk '{print $1}'`
mod_gmass_target=""

#Filter other module which selected to list due to containing keyword:g_mass_storage.(such as the libcomposite and usb_f_mass_storage)
for modname in $mod_gmass_targetlist; do
    case $modname in
    	g_mass_storage*)
			mod_gmass_target="$modname"
            ;;
    esac	    
done

if [ "$mod_gmass_source" == "$mod_gmass_target" ]; then
	echo "g_mass_storage exists, unload g_mass_storage"
	modprobe -r g_mass_storage
fi

mod_gmass_targetlist=`lsmod | grep -i g_mass_storage | awk '{print $1}'`
mod_gmass_target=""

#Filter other module which selected to list due to containing keyword:g_mass_storage.(such as the libcomposite and usb_f_mass_storage)
for modname in $mod_gmass_targetlist; do
    case $modname in
    	g_mass_storage*)
			mod_gmass_target="$modname"
            ;;
    esac	    
done

if [ -z "$mod_gmass_target" ]; then 
	echo "Load g-mass-storage module, file=/dev/${hdname}"
	sleep 1
	modprobe g-mass-storage file=/dev/${hdname} removable=1 luns=1 stall=0
	
	mod_gmass_targetlist=`lsmod | grep -i g_mass_storage | awk '{print $1}'`
	mod_gmass_target=""
	
	#Filter other module which selected to list due to containing keyword:g_mass_storage.(such as the libcomposite and usb_f_mass_storage)
	for modname in $mod_gmass_targetlist; do
	    case $modname in
	    	g_mass_storage*)
				mod_gmass_target="$modname"
	            ;;
	    esac	    
	done
	
	if [ "$mod_gmass_source" == "$mod_gmass_target" ]; then
		echo "Load g_mass_storage Successfully !!!"
	else
		echo "[Error] Load g_mass_storage Fail !!!"
		echo -e "\n"
		exit 3
	fi
else
	echo "[Error] Can't unload g_mass_storage !!!"
	echo -e "\n"
	exit 4	
fi
fi
echo "########## End USB OTG Setting ############"
echo -e "\n"


