DESCRIPTION = "ADLINK BSP Image with XFCE X Window"

LICENSE = "MIT"

#IMAGE_FEATURES += " package-management ssh-server-dropbear hwcodecs"

inherit core-image

REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_INSTALL += "packagegroup-core-x11 \
     	 	  packagegroup-xfce-base "
		  
export IMAGE_BASENAME = "adlink-xfce-x86"

### XFCE Tools

IMAGE_INSTALL_append = " garcon sysprof xfce4-screenshooter ristretto xfce4-taskmanager xfce4-appfinder xfce-dusk-gtk3 xfceshutdown "



## X-Server
IMAGE_INSTALL_append = " xserver-xorg xterm xinit-env"


## SEMA applications
#IMAGE_INSTALL_append = " sema semagui-desktop trolltech startupconfig "
                 
#Tools
IMAGE_INSTALL_append = " usbotg-setting git wget which busybox bzip2 cmake bash tar gzip kmod ethtool i2c-tools ifupdown inetutils init-ifupdown iw minicom net-tools vim openssh "

## For additional tools/packages
IMAGE_INSTALL_append = " mcelog evince haveged lshw ntp ntpdate libstdc++ kernel-modules kernel-devsrc dmidecode"


